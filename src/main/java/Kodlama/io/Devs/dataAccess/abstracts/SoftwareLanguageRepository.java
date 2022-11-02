package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;


import Kodlama.io.Devs.entities.SoftwareLanguage;

// database process in here
public interface SoftwareLanguageRepository {
	
	void add(SoftwareLanguage softwareLanguage)throws Exception;
	void delete(int id);
	void update(int id, SoftwareLanguage softwareLanguage);
	
	//getAll to see List of Software Languages
	List<SoftwareLanguage> getAll();
	
	SoftwareLanguage getById(int id);
	
	
}
