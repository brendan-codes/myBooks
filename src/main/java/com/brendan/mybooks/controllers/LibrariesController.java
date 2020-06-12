package com.brendan.mybooks.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.brendan.mybooks.models.Library;
import com.brendan.mybooks.services.ApiService;

@Controller
public class LibrariesController {

	@Autowired
	ApiService apiService;
	
	@GetMapping("/library")
	private String libraries(@ModelAttribute("library") Library library, Model model) {
		model.addAttribute("libraries", apiService.allLibraries());
		return "libraries.jsp";
	}
	
	@PostMapping("/library")
	private String createLibrary(@Valid @ModelAttribute("library") Library library, BindingResult result, Model model) {
		System.out.println(library.toString());
		if(result.hasErrors()) {
			return "libraries.jsp";
		}else {
			apiService.createLibrary(library);
			return "redirect:/library";
		}
	}
	
	@PostMapping("/delete/library/{id}")
	private String deleteLibrary(@PathVariable Long id) {
		apiService.deleteLibrary(id);
		return "redirect:/library";
	}
}
