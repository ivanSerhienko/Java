package Ivan.Serhienko;

import java.util.Scanner;

public class Main {
    public static void main (String [] args ) {
        BankAccount.setPercent(2);
        // создание счета
        System.out.print("How much would you like to open your account? :> ");
        Scanner in = new Scanner(System.in);
        float open = in.nextFloat();
        BankAccount account1 = new BankAccount(open);
        System.out.println("You have successfully opened a bank account.");

        System.out.println();

        //проверка метода "пополнение счета"
        System.out.print("How much do you want to fund your account? :> ");
        Scanner in1 = new Scanner(System.in);
        float addMonoey = in1.nextFloat();
        System.out.println("The account has been replenished");
        System.out.println("Current balance: " + account1.refill(addMonoey));

        System.out.println();

        //проверка метода "снятия денег со счета"
        System.out.print("How much do you want to withdraw your account? :> ");
        Scanner in2 = new Scanner(System.in);
        float subMoney = in2.nextFloat();
        if (account1.decline(subMoney)) {
            System.out.println("Money was withdrawn");
            System.out.println("Current balance: " + account1.getAccountBalance());
        }
        else {
            System.out.println("Money was not withdrawn");
            System.out.println("Current balance: " + account1.getAccountBalance());
        }

        System.out.println();

        // изменение процентов
        System.out.println("Do you want to change percent? please enter 1 if you want");
        Scanner in3 = new Scanner(System.in);
        int flag = in.nextInt();
        if (flag == 1) {
            System.out.print("Please, enter new percent. :> ");
            Scanner in4 = new Scanner(System.in);
            int newPercent = in4.nextInt();
            BankAccount.setPercent(newPercent);
        }


        //проверка метода "начисление процентов"
        System.out.println("Interest has been successfully accrued, your сurrent balance: " + account1.percent());

        System.out.println();

        //общий баланс по всем счетам
        BankAccount check = new BankAccount(0);
        BankAccount [] accounts = {account1, new BankAccount(10000)};
        System.out.println("The total balance is equal to: " + check.getTotalSum());
    }
}