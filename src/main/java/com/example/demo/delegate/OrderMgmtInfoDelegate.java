package com.example.demo.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.api.CustomerInfo;
import com.example.demo.api.ProductInfo;
import com.example.demo.exception.DemoException;

@Service
public class OrderMgmtInfoDelegate {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${get.customer.service.url}")
	private String GET_CUSTOMER_SVC_URL;
	
	@Value("${get.products.service.url}")
	private String GET_PRODUCTS_SVC_URL;
	
	
	public CustomerInfo getCustomer(String customerId) throws DemoException {
		UriComponentsBuilder urilBuilder = UriComponentsBuilder.fromHttpUrl(GET_CUSTOMER_SVC_URL).queryParam("customerId", customerId);
		CustomerInfo customerInfo = restTemplate.getForObject(urilBuilder.toUriString(), CustomerInfo.class);
		
		return customerInfo;
	}
	
	public List<ProductInfo> getProducts(String customerId, String category) throws DemoException {
		UriComponentsBuilder urilBuilder = UriComponentsBuilder.fromHttpUrl(GET_PRODUCTS_SVC_URL)
																.queryParam("customerId", customerId)
																.queryParam("category", category);
		List<ProductInfo> productInfos = restTemplate.getForObject(urilBuilder.encode().toUriString(), List.class);
		
		return productInfos;
	}

}
