package uk.co.kenfos.api.user.service.payment

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class DefaultPaymentService implements PaymentService {

    @Value('${kenfos.payment-service.url}') private String paymentServiceURL

    @Override
    String billingAgreementStatus(Long id) {
        new URL("$paymentServiceURL/$id").text
    }
}
