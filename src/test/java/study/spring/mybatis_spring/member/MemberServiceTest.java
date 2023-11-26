package study.spring.mybatis_spring.member;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    void selectMemberPerson() {
        memberService.selectMemberPerson();
    }

    @Test
    void selectMemberPersonWithTx() {
        memberService.selectMemberPersonWithTx();
    }
}