package umc.spring.repository.memberRepository;

import umc.spring.domain.common.Member;

public interface MemberRepositoryCustom {

    //맴버 조회
    Member findMemberById(Long id);

}
