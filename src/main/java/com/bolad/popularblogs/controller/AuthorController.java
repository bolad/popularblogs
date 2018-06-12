package com.bolad.popularblogs.controller;

import com.bolad.popularblogs.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService){
        super();
        this.authorService = authorService;
    }

    @RequestMapping("/list")
    public String listOfAuthors(Model model){
        model.addAttribute("authors", authorService.listOfAuthors());
        return "author/list";
    }

    @RequestMapping("/view")
    /*
    @ModelAttribute methods are invoked before the controller methods annotated
    with @RequestMapping are invoked. The logic behind the sequence is that, the
    model object has to be created before any processing starts inside the controller methods.
     */
    public String view(Model model){
        return "author/view";
    }
}
