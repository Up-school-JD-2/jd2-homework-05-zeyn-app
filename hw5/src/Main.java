import CreditCard.CreditCart;
import CreditCard.CreditCartManager;
import CvvInvalidException.*;
import ExpirationDateInvalidException.*;
import AccountNumberInvalidException.*;
import PaymentAmountInvalidException.PaymentAmountInvalidExcepiton;
import SystemNotWorkingException.SystemNotWorkingException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CreditCart creditCart = null;
        Main main = new Main();
        //while (true) {
            try {
                creditCart = main.createCreditCard();
                System.out.println();
                main.pay();
                System.out.println("Payment process completed successfully.");
                System.out.println(creditCart);
            } catch (PaymentAmountInvalidExcepiton e) {
                System.out.println(e.getMessage());
            } catch (ExpirationDateInvalidException e) {
                System.out.println(e.getMessage());
            } catch (AccountNumberInvalidException e) {
                System.out.println(e.getMessage());
            } catch (CvvInvalidException e) {
                System.out.println(e.getMessage());
            } catch (SystemNotWorkingException e) {
                System.out.println(e.getMessage());
                try {
                    main.pay();
                    System.out.println("Payment process completed successfully.");
                    System.out.println(creditCart);
                } catch (SystemNotWorkingException subEx) {
                    System.out.println(subEx.getMessage());
                }
            }
       // }
    }

    public CreditCart createCreditCard() throws PaymentAmountInvalidExcepiton, AccountNumberInvalidException, ExpirationDateInvalidException, CvvInvalidException, RuntimeException {
        // 1234567890123456
        CreditCartManager creditCartManager = new CreditCartManager();
        CreditCart creditCart;
        String expirationDate, accountNumber, cvv, paymentAccount;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Payment Amount: ");
        paymentAccount = scanner.nextLine();
        creditCartManager.checkValidPaymentAmount(paymentAccount);

        System.out.print("Account Number: ");
        accountNumber = scanner.nextLine();
        creditCartManager.checkValidAccountNumber(accountNumber);

        System.out.print("Expiration Date: ");
        expirationDate = scanner.nextLine();
        creditCartManager.checkValidExparitaionDate(expirationDate);

        System.out.print("CVV: ");
        cvv = scanner.nextLine();
        creditCartManager.checkValidCvv(cvv);

        creditCart = new CreditCart(expirationDate, accountNumber, cvv);
        return creditCart;
    }

    public void pay() throws SystemNotWorkingException {
        int random = (int) (Math.random() * 100);
        System.out.println("random: " + random);
        if (random > 75)
            throw new SystemNotWorkingException("System not working, please be patient...");
    }
}
