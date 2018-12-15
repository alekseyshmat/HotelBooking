package service;

import entity.Transaction;
import entity.types.OperationType;
import exception.RepositoryException;
import exception.ServiceException;
import repository.TransactionRepository;
import repository.creator.RepositoryCreator;
import specification.searchSpecification.FindById;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TransactionService {

    public List<Transaction> findById(int id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            TransactionRepository transactionRepository = repositoryCreator.getTransctionRepository();
            return transactionRepository.queryAll(new FindById(id));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public void addOperations(Integer id, int idClient, OperationType operationType, LocalDate date, BigDecimal sum) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            TransactionRepository transactionRepository = repositoryCreator.getTransctionRepository();
            Transaction transaction = new Transaction(id, idClient, operationType, date, sum);
            transactionRepository.save(transaction);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

}
