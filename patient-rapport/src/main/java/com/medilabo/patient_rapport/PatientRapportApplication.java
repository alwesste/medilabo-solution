package com.medilabo.patient_rapport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PatientRapportApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientRapportApplication.class, args);
	}

}
