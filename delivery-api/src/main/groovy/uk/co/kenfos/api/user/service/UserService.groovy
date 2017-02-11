package uk.co.kenfos.api.user.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import uk.co.kenfos.api.user.model.BillingAgreementState
import uk.co.kenfos.api.user.model.User
import uk.co.kenfos.api.user.repository.UserRepository
import uk.co.kenfos.api.user.service.payment.PaymentService

import javax.transaction.Transactional

@Service
@Transactional
class UserService {

    @Autowired private PaymentService paymentService
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
        users.collect { User user -> withBillingAgreement user }
    }

    private withBillingAgreement(User user) {
        user.billingAgreementStatus = BillingAgreementState.valueOf(paymentService.billingAgreementStatus(user.id))
        user
    }
}
