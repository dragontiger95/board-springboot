package project.projectspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import project.projectspring.repository.MemoryUserRepository;
import project.projectspring.repository.UserRepository;

@Configuration
public class SpringConfig {
    
    @Bean
    public UserRepository userRepository() {
        return new MemoryUserRepository();
    }
}
