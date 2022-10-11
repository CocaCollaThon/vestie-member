package vestie.member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    private String name;

    private Long age;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private String birthDate;

    private String username;

    private String password;

    private Long point;
}
