package vestie.member.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vestie.member.exception.DuplicateUsernameException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(DuplicateUsernameException.class)
    public ResponseEntity<ErrorMessage> duplicateUsernameException(DuplicateUsernameException e){
        return ResponseEntity.status(e.getStatus())
                .body(ErrorMessageFactory.from(e.getStatus(), e.getErrorMessage()));
    }
}
