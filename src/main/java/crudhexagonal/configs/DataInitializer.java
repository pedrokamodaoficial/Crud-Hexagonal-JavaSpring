package crudhexagonal.configs;

import crudhexagonal.domain.model.User;
import crudhexagonal.domain.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner init(UserRepository userRepository){
        return args -> {

            if (userRepository.findByUsername("admin").isEmpty()){

                User user = new User(
                        null,
                        "admin",
                        "123456"
                );

                userRepository.save(user);

                System.out.println("Usuário admin criado");
            }
        };
    }
}
