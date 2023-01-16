import java.util.ArrayDeque;
import java.io.*;

public class Kitchen{
    public Kitchen() {}

    ArrayDeque<Dish> dishes = new ArrayDeque<>(); // не стринг а Dish (Dish - абстракный класс)

    public void addToQueue(Dish dish){
        if(dish != null){
            if(dish.checkIngrediends()){
                dish.decrementIngredients();
                dishes.addLast(dish);
            }
        }
    }

    public Dish deleteFromQueue(){
        return dishes.pollFirst();
    }

    public void writeToFileUp() {
        try(FileWriter writer = new FileWriter("Dishes prepared.txt", true))
        {
            while(this.dishes.peek() != null){
                System.out.println(this.dishes.peek());
                String text = String.valueOf(this.dishes.pop());
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
        String file = "Dishes prepared.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException e) { e.printStackTrace(); }
        return resultStringBuilder.toString();
    }

    public void delFirstLineFromFile() {
        try(BufferedReader reader = new BufferedReader(new FileReader("Dishes prepared.txt"))){
            StringBuilder sb = new StringBuilder();

            while (reader.ready()) {
                sb.append(reader.readLine()).append("\n");
            }

            int indexDel = sb.indexOf("\n");
            if (indexDel != -1)
                sb.delete(0, indexDel + 1);

            FileWriter writer = new FileWriter("Dishes prepared.txt", false);
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException e) { e.printStackTrace(); }
    }


    @Override
    public String toString() {
        System.out.println("Dishes that are being prepared");
        while(dishes.peek()!=null){
            System.out.println(dishes.pop());
        }
        return "";
    }
}