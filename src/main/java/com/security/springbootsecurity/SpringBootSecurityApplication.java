package com.security.springbootsecurity;

import com.security.springbootsecurity.models.Role;
import com.security.springbootsecurity.models.User;
import com.security.springbootsecurity.repository.RoleRepository;
import com.security.springbootsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootSecurityApplication implements CommandLineRunner{

//	@Autowired
//	private UserRepository userRepository;
//    @Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		if(roleRepository.findAll().isEmpty()) {

			Role role = new Role();
			role.setName("ROLE_ADMIN");
			roleRepository.save(role);

			Role role1 = new Role();
			role1.setName("ROLE_CREATOR");
			roleRepository.save(role1);

			Role role2 = new Role();
			role2.setName("ROLE_USER");
			roleRepository.save(role2);

			Role role3 = new Role();
			role3.setName("ROLE_EDITOR");
			roleRepository.save(role3);

		}

//		User user = new User();
//		user.setUsername("jyoti");
//		user.setEmail("jyoti@example.com");
//		user.setPassword(this.bCryptPasswordEncoder.encode("jyoti"));
//		user.setRole("ROLE_ADMIN");
//		this.userRepository.save(user);
//
//		User user1 = new User();
//		user1.setUserName("john");
//		user1.setEmail("john@example.com");
//		user1.setPassword(this.bCryptPasswordEncoder.encode("john"));
//		user1.setRole("ROLE_NORMAL");
//		this.userRepository.save(user1);
	}
}
