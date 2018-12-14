package service;

import entity.Transaction;
import exception.RepositoryException;
import exception.ServiceException;
import repository.TransactionRepository;
import repository.creator.RepositoryCreator;
import specification.searchSpecification.FindById;

import java.util.List;

public class TransactionService {

    public List<Transaction> findById(int id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            TransactionRepository transactionRepository = repositoryCreator.getTransctionRepository();
            return transactionRepository.queryAll(new FindById(id));
        }catch (RepositoryException ex){
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

}
