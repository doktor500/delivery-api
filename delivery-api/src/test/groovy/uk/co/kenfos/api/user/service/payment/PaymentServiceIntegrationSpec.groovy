package uk.co.kenfos.api.user.service.payment

import org.springframework.beans.factory.annotation.Autowired
import uk.co.kenfos.api.IntegrationSpec

class PaymentServiceIntegrationSpec extends IntegrationSpec {

    private static final BILLING_AGREEMENT_STATE = 'Active'

    @Autowired PaymentService paymentService

    void 'returns user billing agreement status'() {
        expect:
        paymentService.billingAgreementStatus(1) == BILLING_AGREEMENT_STATE
    }
}
