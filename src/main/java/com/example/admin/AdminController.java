package com.example.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository ;
	
	// get admin detail by admin_name
//
//	@GetMapping("/admin/{name}")
//	public Admin getAdminDetails(@PathVariable("name") String name){
//		return this.adminRepository.findByName(name);
//	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Admin admin) {
		Admin existingAdmin = adminRepository.findByName(admin.getName());
		if (existingAdmin == null || !existingAdmin.getPassword().equals(admin.getPassword())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
		} else {
			return ResponseEntity.ok("Login successful");
		}
	}

	}
