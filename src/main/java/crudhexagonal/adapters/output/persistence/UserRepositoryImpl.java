package crudhexagonal.adapters.output.persistence;

import crudhexagonal.adapters.output.persistence.mapper.UserMapper;
import crudhexagonal.adapters.output.persistence.repository.SpringDataUserRepository;
import crudhexagonal.domain.model.User;
import crudhexagonal.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final SpringDataUserRepository repository;

    public UserRepositoryImpl(SpringDataUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        var entity = UserMapper.toEntity(user);
        var saved = repository.save(entity);
        return UserMapper.toDomain(saved);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username)
                .map(UserMapper::toDomain);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return repository.findById(id)
                .map(UserMapper::toDomain);
    }
}
