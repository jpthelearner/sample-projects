package com.jp.app_name.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;


public class JaxbUtil {

	private static final Logger log = Logger.getLogger(JaxbUtil.class);
	private static final String JAVA_PACKAGE_LIST_FOR_JAXB_CONTEXT = "com.jp.app_name.schema";
	
	public static String getXmlString(Object jaxbObject) {
		String xmlString = null;
		try {
			StringWriter stringWriter = new StringWriter();
			JAXBContext jaxbContext = JAXBContext.newInstance(JAVA_PACKAGE_LIST_FOR_JAXB_CONTEXT);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(jaxbObject, stringWriter);
			xmlString = stringWriter.toString();
			
		} catch (JAXBException e) {
			log.error("Error while marshalling xml", e);
			e.printStackTrace();
		}
		//System.out.println(xmlString);
		return xmlString;
	}
	
	public static Object getJaxbObject(String xmlString) {
		Object jaxbObject = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(JAVA_PACKAGE_LIST_FOR_JAXB_CONTEXT);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			jaxbObject = unmarshaller.unmarshal(new StringReader(xmlString));
		} catch (JAXBException e) {
			log.error("Error while unmarshalling xml", e);
		}
		return jaxbObject;
	}
	
}
