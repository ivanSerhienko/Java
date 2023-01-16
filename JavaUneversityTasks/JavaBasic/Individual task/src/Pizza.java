public class Pizza extends Dish{
    private String pizza;

    public Pizza(String pizza) { this.pizza = pizza; }

    private Storage repository = new Storage();

    @Override
    public boolean checkIngrediends(){
        if (pizza.equalsIgnoreCase("Meat pizza")){
            if(repository.getAmountSalami() != 0){
                if(repository.getAmountCarbonade() != 0){
                    if(repository.getAmountHam() != 0){
                        if(repository.getAmountTomato() != 0){
                            if(repository.getAmountPepper() != 0){
                                if(repository.getAmountOnion() != 0){
                                    if(repository.getAmountCheddar() != 0){
                                        if(repository.getAmountKetchup() != 0){
                                            if(repository.getAmountParmesan() != 0){
                                                if(repository.getAmountDough() != 0){
                                                    return true;
                                                }
                                                else {
                                                    System.out.println("Dough is over, buy dough!");
                                                    return false;
                                                }
                                            }
                                            else {
                                                System.out.println("Parmesan is over, buy parmesan!");
                                                return false;
                                            }
                                        }
                                        else {
                                            System.out.println("Ketchup is over, buy ketchup!");
                                            return false;
                                        }
                                    }
                                    else {
                                        System.out.println("Cheddar is over, buy cheddar!");
                                        return false;
                                    }
                                }
                                else {
                                    System.out.println("Onion is over, buy onion!");
                                    return false;
                                }
                            }
                            else {
                                System.out.println("Pepper is over, buy pepper!");
                                return false;
                            }
                        }
                        else {
                            System.out.println("Tomato is over, buy tomato!");
                            return false;
                        }
                    }
                    else {
                        System.out.println("Ham is over, buy ham!");
                        return false;
                    }
                }
                else {
                    System.out.println("Carbonade is over, buy carbonade!");
                    return false;
                }
            }
            else {
                System.out.println("Salami is over, buy salami!");
                return false;
            }
        }
        if(pizza.equalsIgnoreCase("Fish pizza")){
            if(repository.getAmountMozzarella() != 0){
                if(repository.getAmountTuna() != 0){
                    if(repository.getAmountFishFillet() != 0){
                        if(repository.getAmountParsley() != 0){
                            if(repository.getAmountKetchup() != 0){
                                if(repository.getAmountDough() != 0){
                                    return true;
                                }
                                else{
                                    System.out.println("Dough is over, buy dough!");
                                    return false;
                                }
                            }
                            else{
                                System.out.println("Ketchup is over, buy ketchup!");
                                return false;
                            }
                        }
                        else{
                            System.out.println("Parsley is over, buy parsley!");
                            return false;
                        }
                    }
                    else{
                        System.out.println("Fish fillet is over, buy fish fillet!");
                        return false;
                    }
                }
                else{
                    System.out.println("Tuna is over, buy tuna!");
                    return false;
                }
            }
            else{
                System.out.println("Mozzarella is over, buy mozzarella!");
                return false;
            }
        }
        if (pizza.equalsIgnoreCase("Vegan pizza")){
            if(repository.getAmountKetchup() != 0){
                if(repository.getAmountDough() != 0){
                    if(repository.getAmountTomato() != 0){
                        if(repository.getAmountPepper() != 0){
                            if(repository.getAmountOnion() != 0){
                                if(repository.getAmountMozzarella() != 0){
                                    if(repository.getAmountCheese() != 0){
                                        if(repository.getAmountOlives() != 0){
                                            if(repository.getAmountGarlic() != 0) {
                                                return true;
                                            }
                                            else{
                                                System.out.println("Garlic is over, buy garlic!");
                                                return false;
                                            }
                                        }
                                        else{
                                            System.out.println("Olives is over, buy olives!");
                                            return false;
                                        }
                                    }
                                    else{
                                        System.out.println("Cheese is over, buy cheese!");
                                        return false;
                                    }
                                }
                                else{
                                    System.out.println("Mozzarella is over, buy mozzarella!");
                                    return false;
                                }
                            }
                            else{
                                System.out.println("Onion is over, buy onion!");
                                return false;
                            }
                        }
                        else{
                            System.out.println("Pepper is over, buy pepper!");
                            return false;
                        }
                    }
                    else{
                        System.out.println("Tomato is over, buy tomato!");
                        return false;
                    }
                }
                else{
                    System.out.println("Dough is over, buy dough!");
                    return false;
                }
            }
            else{
                System.out.println("Ketchup is over, buy ketchup!");
                return false;
            }
        }
        return false;
    }

    @Override
    public void decrementIngredients(){
        if (pizza.equalsIgnoreCase("Meat pizza")) {
                repository.decrementAmountSalami();
                repository.decrementAmountCarbonade();
                repository.decrementAmountHam();
                repository.decrementAmountTomato();
                repository.decrementAmountPepper();
                repository.decrementAmountOnion();
                repository.decrementAmountCheddar();
                repository.decrementAmountKetchup();
                repository.decrementAmountParmesan();
                repository.decrementAmountDough();
        }
        if (pizza.equalsIgnoreCase("Fish pizza")) {
                repository.decrementAmountMozzarella();
                repository.decrementAmountTuna();
                repository.decrementAmountFishFillet();
                repository.decrementAmountParsley();
                repository.decrementAmountKetchup();
                repository.decrementAmountDough();
        }
        if (pizza.equalsIgnoreCase("Vegan pizza")) {
                repository.decrementAmountKetchup();
                repository.decrementAmountDough();
                repository.decrementAmountTomato();
                repository.decrementAmountPepper();
                repository.decrementAmountOnion();
                repository.decrementAmountMozzarella();
                repository.decrementAmountCheese();
                repository.decrementAmountOlives();
                repository.decrementAmountGarlic();
        }
        //throw IllegalArgumentException();
    }

    @Override
    public String toString() { return pizza; }
}