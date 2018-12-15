package entity;

import entity.types.OperationType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction implements Entity {

    private Integer id;
    private Integer idClient;
    private OperationType operationType;
    private LocalDate date;
    private BigDecimal sum;

    public Transaction(Integer id, Integer idClient, OperationType operationType, LocalDate date, BigDecimal sum) {
        this.id = id;
        this.idClient = idClient;
        this.operationType = operationType;
        this.date = date;
        this.sum = sum;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
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
