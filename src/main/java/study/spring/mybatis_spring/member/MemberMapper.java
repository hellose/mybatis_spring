package study.spring.mybatis_spring.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    MemberVo selectMember(Long id);

    void insertMember(MemberVo personVo);

    void updateMember(MemberVo personVo);

    void deleteMember(Long id);
}
