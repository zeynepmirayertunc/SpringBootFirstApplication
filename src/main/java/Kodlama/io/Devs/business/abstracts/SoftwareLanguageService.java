package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.softwareLanguages.CreateSoftwareLanguageRequest;
import Kodlama.io.Devs.business.requests.softwareLanguages.UpdateSoftwareLanguagesRequest;
import Kodlama.io.Devs.business.responses.softwareLanguages.GetAllSoftwareLanguageResponse;
import Kodlama.io.Devs.business.responses.softwareLanguages.GetByIdSoftwareLanguageResponse;

public interface SoftwareLanguageService {
	// add if it complies with the business rules
	void add(CreateSoftwareLanguageRequest createSoftwareLanguageRequest)throws Exception; 
	void delete(int id);
	// update if it complies with the business rules
	void update(int id, UpdateSoftwareLanguagesRequest updateSoftwareLanguagesRequest ) throws Exception;
	
	List<GetAllSoftwareLanguageResponse> getAll();
	GetByIdSoftwareLanguageResponse getById(int id) throws Exception;

}
