package vestie.member.global.exception.handler;

import org.springframework.http.HttpStatus;

public class ErrorMessageFactory {

    public static ErrorMessage from(HttpStatus status, String errorMessage){
        return ErrorMessage.builder()
                .status(status.value())
                .error(status.name())
                .message(errorMessage)
                .build();
    }
}
