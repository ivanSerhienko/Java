public class Tea extends Drink{
    private String tea;

    public Tea(String tea) { this.tea = tea; }

    private Storage repository = new Storage();

    @Override
    public boolean checkIngredients(){
        if(tea.equalsIgnoreCase("Tea")){
            if(repository.getAmountTea() != 0)
            return true;
        else
            System.out.println("Tea is over, buy Tea!");
            return false;
        }
        return false;
    }

    @Override
    public void decrementIngredients(){
        if(tea.equalsIgnoreCase("Tea")){
                repository.decrementTea();
        }
    }

    @Override
    public String toString() { return tea ; }
}
