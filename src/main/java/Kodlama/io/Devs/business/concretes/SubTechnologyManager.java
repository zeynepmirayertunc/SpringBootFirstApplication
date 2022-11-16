package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.SubTechnologyService;
import Kodlama.io.Devs.business.requests.subTechnologies.CreateSubTechRequest;
import Kodlama.io.Devs.business.requests.subTechnologies.UpdateSubTechRequest;
import Kodlama.io.Devs.business.responses.subTechnologies.GetAllSubTechnologyResponse;
import Kodlama.io.Devs.business.responses.subTechnologies.GetByIdSubTechnologyResponse;
import Kodlama.io.Devs.dataAccess.abstracts.SoftwareLanguageRepository;
import Kodlama.io.Devs.dataAccess.abstracts.SubTechnologyRepository;
import Kodlama.io.Devs.entities.SoftwareLanguage;
import Kodlama.io.Devs.entities.SubTechnology;

@Service
public class SubTechnologyManager implements SubTechnologyService {
	private SubTechnologyRepository subTechnologyRepository;
	private SoftwareLanguageRepository softwareLanguageRepository;

	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository,
			SoftwareLanguageRepository softwareLanguageRepository) {
		this.subTechnologyRepository = subTechnologyRepository;
		this.softwareLanguageRepository = softwareLanguageRepository;
	}

	@Override
	public void add(CreateSubTechRequest createSubTechRequest) throws Exception {
		// check if name is unique and cannot be blank.
		if (createSubTechRequest.getName().isEmpty()) {
			throw new Exception("The software language cannot be left blank!");
		}

		for (SubTechnology subTechnology : subTechnologyRepository.findAll()) {
			if (subTechnology.getName().equals(createSubTechRequest.getName())) {
				throw new Exception("The software language is available in the database!");
			}
		}
		SubTechnology subTechnology = new SubTechnology();
		SoftwareLanguage softwareLanguage = softwareLanguageRepository.findById(createSubTechRequest.getLanguage_id()).get();
		subTechnology.setName(createSubTechRequest.getName());
		subTechnology.setSoftwareLanguage(softwareLanguage);
		subTechnologyRepository.save(subTechnology);
	}

	@Override
	public void delete(int id) {
		subTechnologyRepository.deleteById(id);

	}

	@Override
	public void update(int id, UpdateSubTechRequest updateSubTechRequest) throws Exception {
		// check if name is unique and cannot be blank.
		if (updateSubTechRequest.getName().isEmpty()) {
			throw new Exception("The software language cannot be left blank!");
		}

		for (SubTechnology subTechnology : subTechnologyRepository.findAll()) {
			if (subTechnology.getName().equals(updateSubTechRequest.getName())) {
				throw new Exception("The software language is available in the database!");
			}
		}
		
		SubTechnology subTechnology = subTechnologyRepository.findById(id)
				.orElseThrow(() -> new Exception("id does not exist"));
		subTechnology.setName(updateSubTechRequest.getName());
		

		subTechnologyRepository.save(subTechnology);

	}

	@Override
	public List<GetAllSubTechnologyResponse> getAll() {

		List<SubTechnology> subTechnologies = subTechnologyRepository.findAll();
		List<GetAllSubTechnologyResponse> getAllSubTechnologyResponses = new ArrayList<GetAllSubTechnologyResponse>();

		for (SubTechnology subTechnology : subTechnologies) {
			GetAllSubTechnologyResponse responseItem = new GetAllSubTechnologyResponse();
			// We called the SoftwareLanguage entity in the SubTechnology entity
			SoftwareLanguage softwareLanguage = softwareLanguageRepository
					.getReferenceById(subTechnology.getSoftwareLanguage().getId());
			responseItem.setId(subTechnology.getId());
			responseItem.setName(subTechnology.getName());
			responseItem.setLanguage_id(softwareLanguage.getId());
			responseItem.setLanguage_name(softwareLanguage.getName());
			getAllSubTechnologyResponses.add(responseItem);
		}

		return getAllSubTechnologyResponses;
	}

	@Override
	public GetByIdSubTechnologyResponse getById(int id) throws Exception {
		SubTechnology subTechnology = subTechnologyRepository.findById(id)
				.orElseThrow(() -> new Exception("Id does not exist"));
		SoftwareLanguage softwareLanguage = softwareLanguageRepository
				.getReferenceById(subTechnology.getSoftwareLanguage().getId());
		GetByIdSubTechnologyResponse response = new GetByIdSubTechnologyResponse();
		response.setName(subTechnology.getName());
		response.setLanguage_name(softwareLanguage.getName());

		return response;
	}

}
