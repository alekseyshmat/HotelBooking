package entity;

import entity.types.OperationType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {

    private int idClient;
    private OperationType operationType;
    private LocalDate date;
    private BigDecimal sum;

    public Transaction(int idClient, OperationType operationType, LocalDate date, BigDecimal sum) {
        this.idClient = idClient;
        this.operationType = operationType;
        this.date = date;
        this.sum = sum;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
