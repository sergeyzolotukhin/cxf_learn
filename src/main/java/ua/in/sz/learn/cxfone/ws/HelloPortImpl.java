package ua.in.sz.learn.cxfone.ws;

import lombok.extern.slf4j.Slf4j;

import javax.jws.WebService;

@Slf4j
@WebService(serviceName = "HelloService", portName = "HelloPort",
        targetNamespace = "http://service.ws.sample/",
        endpointInterface = "ua.in.sz.learn.cxfone.ws.Hello")
public class HelloPortImpl implements Hello {

    public String sayHello(String name) {
        log.info("Executing operation sayHello {}", name);

        try {
            return "Hello, Welcome to CXF Spring boot " + name + "!!!";
        } catch (Exception e) {
            log.error("Error:", e);
            throw new RuntimeException(e);
        }
    }
}

/*

BindingQName={
http://service.ws.sample/}HelloServiceSoapBinding,
ServiceQName={
http://service.ws.sample/}HelloService,
QName={http://service.ws.sample/}HelloPort

 */