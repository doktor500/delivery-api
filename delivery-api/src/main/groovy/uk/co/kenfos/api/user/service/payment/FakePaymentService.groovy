package uk.co.kenfos.api.user.service.payment

import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

import static uk.co.kenfos.api.user.model.BillingAgreementState.ACTIVE

@Primary
@Service
@Profile('fake-payment-service')
class FakePaymentService implements PaymentService {

    @Override
    String billingAgreementStatus(Long id) {
        ACTIVE
    }
}
