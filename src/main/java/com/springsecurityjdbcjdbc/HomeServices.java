package com.springsecurityjdbcjdbc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeServices {
	@GetMapping("/")
	public String home()
	{
		return ("<h1>Welcome</h1>");
	}
   @GetMapping("/user")
   public String user()
   {
	   return ("<h2>Welcome to User Page</h1>");
		   
   }
   @GetMapping("/admin")
   public String admin()
   {
	   return ("<h2>Welcome to  Admin Page</h1>");
		   
   }

}
