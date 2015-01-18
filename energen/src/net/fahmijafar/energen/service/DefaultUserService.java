package net.fahmijafar.energen.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.fahmijafar.energen.pojo.User;

@Service
public class DefaultUserService implements UserService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=true)
	public User find(String userId) {
		// ambil session hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// ambil data user
		User user = (User) session.get(User.class, userId);
		return user;
	}

}
