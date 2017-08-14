package uk.co.kenfos.api.user.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.stereotype.Service
import uk.co.kenfos.api.user.model.BillingAgreementState
import uk.co.kenfos.api.user.model.User
import uk.co.kenfos.api.user.repository.UserRepository
import uk.co.kenfos.api.user.service.payment.PaymentService

import javax.transaction.Transactional

import static java.util.Locale.UK

@Service
@Transactional
class UserService {

    private static final LANG = 'lang'

    @Autowired private PaymentService paymentService
    @Autowired private UserRepository userRepository
    @Autowired private MessageSource messageSource

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
        user.lang = messageSource.getMessage(LANG, null, UK)
        user
    }
}
