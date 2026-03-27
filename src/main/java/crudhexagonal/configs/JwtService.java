package crudhexagonal.configs;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

public class JwtService {

    private final SecretKey SECRET_KEY =
            Keys.hmacShaKeyFor("minha-chave-super-secreta-com-mais-de-32-caracteres-123456".getBytes());

    public String generateToken(String username){ //Cria o token

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) //1h
                .signWith(SECRET_KEY)
                .compact();
    }


    public String extractUsername(String token){ //Lê o token

        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
    }

    public Boolean isValid(String token){ //Verifica se é válido
        try {
            extractUsername(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
