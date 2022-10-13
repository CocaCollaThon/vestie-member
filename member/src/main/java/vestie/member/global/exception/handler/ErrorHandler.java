package vestie.member.global.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vestie.member.global.exception.DuplicateUsernameException;
import vestie.member.global.exception.PasswordMismatchException;
import vestie.member.global.exception.UsernameNotFoundException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(DuplicateUsernameException.class)
    public ResponseEntity<ErrorMessage> duplicateUsernameException(DuplicateUsernameException e){
        return ResponseEntity.status(e.getStatus())
                .body(ErrorMessageFactory.from(e.getStatus(), e.getErrorCode(),e.getErrorMessage()));
    }

    @ExceptionHandler(PasswordMismatchException.class)
    public ResponseEntity<ErrorMessage> passwordMismatchException(PasswordMismatchException e){
        return ResponseEntity.status(e.getStatus())
                .body(ErrorMessageFactory.from(e.getStatus(), e.getErrorCode(),e.getErrorMessage()));
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorMessage> usernameNotFoundException(UsernameNotFoundException e){
        return ResponseEntity.status(e.getStatus())
                .body(ErrorMessageFactory.from(e.getStatus(), e.getErrorCode(),e.getErrorMessage()));
    }
}
