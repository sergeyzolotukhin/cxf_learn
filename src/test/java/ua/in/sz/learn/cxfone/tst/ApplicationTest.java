package ua.in.sz.learn.cxfone.tst;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.in.sz.learn.cxfone.ws.Hello;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Test
    public void contextLoads() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(Hello.class);
        jaxWsProxyFactoryBean.setAddress("http://localhost:8080/services/Hello");

        Hello helloWorldClientProxy = (Hello) jaxWsProxyFactoryBean.create();

        String greeting = helloWorldClientProxy.sayHello("person");
        log.info("Response: {}", greeting);
    }
}

