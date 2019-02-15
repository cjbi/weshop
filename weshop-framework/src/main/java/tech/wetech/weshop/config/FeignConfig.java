package tech.wetech.weshop.config;

import feign.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.AnnotatedParameterProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FeignConfig {

    @Autowired(
            required = false
    )
    private List<AnnotatedParameterProcessor> parameterProcessors = new ArrayList();

    @Bean
    @ConditionalOnMissingBean
    public Contract feignContract(ConversionService feignConversionService) {

        return new HierarchicalContract();
    }
}
