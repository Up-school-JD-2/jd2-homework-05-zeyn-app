package CreditCard;
public class CreditCart {
    private String expirationDate; //(02/25)
    private String accountNumber; // (.... .... .... ....) --> 16 basamak olmalı ve sadece sayı içermelidir
    private String cvv;

    public CreditCart(){}
    public CreditCart(String expirationDate, String accountNumber, String cvv){
        this.expirationDate = expirationDate;
        this.accountNumber = accountNumber;
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "CreditCart{" +
                "expirationDate='" + expirationDate + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
