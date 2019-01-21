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

public class RoomService {

    public List<Room> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            return roomRepository.queryAll(new FindAll());
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public List<Room> findAll(Integer limit, Integer offset) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            return roomRepository.queryAll(new FindWithOffset(limit, offset));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public void saveRoom(Integer id, String roomNumber, RoomType roomType) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            Room room = new Room(id, roomNumber, roomType);
            roomRepository.save(room);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

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
