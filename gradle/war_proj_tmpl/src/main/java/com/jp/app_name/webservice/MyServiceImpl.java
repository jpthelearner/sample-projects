package com.jp.app_name.webservice;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService(targetNamespace = "http://schema.jp.com/app_name",
endpointInterface = "com.jp.app_name.webservice.MyService"
            )
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class MyServiceImpl implements MyService{

	@Override
	public String sayHello(String name) {
		return "hello "+name;
	}

}
