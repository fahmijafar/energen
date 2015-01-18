package net.fahmijafar.energen.service;

import java.util.List;

import org.hibernate.Query;
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
	public User find(String username, String password) {
		// ambil session hibernate
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createSQLQuery("select * from user u where u.username = :username and "
				+ "u.password = :password")
				.addEntity(User.class)
				.setParameter("username", username)
				.setParameter("password", password);
		
		List<User> result = query.list();
		
		// ambil data user
		User user = null;
		if (!result.isEmpty()) {
			user = (User) result.get(0);
		}
		return user;
	}

}
