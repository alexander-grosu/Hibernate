public class Main {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();
        BankAccount depositAccount = new DepositAccount();
        CardAccount card_Account = new CardAccount();
        DepositAccount depositCount1 = new DepositAccount(1_000_000);
        CardAccount cardCount1 = new CardAccount(777);

        card_Account.getAmount();
        card_Account.put(7000);
        card_Account.getAmount();
        card_Account.send(depositAccount, 2000); // переведется 2000
        card_Account.getAmount();
        depositAccount.getAmount(); // 2000 на счету
        depositAccount.send(bankAccount, 1000); // не переведется потому что не прошнл 1 мес
        depositAccount.getAmount();
        bankAccount.getAmount(); // на счету останется - 0
        card_Account.send(bankAccount, 100);
        bankAccount.getAmount();
        depositCount1.getAmount();
        cardCount1.getAmount();
    }
}