package service;

import entity.RoomPrice;
import repository.RepositoryCreator;
import repository.RoomPriceRepository;
import specification.searchSpecification.room.FindAllPrice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class RoomPriceService {

    public List<RoomPrice> findAll() {
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        RoomPriceRepository roomPriceRepository = repositoryCreator.getRoomPriceRepository();
        return roomPriceRepository.queryAll(new FindAllPrice());
    }

    public void addPrice(String roomNumber, LocalDate startDate, LocalDate endDate, BigDecimal cost) {
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        RoomPriceRepository roomPriceRepository = repositoryCreator.getRoomPriceRepository();
//        roomPriceRepository.queryAdd(new AddRoomPrice(roomNumber, startDate, endDate, cost));
    }
}
