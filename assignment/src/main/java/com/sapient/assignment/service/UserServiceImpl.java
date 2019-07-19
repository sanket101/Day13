package com.sapient.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.assignment.dao.UserServiceDao;
import com.sapient.assignment.model.Post;
import com.sapient.assignment.model.User;


@Service(value="userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserServiceDao userServiceDao;
	
	public UserServiceImpl(UserServiceDao userServiceDao) {
		this.userServiceDao = userServiceDao;
	}
	
	@Transactional
	public User saveUsers(User user) {
		System.out.println("Inside the save user method of User service class ....");
		return this.userServiceDao.saveUsers(user);
	}
	
	@Transactional
	public void deleteUser(long uid) {
		System.out.println("Inside the delete user method of User service class ....");
		this.userServiceDao.deleteUser(uid);
	}
	
	@Transactional
	public void updateUser(long uid, User user) {
		System.out.println("Inside the update user method of User service class ....");
		this.userServiceDao.updateUser(uid, user);
	}
	
	@Transactional
	public Post createPost(long uid, Post post) {
		System.out.println("Inside the create post method of User service class ....");
		return this.userServiceDao.createPost(uid, post);
	}

	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public List<Post> getPostByUserId(long uid) {
		System.out.println("Inside the get post method of User service class ....");
		return this.userServiceDao.getPostByUserId(uid);
	}
	
	@Transactional
	public void deletePostByUserId(long uid, long pid) {
		System.out.println("Inside the delete post method of User service class ....");
		this.userServiceDao.deletePostByUserId(uid, pid);;
	}
	
	@Transactional
	public void deleteAllPostByUser(long uid) {
		System.out.println("Inside the delete all post method of User service class ....");
		this.userServiceDao.deleteAllPostByUser(uid);;
	}
}
