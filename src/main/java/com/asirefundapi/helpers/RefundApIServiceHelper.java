package com.asirefundapi.helpers;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;

import com.asirefundapi.constants.Endpoint;
import com.asirefundapi.utils.ConfigManager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class RefundApIServiceHelper {

	private static final String Base_URL = ConfigManager.getInstance().getString("baseUrl");
	
	public RefundApIServiceHelper()
	{
		RestAssured.baseURI=Base_URL;
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	public Response AsiRefundapi_post()
	{ 
		Map<String,Object> headerMap = new HashMap<String,Object>();
		headerMap.put("mid", "6616");
		headerMap.put("From_date", "2020-01-30");
		headerMap.put("To_date", "2020-01-31");
		headerMap.put("hash", "7d5f3fa30d710b1cd270bbc88dfaced95a80387546c5e2cadb9fa71e0e4e3151e004696d19f084a6b9dd68733c836dc1da0b4bb8280a92e36256ad772a45c4d1");
		
		
		Response response=RestAssured.given()
				.auth()
                .preemptive()
                .basic("payu","payu@98765")
                .contentType(ContentType.JSON)
				.header((Header) headerMap)
				.when()
				.post(Endpoint.ASIRefund_postApi)
				.andReturn();
		
		assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED,"created");
		
		
		return response;
	}
	
}
