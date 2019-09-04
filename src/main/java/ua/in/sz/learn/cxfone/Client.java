package ua.in.sz.learn.cxfone;

import java.io.StringReader;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.Service.Mode;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.staxutils.StaxUtils;

@Slf4j
public class Client {
    public static void main(String[] args) throws Exception {
        String address = "http://localhost:8080/services/Hello";
        String request = "<q0:sayHello xmlns:q0=\"http://service.ws.sample/\"><name>Elan</name></q0:sayHello>";

        StreamSource source = new StreamSource(new StringReader(request));
        Service service = Service.create(new URL(address + "?wsdl"),
                new QName("http://service.ws.sample/" , "HelloService"));
        Dispatch<Source> disp = service.createDispatch(
                new QName("http://service.ws.sample/" , "HelloPort"),
                Source.class, Mode.PAYLOAD);

        Source result = disp.invoke(source);
        String resultAsString = StaxUtils.toString(result);
        log.info("Response: {}", resultAsString);

    }
}
