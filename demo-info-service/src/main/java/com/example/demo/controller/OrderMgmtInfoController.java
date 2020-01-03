package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.CustomerInfo;
import com.example.demo.api.ProductInfo;
import com.example.demo.delegate.OrderMgmtInfoDelegate;
import com.example.demo.exception.DemoException;

@RestController
@RequestMapping("v1")
public class OrderMgmtInfoController {
	
	@Autowired
	private OrderMgmtInfoDelegate orderMgmtInfoDelegate;

	@GetMapping("/ordermgmt/customer")
	public CustomerInfo getCustomer(@RequestParam String customerId) throws DemoException {
		return orderMgmtInfoDelegate.getCustomer(customerId);
	}
	
	@GetMapping("/ordermgmt/products")
	public List<ProductInfo> getProducts(@RequestParam String customerId, @RequestParam String category) throws DemoException {
		return orderMgmtInfoDelegate.getProducts(customerId, category);
	}

}
