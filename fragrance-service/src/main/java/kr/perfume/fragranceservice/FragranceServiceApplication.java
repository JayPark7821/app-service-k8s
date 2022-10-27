package kr.perfume.fragranceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"kr.perfume.fragranceservice", "kr.perfume.utils"})
public class FragranceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FragranceServiceApplication.class, args);
    }

}
