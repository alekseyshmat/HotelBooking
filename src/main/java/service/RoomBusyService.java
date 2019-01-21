package service;

import entity.RoomBusy;
import entity.types.RoomType;
import exception.RepositoryException;
import exception.ServiceException;
import repository.RoomBusyRepository;
import repository.creator.RepositoryCreator;
import specification.searchSpecification.room.FindByCriteria;

import java.sql.Date;
import java.util.List;

/**
 * Class provides methods to work with {@link RoomBusy} objects.
 */
public class RoomBusyService {

    /**
     * The method searches for busy rooms with given parameters.
     *
     * @param checkInDate  a {@link Date} object that maps check in date of the order.
     * @param checkOutDate a {@link Date} object that maps check out date of the order.
     * @param roomType     a {@link RoomType} object that maps room type of the order.
     * @return an {@link List} implementation with {@link RoomBusy} objects.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */

    public List<RoomBusy> findAllByCriteria(RoomType roomType, Date checkInDate, Date checkOutDate) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomBusyRepository roomBusyRepository = repositoryCreator.getRoomBusyRepository();
            return roomBusyRepository.queryAll(new FindByCriteria(roomType, checkInDate, checkOutDate));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method searches for busy rooms with given parameters.
     *
     * @param id        a {@link Integer} object identifier in database
     * @param idRoom    a {@link Integer} object room identifier in database
     * @param startDate a {@link Date} object that maps start date of the busy.
     * @param endDate   a {@link Date} object that maps end date of the busy.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */

    public void addBusyRoom(Integer id, Integer idRoom, Date startDate, Date endDate) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomBusyRepository roomBusyRepository = repositoryCreator.getRoomBusyRepository();
            RoomBusy roomBusy = new RoomBusy(id, idRoom, startDate, endDate);
            roomBusyRepository.save(roomBusy);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
}
