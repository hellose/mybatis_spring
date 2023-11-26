package study.spring.mybatis_spring.person;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper {

    PersonVo selectPerson(Long id);

    void insertPerson(PersonVo personVo);

    void updatePerson(PersonVo personVo);

    void deletePerson(Long id);
}
