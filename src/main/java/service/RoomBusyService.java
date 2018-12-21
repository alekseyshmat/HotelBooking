package service;

import entity.RoomBusy;
import entity.types.RoomType;
import exception.RepositoryException;
import exception.ServiceException;
import repository.RoomBusyRepository;
import repository.creator.RepositoryCreator;
import specification.searchSpecification.room.FindByCriteria;

import java.time.LocalDate;
import java.util.List;

public class RoomBusyService {

    public List<RoomBusy> findAllByCriteria(RoomType roomType, LocalDate checkInDate, LocalDate checkOutDate) throws ServiceException {

        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomBusyRepository roomBusyRepository = repositoryCreator.getRoomBusyRepository();
            return roomBusyRepository.queryAll(new FindByCriteria(roomType, checkInDate, checkOutDate));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
}
