package Kodlama.io.Devs.webAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.SoftwareLanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.SoftwareLanguageRepository;
import Kodlama.io.Devs.entities.SoftwareLanguage;

@RestController
@RequestMapping("/api/languages")
public class SoftwareLanguagesControllers {
	private SoftwareLanguageService softwareLanguageService;
	
	@Autowired
	public SoftwareLanguagesControllers(SoftwareLanguageService softwareLanguageService) {
		this.softwareLanguageService = softwareLanguageService;
	}

	@PostMapping("/add")
	public void add(SoftwareLanguage softwareLanguage) throws Exception {
		softwareLanguageService.add(softwareLanguage);
	}

	@DeleteMapping("/delete")
	public void delete(int id) {
		softwareLanguageService.delete(id);
	}

	@PutMapping("/update")
	public void update(int id, SoftwareLanguage softwareLanguage) throws Exception {
		softwareLanguageService.update(id, softwareLanguage);
	}

	@GetMapping("/getall")
	List<SoftwareLanguage> getAll() {
		return softwareLanguageService.getAll();
	}

	@GetMapping("/getbyid")
	public SoftwareLanguage getById(int id) {
		return softwareLanguageService.getById(id);
	}

}
