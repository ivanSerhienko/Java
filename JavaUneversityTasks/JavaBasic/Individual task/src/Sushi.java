public class Sushi extends Dish{ // наследник Dish
    private String sushi;

    public Sushi(String sushi) { this.sushi = sushi; }

    private Storage repository = new Storage();

    @Override
    public boolean checkIngrediends() {
        if (sushi.equalsIgnoreCase("Sushi spice")) {
            if(repository.getAmountCaviar() != 0){
                if(repository.getAmountСucumber() != 0){
                    if(repository.getAmountRice() != 0){
                        if(repository.getAmountNori() != 0){
                            return true;
                        }
                        else{
                            System.out.println("Nori is over, buy nori!");
                            return false;
                        }
                    }
                    else{
                        System.out.println("Rice is over, buy rice!");
                        return false;
                    }
                }
                else{
                    System.out.println("Сucumber is over, buy cucumber!");
                    return false;
                }
            }
            else{
                System.out.println("Caviar is over, buy caviar!");
                return false;
            }
        }
        if (sushi.equalsIgnoreCase("Sushi with caviar")) {
            if(repository.getAmountCaviar() != 0){
                if(repository.getAmountTuna() != 0){
                    if(repository.getAmountRice() != 0){
                        if(repository.getAmountMozzarella() != 0){
                            return true;
                        }
                        else{
                            System.out.println("Mozzarella is over, buy mozzarella!");
                            return false;
                        }
                    }
                    else{
                        System.out.println("Rice is over, buy rice!");
                        return false;
                    }
                }
                else{
                    System.out.println("Tuna is over, buy tuna!");
                    return false;
                }
            }
            else{
                System.out.println("Caviar is over, buy caviar!");
                return false;
            }
        }
        if (sushi.equalsIgnoreCase("Sushi with tuna")) {
            if(repository.getAmountCaviar() != 0){
                if(repository.getAmountRice() != 0){
                    return true;
                }
                else{
                    System.out.println("Rice is over, buy rice!");
                    return false;
                }
            }
            else{
                System.out.println("Caviar is over, buy caviar!");
                return false;
            }
        }
        return false;
    }

    @Override
    public void decrementIngredients(){
        if (sushi.equalsIgnoreCase("Sushi spice")) {
                repository.decrementAmountCaviar();
                repository.decrementAmountCucumber();
                repository.decrementAmountRice();
                repository.decrementAmountNori();
                Sushi sushi = new Sushi("Sushi spice");
        }
        if (sushi.equalsIgnoreCase("Sushi with caviar")) {
                repository.decrementAmountCaviar();
                repository.decrementAmountTuna();
                repository.decrementAmountRice();
                repository.decrementAmountMozzarella();
                Sushi sushi = new Sushi("Sushi with caviar");
        }
        if (sushi.equalsIgnoreCase("Sushi with tuna")) {
                repository.decrementAmountCaviar();
                repository.decrementAmountRice();
                Sushi sushi = new Sushi("Sushi with tuna");
        }
    }

    @Override
    public String toString() {
        return sushi ;
    }
}
