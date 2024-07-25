package com.rodrigof.ddd.domain.member.repository;

import com.rodrigof.ddd.domain.member.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Optional<Member> findMemberById(Long id);

    Optional<Member> findMemberByUsername(String username);

    List<Member> findAllMembers();

    boolean deleteMemberById(Long id);

    void save(Member member);

}
