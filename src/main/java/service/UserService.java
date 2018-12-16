package service;

import entity.User;
import entity.types.Role;
import exception.RepositoryException;
import exception.ServiceException;
import repository.UserRepository;
import repository.creator.RepositoryCreator;
import specification.searchSpecification.FindById;
import specification.searchSpecification.user.FindByLoginAndPassword;
import specification.searchSpecification.user.FindByRole;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class UserService {

    public Optional<User> login(String login, String password) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator();) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindByLoginAndPassword(login, password));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public Optional<User> findById(int id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindById(id));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }


    public List<User> findByRole(Role role) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.queryAll(new FindByRole(role));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public void updateProfile(Integer id, String firstName, String lastName) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            User user = new User(id, firstName, lastName);
            userRepository.save(user);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public void updateBalance(Integer id, BigDecimal cost) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            User user = new User(id, cost);
            userRepository.save(user);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

}
