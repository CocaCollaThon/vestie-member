package vestie.member.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public class UsernameNotFoundException extends RuntimeException {
    private final HttpStatus status = HttpStatus.NOT_FOUND;
    private final String errorMessage;
}
