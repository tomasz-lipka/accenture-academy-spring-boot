package com.accenture.academy.leader;

class LeaderMapper {

    static LeaderDao mapDtoToDao(LeaderDto leaderDto){
        LeaderDao leaderDao = new LeaderDao();
        leaderDao.setName(leaderDto.getName());
        leaderDao.setAge(leaderDto.getAge());
        return leaderDao;
    }
}
