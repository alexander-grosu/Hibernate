public class Main {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();
        BankAccount depositAccount = new DepositAccount();
        CardAccount card_Account = new CardAccount();
        DepositAccount DepositCount1 = new DepositAccount(1_000_000);
        CardAccount CardCount1 = new CardAccount(777);

        card_Account.getAmount();
        card_Account.put(7000);
        card_Account.getAmount();
        card_Account.send(depositAccount, 2000);
        card_Account.getAmount();
        depositAccount.getAmount();
        depositAccount.send(bankAccount, 1000);
        depositAccount.getAmount();
        bankAccount.getAmount();
        card_Account.send(bankAccount, 100);
        bankAccount.getAmount();
        DepositCount1.getAmount();
        CardCount1.getAmount();
    }
}