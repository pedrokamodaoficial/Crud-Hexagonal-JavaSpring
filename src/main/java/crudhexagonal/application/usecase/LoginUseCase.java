package crudhexagonal.application.usecase;

import crudhexagonal.configs.JwtService;
import crudhexagonal.domain.repository.UserRepository;

public class LoginUseCase {

    private final UserRepository userRepository;
    private final JwtService  jwtService;

    public LoginUseCase(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public String execute(String username, String password){

        var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Senha inválida");
        }

        return jwtService.generateToken(username);
    }
}
