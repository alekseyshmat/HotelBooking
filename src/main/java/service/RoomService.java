package service;

import entity.Room;
import entity.types.OrderStatus;
import entity.types.RoomType;
import exception.RepositoryException;
import exception.ServiceException;
import repository.creator.RepositoryCreator;
import repository.RoomRepository;
import specification.searchSpecification.room.FindAll;
import specification.searchSpecification.room.FindByCriteria;

import java.time.LocalDate;
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

    public void saveRoom(Integer id, String roomNumber, RoomType roomType) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            Room room = new Room(id, roomNumber, roomType);
            roomRepository.save(room);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

}
