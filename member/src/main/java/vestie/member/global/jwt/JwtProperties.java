package vestie.member.global.jwt;

public interface JwtProperties {
    int EXPIRATION_TIME = 60000*30; // 30분
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}