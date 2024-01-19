package com.accenture.academy.member;

import org.springframework.data.jpa.repository.JpaRepository;

interface IMemberRepository extends JpaRepository<MemberDao, Long> {
}
