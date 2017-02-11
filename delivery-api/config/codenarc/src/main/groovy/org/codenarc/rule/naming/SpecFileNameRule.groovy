import org.codenarc.rule.AbstractRule
import org.codenarc.rule.Violation
import org.codenarc.source.SourceCode

class SpecFileNameRule extends AbstractRule {

    private static final FILE_NAMES = ['UnitSpec', 'IntegrationSpec', 'FunctionalSpec', 'E2ESpec', 'Fixture', 'Rule']
    private static final MESSAGE = 'The file name has to follow the convention *UnitSpec, *IntegrationSpec, *FunctionalSpec, *E2ESpec, *Fixture, *Rule'

    String name = 'SpecFileName'
    String description = 'Spock file name rule'
    int priority = 3

    void applyTo(SourceCode sourceCode, List<Violation> violations) {
        List classes = sourceCode?.ast?.classes
        List topLevelClasses = classes?.findAll { !it.outerClass }
        topLevelClasses.each { clazz ->
            def valid = FILE_NAMES.any { clazz.name.endsWith(it) }
            if (!valid) {
                violations << violation
            }
        }
    }

    private Violation getViolation() {
        new Violation(rule: this, message: MESSAGE)
    }
}
