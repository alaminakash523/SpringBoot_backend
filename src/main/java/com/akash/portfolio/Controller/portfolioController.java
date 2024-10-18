package com.akash.portfolio.Controller;

import com.akash.portfolio.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class portfolioController {



    @GetMapping("/")
    public String home() {
        return "Hello World";
    }


}
