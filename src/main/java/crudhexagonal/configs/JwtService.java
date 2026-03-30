package crudhexagonal.configs;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private final SecretKey SECRET_KEY =
            Keys.hmacShaKeyFor("minha-chave-super-secreta-com-mais-de-32-caracteres-123456".getBytes());

    public String generateToken(String username){ //Cria o token

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) //1h
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }


    public String extractUsername(String token){ //Lê o token

        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Boolean isValid(String token){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
