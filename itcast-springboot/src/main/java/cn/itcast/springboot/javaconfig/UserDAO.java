package cn.itcast.springboot.javaconfig;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	public List<User> queryUserList(){
		List<User> list=new ArrayList<User>();
		
		//模拟数据库的查询
		for(int i=0; i<10;i++){
			User user=new User();
			user.setName("name"+i);
			user.setAge(i+1);
			user.setPassword("password"+i);
			list.add(user);
		}
		return list;
	}
}
