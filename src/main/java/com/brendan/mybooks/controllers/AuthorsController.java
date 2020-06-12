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

import com.brendan.mybooks.models.Author;
import com.brendan.mybooks.services.ApiService;

@Controller
public class AuthorsController {
	
	@Autowired
	ApiService apiService;
	
	@GetMapping("/author")
	public String authors(@ModelAttribute("authorObject") Author author, Model model) {
		model.addAttribute("authors", apiService.allAuthors());
		return "authors.jsp";
	}
	
	@PostMapping("/author")
	private String createAuthor(@Valid @ModelAttribute("author") Author author, BindingResult result, Model model) {
		System.out.println(author.toString());
		if(result.hasErrors()) {
			return "authors.jsp";
		}else {
			apiService.createAuthor(author);
			return "redirect:/author";
		}
	}
	
	@PostMapping("/delete/author/{id}")
	private String deleteAuthor(@PathVariable Long id) {
		apiService.deleteAuthor(id);
		return "redirect:/author";
	}

}
