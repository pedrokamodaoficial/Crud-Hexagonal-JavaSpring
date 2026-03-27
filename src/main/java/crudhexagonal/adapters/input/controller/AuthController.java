package crudhexagonal.adapters.input.controller;

import crudhexagonal.application.usecase.LoginUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final LoginUseCase loginUseCase;

    public AuthController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        return loginUseCase.execute(request.username(), request.password());
    }
}
