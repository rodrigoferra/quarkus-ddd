package com.rodrigof.ddd.domain.member.exception;

public class MemberNotFoundException extends BusinessException {

    public MemberNotFoundException() {
        super("error.member.not.found");
    }

}
