package com.sapient.assignment.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sapient.assignment.model.Post;
import com.sapient.assignment.model.User;

@Repository("hibernateDAOImpl")
public class HibernateUserServiceDaoImpl implements UserServiceDao{
	
	@Autowired
    private SessionFactory sessionFactory;

	public User saveUsers(User user) {
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        return user;
	}

	public void deleteUser(long uid) {
		Session session = sessionFactory.getCurrentSession();
        User u = session.byId(User.class).load(uid);
        session.delete(u);
	}

	public void updateUser(long uid, User user) {
		Session session = sessionFactory.getCurrentSession();
    	User u1 = session.byId(User.class).load(uid);
    	u1.setName(user.getName());
    	u1.setAddress(user.getAddress());
    	u1.setPostList(user.getPostList());
    	session.saveOrUpdate(u1);
	}

	public Post createPost(long uid, Post post) {
		Session session = sessionFactory.getCurrentSession();
		User u1 = session.byId(User.class).load(uid);
		List<Post> lp = u1.getPostList();
		lp.add(post);
		u1.setPostList(lp);
		session.saveOrUpdate(u1);
		return post;
	}

	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Post> getPostByUserId(long uid) {
		Session session = sessionFactory.getCurrentSession();
		User u1 = session.byId(User.class).load(uid);
		return u1.getPostList();
	}

	public void deletePostByUserId(long uid, long pid) {
		Session session = sessionFactory.getCurrentSession();
		User u1 = session.byId(User.class).load(uid);
		List<Post> lp = u1.getPostList();
		for(Post p : lp) {
			if(p.getPid() == pid) {
				session.delete(p);
			}
		}
	}

	public void deleteAllPostByUser(long uid) {
		Session session = sessionFactory.getCurrentSession();
		User u1 = session.byId(User.class).load(uid);
		List<Post> lp = u1.getPostList();
		for(Post p : lp) {
			session.delete(p);
		}
	}
		
}
