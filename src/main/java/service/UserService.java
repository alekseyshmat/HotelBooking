package service;

import entity.User;
import repository.AbstractRepository;
import repository.RepositoryCreator;
import repository.UserRepository;
import specification.searchSpecification.FindByLoginAndPassword;

import java.util.Optional;

public class UserService {

    public Optional<User> login(String login, String password) {
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        UserRepository userRepository = repositoryCreator.getUserRepository();

        return userRepository.findUserByLoginAndPassword(new FindByLoginAndPassword(login, password));
    }

    public Optional<User> findById(int id) {

        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userDao = repositoryCreator.getUserRepository();
            return userDao.findById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }


}
