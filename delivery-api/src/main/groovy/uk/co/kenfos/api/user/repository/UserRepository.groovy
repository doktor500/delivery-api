package uk.co.kenfos.api.user.repository

import org.springframework.data.jpa.repository.JpaRepository
import uk.co.kenfos.api.user.model.User

interface UserRepository extends JpaRepository<User, Long> { }
