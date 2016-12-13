package uk.co.kenfos.api.fixtures

import org.codehaus.jackson.map.ObjectMapper

import static org.apache.commons.lang.StringUtils.EMPTY

@SuppressWarnings('JavaIoPackageAccess')
trait Fixture {

    ObjectMapper objectMapper = new ObjectMapper()

    private static final FIXTURES_PATH = 'src/main/groovy/uk/co/kenfos/api/fixtures'

    File getFixtureFile(String fileName) {
        new File("${fixturesPath}/${fileName}")
    }

    String getFixturesPath() {
        "${projectPath}/${FIXTURES_PATH}"
    }

    String getProjectPath() {
        new File(EMPTY).absolutePath
    }
}
