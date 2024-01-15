package com.accenture.academy.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class MemberRepository {
    private final IMemberRepository iMemberRepository;

    public List<MemberDao> findAll() {
        return iMemberRepository.findAll();
    }

    public void save(MemberDao memberDao) {
        iMemberRepository.save(memberDao);
    }
}
