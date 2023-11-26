package study.spring.mybatis_spring.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/test1")
    public String test1() {
        memberService.selectMemberPerson();
        return "ok";
    }

    @GetMapping("/test2")
    public String test2() {
        memberService.selectMemberPersonWithTx();
        return "ok";
    }

}
