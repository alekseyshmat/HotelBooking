package service;

import entity.Room;
import entity.types.RoomType;
import repository.RepositoryCreator;
import repository.RoomRepository;
import specification.searchSpecification.room.FindAll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomService {


    public List<Room> findAll() {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            return roomRepository.queryAll(new FindAll());
        }
    }

    public void addRoom(String roomNumber, RoomType roomType) {
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        RoomRepository roomRepository = repositoryCreator.getRoomRepository();
        Room room = new Room(roomNumber, roomType);
        roomRepository.save(room);
//        roomRepository.queryAdd(new AddRoom(roomNumber, roomType));
    }//todo add try

}
