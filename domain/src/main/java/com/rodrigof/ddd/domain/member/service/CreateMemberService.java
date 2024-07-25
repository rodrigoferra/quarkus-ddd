package com.rodrigof.ddd.domain.member.service;

import com.rodrigof.ddd.domain.member.entity.Member;
import com.rodrigof.ddd.domain.member.exception.MemberAlreadyExistsException;
import com.rodrigof.ddd.domain.member.repository.MemberRepository;
import com.rodrigof.ddd.domain.member.vo.PhoneNumber;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class CreateMemberService {

    private final MemberRepository memberRepository;

    @Inject
    public CreateMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member create(String username, String password, String phoneCountryCode, String phoneNumber) {
        memberRepository.findMemberByUsername(username)
                .ifPresent(member -> {
                    throw new MemberAlreadyExistsException();
                });

        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        member.setPhoneNumber(PhoneNumber.of(phoneCountryCode, phoneNumber));

        memberRepository.save(member);

        return member;
    }


}
