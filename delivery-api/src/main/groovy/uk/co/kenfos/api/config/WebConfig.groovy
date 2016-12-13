package uk.co.kenfos.api.config

import org.springframework.boot.context.embedded.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter

import javax.servlet.Filter

@Configuration
class WebConfig {

    @Bean
    FilterRegistrationBean someFilterRegistration() {
        def filterRegistrationBean = new FilterRegistrationBean()
        filterRegistrationBean.setFilter(openEntityManagerInViewFilter())
        filterRegistrationBean.addUrlPatterns('/*')
        filterRegistrationBean.setName('openEntityManagerInViewFilter')
        filterRegistrationBean
    }

    @Bean(name = 'openEntityManagerInViewFilter')
    Filter openEntityManagerInViewFilter() {
        new OpenEntityManagerInViewFilter()
    }

}
