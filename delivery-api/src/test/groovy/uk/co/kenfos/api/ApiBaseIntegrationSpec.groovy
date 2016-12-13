package uk.co.kenfos.api

import org.springframework.test.context.ActiveProfiles

import static org.apache.commons.lang.StringUtils.EMPTY

@ActiveProfiles('test-default')
abstract class ApiBaseIntegrationSpec extends PersistenceAwareIntegrationSpec {

    abstract protected get(Map args)
    abstract protected get(Map args, Map queryParameters)
    abstract protected post(Map args)
    abstract protected json(response)
    abstract protected parse(String text)

    protected getResourceId(Map args) {
        args.id ?: EMPTY
    }
}
