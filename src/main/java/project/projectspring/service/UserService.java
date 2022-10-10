package project.projectspring.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.projectspring.domain.User;
import project.projectspring.repository.MemoryUserRepository;
import project.projectspring.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(User user){
        // 같은 email인 중복 회원 필터링
        validateDuplicateUser(user); // 중복 회원 검증

        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user){
        userRepository.findByEmail(user.getEmail())
            .ifPresent(u -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /**
     * 전체 유저 조회
     */
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    /**
     * 단일 유저 조회
     */
    public Optional<User> findOneUser(Long id){
        return userRepository.findById(id);
    }

}
