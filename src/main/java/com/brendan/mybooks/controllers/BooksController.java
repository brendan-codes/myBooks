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

import com.brendan.mybooks.models.Book;
import com.brendan.mybooks.services.ApiService;

@Controller
public class BooksController {
	
	@Autowired
	private ApiService apiService;
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("bookObject") Book book) {
		System.out.println("Hello?");
		model.addAttribute("allBooks", apiService.allBooks());
		model.addAttribute("libraries", apiService.allLibraries());
		return "index.jsp";
	}
	
	@PostMapping("/book")
	public String create(@Valid @ModelAttribute("bookObject") Book book, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("We got errors!");
		}
		
		apiService.createBook(book);
		return "redirect:/";
		
	}
	
	
	@GetMapping("/book/{book_id}")
	public String findOne(@PathVariable("book_id") Long id, @ModelAttribute("bookObject") Book book, Model model) {
		model.addAttribute("book", apiService.findBookById(id));
		model.addAttribute("authors", apiService.allAuthors());
		return "show.jsp";
	}
	
	@PostMapping("/book/addAuthor/{book_id}")
	public String addAuthor(@PathVariable("book_id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		
		apiService.editBook(book);
		return "redirect:/";
	}
	
	@PostMapping("/delete/book/{book_id}")
	public String delete(@PathVariable("book_id") Long id) {
		apiService.deleteLibrary(id);
		return "redirect:/";
	}
	
	@GetMapping("/edit/book/{book_id}")
	public String showEdit(@PathVariable("book_id") Long id, Model model) {
		Book book = apiService.findBookById(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}
	
	@PostMapping("edit/book/{book_id}")
	public String edit(@PathVariable("book_id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		apiService.editBook(book);
		return "redirect:/";
	}
}
