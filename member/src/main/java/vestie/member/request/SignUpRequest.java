package vestie.member.request;

import lombok.*;
import vestie.member.domain.Gender;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpRequest {

    private String name;
    private Long age;
    private String gender;
    private String birthDate;
    private String username;
    private String password;
}
