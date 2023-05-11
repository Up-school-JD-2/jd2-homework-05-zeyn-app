package CreditCard;

import ExpirationDateInvalidException.*;
import AccountNumberInvalidException.*;
import CvvInvalidException.*;
import PaymentAmountInvalidException.PaymentAmountIcludeInvalidCharacterException;
import PaymentAmountInvalidException.PaymentAmountInvalidExcepiton;
import PaymentAmountInvalidException.PaymentAmountNegativeException;


import java.util.Date;

public class CreditCartManager {
    public void checkValidPaymentAmount(String paymentAmount) throws PaymentAmountInvalidExcepiton {
        for (char c : paymentAmount.toCharArray()) {
            if (!Character.isDigit(c) && c != '.')
                throw new PaymentAmountIcludeInvalidCharacterException("Payment account must include only numbers and \".\"");
        }

        double paymentAmount_ = Double.parseDouble(paymentAmount);
        if (paymentAmount_ <= 0)
            throw new PaymentAmountNegativeException("Payment account must be grater than zero");
    }

    public void checkValidExparitaionDate(String date) throws ExpirationDateInvalidException {
        date = date.replaceAll(" ", "");
        if (date.length() == 6)
            date = 0 + date;
        // System.out.println(date);

        if (date.length() != 7 || !date.contains("/"))
            throw new FormatInvalidException("Expiration date must be (mm/yyyy) format");

        String month = date.substring(0, 2);
        String year = date.substring(3);
        // System.out.println("month: " + month + " year: " + year);

        if (isContainChar(month) || isContainChar(year))
            throw new ExpirationDateIncludeCharacterException("Expiration date must contain only numbers and \"/\"");

        if (Integer.parseInt(month) <= 0 || Integer.parseInt(month) > 12)
            throw new MonthInvalidException("Month must be between 1 and 12");

        int currentYear = new Date().getYear() + 1900;
        // System.out.println("currentYear: " + currentYear);
        if (currentYear > Integer.parseInt(year))
            throw new YearInvalidException("Year must not be a previous year");
    }

    public void checkValidAccountNumber(String accountNumber) throws AccountNumberInvalidException {
        accountNumber = accountNumber.replaceAll(" ", "");

        if (accountNumber.length() != 16)
            throw new AccountNumberInvalidDigitNumbers("Account number must be 16 digits");
        if (isContainChar(accountNumber))
            throw new AccountNumberIncludeCharacterException("Account number must contain only numbers");
    }

    public void checkValidCvv(String cvv) throws CvvInvalidException {
        if (cvv.length() != 3)
            throw new CvvInvalidDigitNumbers("Cvv must be 3 digits");
        if (isContainChar(cvv))
            throw new CvvIncludeCharacterException("Cvv must contain only numbers");
    }

    private boolean isContainChar(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return true;
        }
        return false;
    }
}
