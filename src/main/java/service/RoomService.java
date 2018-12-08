package service;

import entity.Room;
import repository.RepositoryCreator;
import repository.RoomRepository;
import specification.searchSpecification.room.FindAll;

import java.util.List;

public class RoomService  {

    public List<Room> findAllRooms() {
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        RoomRepository roomRepository = repositoryCreator.getRoomRepository();
        return roomRepository.queryAll(new FindAll());
    }
}
