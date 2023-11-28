package study.spring.mybatis_spring.mix;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import study.spring.mybatis_spring.exception.ExceptionUtil;
import study.spring.mybatis_spring.member.MemberMapper;
import study.spring.mybatis_spring.member.MemberVo;
import study.spring.mybatis_spring.person.PersonMapper;
import study.spring.mybatis_spring.person.PersonVo;

@Service
@RequiredArgsConstructor
public class MixMapperService {

	private final MemberMapper memberMapper;
	private final PersonMapper personMapper;

	public void selectMemberThenPerson() {
		memberMapper.selectMember(1L);
		personMapper.selectPerson(1L);
	}

	@Transactional
	public void selectMemberThenPersonTx() {
		memberMapper.selectMember(1L);
		personMapper.selectPerson(1L);
	}

	@Transactional
	public void insertMemberThenPersonTxButRuntimeException1() {
		memberMapper.insertMember(new MemberVo(1L, "MEMBER1"));
		ExceptionUtil.throwRuntimeException();
		personMapper.insertPerson(new PersonVo(1L, "PERSON1"));
	}

	@Transactional
	public void insertMemberThenPersonTxButRuntimeException2() {
		memberMapper.insertMember(new MemberVo(1L, "MEMBER1"));
		personMapper.insertPerson(new PersonVo(1L, "PERSON1"));
		ExceptionUtil.throwRuntimeException();
	}

	@Transactional
	public void insertMemberThenPersonTxButException1() throws Exception {
		memberMapper.insertMember(new MemberVo(1L, "MEMBER1"));
		ExceptionUtil.throwException();
		personMapper.insertPerson(new PersonVo(1L, "PERSON1"));
	}

	@Transactional
	public void insertMemberThenPersonTxButException2() throws Exception {
		memberMapper.insertMember(new MemberVo(1L, "MEMBER1"));
		personMapper.insertPerson(new PersonVo(1L, "PERSON1"));
		ExceptionUtil.throwException();
	}

}
