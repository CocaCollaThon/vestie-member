package vestie.member.global.jwt;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import vestie.member.domain.Member;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    // secret key를 base64로 인코딩
    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(Member member) {
        Date now = new Date();
        System.out.println(secretKey);
        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("fresh")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + Duration.ofMinutes(30).toMillis()))
                .claim("id", member.getId())
                .claim("username", member.getUsername())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
