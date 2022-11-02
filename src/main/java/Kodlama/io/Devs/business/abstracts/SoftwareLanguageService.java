package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.SoftwareLanguage;

public interface SoftwareLanguageService {
	// add if it complies with the business rules
	void add(SoftwareLanguage softwareLanguage)throws Exception; 
	void delete(int id);
	// update if it complies with the business rules
	void update(int id, SoftwareLanguage softwareLanguage ) throws Exception;
	
	List<SoftwareLanguage> getAll();
	SoftwareLanguage getById(int id);

}
