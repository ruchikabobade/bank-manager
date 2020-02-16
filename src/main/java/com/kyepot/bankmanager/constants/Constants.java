package com.kyepot.bankmanager.constants;

public class Constants {
    public static int successCode = 200;
    public static int errorCode = 500;
    public static String success = "Success";
    public static String error = "error";
    public static String insufficientBalanceMessage = "Insufficient Balance.";
    public static String invalidAccountMessageDeposit = "Exception occurred while trying to deposit money into the account -- Account with account number {} does not exists";
    public static String invalidAccountMessageWithdrawn = "Exception occurred while trying to withdraw money into the account -- Account with account number {} does not exists";
    public static String invalidAccountMessage = "Invalid transaction. Account with account number " ;
    public static String newAccountSuccessMessage = "Customer Account Successfully created.";
    public static String amountDepositedMessage = "Amount successfully Deposited in the account";
    public static String amountWithdrawnMessage = "Amount successfully withdrawn from the account";
    public static String transactionsSuccessMessage = " Transactions found for a account number ";
    public static String accountsSuccessMessage = " Accounts found for a email id  ";
    public static String accountsEnquirySuccessMessage = "{} Accounts found for a email id {}";
    public static String transactionsEnquirySuccessMessage = "{} Transactions found for a account number {}";

}
