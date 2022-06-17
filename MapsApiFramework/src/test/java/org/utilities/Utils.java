package org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification reqSpec;
	
	public static RequestSpecification requestSpec() throws IOException {
		
		if(reqSpec == null) {
			
		PrintStream pr = new PrintStream(new FileOutputStream("logfile.txt"));
		reqSpec = new RequestSpecBuilder().setBaseUri(loadProperties("baseUrl")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(pr))
				.addFilter(ResponseLoggingFilter.logResponseTo(pr))
				.setContentType(ContentType.JSON).build();	
		return reqSpec;	
		}
		return reqSpec;
	
	}
	
	public static String loadProperties(String key) throws IOException {
		FileInputStream pptfile = new FileInputStream("config.properties");
		Properties ppt = new Properties();
		ppt.load(pptfile);
		return ppt.getProperty(key);
	}
	
	public static String getJsonPath(Response res, String key ) {
		JsonPath js = new JsonPath(res.asString());
		return js.get(key).toString();
		
	}
	
}
