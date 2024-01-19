package com.accenture.academy.parish;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
class ParishDto {
    private Long leaderId;
    private Long churchId;
//    private Set<Long> membersIds;
}
