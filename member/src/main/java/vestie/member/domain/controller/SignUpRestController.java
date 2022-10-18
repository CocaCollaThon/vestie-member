package vestie.member.domain.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vestie.member.domain.controller.request.SignUpRequest;
import vestie.member.domain.service.MemberService;

import java.net.URI;

import static org.springframework.web.util.UriComponentsBuilder.fromPath;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SignUpRestController {

    private final MemberService memberService;

    @PostMapping("/v1/signUp")
    public ResponseEntity<Void> signUp(@RequestBody SignUpRequest signUpRequest){
        Long memberId = memberService.signUp(signUpRequest);

        URI uri = fromPath("/v1/member/{memberId}") // api/member/{memberId}
                .buildAndExpand(memberId)      // v1member/10
                .toUri();
        return ResponseEntity.created(uri).build();
    }

}
