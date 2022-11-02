package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.SoftwareLanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.SoftwareLanguageRepository;
import Kodlama.io.Devs.entities.SoftwareLanguage;


@Service //it tells this class that it is Business object.
public class SoftwareLanguageManager implements SoftwareLanguageService {
	private SoftwareLanguageRepository softwareLanguageRepository;

	@Autowired 
	public SoftwareLanguageManager(SoftwareLanguageRepository softwareLanguageRepository) {
		this.softwareLanguageRepository = softwareLanguageRepository;
	}

	@Override
	public void add(SoftwareLanguage softwareLanguage)throws Exception {
		// check if name is unique and cannot be blank.
		if(softwareLanguage.getName().isEmpty()){
            throw new Exception("The software language cannot be left blank!");
        }

        for(SoftwareLanguage language1 : softwareLanguageRepository.getAll()){
            if(language1.getId() == softwareLanguage.getId() || language1.getName().equals(softwareLanguage.getName())){
                throw new Exception("The software language is available in the database!");
            }
        }
        softwareLanguageRepository.add(softwareLanguage);
	}

	@Override
	public void delete(int id) {
		softwareLanguageRepository.delete(id);

	}

	@Override
	public void update(int id, SoftwareLanguage softwareLanguage) throws Exception {
		// check if name is unique and cannot be blank.
			if(softwareLanguage.getName().isEmpty()){
	            throw new Exception("The software language cannot be left blank!");
	        }

	        for(SoftwareLanguage language : softwareLanguageRepository.getAll()){
	            if(language.getName().equals(softwareLanguage.getName())){
	                throw new Exception("The software language is available in the database!");
	            }
	        }
	        softwareLanguageRepository.update(id,softwareLanguage);
		}



	@Override
	public List<SoftwareLanguage> getAll() {
		return softwareLanguageRepository.getAll();
	}

	@Override
	public SoftwareLanguage getById(int id) {
		// TODO Auto-generated method stub
		return softwareLanguageRepository.getById(id);
	}

}
