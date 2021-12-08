package com.athensoft.prototype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GlobalController {
	@GetMapping({"/", "/home"})
    public String gotoHome() {
        return "home";
    }

	@GetMapping("/login")
    public String gotoLogin() {
        return "login";
    }
	
	@GetMapping("/hello")
    public String gotoHello() {
        return "hello";
    }
	
}
