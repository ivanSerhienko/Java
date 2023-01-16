public class Bear extends Drink{
    private String bear;

    public Bear(String bear) { this.bear = bear; }

    private Storage repository = new Storage();

    @Override
    boolean checkIngredients(){
        if (bear.equalsIgnoreCase("Bear")){
            if(repository.getAmountBear() != 0)
                return true;
            else
                System.out.println("Bear is over, buy bear!");
            return false;
        }
        return false;
    }

    @Override
    void decrementIngredients(){
        if(bear.equalsIgnoreCase("Bear")){
            if (checkIngredients()){
                repository.decrementBear();
            }
        }
    }

    @Override
    public String toString() { return bear ; }
}