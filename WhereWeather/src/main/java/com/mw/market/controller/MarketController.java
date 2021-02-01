package com.mw.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/market")
public class MarketController {
	
	@RequestMapping("/saleList") // /market/saleList
	public String saleList() {
		return "market/saleList";
	}
	
	@RequestMapping("/saleReg") // /market/saleReg
	public String saleReg() {
		return "market/saleReg";
	}
	
	@RequestMapping("/saleView") // /market/saleView
	public String saleView() {
		return "market/saleView";
	}
	
}