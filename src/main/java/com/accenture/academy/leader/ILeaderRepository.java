package com.accenture.academy.leader;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface ILeaderRepository extends JpaRepository<LeaderDao, Long> {
    List<LeaderDao> findByName(String name);
}
