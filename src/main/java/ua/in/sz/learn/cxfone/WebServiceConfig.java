package ua.in.sz.learn.cxfone;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.in.sz.learn.cxfone.ws.HelloPortImpl;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Bean
    public SpringBus bus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus(), new HelloPortImpl());
        endpoint.publish("/Hello");
        return endpoint;
    }
}