public class Coffee extends Drink {
    private String coffee;

    public Coffee(String coffee) { this.coffee = coffee; }

    private Storage repository = new Storage();

    @Override
    public boolean checkIngredients(){
        if (coffee.equalsIgnoreCase("Coffee")) {
            if(repository.getAmountCoffee() != 0)
                return true;
            else
                System.out.println("Coffee is over, buy coffee!");
            return false;
        }
        return false;
    }

    @Override
    public void decrementIngredients() {
        if (coffee.equalsIgnoreCase("Coffee")) {
                repository.decrementCoffee();
        }
    }

    @Override
    public String toString() { return coffee ; }
}