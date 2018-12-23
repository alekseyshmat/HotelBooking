package service;

import entity.RoomBusy;
import entity.types.RoomType;
import exception.RepositoryException;
import exception.ServiceException;
import repository.RoomBusyRepository;
import repository.creator.RepositoryCreator;
import specification.searchSpecification.room.FindByCriteria;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class RoomBusyService {

    public List<RoomBusy> findAllByCriteria(RoomType roomType, Date checkInDate, Date checkOutDate) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomBusyRepository roomBusyRepository = repositoryCreator.getRoomBusyRepository();
            return roomBusyRepository.queryAll(new FindByCriteria(roomType, checkInDate, checkOutDate));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public void addBusyRoom(Integer id, Integer idRoom, Date startDate, Date endDate) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomBusyRepository roomBusyRepository = repositoryCreator.getRoomBusyRepository();
            RoomBusy roomBusy = new RoomBusy(id,idRoom , startDate, endDate);
            roomBusyRepository.save(roomBusy);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
}
