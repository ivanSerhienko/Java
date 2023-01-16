import java.util.Scanner;

public class Restaurant {
    private String name;

    Kitchen kit = new Kitchen();
    Hall hall = new Hall();
    Bar bar = new Bar();
    Storage storage = new Storage();

    // 3 обьекта Bar Kitchen Hall
    private int cooks;
    private int waiters;
    private int barmans;

    public Restaurant(){} // default constructor

    public Restaurant(String name, int cooks,int waiters, int barmans) {
        this.name = name;
        this.cooks = cooks;
        this.waiters = waiters;
        this.barmans = barmans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCooks() { return cooks; }

    public int getWaiters() { return waiters; }

    public int getBarmans() { return barmans; }

    public int getTotalEmployes() { return cooks + waiters + barmans; }

    public void dismissCook () { cooks -= 1; }
    public void hireCook () { cooks += 1; }

    public void dismissWaiter () { waiters -= 1; }
    public void hireWaiter () { waiters += 1; }

    public void dismissBarmans () {barmans --;}
    public void hireBarmans () {barmans ++;}

    public void modularity() {
        System.out.println("1.Info" + "\n" + "2.New guest" + "\n" + "3.Buy products" + "\n" + "4.Dismiss or Hire" + "\n" + "5.Tables" + "\n" + "0.Finish");
        Scanner in = new Scanner(System.in);
        int choose = in.nextInt();
        int act = 0;

        while (choose != 0) {
            switch (choose) {
                case 1:
                    System.out.println("1.InfoRes" + "\n" + "2.InfoKitchen" + "\n" + "3.InfoWarehouse" + "\n" + "4.InfoHall" + "\n" + "5.Info Bar");
                    Scanner in1 = new Scanner(System.in);
                    int choose1 = in.nextInt();
                    switch (choose1){
                        case 1:
                            System.out.println(toString());
                            act++;
                            break;
                        case 2:
                            System.out.println(kit.readFromFile());
                            act++;
                            break;
                        case 3:
                            System.out.println(storage.readFromFile());
                            act++;
                            break;
                        case 4:
                            System.out.println(hall.readFromFile());
                            act++;
                            break;
                        case 5:
                            System.out.println(bar.readFromFile());
                            act++;
                            break;
                        default:
                            System.out.println("Please, enter the correct number!");
                    }
                    break;
                case 2:
                    System.out.println("Which table has become occupied?");
                    Scanner in3 = new Scanner(System.in);
                    int numTable = in3.nextInt();
                    hall.changeTableStatus(numTable,"Busy");
                    System.out.println("What was ordered?");
                    hall.menu();
                    Scanner in4 = new Scanner(System.in);
                    int choose2 = in4.nextInt();
                    while (choose2 != 0){
                        switch (choose2){
                            case 1:
                                Pizza meatPizza = new Pizza("Meat pizza");
                                kit.addToQueue(meatPizza);
                                hall.addFoodToTable(numTable, meatPizza);
                                break;
                            case 2:
                                Pizza fishPizza = new Pizza("Fish pizza");
                                kit.addToQueue(fishPizza);
                                hall.addFoodToTable(numTable, fishPizza);
                                break;
                            case 3:
                                Pizza veganPizza = new Pizza("Vegan pizza");
                                kit.addToQueue(veganPizza);
                                hall.addFoodToTable(numTable, veganPizza);
                                break;
                            case 4:
                                Pasta meatPasta = new Pasta("Meat pasta");
                                kit.addToQueue(meatPasta);
                                hall.addFoodToTable(numTable, meatPasta);
                                break;
                            case 5:
                                Pasta fishPasta = new Pasta("Fish pasta");
                                kit.addToQueue(fishPasta);
                                hall.addFoodToTable(numTable, fishPasta);
                                break;
                            case 6:
                                Pasta veganPasta = new Pasta("Vegan pasta");
                                kit.addToQueue(veganPasta);
                                hall.addFoodToTable(numTable, veganPasta);
                                break;
                            case 7:
                                Sushi sushiSpice = new Sushi("Sushi spice");
                                kit.addToQueue(sushiSpice);
                                hall.addFoodToTable(numTable, sushiSpice);
                                break;
                            case 8:
                                Sushi sushiWithCaviar = new Sushi("Sushi with caviar");
                                kit.addToQueue(sushiWithCaviar);
                                hall.addFoodToTable(numTable, sushiWithCaviar);
                                break;
                            case 9:
                                Sushi sushiWithTuna = new Sushi("Sushi with tuna");
                                kit.addToQueue(sushiWithTuna);
                                hall.addFoodToTable(numTable, sushiWithTuna);
                                break;
                            case 10:
                                Coffee coffee = new Coffee("Coffee");
                                bar.addToQueue(coffee);
                                hall.addDrinkToTable(numTable, coffee);
                                break;
                            case 11:
                                Tea tea = new Tea("Tea");
                                bar.addToQueue(tea);
                                hall.addDrinkToTable(numTable, tea);
                                break;
                            case 12:
                                Bear bear = new Bear("Bear");
                                bar.addToQueue(bear);
                                hall.addDrinkToTable(numTable, bear);
                                break;
                            default:
                                System.out.println("Please, enter the correct number!");
                        }
                        System.out.println("Anything else? Enter 0 if that's all");

                        Scanner in36 = new Scanner(System.in);
                        choose2 = in36.nextInt();
                    }
                    kit.writeToFileUp();
                    bar.writeToFileUp();
                    hall.writeToFile();
                    act++;
                    break;
                case 3:
                    System.out.println("1.Buy salami" +
                            "\n" +
                            "2.Buy carbonade" +
                            "\n" +
                            "3.Buy ham" +
                            "\n" +
                            "4.Buy tomato" +
                            "\n" +
                            "5.Buy pepper" +
                            "\n" +
                            "6.Buy onion" +
                            "\n" +
                            "7.Buy cheddar" +
                            "\n" +
                            "8.Buy ketchup" +
                            "\n" +
                            "9.Buy parmesan" +
                            "\n" +
                            "10.Buy dough" +
                            "\n" +
                            "11.Buy mozzarella" +
                            "\n" +
                            "12.Buy tuna" +
                            "\n" +
                            "13.Buy fish fillet" +
                            "\n" +
                            "14.Buy parsley" +
                            "\n" +
                            "15.Buy cheese" +
                            "\n" +
                            "16.Buy olives" +
                            "\n" +
                            "17.Buy garlic" +
                            "\n" +
                            "18.Buy pasta" +
                            "\n" +
                            "19.Buy caviar" +
                            "\n" +
                            "20.Buy rice" +
                            "\n" +
                            "21.Buy cucumber" +
                            "\n" +
                            "22.Buy nori" +
                            "\n" +
                            "23.Buy coffee"
                            +"\n"+
                            "24.Buy tea"
                            +"\n"+
                            "25.Buy bear");
                    System.out.println();
                    Scanner in5 = new Scanner(System.in);
                    int choose3 = in5.nextInt();
                    while (choose3 != 0){
                        switch (choose3){
                            case 1:
                                System.out.println("Haw many?");
                                Scanner in6 = new Scanner(System.in);
                                int amount = in6.nextInt();
                                storage.buySalami(amount);
                                break;
                            case 2:
                                System.out.println("Haw many?");
                                Scanner in7 = new Scanner(System.in);
                                int amount1 = in7.nextInt();
                                storage.buyCarbonade(amount1);
                                break;
                            case 3:
                                System.out.println("Haw many?");
                                Scanner in8 = new Scanner(System.in);
                                int amount2 = in8.nextInt();
                                storage.buyHam(amount2);
                                break;
                            case 4:
                                System.out.println("Haw many?");
                                Scanner in9 = new Scanner(System.in);
                                int amount3 = in9.nextInt();
                                storage.buyTomato(amount3);
                                break;
                            case 5:
                                System.out.println("Haw many?");
                                Scanner in10 = new Scanner(System.in);
                                int amount4 = in10.nextInt();
                                storage.buyPepper(amount4);
                                break;
                            case 6:
                                System.out.println("Haw many?");
                                Scanner in11 = new Scanner(System.in);
                                int amount5 = in11.nextInt();
                                storage.buyOnion(amount5);
                                break;
                            case 7:
                                System.out.println("Haw many?");
                                Scanner in12 = new Scanner(System.in);
                                int amount6 = in12.nextInt();
                                storage.buyCheddar(amount6);
                                break;
                            case 8:
                                System.out.println("Haw many?");
                                Scanner in13 = new Scanner(System.in);
                                int amount7 = in13.nextInt();
                                storage.buyKetchup(amount7);
                                break;
                            case 9:
                                System.out.println("Haw many?");
                                Scanner in14 = new Scanner(System.in);
                                int amount8 = in14.nextInt();
                                storage.buyParmesan(amount8);
                                break;
                            case 10:
                                System.out.println("Haw many?");
                                Scanner in15 = new Scanner(System.in);
                                int amount9 = in15.nextInt();
                                storage.buyDough(amount9);
                                break;
                            case 11:
                                System.out.println("Haw many?");
                                Scanner in16 = new Scanner(System.in);
                                int amount10 = in16.nextInt();
                                storage.buyMozzarella(amount10);
                                break;
                            case 12:
                                System.out.println("Haw many?");
                                Scanner in17 = new Scanner(System.in);
                                int amount11 = in17.nextInt();
                                storage.buyTuna(amount11);
                                break;
                            case 13:
                                System.out.println("Haw many?");
                                Scanner in18 = new Scanner(System.in);
                                int amount12 = in18.nextInt();
                                storage.buyFishFillet(amount12);
                                break;
                            case 14:
                                System.out.println("Haw many?");
                                Scanner in19 = new Scanner(System.in);
                                int amount13 = in19.nextInt();
                                storage.buyParsley(amount13);
                                break;
                            case 15:
                                System.out.println("Haw many?");
                                Scanner in20 = new Scanner(System.in);
                                int amount14 = in20.nextInt();
                                storage.buyCheese(amount14);
                                break;
                            case 16:
                                System.out.println("Haw many?");
                                Scanner in21 = new Scanner(System.in);
                                int amount15 = in21.nextInt();
                                storage.buyOlives(amount15);
                                break;
                            case 17:
                                System.out.println("Haw many?");
                                Scanner in22 = new Scanner(System.in);
                                int amount16 = in22.nextInt();
                                storage.buyGarlic(amount16);
                                break;
                            case 18:
                                System.out.println("Haw many?");
                                Scanner in23 = new Scanner(System.in);
                                int amount17 = in23.nextInt();
                                storage.buyPasta(amount17);
                                break;
                            case 19:
                                System.out.println("Haw many?");
                                Scanner in24 = new Scanner(System.in);
                                int amount18 = in24.nextInt();
                                storage.buyCaviar(amount18);
                                break;
                            case 20:
                                System.out.println("Haw many?");
                                Scanner in25 = new Scanner(System.in);
                                int amount19 = in25.nextInt();
                                storage.buyRice(amount19);
                                break;
                            case 21:
                                System.out.println("Haw many?");
                                Scanner in26 = new Scanner(System.in);
                                int amount20 = in26.nextInt();
                                storage.buyСucumber(amount20);
                                break;
                            case 22:
                                System.out.println("Haw many?");
                                Scanner in27 = new Scanner(System.in);
                                int amount21 = in27.nextInt();
                                storage.buyNori(amount21);
                                break;
                            case 23:
                                System.out.println("Haw many?");
                                Scanner in28 = new Scanner(System.in);
                                int amount22 = in28.nextInt();
                                storage.buyCoffee(amount22);
                                break;
                            case 24:
                                System.out.println("Haw many?");
                                Scanner in29 = new Scanner(System.in);
                                int amount23 = in29.nextInt();
                                storage.buyTea(amount23);
                                break;
                            case 25:
                                System.out.println("Haw many?");
                                Scanner in30 = new Scanner(System.in);
                                int amount24 = in30.nextInt();
                                storage.buyBear(amount24);
                                break;
                            default:
                                System.out.println("Please, enter the correct number!");
                        }
                        System.out.println("Anything else? Enter 0 if that's all");
                        Scanner in38 = new Scanner(System.in);
                        choose3 = in38.nextInt();
                    }
                    storage.write();
                    act++;
                    break;
                case 4:
                    System.out.println("1.Cooks" + "\n" + "2.Waiter" + "\n" + "3.Bartender");
                    Scanner in31 = new Scanner(System.in);
                    int choose4 = in31.nextInt();
                    switch (choose4) {
                        case 1:
                            System.out.println("1.Hire" + "\n" + "2.Dismiss");
                            Scanner in32 = new Scanner(System.in);
                            int choose5 = in32.nextInt();
                            switch (choose5) {
                                case 1:
                                    hireCook();
                                    act++;
                                    break;
                                case 2:
                                    dismissCook();
                                    act++;
                                    break;
                                default:
                                    System.out.println("Please, enter the correct number!");
                            }
                            break;
                        case 2:
                            System.out.println("1.Hire" + "\n" + "2.Dismiss");
                            Scanner in33 = new Scanner(System.in);
                            int choose6 = in33.nextInt();
                            switch (choose6) {
                                case 1:
                                    hireWaiter();
                                    act++;
                                    break;
                                case 2:
                                    dismissWaiter();
                                    act++;
                                    break;
                                default:
                                    System.out.println("Please, enter the correct number!");
                            }
                            break;
                        case 3:
                            System.out.println("1.Hire" + "\n" + "2.Dismiss");
                            Scanner in34 = new Scanner(System.in);
                            int choose7 = in34.nextInt();
                            switch (choose7){
                                case 1:
                                    hireBarmans();
                                    act++;
                                    break;
                                case 2:
                                    dismissBarmans();
                                    act++;
                                    break;
                                default:
                                    System.out.println("Please, enter the correct number!");
                            }
                            break;
                        default:
                            System.out.println("Please, enter the correct number!");
                    }
                    break;
                case 5:
                    System.out.println("1.Reset table" + "\n" + "2.Print table info" + "\n " + "3.Add table" + "\n " + "4.Delete table");
                    Scanner in40 = new Scanner(System.in);
                    int choose7 = in40.nextInt();
                    switch (choose7){
                        case 1:
                            System.out.println("Enter the number of the table");
                            Scanner in41 = new Scanner(System.in);
                            int tableNum = in40.nextInt();
                            hall.resetTheTable(tableNum);
                            act++;
                            break;
                        case 2:
                            System.out.println("Enter the number of the table");
                            Scanner in42 = new Scanner(System.in);
                            int tableNum1 = in40.nextInt();
                            hall.printTableInfo(tableNum1);
                            act ++;
                            break;
                        case 3:
                            System.out.println("Enter the number of the table");
                            Scanner in43 = new Scanner(System.in);
                            int tableNum2 = in40.nextInt();
                            hall.addTable(tableNum2);
                            act++;
                            break;
                        case  4:
                            System.out.println("Enter the number of the table");
                            Scanner in44 = new Scanner(System.in);
                            int tableNum3 = in40.nextInt();
                            hall.delTable(tableNum3);
                            act++;
                            break;
                        default:
                            System.out.println("Please, enter the correct number!");
                    }
                    break;
                default:
                    System.out.println("Please, enter the correct number!");
            }
            if (act >= 1){
                if(act>=2){
                    kit.deleteFromQueue();
                    bar.deleteFromQueue();
                    kit.delFirstLineFromFile();
                    bar.delFirstLineFromFile();
                    act = 0;
                }
                else{
                    bar.deleteFromQueue();
                    bar.delFirstLineFromFile();
                    act = 0;
                }
            }
            System.out.println("1.Info" + "\n" + "2.New guest" + "\n" + "3.Buy products" + "\n" + "4.Dismiss or Hire" + "\n" + "5.Tables" + "\n"  + "0. Finish");
            Scanner in35 = new Scanner(System.in);
            choose = in35.nextInt();
        }
    }

    @Override
    public String toString() { // вывод информации
        return "Restaurant: " + name
                + "\n" +
                "Amount of employees: " + getTotalEmployes()
                + "\n" +
                "Amount of cooks: " + cooks
                + "\n" +
                "Amount of waiters: " + waiters
                + "\n" +
                "Amount of barmans: " + barmans;
    }

    public Kitchen getKit() {
        return kit;
    }

    public void setKit(Kitchen kit) {
        this.kit = kit;
    }
}
