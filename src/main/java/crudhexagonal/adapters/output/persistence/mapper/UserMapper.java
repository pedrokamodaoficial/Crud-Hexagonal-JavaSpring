package crudhexagonal.adapters.output.persistence.mapper;

import crudhexagonal.adapters.output.persistence.entity.UserEntity;
import crudhexagonal.domain.model.User;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
    }

    public static User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getUsername(),
                entity.getPassword()
        );
    }
}
