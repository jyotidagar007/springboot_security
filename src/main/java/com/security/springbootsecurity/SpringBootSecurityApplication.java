package com.security.springbootsecurity;

import com.security.springbootsecurity.models.User;
import com.security.springbootsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootSecurityApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		User user = new User();
		user.setUserName("jyoti");
		user.setEmail("jyoti@example.com");
		user.setPassword(this.bCryptPasswordEncoder.encode("jyoti"));
		user.setRole("ROLE_ADMIN");
		this.userRepository.save(user);

		User user1 = new User();
		user1.setUserName("john");
		user1.setEmail("john@example.com");
		user1.setPassword(this.bCryptPasswordEncoder.encode("john"));
		user1.setRole("ROLE_NORMAL");
		this.userRepository.save(user1);
	}
}
