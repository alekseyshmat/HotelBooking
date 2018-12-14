package service;

import entity.RoomPrice;
import exception.RepositoryException;
import exception.ServiceException;
import repository.creator.RepositoryCreator;
import repository.RoomPriceRepository;
import specification.searchSpecification.room.FindAllPrice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class RoomPriceService {

    public List<RoomPrice> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomPriceRepository roomPriceRepository = repositoryCreator.getRoomPriceRepository();
            return roomPriceRepository.queryAll(new FindAllPrice());
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public void addPrice(Integer id, int roomId, LocalDate startDate, LocalDate endDate, BigDecimal cost) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomPriceRepository roomPriceRepository = repositoryCreator.getRoomPriceRepository();
            RoomPrice roomPrice = new RoomPrice(id, roomId, startDate, endDate, cost);
            roomPriceRepository.save(roomPrice);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
}
