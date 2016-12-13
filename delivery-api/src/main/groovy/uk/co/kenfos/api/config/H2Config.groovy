package uk.co.kenfos.api.config

import org.h2.server.web.WebServlet
import org.springframework.boot.context.embedded.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile('h2-db')
class H2Config {

    private static final H2_CONSOLE_URL_MAPPING = '/console/*'

    @Bean
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet())
        registrationBean.addUrlMappings(H2_CONSOLE_URL_MAPPING)
        registrationBean
    }
}
