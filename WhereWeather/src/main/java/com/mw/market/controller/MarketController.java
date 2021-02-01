package com.mw.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/market")
public class MarketController {
	
	@RequestMapping("/salelist") // /market/salelist
	public String saleList() {
		return "market/salelist";
	}
	
	@RequestMapping("/salereg") // /market/salereg
	public String saleReg() {
		return "market/salereg";
	}
	
	@RequestMapping("/saleview") // /market/saleview
	public String saleView() {
		return "market/saleview";
	}
	
}