package project.projectspring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import project.projectspring.domain.User;

public class MemoryUserRepository implements UserRepository{

    private static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return store.values().stream()
                    .filter(user -> user.getEmail().equals(email))
                    .findAny();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<User> findByName(String name) {
        return store.values().stream()
                    .filter(user -> user.getName().equals(name))
                    .findAny();
    }

    @Override
    public User save(User user) {
        user.setId(sequence++);
        store.put(user.getId(), user);
        return null;
    }
    
    public void clear() {
        store.clear();
    }
}
