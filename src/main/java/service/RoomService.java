package service;

import entity.Room;
import entity.types.RoomType;
import repository.RepositoryCreator;
import repository.RoomRepository;
import specification.addSpecification.AddRoom;
import specification.searchSpecification.room.FindAll;

import java.util.List;

public class RoomService {

    public List<Room> findAllRooms() {
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        RoomRepository roomRepository = repositoryCreator.getRoomRepository();
        return roomRepository.queryAll(new FindAll());
    }

    public void addRoom(String roomNumber, RoomType roomType) {
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        RoomRepository roomRepository = repositoryCreator.getRoomRepository();
        roomRepository.queryAdd(new AddRoom(roomNumber, roomType));
    }

}
