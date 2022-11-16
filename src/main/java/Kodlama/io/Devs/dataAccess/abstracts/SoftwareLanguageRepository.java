package Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import Kodlama.io.Devs.entities.SoftwareLanguage;

// database process in here
public interface SoftwareLanguageRepository extends JpaRepositoryImplementation<SoftwareLanguage, Integer>{
		
}
