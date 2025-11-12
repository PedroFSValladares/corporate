package br.edu.infnet.pedrovalladaresapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PedrovalladaresapiApplication {

	public static void main(String[] args) {
        SpringApplication.run(PedrovalladaresapiApplication.class, args);

	}

}
