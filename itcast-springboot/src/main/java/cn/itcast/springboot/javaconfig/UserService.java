package cn.itcast.springboot.javaconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public List<User> queryUserList(){
		return userDAO.queryUserList();
	}
}
