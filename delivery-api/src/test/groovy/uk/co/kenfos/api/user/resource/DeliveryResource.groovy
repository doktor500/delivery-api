package uk.co.kenfos.api.user.resource

@SuppressWarnings('SpecFileName')
trait DeliveryResource implements FixtureTemplate {

    def deliveries(priority) {
        "[ ${delivery(priority)} ]"
    }

    def delivery(priority) {
        getFixture('/delivery/DeliveryResponse.fixture', [priority: priority])
    }
}
