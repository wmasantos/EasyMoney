package br.com.easymoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
@SpringBootApplication
public class EasyMoneyApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EasyMoneyApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EasyMoneyApplication.class);
    }

    @GetMapping("/")
    public String start(){
        return "API ROCK's - " + new Date().toString();
    }
}
