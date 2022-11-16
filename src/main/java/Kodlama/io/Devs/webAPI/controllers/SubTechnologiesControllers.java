package Kodlama.io.Devs.webAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.SubTechnologyService;
import Kodlama.io.Devs.business.requests.subTechnologies.CreateSubTechRequest;
import Kodlama.io.Devs.business.requests.subTechnologies.UpdateSubTechRequest;
import Kodlama.io.Devs.business.responses.subTechnologies.GetAllSubTechnologyResponse;
import Kodlama.io.Devs.business.responses.subTechnologies.GetByIdSubTechnologyResponse;

@RestController
@RequestMapping("/api/subtechs")
public class SubTechnologiesControllers {
	private SubTechnologyService subTechnologyService;

	@Autowired
	public SubTechnologiesControllers(SubTechnologyService subTechnologyService) {
		this.subTechnologyService = subTechnologyService;
	}
	
	@PostMapping("/add")
	 public void add(CreateSubTechRequest createSubTechRequest) throws Exception{
		 subTechnologyService.add(createSubTechRequest);
	 }
	
	@DeleteMapping("/delete")
	public void delete(int id) {
		subTechnologyService.delete(id);
	}
	 
	@PutMapping("/update")
	public void update(int id, UpdateSubTechRequest updateSubTechRequest) throws Exception{
		subTechnologyService.update(id,updateSubTechRequest);
	}
	
	@GetMapping("/getall")
	public List<GetAllSubTechnologyResponse> getAll() {
		return subTechnologyService.getAll();
	}
	
	@GetMapping("/getbyid")
	public GetByIdSubTechnologyResponse getById(@RequestParam int id) throws Exception {
		return subTechnologyService.getById(id);
	}
	

}
