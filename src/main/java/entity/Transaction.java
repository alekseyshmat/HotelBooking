package entity;

import entity.types.OperationType;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction implements Entity {

    private Integer id;
    private Integer idClient;
    private OperationType operationType;
    private Date date;
    private BigDecimal sum;

    public Transaction(Integer id, Integer idClient, OperationType operationType, Date date, BigDecimal sum) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Transaction transaction = (Transaction) obj;
        return Objects.equals(id, transaction.id) &&
                Objects.equals(idClient, transaction.idClient) &&
                Objects.equals(operationType, transaction.operationType) &&
                Objects.equals(date, transaction.date) &&
                Objects.equals(sum, transaction.sum);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result + id;
        result = prime * result + idClient;
        result = prime * result + operationType.hashCode();
        result = prime * result + date.hashCode();
        result = prime * result + sum.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Transaction  : " +
                ", id=" + id +
                ", id client=" + idClient +
                ", operation type=" + operationType +
                ", date=" + date +
                ", sum=" + sum;
    }
}
