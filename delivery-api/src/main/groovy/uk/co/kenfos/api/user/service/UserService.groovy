package uk.co.kenfos.api.user.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import uk.co.kenfos.api.user.model.User
import uk.co.kenfos.api.user.repository.UserRepository

import javax.transaction.Transactional

@Service
@Transactional
class UserService {

    @Value('${kenfos.payment-service.url}') private String paymentServiceURL
    @Autowired private UserRepository userRepository

    User save(User user) {
        withBillingAgreement userRepository.save(user)
    }

    User getOne(Long id) {
        withBillingAgreement userRepository.getOne(id)
    }

    List<User> findAll() {
        withBillingAgreement userRepository.findAll()
    }

    private withBillingAgreement(List users) {
        users.collect { user -> withBillingAgreement user }
    }

    private withBillingAgreement(User user) {
        user.billingAgreementStatus = billingAgreementStatus(user.id)
        user
    }

    private billingAgreementStatus(Long id) {
        new URL("$paymentServiceURL/$id").text
    }
}