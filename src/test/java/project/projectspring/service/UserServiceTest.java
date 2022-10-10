package project.projectspring.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.projectspring.domain.User;
import project.projectspring.repository.MemoryUserRepository;
import project.projectspring.repository.UserRepository;

public class UserServiceTest {

    UserService userService;
    MemoryUserRepository userRepository;

    @BeforeEach
    public void beforeEach() {
        userRepository = new MemoryUserRepository();
        userService = new UserService(userRepository);
    }

    @AfterEach
    public void afterEach() {
        userRepository.clear();
    }


    @Test
    void testFindOneUser() {

    }

    @Test
    void testFindUsers() {

    }

    @Test
    void 회원가입() {
        // given
        User user1 = new User();
        user1.setName("spring1");
        user1.setEmail("spring@test.com");

        // when
        Long saveId = userService.join(user1);

        // then
        User res = userService.findOneUser(saveId).get();
        Assertions.assertThat(user1.getEmail()).isEqualTo(res.getEmail());

    }

    @Test
    public void 중복_회원_예외() {
        // given
        User user1 = new User();
        user1.setEmail("spring@test.com");

        User user2 = new User();
        user2.setEmail("spring@test.com");

        // when
        userService.join(user1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> userService.join(user2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        // try {
        //     userService.join(user2);
        //     fail();
        // } catch(IllegalStateException e){
        //     Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        // }

        // then
    }
}
