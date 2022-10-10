package project.projectspring.repository;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import project.projectspring.domain.User;

class MemoryUserRepositoryTest {
    
    MemoryUserRepository userRepository = new MemoryUserRepository();

    @AfterEach
    public void afterEach() {
        userRepository.clear();
    }

    @Test
    public void save() {
        User user = new User();
        user.setName("spring");
        
        userRepository.save(user);

        User res = userRepository.findById(user.getId()).get();
        org.assertj.core.api.Assertions.assertThat(user).isEqualTo(res);
    }

    @Test
    public void findByName() {
        
        User user1 = new User();
        user1.setName("spring1");
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("spring2");
        userRepository.save(user2);

        User res = userRepository.findByName("spring2").get();
        Assertions.assertThat(res).isEqualTo(user2);
    }

    @Test
    public void findAll() {

        User user1 = new User();
        user1.setName("spring1");
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("spring2");
        userRepository.save(user2);

        List<User> res = userRepository.findAll();
        Assertions.assertThat(res.size()).isEqualTo(2);

    }

}
