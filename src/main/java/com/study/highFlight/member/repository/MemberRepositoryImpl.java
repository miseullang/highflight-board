package com.study.highFlight.member.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.highFlight.member.dto.SearchMemberResponseDTO;
import com.study.highFlight.member.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;

import static com.study.highFlight.member.entity.QMember.member;

import java.util.List;
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

    @Override
    public Optional<Member> requestMemberId(String memberId) {
        return Optional.ofNullable(
                jpaQueryFactory.select(member)
                        .from(member)
                        .where(member.memberId.eq(memberId))
                        .fetchFirst()
        );
    }

    @Override
    public List<SearchMemberResponseDTO> searchMember(String memberId) {
        return jpaQueryFactory.select(Projections.constructor(SearchMemberResponseDTO.class,
                member.memberNo, member.memberId, member.memberMail, member.memberNickName, member.memberCreate))
                .from(member)
                .where(member.memberId.like("%" + memberId + "%"))
                .orderBy(member.memberNo.desc())
                .fetch();
    }
}
