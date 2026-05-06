package com.study.highFlight.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.highFlight.member.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;

import static com.study.highFlight.member.entity.QMember.member;

import java.util.Optional;

public class MemberRepositoryImpl implements MemberRepositoryCustom {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    // 회원 조회
    @Override
    public Optional<Member> selectMemberInfo(Long memberNo){
        return Optional.ofNullable(
                jpaQueryFactory.select(member)
                        .from(member)
                        .where(member.memberNo.eq(memberNo))
                        .fetchFirst()
        );
    }
}
