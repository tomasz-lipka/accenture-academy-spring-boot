package com.accenture.academy.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    List<MemberDao> getAllMembers() {
        return memberRepository.findAll();
    }

    void addMember(MemberDao memberDao){
        memberRepository.save(memberDao);
    }

    public MemberDao getMemberById(long id) {
        return memberRepository
                .findByID(id)
                .orElseThrow(()->new MemberNotFoundException("Member with id " + id + " not found"));
    }
}
