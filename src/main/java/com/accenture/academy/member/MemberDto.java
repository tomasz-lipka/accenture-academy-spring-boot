package com.accenture.academy.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class MemberDto {

    private String name;
    private Integer age;
}
