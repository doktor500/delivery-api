package uk.co.kenfos.api.user.service.payment

import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Primary
@Service
@Profile('fake-payment-service')
class FakePaymentService implements PaymentService {

    private static final BILLING_AGREEMENT_STATE = 'Active'

    @Override
    String billingAgreementStatus(Long id) {
        BILLING_AGREEMENT_STATE
    }
}
