package service;

import entity.Transaction;
import entity.types.OperationType;
import exception.RepositoryException;
import exception.ServiceException;
import repository.TransactionRepository;
import repository.creator.RepositoryCreator;
import specification.searchSpecification.transaction.FindByIdClient;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Class provides methods to work with {@link Transaction} objects.
 */
public class TransactionService {

    /**
     * The method searches for transaction with given identifier.
     *
     * @param id a {@link Integer} object identifier in database
     * @return a {@link List} implementation with {@link Transaction} object.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */
    public List<Transaction> findById(Integer id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            TransactionRepository transactionRepository = repositoryCreator.getTransactionRepository();
            return transactionRepository.queryAll(new FindByIdClient(id));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method searches for busy rooms with given parameters.
     *
     * @param id            a {@link Integer} object identifier in database
     * @param idClient      a {@link Integer} object client identifier in database
     * @param date          a {@link Date} object that maps date of operation.
     * @param sum           a {@link BigDecimal} object that maps sum of operation.
     * @param operationType a {@link OperationType} object that maps operation type.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */
    public void addOperations(Integer id, Integer idClient, OperationType operationType,
                              Date date, BigDecimal sum) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            TransactionRepository transactionRepository = repositoryCreator.getTransactionRepository();
            Transaction transaction = new Transaction(id, idClient, operationType, date, sum);
            transactionRepository.save(transaction);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
}
