package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.subTechnologies.CreateSubTechRequest;
import Kodlama.io.Devs.business.requests.subTechnologies.UpdateSubTechRequest;
import Kodlama.io.Devs.business.responses.subTechnologies.GetAllSubTechnologyResponse;
import Kodlama.io.Devs.business.responses.subTechnologies.GetByIdSubTechnologyResponse;

public interface SubTechnologyService {
	// add if it complies with the business rules
	void add(CreateSubTechRequest createSubTechRequest) throws Exception;

	void delete(int id);

	// update if it complies with the business rules
	void update(int id, UpdateSubTechRequest updateSubTechRequest) throws Exception;

	List<GetAllSubTechnologyResponse> getAll();

	GetByIdSubTechnologyResponse getById(int id) throws Exception;

}
