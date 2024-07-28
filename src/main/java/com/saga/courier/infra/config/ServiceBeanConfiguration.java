package com.saga.courier.infra.config;

import com.saga.courier.domain.in.CourierDomainServiceApi;
import com.saga.courier.domain.out.CourierRepositoryApi;
import com.saga.courier.domain.service.CourierDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBeanConfiguration {

    @Bean
    public CourierDomainServiceApi courierDomainServiceApi(CourierRepositoryApi courierRepositoryApi){
        return new CourierDomainService(courierRepositoryApi);
    }
}
