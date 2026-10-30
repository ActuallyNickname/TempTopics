package OOP.Inheritance.task2Yandex;

public class SoupBase {
    protected double water;
    protected double salt;

    public SoupBase(double water, double salt) {
        this.water = water;
        this.salt = salt;
    }

    public void printIngredients() {
        System.out.println("Ингредиенты суповой основы:");
        System.out.println("Вода: " + water + " л.");
        System.out.println("Соль: " + salt + " г.");
    }

}
