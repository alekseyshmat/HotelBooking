package service;

import entity.RoomPrice;
import exception.RepositoryException;
import exception.ServiceException;
import repository.RoomPriceRepository;
import repository.creator.RepositoryCreator;
import specification.searchSpecification.room.FindAllPrice;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Class provides methods to work with {@link RoomPrice} objects.
 */
public class RoomPriceService {

    /**
     * The method searches for busy rooms with given parameters.
     *
     * @param id a {@link Integer} object identifier in database
     * @return an {@link List} implementation with {@link RoomPrice} objects.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */
    public List<RoomPrice> findAll(Integer id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomPriceRepository roomPriceRepository = repositoryCreator.getRoomPriceRepository();
            return roomPriceRepository.queryAll(new FindAllPrice(id));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method searches for busy rooms with given parameters.
     *
     * @param id        a {@link Integer} object identifier in database
     * @param roomId    a {@link Integer} object room identifier in database
     * @param startDate a {@link Date} object that maps start date.
     * @param endDate   a {@link Date} object that maps end date.
     * @param cost      a {@link BigDecimal} object that cost of the room.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */

    public void addPrice(Integer id, Integer roomId, Date startDate, Date endDate, BigDecimal cost) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomPriceRepository roomPriceRepository = repositoryCreator.getRoomPriceRepository();
            RoomPrice roomPrice = new RoomPrice(id, roomId, startDate, endDate, cost);
            roomPriceRepository.save(roomPrice);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
}
