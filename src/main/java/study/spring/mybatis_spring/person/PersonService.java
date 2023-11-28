package study.spring.mybatis_spring.person;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import study.spring.mybatis_spring.exception.ExceptionUtil;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PersonService {

	private final PersonMapper personMapper;

	public void selectPerson() {
		personMapper.selectPerson(1L);
	}

	public void selectPersonTwice() {
		personMapper.selectPerson(1L);
		personMapper.selectPerson(1L);
	}

	@Transactional
	public void selectPersonTx() {
		personMapper.selectPerson(1L);
	}

	@Transactional
	public void selectPersonTwiceTx() {
		personMapper.selectPerson(1L);
		personMapper.selectPerson(1L);
	}

	@Transactional(rollbackFor = Exception.class)
	public void insertPersonTxRollbackForException1() throws Exception {
		personMapper.insertPerson(new PersonVo(1L, "PERSON1"));
		ExceptionUtil.throwException();
	}

	@Transactional(rollbackFor = Exception.class)
	public void insertPersonTxRollbackForException2() {
		personMapper.insertPerson(new PersonVo(1L, "PERSON1"));
		ExceptionUtil.throwRuntimeException();
	}

}
