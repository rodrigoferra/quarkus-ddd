package com.rodrigof.ddd.domain.member.exception;

public class MemberAlreadyExistsException extends BusinessException {

    public MemberAlreadyExistsException() {
        super("error.member.already.exists");
    }

}
