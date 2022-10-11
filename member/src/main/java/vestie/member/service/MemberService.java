package vestie.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vestie.member.domain.Gender;
import vestie.member.domain.Member;
import vestie.member.exception.DuplicateUsernameException;
import vestie.member.repository.MemberRepository;
import vestie.member.request.SignUpRequest;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public Long signUp(SignUpRequest signUpRequest) {
        checkDuplicateUsername(signUpRequest.getUsername());

        Member member = Member.builder()
                .name(signUpRequest.getName())
                .age(signUpRequest.getAge())
                .gender(Gender.valueOf(signUpRequest.getGender()))
                .birthDate(signUpRequest.getBirthDate())
                .username(signUpRequest.getUsername())
                .password(signUpRequest.getPassword())
                .point(0L)
                .build();

        return memberRepository.save(member).getId();
    }

    private void checkDuplicateUsername(String username){
        if(memberRepository.findByUsername(username).isPresent()){
            throw new DuplicateUsernameException("이미 존재하는 username 입니다.");
        }
    }
}
