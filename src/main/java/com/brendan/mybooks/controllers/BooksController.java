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
import org.springframework.web.bind.annotation.RequestMapping;

import com.brendan.mybooks.models.Book;
import com.brendan.mybooks.services.ApiService;

@Controller
public class BooksController {
	
	@Autowired
	private ApiService bookService;
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("bookObject") Book book) {
		System.out.println("Hello?");
		model.addAttribute("allBooks", bookService.allBooks());
		return "index.jsp";
	}
	
	@PostMapping("/book")
	public String create(@Valid @ModelAttribute("bookObject") Book book, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("We got errors!");
		}
		
		bookService.createBook(book);
		return "redirect:/";
		
	}
	
	
	@GetMapping("/book/{book_id}")
	public String findOne(@PathVariable("book_id") Long id, Model model) {
		model.addAttribute("book", bookService.findBookById(id));
		return "show.jsp";
	}
	
	@PostMapping("/delete/book/{book_id}")
	public String delete(@PathVariable("book_id") Long id) {
		bookService.deleteLibrary(id);
		return "redirect:/";
	}
	
	@GetMapping("/edit/book/{book_id}")
	public String showEdit(@PathVariable("book_id") Long id, Model model) {
		Book book = bookService.findBookById(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}
	
	@PostMapping("edit/book/{book_id}")
	public String edit(@PathVariable("book_id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		Book editedBook = bookService.editBook(book);
		return "redirect:/";
	}
}
