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

import Kodlama.io.Devs.business.abstracts.SoftwareLanguageService;
import Kodlama.io.Devs.business.requests.softwareLanguages.CreateSoftwareLanguageRequest;
import Kodlama.io.Devs.business.requests.softwareLanguages.UpdateSoftwareLanguagesRequest;
import Kodlama.io.Devs.business.responses.softwareLanguages.GetAllSoftwareLanguageResponse;
import Kodlama.io.Devs.business.responses.softwareLanguages.GetByIdSoftwareLanguageResponse;

@RestController
@RequestMapping("/api/languages")
public class SoftwareLanguagesControllers {
	private SoftwareLanguageService softwareLanguageService;
	
	@Autowired
	public SoftwareLanguagesControllers(SoftwareLanguageService softwareLanguageService) {
		this.softwareLanguageService = softwareLanguageService;
	}

	@PostMapping("/add")
	public void add(CreateSoftwareLanguageRequest createSoftwareLanguageRequest) throws Exception {
		softwareLanguageService.add(createSoftwareLanguageRequest);
	}

	@DeleteMapping("/delete")
	public void delete(int id) {
		softwareLanguageService.delete(id);
	}

	@PutMapping("/update")
	public void update(int id, UpdateSoftwareLanguagesRequest updateSoftwareLanguagesRequest) throws Exception {
		softwareLanguageService.update(id, updateSoftwareLanguagesRequest);
	}

	@GetMapping("/getall")
	List<GetAllSoftwareLanguageResponse> getAll() {
		return softwareLanguageService.getAll();
	}

	@GetMapping("/getbyid")
	public GetByIdSoftwareLanguageResponse getById(@RequestParam int id) throws Exception {
		return softwareLanguageService.getById(id);
	}

}
