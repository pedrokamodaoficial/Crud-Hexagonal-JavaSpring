package crudhexagonal.application.usecase;

import crudhexagonal.domain.model.User;
import crudhexagonal.domain.repository.UserRepository;

public class CreateUserUseCase {
    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String username, String password){
        //Regra 1 - Validar username
        if (username == null || username.isBlank()){
            throw new IllegalArgumentException("Username inválido!");
        }

        //Regra 2 - verificar se já existe
        userRepository.findByUsername(username).
                ifPresent(u -> {
            throw new IllegalArgumentException("Usuário já existe");
        });

        //Regra 3 - Criar usuário
        User user = new User(username, password);

        //Regra 4 - Salvar
        return userRepository.save(user);
    }
}
