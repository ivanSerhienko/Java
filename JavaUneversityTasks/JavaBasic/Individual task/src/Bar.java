import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;

public class Bar{

    public Bar() {}

    //Drink [] beverages = { new Bear(), new Coffee(), new Tea() };

    ArrayDeque<Drink> drinks = new ArrayDeque<Drink>(); // не стринг а Drink (Drink - абстракный класс)

    public void addToQueue(Drink drink){
        if(drink != null){
            if (drink.checkIngredients()){
                drink.decrementIngredients();
                drinks.addLast(drink);
            }
        }
    }

    public Drink deleteFromQueue(){
        return drinks.pollFirst();
    }

    public void writeToFileUp() {
        try(FileWriter writer = new FileWriter("Drinks prepared.txt", true))
        {
            while(this.drinks.peek() != null){
                System.out.println(this.drinks.peek());
                String text = String.valueOf(this.drinks.pop());
                writer.write(text);
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public String readFromFile() {
        StringBuilder resultStringBuilder = new StringBuilder();
        String file = "Drinks prepared.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException e) { e.printStackTrace(); }
        return resultStringBuilder.toString();
    }

    public void delFirstLineFromFile() {
        try(BufferedReader reader = new BufferedReader(new FileReader("Drinks prepared.txt"))){
            StringBuilder sb = new StringBuilder();

            while (reader.ready()) {
                sb.append(reader.readLine()).append("\n");
            }

            int indexDel = sb.indexOf("\n");
            if (indexDel != -1)
                sb.delete(0, indexDel + 1);

            FileWriter writer = new FileWriter("Drinks prepared.txt", false);
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException e) { e.printStackTrace(); }
    }

    @Override
    public String toString() {
        System.out.println("Drinks that are being prepared");
        while(drinks.peek()!=null){
            // извлечение c начала
            System.out.println(drinks.pop());
        }
        return "";
    }
}