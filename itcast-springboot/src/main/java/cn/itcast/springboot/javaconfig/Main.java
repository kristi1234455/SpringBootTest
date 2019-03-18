package cn.itcast.springboot.javaconfig;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new 
				AnnotationConfigApplicationContext(SpringConfig.class);
		UserService userService=context.getBean(UserService.class);
		List<User> list = userService.queryUserList();
		for(User user : list){
			System.out.println(user.getName()+","+user.getPassword()+","+user.getAge());
		}
		context.destroy();
	}
}
