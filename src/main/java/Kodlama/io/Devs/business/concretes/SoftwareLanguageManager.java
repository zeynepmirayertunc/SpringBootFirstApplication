package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.SoftwareLanguageService;
import Kodlama.io.Devs.business.requests.softwareLanguages.CreateSoftwareLanguageRequest;
import Kodlama.io.Devs.business.requests.softwareLanguages.UpdateSoftwareLanguagesRequest;
import Kodlama.io.Devs.business.responses.softwareLanguages.GetAllSoftwareLanguageResponse;
import Kodlama.io.Devs.business.responses.softwareLanguages.GetByIdSoftwareLanguageResponse;
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
	public void add(CreateSoftwareLanguageRequest createSoftwareLanguageRequest) throws Exception {
		// check if name is unique and cannot be blank.
		if (createSoftwareLanguageRequest.getName().isEmpty()) {
			throw new Exception("The software language cannot be left blank!");
		}

		for (SoftwareLanguage language1 : softwareLanguageRepository.findAll()) {
			if (language1.getName().equals(createSoftwareLanguageRequest.getName())) {
				throw new Exception("The software language is available in the database!");
			}
		}
		SoftwareLanguage softwareLanguage = new SoftwareLanguage();
		softwareLanguage.setName(createSoftwareLanguageRequest.getName());
		softwareLanguageRepository.save(softwareLanguage);
	}

	@Override
	public void delete(int id) {
		softwareLanguageRepository.deleteById(id);

	}

	@Override
	public void update(int id, UpdateSoftwareLanguagesRequest updateSoftwareLanguagesRequest) throws Exception {
		// check if name is unique and cannot be blank.
		if (updateSoftwareLanguagesRequest.getName().isEmpty()) {
			throw new Exception("The software language cannot be left blank!");
		}

		for (SoftwareLanguage language : softwareLanguageRepository.findAll()) {
			if (language.getName().equals(updateSoftwareLanguagesRequest.getName())) {
				throw new Exception("The software language is available in the database!");
			}
		}

		SoftwareLanguage sftwareLanguage = softwareLanguageRepository.findById(id).orElseThrow(() -> new Exception("Id does not exist"));
		sftwareLanguage.setName(sftwareLanguage.getName());
		softwareLanguageRepository.save(sftwareLanguage);
	}

	@Override
	public List<GetAllSoftwareLanguageResponse> getAll() {
		List<SoftwareLanguage> softwareLanguages = softwareLanguageRepository.findAll();
		List<GetAllSoftwareLanguageResponse> allSoftwareLanguageResponses = new ArrayList<GetAllSoftwareLanguageResponse>();

		for (SoftwareLanguage softwareLanguage : softwareLanguages) {
			GetAllSoftwareLanguageResponse responseItem = new GetAllSoftwareLanguageResponse();
			responseItem.setId(softwareLanguage.getId());
			responseItem.setName(softwareLanguage.getName());
			allSoftwareLanguageResponses.add(responseItem);

		}
		return allSoftwareLanguageResponses;
	}

	@Override
	public GetByIdSoftwareLanguageResponse getById(int id) throws Exception {
		SoftwareLanguage sftwareLanguage = softwareLanguageRepository.findById(id).orElseThrow(() -> new Exception("Id does not exist"));
		GetByIdSoftwareLanguageResponse response = new GetByIdSoftwareLanguageResponse();
		response.setName(sftwareLanguage.getName());
		return response;
	}
}
