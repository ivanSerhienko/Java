// Сергиенко Иван МФ-21
/*Разработать класс «Банковский счет», обеспечить возможность добавления и снятия денег со счета, проверки текущего
  баланса, а также начисления процентов. Использовать статические переменные для хранения процентной ставки и
  подсчета общего баланса по всем счетам*/
package Ivan.Serhienko;

import java.util.Scanner;

public class BankAccount{

    private float accountBalance;

    private static int percent = 2;

    static float totalSum = 0;

    public BankAccount (float accountBalance){
        this.accountBalance = accountBalance;
        totalSum += this.accountBalance;
    }

    public float getAccountBalance(){ return accountBalance; }

    public float refill (float money){
        accountBalance += money;
        totalSum += accountBalance - totalSum;
        return accountBalance;
    }

    public static void setPercent(int percent) {
        BankAccount.percent = percent;
    }

    public boolean decline (float money){
        while(money > accountBalance){
            System.out.println("You don't have enough money in your account.");
            System.out.println("Your current balance: " + accountBalance);
            System.out.print("Please enter another amount. Enter 0 if you want exit. : > ");
            Scanner in = new Scanner(System.in);
            money = in.nextFloat();
            if (money == 0) return false;
        }
        accountBalance -= money;
        totalSum -= accountBalance + totalSum;
        return true;
    }

    public float percent (){
        accountBalance += accountBalance * percent;
        totalSum += accountBalance - totalSum;
        return accountBalance;
    }

    public static float getTotalSum (){
        return totalSum;
    }
}