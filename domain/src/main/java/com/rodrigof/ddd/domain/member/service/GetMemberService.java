package com.rodrigof.ddd.domain.member.service;

import com.rodrigof.ddd.domain.member.entity.Member;
import com.rodrigof.ddd.domain.member.exception.MemberNotFoundException;
import com.rodrigof.ddd.domain.member.repository.MemberRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class GetMemberService {

    private final MemberRepository memberRepository;

    @Inject
    public GetMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member getById(Long id) {
        return memberRepository.findMemberById(id)
                .orElseThrow(MemberNotFoundException::new);
    }

    public List<Member> getAll() {
        return memberRepository.findAllMembers();
    }

}
