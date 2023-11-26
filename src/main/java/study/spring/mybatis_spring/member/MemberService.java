package study.spring.mybatis_spring.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring.mybatis_spring.person.PersonMapper;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final PersonMapper personMapper;

    public void selectMemberPerson() {
        memberMapper.selectMember(1L);
        personMapper.selectPerson(1L);
    }

    @Transactional
    public void selectMemberPersonWithTx() {
        memberMapper.selectMember(1L);
        personMapper.selectPerson(1L);
    }
}
