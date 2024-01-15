package com.accenture.academy.leader;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ILeaderRepository extends JpaRepository<LeaderDao, Long> {
}
