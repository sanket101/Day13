package com.sapient.assignment.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.assignment.model.Post;
import com.sapient.assignment.model.User;
import com.sapient.assignment.service.UserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/api/v1/users/")
@EnableSwagger2
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/", consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public void saveUser(@Valid @RequestBody User user) {
		System.out.println("Inside saveUser..");
		this.userService.saveUsers(user);
	}
	
	@PutMapping(value="/{uid}", consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public void updateProduct(@PathVariable int uid, @RequestBody User user) {
		System.out.println("Came inside update user method");
		this.userService.updateUser(uid, user);
	}
	
	@DeleteMapping(value="/{uid}")
	public void deleteProduct(@PathVariable int uid) {
		System.out.println("Deleted the user successfully");
		this.userService.deleteUser(uid);
	}
	
	@PostMapping(value="/{uid}/post", consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public void createPost(@PathVariable int uid, @RequestBody Post post) {
		System.out.println("Created the post successfully");
		this.userService.createPost(uid, post);
	}
	
	@GetMapping(value="/{uid}/post", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public void getPostByUserId(@PathVariable int uid) {
		System.out.println("Got the post successfully");
		this.userService.getPostByUserId(uid);
	}
	
	@DeleteMapping(value="/{uid}/post/{pid}")
	public void deletePostByUserId(@PathVariable int uid, @PathVariable int pid) {
		System.out.println("Deleted the particular post successfully");
		this.userService.deletePostByUserId(uid, pid);
	}
	
	@DeleteMapping(value="/{uid}/post")
	public void deleteAllPostByUser(@PathVariable int uid) {
		System.out.println("Deleted all post successfully");
		this.userService.deleteAllPostByUser(uid);
	}
}
