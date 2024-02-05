package com.gcu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController 
{
		// Display Home Page
		@GetMapping("/home")
		public String showAllListings()
		{
			return "home";
		}
}
