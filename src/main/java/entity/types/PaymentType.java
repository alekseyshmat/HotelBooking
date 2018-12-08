package entity.types;

public enum PaymentType {
    CREDITCARD("creditCard"),
    CASH("cash");

     String paymentType;

     PaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentType() {
        return paymentType;
    }
}
