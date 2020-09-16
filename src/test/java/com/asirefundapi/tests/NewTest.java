package com.asirefundapi.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.asirefundapi.helpers.RefundApIServiceHelper;

public class NewTest {
 
private com.asirefundapi.helpers.RefundApIServiceHelper RefundAPIService;
	
	@BeforeClass
	public void init()
	{
		RefundAPIService=new RefundApIServiceHelper();
	}
	
	@Test
	public void post_api()
	{
		RefundAPIService.AsiRefundapi_post();
	}
	
	
}
