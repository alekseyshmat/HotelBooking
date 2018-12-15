package entity;

import entity.types.OperationType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction implements Entity {

    private Integer id;
    private int idClient;
    private OperationType operationType;
    private LocalDateTime date;
    private LocalDate dater;
    private BigDecimal sum;

    public Transaction(Integer id, int idClient, OperationType operationType, LocalDateTime date, BigDecimal sum) {
        this.id = id;
        this.idClient = idClient;
        this.operationType = operationType;
        this.date = date;
        this.sum = sum;
    }

    public Transaction(Integer id, int idClient, OperationType operationType, LocalDate date, BigDecimal sum) {
        this.id = id;
        this.idClient = idClient;
        this.operationType = operationType;
        this.dater = date;
        this.sum = sum;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public LocalDate getDater() {
        return dater;
    }

    public void setDater(LocalDate dater) {
        this.dater = dater;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
