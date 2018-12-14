package service;

import entity.RoomPrice;
import repository.creator.RepositoryCreator;
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

    public void addPrice(int roomId, LocalDate startDate, LocalDate endDate, BigDecimal cost) {
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        RoomPriceRepository roomPriceRepository = repositoryCreator.getRoomPriceRepository();
        RoomPrice roomPrice = new RoomPrice(roomId,startDate ,endDate ,cost);
        roomPriceRepository.save(roomPrice);
    }
}
