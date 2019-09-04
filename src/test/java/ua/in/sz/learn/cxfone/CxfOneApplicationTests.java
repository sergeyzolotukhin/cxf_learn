package ua.in.sz.learn.cxfone;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.BindingProvider;

/**
 * https://github.com/code-not-found/jaxws-cxf/blob/master/jaxws-cxf-server-basic-authentication-server/src/test/java/com/codenotfound/soap/http/cxf/HelloWorldClientImplMock.java
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CxfOneApplicationTests {

    @Test
    public void contextLoads() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(HelloWorldPortType.class);
        jaxWsProxyFactoryBean.setAddress("endpointAddress");

        HelloWorldPortType  helloWorldClientProxy = (HelloWorldPortType) jaxWsProxyFactoryBean.create();

        setBasicAuthentication("userName", "password");

        Greeting greeting = helloWorldClientProxy.sayHello(person);

    }

    private void setBasicAuthentication(String userName, String password) {
        // the BindingProvider provides access to the protocol binding and
        // associated context objects for request/response message processing
        BindingProvider bindingProvider = (BindingProvider) helloWorldClientProxy;
        // set the user name for basic authentication
        bindingProvider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, userName);
        // set the password for basic authentication
        bindingProvider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
    }
}
