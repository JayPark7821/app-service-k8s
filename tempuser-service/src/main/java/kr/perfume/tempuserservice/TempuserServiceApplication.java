package kr.perfume.tempuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"kr.perfume.tempuserservice", "kr.perfume.utils"})
public class TempuserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TempuserServiceApplication.class, args);
    }

}
