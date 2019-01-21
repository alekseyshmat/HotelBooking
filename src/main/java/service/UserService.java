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
import specification.searchSpecification.user.FindByLogin;
import specification.searchSpecification.user.FindByLoginAndPassword;
import specification.searchSpecification.user.FindByRole;
import specification.searchSpecification.user.FindByRoleWithOffset;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

/**
 * Class provides methods to work with {@link User} objects.
 */
public class UserService {

    /**
     * Method designed for searching user depends on user login and password.
     *
     * @param login    is a {@link String} object that contains user login
     * @param password is a {@link String} object that contains user password
     * @return a {@link Optional} object with finding {@link User} inside.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */

    public Optional<User> login(String login, String password) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindByLoginAndPassword(login, password));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method searches for user with given identifier.
     *
     * @param id an object identifier in database
     * @return a {@link Optional} implementation with object.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */
    public Optional<User> findById(Integer id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindById(id));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method searches for user with given login.
     *
     * @param login an object login in database
     * @return a {@link Optional} implementation with object.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */
    public Optional<User> findByLogin(String login) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindByLogin(login));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method searches for user with given role.
     *
     * @param role a {@link Role} object identifier in database
     * @return a {@link List} implementation with {@link User} object.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */

    public List<User> findByRole(Role role) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.queryAll(new FindByRole(role));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method searches for user with given role, limit and offset.
     *
     * @param role   a {@link Role} object identifier in database
     * @param limit  a {@link Integer} object that maps limit of mapping items on the page.
     * @param offset a {@link Integer} object that maps the element from which the countdown begins.
     * @return a {@link List} implementation with {@link User} object.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */

    public List<User> findByRole(Role role, Integer limit, Integer offset) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.queryAll(new FindByRoleWithOffset(role, limit, offset));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method for update profile information with given parameters.
     *
     * @param id        a {@link Integer} object identifier in database
     * @param firstName a {@link String} object that maps first name of user.
     * @param lastName  a {@link String} object that maps second name of user.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */
    public void updateProfile(Integer id, String firstName, String lastName) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            User user = new User(id, firstName, lastName);
            userRepository.save(user);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method for update balance information with given parameters.
     *
     * @param id      a {@link Integer} object identifier in database
     * @param balance a {@link BigDecimal} object that maps sum for refile balance.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */
    public void updateBalance(Integer id, BigDecimal balance) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            User user = new User(id, balance);
            userRepository.save(user);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method for sign up user with given parameters.
     *
     * @param id        a {@link Integer} object identifier in database
     * @param firstName a {@link String} object that maps first name of user.
     * @param lastName  a {@link String} object that maps second name of user.
     * @param email     a {@link String} object that maps email of user.
     * @param login     a {@link String} object that maps login of user.
     * @param password  a {@link String} object that maps password of user.
     * @param birthday  a {@link Date} object that maps user's birthday.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */

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

    /**
     * The method for change blocking status of user with given parameters.
     *
     * @param id             a {@link Integer} object identifier in database
     * @param blockingStatus a {@link BlockingStatus} object that maps blocking status of user.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */
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
