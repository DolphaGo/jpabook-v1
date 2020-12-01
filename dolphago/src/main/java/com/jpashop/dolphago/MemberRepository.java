package com.jpashop.dolphago;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository // 컴포넌트 스캔의 대상이 되므로 자동으로 Bean에 등록됨
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId(); //커맨드와 쿼리를 분리하기 위함
        //ID 정도 리턴하면 다음번에 다시 조회할 때 사용할 수 있기 때문에
    }

    public Member find(Long id){
        return em.find(Member.class,id);
    }
}
