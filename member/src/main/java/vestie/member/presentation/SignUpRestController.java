package vestie.member.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vestie.member.service.MemberService;
import vestie.member.request.SignUpRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SignUpRestController {

    private final MemberService memberService;

    @PostMapping("/v1/signUp")
    ResponseEntity<Long> signUp(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(memberService.signUp(signUpRequest));
    }

}
