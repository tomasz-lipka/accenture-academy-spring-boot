package com.accenture.academy.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    public Optional<MemberDao> findByID(Long id){
        return iMemberRepository.findById(id);
    }
}
