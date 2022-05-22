package auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTTOKEN {

    @Autowired
    public JWTTOKEN() {}
    public String secretKey = "q1w2e3r4";
    public Map<String, Object> makeHeader() {

        Map<String, Object> headerClaims = new HashMap<>();
        headerClaims.put("alg", "HMCA256");
        headerClaims.put("typ", "JWT");

        return headerClaims;
    }
    public Map<String, String> makePayload(User user) {

        Map<String, String> payloadClaims  = new HashMap<>();
        payloadClaims.put("id", Long.toString(user.getId()));
        payloadClaims.put("account", user.getAccount());
        payloadClaims.put("nickname", user.getNickname());

        return payloadClaims ;
    }
    public String create(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            Map<String, Object> headerClaims = makeHeader();
            Map<String, String> payloadClaims = makePayload(user);

            return JWT.create().withIssuer("hspark").withIssuedAt(new Date()).withHeader(headerClaims).withPayload(payloadClaims).sign(algorithm);
        }
        catch(JWTCreationException exception) {
            System.out.println("JWT CRETAE EXCEPT: " + exception.getMessage());
            return "ERR";
        }
    }

    public User verify(String token) {
        User user = new User();
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("hspark")
                    .acceptExpiresAt(60* 60) // 1 hour
                    .build();
            DecodedJWT jwt = verifier.verify(token);


            user.setId(Long.parseLong(jwt.getClaim("id").asString()));
            user.setAccount(jwt.getClaim("account").asString());
            user.setNickname(jwt.getClaim("nickname").asString());

            System.out.println("DEOCDE" + jwt.getToken());
            System.out.println(user.getId());
        }
        catch(JWTVerificationException exception){
            System.out.println("JWT VERIFY EXCEPT: "+ exception.getMessage());
        }
        return user;
    }

}
