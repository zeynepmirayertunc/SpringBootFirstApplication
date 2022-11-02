package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.SoftwareLanguageRepository;
import Kodlama.io.Devs.entities.SoftwareLanguage;

@Repository // it tells this class that it is a Data Access object.
public class InMemorySoftwareLanguageRepository implements SoftwareLanguageRepository{
	
	List<SoftwareLanguage> softwareLanguages;
	

	public InMemorySoftwareLanguageRepository() {
		softwareLanguages = new ArrayList<SoftwareLanguage>();
		softwareLanguages.add(new SoftwareLanguage(1, "C#"));
		softwareLanguages.add(new SoftwareLanguage(2, "Java"));
		softwareLanguages.add(new SoftwareLanguage(3, "Python"));
	}

	@Override
	public void add(SoftwareLanguage softwareLanguage) throws Exception {
		softwareLanguages.add(softwareLanguage);
		
	}

	@Override
	public void delete(int id) {
		for (Iterator<SoftwareLanguage>  iterator = softwareLanguages.iterator();  iterator.hasNext();) {
			SoftwareLanguage softwareLanguage = iterator.next();
			if (softwareLanguage.getId() == id) {
				iterator.remove();
			}
			
		}
		
	}

	@Override
	public void update(int id, SoftwareLanguage softwareLanguage) {
		var item = getById(softwareLanguage.getId());
		item.setName(softwareLanguage.getName());
		
	}

	@Override
	public List<SoftwareLanguage> getAll() {
		return softwareLanguages;
	}

	@Override
	public SoftwareLanguage getById(int id) {
		SoftwareLanguage sw_lng=null;
		for (SoftwareLanguage softLanguage : softwareLanguages) {
			if (softLanguage.getId() == id) {
				sw_lng = softLanguage;
				break;
			}
			
		}
		return sw_lng;
	}

}
