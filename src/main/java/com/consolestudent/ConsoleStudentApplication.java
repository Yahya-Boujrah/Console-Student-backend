package com.consolestudent;

import com.consolestudent.repo.AnnonceRepo;
import com.consolestudent.repo.ConventionRepo;
import com.consolestudent.repo.DemandeRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
//			conventionRepo.save(new Convention(null, "convention 1", "Viseo", "casablanca","viseo@mail.com","representant"
//					,"representant", "salesforce", new Date(), new Date(),
//					"Encadrant", "Encadrant",
//					"1112233344", 4000, "especes"));


//			studentRepo.save(new Student(12345L, "D12345", "EE12345", "Hsaini", "yassmine", "yassmine@gmail.com", "2001", "Dakhla", "0606060606", "Azzouzia", "CI2", "GI"));
//			 studentRepo.findById(12345L);

		};
	}

}
