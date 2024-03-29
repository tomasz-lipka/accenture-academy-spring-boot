package com.accenture.academy.church;

class ChurchMapper {

    static ChurchDao mapDtoToDao(ChurchDto churchDto){
        ChurchDao churchDao = new ChurchDao();
        churchDao.setName(churchDto.getName());
        churchDao.setBudget(churchDto.getBudget());
        churchDao.setNameOfCity(churchDto.getNameOfCity());
        churchDao.setNumberOfSeats(churchDto.getNumberOfSeats());
        churchDao.setNumberOfMembers(churchDto.getNumberOfMembers());
        return churchDao;
    }

    static ChurchDao mapDtoToDao(long id, ChurchDto churchDto){
        ChurchDao churchDao = new ChurchDao();
        churchDao.setId(id);
        churchDao.setName(churchDto.getName());
        churchDao.setBudget(churchDto.getBudget());
        churchDao.setNameOfCity(churchDto.getNameOfCity());
        churchDao.setNumberOfSeats(churchDto.getNumberOfSeats());
        churchDao.setNumberOfMembers(churchDto.getNumberOfMembers());
        return churchDao;
    }
}
