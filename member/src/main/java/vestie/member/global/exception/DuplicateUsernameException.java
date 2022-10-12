package vestie.member.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public class DuplicateUsernameException extends RuntimeException {
    private final HttpStatus status = HttpStatus.CONFLICT;
    private final String errorMessage;
}
