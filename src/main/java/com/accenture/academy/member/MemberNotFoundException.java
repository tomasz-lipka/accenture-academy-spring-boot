package com.accenture.academy.member;

class MemberNotFoundException extends RuntimeException {

    MemberNotFoundException(String message) {
        super(message);
    }
}
