package OOP.Inheritance.task2Yandex;

public class PotatoSoup extends Bouillon {
    protected double potato;
    protected double carrot;


    public PotatoSoup(Bouillon bouillon,
                      double potato, double carrot) {
        super(bouillon.water, bouillon.salt, bouillon.meat);
        this.carrot = carrot;
        this.potato = potato;
    }

    public PotatoSoup(SoupBase soupBase, double meat,
                      double potato, double carrot) {
        super(soupBase.water, soupBase.salt, meat);
        this.carrot = carrot;
        this.potato = potato;
    }

    public PotatoSoup(double water, double salt,
                      double meat, double potato, double carrot) {
        super(water, salt, meat);
        this.carrot = carrot;
        this.potato = potato;
    }

    @Override
    public void printIngredients() {
        System.out.println("Ингредиенты картофельного супа:");
        System.out.println("Вода: " + water + " л.");
        System.out.println("Соль: " + salt + " г.");
        System.out.println("Мясо: " + meat + " г.");
        System.out.println("Картошка: " + potato + " шт.");
        System.out.println("Морковка: " + carrot + " шт.");
    }
}