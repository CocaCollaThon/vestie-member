package vestie.member.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vestie.member.domain.Gender;
import vestie.member.domain.Member;
import vestie.member.domain.controller.request.SignUpRequest;
import vestie.member.domain.repository.MemberRepository;
import vestie.member.global.dto.TokenDto;
import vestie.member.global.exception.DuplicateUsernameException;
import vestie.member.global.exception.PasswordMismatchException;
import vestie.member.global.exception.UsernameNotFoundException;
import vestie.member.global.jwt.JwtTokenProvider;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    private final JwtTokenProvider jwtTokenProvider;

    public Long signUp(SignUpRequest signUpRequest) {
        // TODO password 인코딩
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

    public TokenDto login(String username, String password) {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 username 입니다."));
        if(!member.getPassword().equals(password)){
            throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
        }
        return TokenDto.builder().token(jwtTokenProvider.createToken(member)).build();
    }
}
