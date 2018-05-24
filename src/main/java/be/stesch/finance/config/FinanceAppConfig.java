package be.stesch.finance.config;

import org.slf4j.Logger;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Configuration
public class FinanceAppConfig {

    @Bean
    //@Scope(SCOPE_PROTOTYPE)
    Logger logger(InjectionPoint injectionPoint) {
        return getLogger(injectionPoint.getMethodParameter().getContainingClass());
    }

}
