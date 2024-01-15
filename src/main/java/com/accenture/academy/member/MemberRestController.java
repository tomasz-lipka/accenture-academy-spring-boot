package com.accenture.academy.member;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/members")
@RequiredArgsConstructor
class MemberRestController {

    private final MemberService memberService;

    @GetMapping()
    List<MemberDao> getAllMembers(){
        return memberService.getAllMembers();
    }
}
