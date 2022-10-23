package project.projectspring.repository;

import java.util.List;
import java.util.Optional;

import project.projectspring.domain.User;

public class JpaUserRepository implements UserRepository {

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        
        return null;
    }

}