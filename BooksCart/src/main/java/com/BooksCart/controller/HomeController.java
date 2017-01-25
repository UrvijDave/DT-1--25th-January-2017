package com.BooksCart.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.BooksCart.model.Product;


@Controller
public class HomeController {

	//need to call methods of userdaoimpl---- use autowired
	
	
	@RequestMapping("/")
	public String homePage() {

		System.out.println("Executing HomePage");
		return "index";
	}
	
/*	
	@RequestMapping("/homePage")
	public String homePage() {

		System.out.println("Executing HomePage");
		return "welcome";
	}
*/	
	
	@RequestMapping("/login")
	public ModelAndView showLoginPage()
	{
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("msg", "You clicked Login");
		mv.addObject("showLoginPage", "true");
		return mv;
	}
	
	@RequestMapping("/registration")
	public ModelAndView showRegistrationPage()
	{
		ModelAndView mv = new ModelAndView("registration");
		mv.addObject("msg", "You clicked registration");
		mv.addObject("showRegistrationPage", "true");
		return mv;
	}

	
	
	/*-------contact us-----------*/
 	@RequestMapping("/contactus")
	public ModelAndView showContactUs()
	{
		System.out.println("Contact Us called.....");
		ModelAndView mv = new ModelAndView("contactus");
		mv.addObject("showContactUs", "true");
		return mv;
	}
	
	/*--------Books Page----------*/
	
 	@RequestMapping("/books")
	public ModelAndView showBooksPage()
	{
		ModelAndView mv = new ModelAndView("books");
		mv.addObject("msg", "You clicked books");
		mv.addObject("showBooksPage", "true");
		return mv;
	}	
 	
/*--------Category Page----------*/
	
 	@RequestMapping("/category")
	public ModelAndView showCategoryPage()
	{
		ModelAndView mv = new ModelAndView("category");
		mv.addObject("msg", "You clicked on Category Page");
		mv.addObject("showCategoryPage", "true");
		return mv;
	}	
 	
/*--------Category Page----------*/
	
 	@RequestMapping("/publisher")
	public ModelAndView showPublisherPage()
	{
		ModelAndView mv = new ModelAndView("publisher");
		mv.addObject("msg", "You clicked on Publisher Page");
		mv.addObject("showPublisherPage", "true");
		return mv;
	}	

/*--------Fiction Page----------*/
	
 	@RequestMapping("/fiction")
	public ModelAndView showFictionPage()
	{
		ModelAndView mv = new ModelAndView("fiction");
		mv.addObject("msg", "You clicked on Fiction Category");
		mv.addObject("showFictionPage", "true");
		return mv;
	}	
 	
/*--------Spiritual Page----------*/
	
 	@RequestMapping("/spiritual")
	public ModelAndView showSpiritualPage()
	{
		ModelAndView mv = new ModelAndView("spiritual");
		mv.addObject("msg", "You clicked on Spiritual Category");
		mv.addObject("showSpiritualPage", "true");
		return mv;
	}
/*--------Science Page----------*/
	
 	@RequestMapping("/science")
	public ModelAndView showSciencePage()
	{
		ModelAndView mv = new ModelAndView("science");
		mv.addObject("msg", "You clicked on Science Category");
		mv.addObject("showSciencePage", "true");
		return mv;
	}	
	
/*--------Add Product Page----------
	
 	@RequestMapping("/addproduct")
	public ModelAndView showAddProductPage()
	{
		ModelAndView mv = new ModelAndView("addproduct");
		mv.addObject("msg", "You clicked on Add Product");
		mv.addObject("showAddProductPage", "true");
		return mv;
	} 	*/
 	
 	/*--------Validate Method----------*/	
	@RequestMapping("/validate")
	public ModelAndView validate(@RequestParam("id") String id, @RequestParam("password") String password)
	{
		System.out.println("id: " + id);
		System.out.println("pwd: " + password);
		System.out.print("In Validate Method");
		ModelAndView mv = new ModelAndView("index");
/*		UserDAO userDAO = new UserDAO();
		
		if (userDAO.isValidCredentials(id, password) == true)
		{
			mv.addObject("successMsg", "You logged in Successfully");
		}
		else
		{
			mv.addObject("errorMsg", "Invalid credentials. Try again");
		} */
		return mv;
	}

}