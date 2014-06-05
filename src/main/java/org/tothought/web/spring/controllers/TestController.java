package org.tothought.web.spring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	
	@RequestMapping("/sotest")
	public String so(){
		return "so";
	}
	
	@RequestMapping("/so")
	public void so2(@RequestParam("department[]") int[] department){
		for(Integer i:department){
			System.out.println(i);
		}
	}

}
