package uk.co.kenfos.api.config

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

import javax.servlet.*
import javax.servlet.http.HttpServletResponse

@Slf4j
@Component
class CORSFilter implements Filter {

    void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        def response = (HttpServletResponse) res
        response.setHeader('Access-Control-Allow-Origin', '*')
        response.setHeader('Access-Control-Allow-Methods', 'POST, GET, PUT, OPTIONS, DELETE')
        response.setHeader('Access-Control-Max-Age', '3600')
        response.setHeader('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept')
        chain.doFilter(req, res)
    }

    @SuppressWarnings('UnusedMethodParameter')
    void init(FilterConfig filterConfig) {
        log.debug('initializing CORSFilter')
    }
    void destroy() {
        log.debug('destroying CORSFilter')
    }
}
