package com.brendan.mybooks.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brendan.mybooks.models.Book;
import com.brendan.mybooks.services.BookService;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("")
	public String index(Model model, @ModelAttribute("bookObject") Book book) {
		System.out.println("Hello?");
		model.addAttribute("allBooks", bookService.allBooks());
		return "index.jsp";
	}
	
	@PostMapping("book")
	public String create(@Valid @ModelAttribute("bookObject") Book book, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("We got errors!");
		}
		
		bookService.createBook(book);
		return "redirect:/";
		
	}

	
}
