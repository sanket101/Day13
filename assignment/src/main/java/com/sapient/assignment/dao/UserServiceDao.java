package com.sapient.assignment.dao;

import java.util.List;

import com.sapient.assignment.model.Post;
import com.sapient.assignment.model.User;

public interface UserServiceDao {
	
	public User saveUsers(User user);

    //public List<User> fetchAllUsers();

    //public User findById(long id);

    public void deleteUser(long uid);
    
    public void updateUser(long uid, User user);
    
    public Post createPost(long uid, Post post);
    
    public List<Post> getAllPost();
    
    public List<Post> getPostByUserId(long uid);
    
    public void deletePostByUserId(long uid, long pid);
    
    public void deleteAllPostByUser(long uid);
}
