package service;

import entity.User;
import entity.types.Role;
import repository.RepositoryCreator;
import repository.UserRepository;
import specification.searchSpecification.FindById;
import specification.searchSpecification.user.FindByLoginAndPassword;
import specification.searchSpecification.user.FindByRole;

import java.util.List;
import java.util.Optional;

public class UserService {

    public Optional<User> login(String login, String password) {
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        UserRepository userRepository = repositoryCreator.getUserRepository();
        return userRepository.query(new FindByLoginAndPassword(login, password));
    }

    public Optional<User> findById(int id) {
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        UserRepository userRepository = repositoryCreator.getUserRepository();
        return userRepository.query(new FindById(id));
    }

    public List<User> findByRole(Role role) {
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        UserRepository userRepository = repositoryCreator.getUserRepository();
        return userRepository.queryAll(new FindByRole(role));
    }


}
