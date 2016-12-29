package uk.co.kenfos.api.user.service.payment

import org.springframework.beans.factory.annotation.Autowired
import uk.co.kenfos.api.IntegrationSpec

import static uk.co.kenfos.api.user.model.BillingAgreementState.ACTIVE

class PaymentServiceIntegrationSpec extends IntegrationSpec {

    @Autowired PaymentService paymentService

    void 'returns user billing agreement status'() {
        expect:
        paymentService.billingAgreementStatus(1) == ACTIVE.name()
    }
}
