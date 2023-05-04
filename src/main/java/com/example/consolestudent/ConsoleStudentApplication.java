package com.example.consolestudent;

import com.example.consolestudent.model.Annonce;
import com.example.consolestudent.model.Convention;
import com.example.consolestudent.model.Demande;
import com.example.consolestudent.repo.AnnonceRepo;
import com.example.consolestudent.repo.ConventionRepo;
import com.example.consolestudent.repo.DemandeRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class ConsoleStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsoleStudentApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AnnonceRepo annonceRepo, DemandeRepo demandeRepo , ConventionRepo conventionRepo){
//		Date date = new Date();
//		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MMMM/yyyy");
//		String stringDate= DateFor.format(date);
		return args -> {
//			annonceRepo.save(new Annonce(null, "Test1","this is a test 1","CP1,CP2","TC",new Date()));
//			annonceRepo.save(new Annonce(null, "Test2","this is a test 2","CI1,CI2","GI,GIL",new Date()));
//			annonceRepo.save(new Annonce(null, "Test0","this is a test 3","CP2","TC",new Date()));
//			demandeRepo.save(new Demande(null, "demande 1", "certif", "Nouvelle","student who requested",new Date()));
//			demandeRepo.save(new Demande(null, "demande 2", "certif", "Nouvelle","student who requested1",new Date()));
			conventionRepo.save(new Convention(null, "convention 1", "Viseo", "casablanca","viseo@mail.com","representant"
					,"representant", "salesforce", new Date(), new Date(),
					"Encadrant", "Encadrant",
					"1112233344", 4000, "especes"));

		};
	}
	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type",
				"Accept","Jwt-Token","Authorization","Origin, Accept","X-Requested-With",
				"Access-Control-Request-Method","Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type",
				"Accept","Jwt-Token","Authorization", "Access-Control-Allow-Credentials","Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PATCH","DELETE","OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
