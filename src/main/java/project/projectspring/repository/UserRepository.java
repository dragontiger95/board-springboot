package project.projectspring.repository;

import java.util.List;
import java.util.Optional;

import project.projectspring.domain.User;

public interface UserRepository {

    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    List<User> findAll();
}
