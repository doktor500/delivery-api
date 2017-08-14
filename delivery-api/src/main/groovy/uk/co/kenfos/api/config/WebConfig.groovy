package uk.co.kenfos.api.config

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor
import org.springframework.web.servlet.i18n.SessionLocaleResolver

import javax.servlet.Filter

@Configuration
class WebConfig extends WebMvcConfigurerAdapter {

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

    @Bean
    LocaleResolver localeResolver() {
        def sessionLocaleResolver = new SessionLocaleResolver()
        sessionLocaleResolver.defaultLocale = Locale.UK
        sessionLocaleResolver
    }

    @Bean
    LocaleChangeInterceptor localeChangeInterceptor() {
        def localeChangeInterceptor = new LocaleChangeInterceptor()
        localeChangeInterceptor.paramName = 'lang'
        localeChangeInterceptor
    }

    @Override
    void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor())
    }

}
