package uk.co.kenfos.api

import org.junit.runner.Description
import org.junit.runners.model.Statement
import software.betamax.TapeMode
import software.betamax.junit.Betamax
import software.betamax.junit.RecorderRule
import software.betamax.tape.yaml.YamlTapeLoader

import static java.io.File.separator
import static org.apache.commons.lang.StringUtils.isNotEmpty
import static software.betamax.Configuration.DEFAULT_TAPE_ROOT
import static software.betamax.Configuration.builder
import static software.betamax.TapeMode.READ_ONLY
import static software.betamax.TapeMode.UNDEFINED

@SuppressWarnings('JavaIoPackageAccess')
class BetamaxRecorderRule extends RecorderRule {

    private static final String DEFAULT_TEST_ROOT = new File('').absolutePath
    private static final String DEFAULT_MODE = 'betamax.defaultMode'
    private static final int TIME_OUT_SECONDS = 30

    private final YamlTapeLoader tapeLoader = createYamlTapeLoader()

    BetamaxRecorderRule() {
        super(builder().proxyTimeoutSeconds(TIME_OUT_SECONDS).build())
    }

    Statement apply(final Statement statement, final Description description) {
        Betamax annotation = description.getAnnotation(Betamax)
        if (annotation != null) {
            Statement baseStatement = super.apply(statement, description)
            return new BetamaxStatement(baseStatement, annotation.tape(), annotation.mode())
        }
        statement
    }

    private void setup(String tapeName, TapeMode tapeMode) {
        if (isNotEmpty(tapeName) && isReadOnly(tapeMode)) {
            tapeLoader.loadTape(tapeName)
        }
    }

    private boolean isReadOnly(TapeMode tapeMode) {
        tapeMode == UNDEFINED ? READ_ONLY == defaultTapeMode : READ_ONLY == tapeMode
    }

    private TapeMode getDefaultTapeMode() {
        String defaultMode = System.getProperty(DEFAULT_MODE)
        defaultMode != null ? TapeMode.valueOf(defaultMode) : UNDEFINED
    }

    private YamlTapeLoader createYamlTapeLoader() {
        new YamlTapeLoader(new File(DEFAULT_TEST_ROOT + separator + DEFAULT_TAPE_ROOT))
    }

    private class BetamaxStatement extends Statement {

        private final Statement baseStatement
        private final String tapeName
        private final TapeMode tapeMode

        BetamaxStatement(Statement baseStatement, String tapeName, TapeMode tapeMode) {
            this.baseStatement = baseStatement
            this.tapeName = tapeName
            this.tapeMode = tapeMode
        }

        @Override
         void evaluate() throws Throwable {
            setup(tapeName, tapeMode)
            baseStatement.evaluate()
        }
    }

}
