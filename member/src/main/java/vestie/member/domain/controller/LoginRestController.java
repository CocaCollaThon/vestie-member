package vestie.member.domain.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vestie.member.domain.controller.request.LoginRequest;
import vestie.member.domain.service.MemberService;
import vestie.member.global.dto.TokenDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class LoginRestController {

    private final MemberService memberService;

    @PostMapping("/v1/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(memberService.login(loginRequest.getUsername(), loginRequest.getPassword()));
    }

}
