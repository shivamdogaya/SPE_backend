package com.example.user;

import java.util.List;

import com.example.admin.Admin;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	   @Autowired
	   private UserRepository userRepository;
	   
	     // get all user
		   @GetMapping("/user")
		   public List<User> getAllUser() {
			   return (List<User>)this.userRepository.findAll();
		   }
	   
	   
	   // get user detail by its email
	   @GetMapping("/user/{email}")
	   public User getUserDetails(@PathVariable("email") String email) {
		   return this.userRepository.findByEmail(email);
	   }

	@PostMapping("/use")
	public ResponseEntity<String> login(@RequestBody @NotNull User user) {
		User existingUser = userRepository.findByEmail(user.getEmail());
		if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
		} else {
			return ResponseEntity.ok("Login successful");
		}
	}
	   // to add a new user
	   @PostMapping("/user")
	   public User addNewUser(@RequestBody User user) {
		   return this.userRepository.save(user);
	   }
}
