package JavaModificators.Final.task1Yandex;

public class MountainHare {
    private static String color = "белый";

    private int age;
    private double weight;
    private double jumpLength;

    // добавьте переменные и конструктор


    public MountainHare(int age, double weight, double jumpLength) {
        this.age = age;
        this.jumpLength = jumpLength;
        this.weight = weight;
    }

    public static void getAddepted(String newSeason){
        newSeason = newSeason.toLowerCase();
        switch (newSeason){
            case "лето" -> color = "серо-рыжий";
            case "зима" -> color = "белый";
        }
    }

    @Override
    public String toString() {
        return "Заяц-беляк: " +
                "age=" + age +
                ", weight=" + weight +
                ", jumpLength=" + jumpLength +
                ", color=" + color +
                '.';
    }
}