package uk.co.kenfos.api.user.resource

import groovy.text.GStringTemplateEngine
import groovy.transform.Memoized

@SuppressWarnings(['JavaIoPackageAccess', 'SpecFileName'])
trait FixtureTemplate {

    static fixturesPath = '/src/test/groovy/uk/co/kenfos/api/fixtures'

    String getFixture(String fixtureName, Map args = [:]) {
        def file = new File("${absolutePath}${fixturesPath}${fixtureName}")
        def engine = new GStringTemplateEngine()
        engine.createTemplate(file.text).make(args).toString()
    }

    @Memoized
    String getAbsolutePath() {
        new File('.').absolutePath
    }
}
