package service;

import entity.Transaction;
import entity.types.OperationType;
import exception.RepositoryException;
import exception.ServiceException;
import repository.TransactionRepository;
import repository.creator.RepositoryCreator;
import specification.searchSpecification.transaction.FindByIdClient;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TransactionService {

    public List<Transaction> findById(Integer id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            TransactionRepository transactionRepository = repositoryCreator.getTransactionRepository();
            return transactionRepository.queryAll(new FindByIdClient(id));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public void addOperations(Integer id, Integer idClient, OperationType operationType, LocalDate date, BigDecimal sum) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            TransactionRepository transactionRepository = repositoryCreator.getTransactionRepository();
            Transaction transaction = new Transaction(id, idClient, operationType, date, sum);
            transactionRepository.save(transaction);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

}
