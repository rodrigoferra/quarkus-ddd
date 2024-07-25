package com.dolap.quarkus.ddd.application.member.converter;

import com.dolap.quarkus.ddd.application.base.converter.Converter;
import com.dolap.quarkus.ddd.application.member.message.dto.MemberDTO;
import com.rodrigof.ddd.domain.member.entity.Member;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class MemberToMemberDTOConverter implements Converter<Member, MemberDTO> {

    public MemberDTO convert(Member member) {
        return MemberDTO.create(member.getId(), member.getUsername(), member.getPhoneNumber().getFullPhoneNumber());
    }
}
