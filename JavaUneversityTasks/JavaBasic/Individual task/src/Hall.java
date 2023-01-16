import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* класс Table - массив столиков,
что было заказано, обнулить столик. - Map или Set*/
public class Hall{
    private ArrayList <Table> tables = new ArrayList<Table>(); // массив столиков

    //private Table obj = new Table(-1, ""); // обьект класса Table для вызова методов класса Table

    public Hall() { createTables(); }

    public void changeTableStatus (int numTable, String newStatus) {tables.get(numTable - 1).changeStatus(newStatus);} // изменить статус столика

    public void addFoodToTable(int numTable, Dish order) { tables.get(numTable - 1).addFoodToTable(order);}//добваить заказ(еда) на стол

    public void addDrinkToTable(int numTable, Drink order) {tables.get(numTable - 1).addDrinkToTable(order);}//добваить заказ(напиток) на стол

    public void resetTheTable(int numTable) {tables.get(numTable - 1).clearTable();} //обнулить столик

    public void printTableInfo(int numTable){tables.get(numTable - 1).print();} //вывести инфо про стол. Инфо про вес столы выводиться через toString

    public void menu(){
        System.out.println("Pizza:");
        System.out.println("\t1.Meat Pizza");
        System.out.println("\t2.Fish Pizza");
        System.out.println("\t3.Vegan Pizza");
        System.out.println("Pasta:");
        System.out.println("\t4.Meat Pasta");
        System.out.println("\t5.Fish Pasta");
        System.out.println("\t6.Vegan Pasta");
        System.out.println("Sushi");
        System.out.println("\t7.Sushi spice");
        System.out.println("\t8.Sushi with caviar");
        System.out.println("\t9.Sushi with tuna");
        System.out.println("Drinks");
        System.out.println("\t10.Coffee");
        System.out.println("\t11.Tea");
        System.out.println("\t12.Bear");
    }

    public void addTable(int numTable){ tables.add(new Table(numTable - 1, "Free" )); } // добавить новый стол

    public void delTable(int numTable){ tables.remove(numTable - 1); } // удалить стол

    public void createTables(){ // создание столов (по умолчанию)
        for(int i = 0; i < 5 ; i++) { // 5 столиков по умолчанию
            tables.add(new Table(i+1,"Free"));
        }
    }

    public void writeToFile(){
        try(FileWriter fw = new FileWriter("Tables.txt")) {
            for (int i = 0; i < tables.size(); i++) {
                fw.write(i+1 + ". " +tables.get(i).status);
                if(tables.get(i).food.iterator().hasNext() | tables.get(i).drink.iterator().hasNext()){
                    fw.write(": The food that was ordered: ");
                    if (tables.get(i).food.isEmpty())
                        fw.write("Nothing ");
                    else {
                        Dish food = null;
                        for (int k = 0; k < tables.get(i).food.size(); k++)
                            fw.write((tables.get(i).food.get(k)) + " ");
                    }
                    fw.write(" The drink that was ordered: ");
                    if (tables.get(i).drink.isEmpty())
                        fw.write("Nothing ");
                    else {
                        for (int j = 0; j < tables.get(i).drink.size(); j++)
                            fw.write(tables.get(i).drink.get(j) + " ");
                    }
                }

                fw.append("\n");
            }
            fw.flush();
        } catch (IOException ex) {System.out.println(ex.getMessage());}
    }

    public String readFromFile(){
        StringBuilder resultStringBuilder = new StringBuilder();
        String file = "Tables.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException e) { e.printStackTrace(); }
        return resultStringBuilder.toString();
    }

    class Table { //номер стола, список блюд, список напитков
        private int id; // номер столика
        String status; // стол свободен или занят

        public Table(int id, String status) {
            this.id = id;
            this.status = status;
        }

        //private - потому это поле класса
        private ArrayList <Dish> food = new ArrayList<Dish>(); // стринговый массив - еда, которая была заказана на столик
        private ArrayList <Drink> drink = new ArrayList<Drink>();// стринговый массив - напитки, которые были заказаны на столик

        public void changeStatus(String newStatus){
            this.status = newStatus;
        }

        public void addFoodToTable(Dish food){
            this.food.add(food);
        }

        public void addDrinkToTable(Drink drink){ this.drink.add(drink); }

        public void clearTable(){
            this.food.clear();
            this.drink.clear();
            status = "Free";
        }

        public void print(){
            System.out.print("The food that was ordered: ");
            if(food.isEmpty())
                System.out.print("Nothing ");
            else{
                for (int i = 0; i < this.food.size(); i++)
                    System.out.print(this.food.get(i) + " ");
            }
            System.out.print(" The drink that was ordered: ");
            if(drink.isEmpty())
                System.out.print("Nothing ");
            else{
                for (int j = 0; j < this.drink.size(); j++)
                    System.out.print(this.drink.get(j) + " ");
            }
        }
    }

    @Override
    public String toString() {
        System.out.println("Status of tables:");
        for (Table i : tables) {
            System.out.print((tables.indexOf(i) + 1) + " ");
            System.out.print(i.status + " ");
            if(i.food.iterator().hasNext() | i.drink.iterator().hasNext()){
                i.print();
            }
            System.out.println();
        }
        return "";
    }
}
