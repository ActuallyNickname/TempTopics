package JavaModificators.Final.task1Yandex;

import java.util.ArrayList;

public class Practicum {

    public static void main(String[] args) {
        ArrayList<MountainHare> hares = new ArrayList<>() {{
                add(new MountainHare(4, 4.4, 120));
                add(new MountainHare(7, 3.6, 150));
                add(new MountainHare(1, 2.3, 100));
        }};

        System.out.println("В лесу лето!");
        // создайте объект "летний лес с зайцами"
        Forest forest = new Forest(hares, "Лето");

        System.out.println("Список зайцев:");
        // напечатайте список всех зайцев
        forest.printHares();

        System.out.println("В лесу зима!");
        // поменяйте время года на зиму
        forest.setSeason("зИма");

        System.out.println("Список зайцев:");
        // напечатайте список всех зайцев
        forest.printHares();
    }

}