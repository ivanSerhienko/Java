public class Pasta extends Dish {
    private String pasta;

    public Pasta(String pasta) {this.pasta = pasta;}

    private Storage repository = new Storage();

    @Override
    public boolean checkIngrediends() {
        if (pasta.equalsIgnoreCase("Meat pasta")) {
            if (repository.getAmountPasta() != 0) {
                if (repository.getAmountHam() != 0) {
                    if (repository.getAmountTomato() != 0) {
                        if (repository.getAmountCheese() != 0) {
                            if (repository.getAmountParsley() != 0) {
                                return true;
                            } else {
                                System.out.println("Parsley is over, buy parsley!");
                                return false;
                            }
                        } else {
                            System.out.println("Cheese is over, buy cheese!");
                            return false;
                        }
                    } else {
                        System.out.println("Tomato is over, buy tomato!");
                        return false;
                    }
                } else {
                    System.out.println("Ham is over, buy ham!");
                    return false;
                }
            } else {
                System.out.println("Pasta is over, buy pasta!");
                return false;
            }
        }
        if (pasta.equalsIgnoreCase("Fish pasta")) {
            if (repository.getAmountPasta() != 0) {
                if (repository.getAmountTuna() != 0) {
                    if (repository.getAmountGarlic() != 0) {
                        if (repository.getAmountParmesan() != 0) {
                            return true;
                        } else {
                            System.out.println("Parmesan is over, buy parmesan!");
                            return false;
                        }
                    } else {
                        System.out.println("Garlic is over, buy garlic!");
                        return false;
                    }
                } else {
                    System.out.println("Tuna is over, buy tuna!");
                    return false;
                }
            } else {
                System.out.println("Pasta is over, buy pasta!");
                return false;
            }
        }
        if (pasta.equalsIgnoreCase("Vegan pasta")) {
            if (repository.getAmountPasta() != 0) {
                if (repository.getAmountOnion() != 0) {
                    if (repository.getAmountTomato() != 0) {
                        if (repository.getAmountGarlic() != 0) {
                            if (repository.getAmountParsley() != 0) {
                                return true;
                            } else {
                                System.out.println("Parsley is over, buy parsley!");
                                return false;
                            }
                        } else {
                            System.out.println("Garlic is over, buy garlic!");
                            return false;
                        }
                    } else {
                        System.out.println("Tomato is over, buy tomato!");
                        return false;
                    }
                } else {
                    System.out.println("Onion is over, buy onion!");
                    return false;
                }
            } else {
                System.out.println("Pasta is over, buy pasta!");
                return false;
            }
        }
        return false;
    }

    @Override
    public void decrementIngredients() {
        if (pasta.equalsIgnoreCase("Meat pasta")) {
                repository.decrementAmountPasta();
                repository.decrementAmountHam();
                repository.decrementAmountTomato();
                repository.decrementAmountCheese();
                repository.decrementAmountParsley();
                Pasta pasta = new Pasta("Meat pasta");
        }
        if (pasta.equalsIgnoreCase("Fish pasta")) {
                repository.decrementAmountPasta();
                repository.decrementAmountTuna();
                repository.decrementAmountGarlic();
                repository.decrementAmountParmesan();
                Pasta pasta = new Pasta("Fish pasta");
        }
        if (pasta.equalsIgnoreCase("Vegan pasta")) {
                repository.decrementAmountPasta();
                repository.decrementAmountOnion();
                repository.decrementAmountTomato();
                repository.decrementAmountGarlic();
                repository.decrementAmountParsley();
                Pasta pasta = new Pasta("Vegan pasta");
        }
    }

    @Override
    public String toString() { return pasta ; }
}