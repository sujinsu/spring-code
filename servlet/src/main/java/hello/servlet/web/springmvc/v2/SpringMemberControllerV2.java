package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;

@Controller
public class SpringMemberControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();


}
