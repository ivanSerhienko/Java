import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

class Storage { //хранилище продуктов
    private int amountSalami = 14;
    private int amountCarbonade = 17;
    private int amountHam = 10;
    private int amountTomato = 20;
    private int amountPepper = 25;
    private int amountOnion = 19;
    private int amountCheddar = 23;
    private int amountKetchup = 23;
    private int amountParmesan = 21;
    private int amountDough = 29;
    private int amountMozzarella = 17;
    private int amountTuna = 11;
    private int amountFishFillet = 13;
    private int amountParsley = 16;
    private int amountCheese = 12;
    private int amountOlives = 99;
    private int amountGarlic = 10;
    private int amountPasta = 30;
    private int amountCaviar = 23;
    private int amountCucumber = 21;
    private int amountRice = 17;
    private int amountNori = 19;
    private int amountCoffee = 15;
    private int amountTea = 15;
    private int amountBear = 10;


    public Storage() { initializeAmountProductFromFile(); } // конструктор по умолчанию

    public int getAmountSalami() {
        return amountSalami;
    }

    public int getAmountCarbonade() {
        return amountCarbonade;
    }

    public int getAmountHam() {
        return amountHam;
    }

    public int getAmountTomato() {
        return amountTomato;
    }

    public int getAmountPepper() {
        return amountPepper;
    }

    public int getAmountOnion() {
        return amountOnion;
    }

    public int getAmountCheddar() {
        return amountCheddar;
    }

    public int getAmountKetchup() {
        return amountKetchup;
    }

    public int getAmountParmesan() {
        return amountParmesan;
    }

    public int getAmountDough() {
        return amountDough;
    }

    public int getAmountMozzarella() {
        return amountMozzarella;
    }

    public int getAmountTuna() {
        return amountTuna;
    }

    public int getAmountFishFillet() {
        return amountFishFillet;
    }

    public int getAmountParsley() {
        return amountParsley;
    }

    public int getAmountCheese() {
        return amountCheese;
    }

    public int getAmountOlives() {
        return amountOlives;
    }

    public int getAmountGarlic() {
        return amountGarlic;
    }

    public int getAmountPasta() {
        return amountPasta;
    }

    public int getAmountCaviar() {
        return amountCaviar;
    }

    public int getAmountСucumber() {
        return amountCucumber;
    }

    public int getAmountRice() {
        return amountRice;
    }

    public int getAmountNori() {
        return amountNori;
    }

    public int getAmountCoffee() {
        return amountCoffee;
    }

    public int getAmountTea() {
        return amountTea;
    }

    public int getAmountBear() {
        return amountBear;
    }

    public void decrementAmountSalami() {
        amountSalami--;
    }

    public void decrementAmountCarbonade() {
        amountCarbonade--;
    }

    public void decrementAmountHam() {
        amountHam--;
    }

    public void decrementAmountTomato() {
        amountTomato--;
    }

    public void decrementAmountPepper() {
        amountPepper--;
    }

    public void decrementAmountOnion() {
        amountOnion--;
    }

    public void decrementAmountCheddar() {
        amountCheddar--;
    }

    public void decrementAmountKetchup() {
        amountKetchup--;
    }

    public void decrementAmountParmesan() {
        amountParmesan--;
    }

    public void decrementAmountDough() {
        amountDough--;
    }

    public void decrementAmountMozzarella() {
        amountMozzarella--;
    }

    public void decrementAmountTuna() {
        amountTuna--;
    }

    public void decrementAmountFishFillet() {
        amountFishFillet--;
    }

    public void decrementAmountParsley() {
        amountParsley--;
    }

    public void decrementAmountCheese() {
        amountCheese--;
    }

    public void decrementAmountOlives() {
        amountOlives--;
    }

    public void decrementAmountGarlic() {
        amountGarlic--;
    }

    public void decrementAmountPasta() {
        amountPasta--;
    }

    public void decrementAmountCaviar() {
        amountCaviar--;
    }

    public void decrementAmountCucumber() {
        amountCucumber--;
    }

    public void decrementAmountRice() {
        amountRice--;
    }

    public void decrementAmountNori() {
        amountNori--;
    }

    public void decrementCoffee() {
        amountCoffee--;
    }

    public void decrementTea() {
        amountTea--;
    }

    public void decrementBear() {
        amountBear--;
    }

    //покупка продуктов
    public void buySalami(int amount) {
        amountSalami += amount;
    }

    public void buyCarbonade(int amount) {
        amountCarbonade += amount;
    }

    public void buyHam(int amount) {
        amountHam += amount;
    }

    public void buyTomato(int amount) {
        amountTomato += amount;
    }

    public void buyPepper(int amount) {
        amountPepper += amount;
    }

    public void buyOnion(int amount) {
        amountOnion += amount;
    }

    public void buyCheddar(int amount) {
        amountCheddar += amount;
    }

    public void buyKetchup(int amount) {
        amountKetchup += amount;
    }

    public void buyParmesan(int amount) {
        amountParmesan += amount;
    }

    public void buyDough(int amount) {
        amountDough += amount;
    }

    public void buyMozzarella(int amount) {
        amountMozzarella += amount;
    }

    public void buyTuna(int amount) {
        amountTuna += amount;
    }

    public void buyFishFillet(int amount) {
        amountFishFillet += amount;
    }

    public void buyParsley(int amount) {
        amountParsley += amount;
    }

    public void buyCheese(int amount) {
        amountCheese += amount;
    }

    public void buyOlives(int amount) {
        amountOlives += amount;
    }

    public void buyGarlic(int amount) {
        amountGarlic += amount;
    }

    public void buyPasta(int amount) {
        amountPasta += amount;
    }

    public void buyCaviar(int amount) {
        amountCaviar += amount;
    }

    public void buyRice(int amount) {
        amountRice += amount;
    }

    public void buyСucumber(int amount) {
        amountCucumber += amount;
    }

    public void buyNori(int amount) {
        amountNori += amount;
    }

    public void buyCoffee(int amount) {
        amountCoffee += amount;
    }

    public void buyTea(int amount) {
        amountTea += amount;
    }

    public void buyBear(int amount) {
        amountBear += amount;
    }

    public void write() {
        try (FileWriter products = new FileWriter("Products.txt", false)) {
            products.write("FoodStorage" +
                    "\n" +
                    "Amount of salami: " + amountSalami +
                    "\n" +
                    "Amount of ham: " + amountHam +
                    "\n" +
                    "Amount of bear: " + amountBear +
                    "\n" +
                    "Amount of carbonade: " + amountCarbonade +
                    "\n" +
                    "Amount of caviar: " + amountCaviar +
                    "\n" +
                    "Amount of cheddar: " + amountCheddar +
                    "\n" +
                    "Amount of cheese: " + amountCheese +
                    "\n" +
                    "Amount of coffee: " + amountCoffee +
                    "\n" +
                    "Amount of cucumber: " + amountCucumber +
                    "\n" +
                    "Amount of dough: " + amountDough +
                    "\n" +
                    "Amount of fish fillet: " + amountFishFillet +
                    "\n" +
                    "Amount of garlic: " + amountGarlic +
                    "\n" +
                    "Amount of ketchup: " + amountKetchup +
                    "\n" +
                    "Amount of mozzarella: " + amountMozzarella +
                    "\n" +
                    "Amount of fish nori: " + amountNori +
                    "\n" +
                    "Amount of olives: " + amountOlives +
                    "\n" +
                    "Amount of onion: " + amountOnion +
                    "\n" +
                    "Amount of parmesan: " + amountParmesan +
                    "\n" +
                    "Amount of parsley: " + amountParsley +
                    "\n" +
                    "Amount of pasta: " + amountPasta +
                    "\n" +
                    "Amount of pepper: " + amountPepper +
                    "\n" +
                    "Amount of rice: " + amountRice +
                    "\n" +
                    "Amount of tea: " + amountTea +
                    "\n" +
                    "Amount of tomato: " + amountTomato +
                    "\n" +
                    "Amount of tuna: " + amountTuna +
                    "\n" +
                    "Amount of tea: " + amountTea +
                    "\n" +
                    "Amount of bear: " + amountBear);
            products.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String readFromFile() {
        StringBuilder resultStringBuilder = new StringBuilder();
        String file = "Products.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultStringBuilder.toString();
    }

    public void initializeAmountProductFromFile() {
        String file = "Products.txt";
        TreeMap<String, String> productMap = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] splittedProduct = line.split(":\\s");
                productMap.put(splittedProduct[0], splittedProduct[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] amountOfProducts = new int[productMap.size()];
        int counter = 0;
        for (Map.Entry<String, String> entry : productMap.entrySet()) {
            amountOfProducts[counter] = Integer.parseInt(entry.getValue());
            counter++;
        }
        amountBear = amountOfProducts[0];
        amountCarbonade = amountOfProducts[1];
        amountCaviar = amountOfProducts[2];
        amountCheddar = amountOfProducts[3];
        amountCheese= amountOfProducts[4];
        amountCoffee = amountOfProducts[5];
        amountCucumber = amountOfProducts[6];
        amountDough = amountOfProducts[7];
        amountFishFillet = amountOfProducts[8];
        amountNori = amountOfProducts[9];
        amountGarlic = amountOfProducts[10];
        amountHam = amountOfProducts[11];
        amountKetchup = amountOfProducts[12];
        amountMozzarella = amountOfProducts[13];
        amountOlives = amountOfProducts[14];
        amountOnion = amountOfProducts[15];
        amountParmesan = amountOfProducts[16];
        amountParsley = amountOfProducts[17];
        amountPasta = amountOfProducts[18];
        amountPepper = amountOfProducts[19];
        amountRice = amountOfProducts[20];
        amountSalami = amountOfProducts[21];
        amountTea = amountOfProducts[22];
        amountTomato = amountOfProducts[23];
        amountTuna = amountOfProducts[24];
    }

    @Override
    public String toString() {
        return "FoodStorage" +
                "\n" +
                "Amount of salami: " + amountSalami +
                "\n" +
                "Amount of carbonade: " + amountCarbonade +
                "\n" +
                "Amount of ham: " + amountHam +
                "\n" +
                "Amount of tomato: " + amountTomato +
                "\n" +
                "Amount of pepper: " + amountPepper +
                "\n" +
                "Amount of onion: " + amountOnion +
                "\n" +
                "Amount of cheddar: " + amountCheddar +
                "\n" +
                "Amount of ketchup: " + amountKetchup +
                "\n" +
                "Amount of parmesan: " + amountParmesan +
                "\n" +
                "Amount of dough: " + amountDough +
                "\n" +
                "Amount of mozzarella: " + amountMozzarella +
                "\n" +
                "Amount of tuna: " + amountTuna +
                "\n" +
                "Amount of fish fillet: " + amountFishFillet +
                "\n" +
                "Amount of parsley: " + amountParsley +
                "\n" +
                "Amount of cheese: " + amountCheese +
                "\n" +
                "Amount of olives: " + amountOlives +
                "\n" +
                "Amount of garlic: " + amountGarlic +
                "\n" +
                "Amount of pasta: " + amountPasta +
                "\n" +
                "Amount of caviar: " + amountCaviar +
                "\n" +
                "Amount of rice: " + amountRice +
                "\n" +
                "Amount of cucumber: " + amountCucumber +
                "\n" +
                "Amount of nori: " + amountNori +
                "\n" +
                "Amount of coffee: " + amountCoffee +
                "\n" +
                "Amount of tea: " + amountTea +
                "\n" +
                "Amount of bear: " + amountBear;
    }
}
