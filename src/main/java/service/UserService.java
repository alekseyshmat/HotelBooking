package service;

import entity.User;
import entity.types.BlockingStatus;
import entity.types.Role;
import exception.RepositoryException;
import exception.ServiceException;
import org.apache.commons.codec.digest.DigestUtils;
import repository.UserRepository;
import repository.creator.RepositoryCreator;
import specification.searchSpecification.FindById;
import specification.searchSpecification.user.FindByLoginAndPassword;
import specification.searchSpecification.user.FindByRole;
import specification.searchSpecification.user.FindByRoleWithOffset;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class UserService {

    public Optional<User> login(String login, String password) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindByLoginAndPassword(login, password));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public Optional<User> findById(Integer id) throws ServiceException {
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

    public List<User> findByRole(Role role, Integer limit, Integer offset) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.queryAll(new FindByRoleWithOffset(role, limit, offset));
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

    public void updateBalance(Integer id, BigDecimal balance) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            User user = new User(id, balance);
            userRepository.save(user);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public void signUpUser(Integer id, String firstName, String lastName, String email,
                           String login, String password, Date birthday) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            String decryptedPassword = DigestUtils.sha512Hex(password);
            User user = new User(id, firstName, lastName, birthday, email, login, decryptedPassword);
            userRepository.save(user);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public void changeBlockingStatus(Integer id, BlockingStatus blockingStatus) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            User user = new User(id, blockingStatus);
            UserRepository userRepository = repositoryCreator.getUserRepository();
            userRepository.save(user);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }


}
