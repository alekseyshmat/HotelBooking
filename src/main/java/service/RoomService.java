package service;

import entity.Room;
import entity.types.RoomStatus;
import entity.types.RoomType;
import exception.RepositoryException;
import exception.ServiceException;
import repository.RoomRepository;
import repository.creator.RepositoryCreator;
import specification.searchSpecification.room.FindAll;
import specification.searchSpecification.room.FindWithOffset;

import java.util.List;

/**
 * Class provides methods to work with {@link Room} objects.
 */
public class RoomService {

    /**
     * The method searches for rooms without parameters.
     *
     * @return an {@link List} implementation with {@link Room} objects.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */
    public List<Room> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            return roomRepository.queryAll(new FindAll());
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method searches for all rooms with given parameters.
     *
     * @param limit  a {@link Integer} object that maps limit of mapping items on the page.
     * @param offset a {@link Integer} object that maps the element from which the countdown begins.
     * @return an {@link List} implementation with {@link Room} objects.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */
    public List<Room> findAll(Integer limit, Integer offset) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            return roomRepository.queryAll(new FindWithOffset(limit, offset));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method for update or insert rooms with given parameters.
     *
     * @param id  a {@link Integer} object identifier in database
     * @param roomNumber a {@link String} object that maps room number.
     * @param roomType a {@link RoomType} object that maps room type.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */
    public void saveRoom(Integer id, String roomNumber, RoomType roomType) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            Room room = new Room(id, roomNumber, roomType);
            roomRepository.save(room);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method searches for delete rooms with given parameters.
     *
     * @param id  a {@link Integer} object identifier in database
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */
    public void deleteRoom(Integer id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            Room room = new Room(id, RoomStatus.DELETED);
            roomRepository.save(room);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

}
