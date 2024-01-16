package com.accenture.academy.leader;

class LeaderMapper {

    static LeaderDao mapDtoToDao(LeaderDto leaderDto){
        LeaderDao leaderDao = new LeaderDao();
        leaderDao.setName(leaderDto.getName());
        leaderDao.setAge(leaderDto.getAge());
        return leaderDao;
    }

    static LeaderDao mapDtoToDao(long id, LeaderDto leaderDto){
        LeaderDao leaderDao = new LeaderDao();
        leaderDao.setId(id);
        leaderDao.setName(leaderDto.getName());
        leaderDao.setAge(leaderDto.getAge());
        return leaderDao;
    }
}
