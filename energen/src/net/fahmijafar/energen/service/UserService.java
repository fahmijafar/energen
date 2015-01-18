package net.fahmijafar.energen.service;

import net.fahmijafar.energen.pojo.User;

public interface UserService {
	User find(String username, String password);
}
