package study.spring.mybatis_spring.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
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
    public void selectPersonWithTx() {
        personMapper.selectPerson(1L);
    }

    @Transactional
    public void selectPersonTwiceWithTx() {
        personMapper.selectPerson(1L);
        personMapper.selectPerson(1L);
    }
}
