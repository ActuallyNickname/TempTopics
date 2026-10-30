package OOP.Polymorphism.Generics.task1Yandex.part1of2;


import java.util.*;

public class Practicum {
    public static void main(String[] args) {
        //создаём двухуровневую хеш-таблицу для хранения расписания уроков
        AdvancedHashMap<String, Integer, String> timetable = new AdvancedHashMap<>();
        //добавляем уроки, с указанием дня недели и номера урока
        timetable.put("Понедельник", 1, "Русский язык");
        timetable.put("Понедельник", 2, "Математика");
        timetable.put("Вторник", 1, "Физкультура");
        timetable.put("Вторник", 2, "Русский язык");

        //выводим первый урок во вторник
        System.out.println(timetable.get("Вторник", 1));

        //получаем и выводим все уроки в понедельник
        ArrayList<String> mondayLessons = timetable.getAll("Понедельник");
        System.out.println(mondayLessons);
    }

}

class AdvancedHashMap <K,N,V> {
    //данные будем хранить в хеш-таблице из хеш-таблиц
    private Map<K,Map<N,V>> internalHashMap = new HashMap<>();

    public void put(K day, N lessonNumber, V lessonName) {
        //получаем хеш-таблицу по первому ключу
         Map<N,V> innerHashMap = internalHashMap.get(day);
        if (innerHashMap == null) {
            //вложенной хеш-таблицы по первому ключу пока нет — создаём её и добавляем в internalHashMap
            innerHashMap = new HashMap<>();
        }
        innerHashMap.put(lessonNumber,lessonName);
        //добавляем элемент во вложенную хеш-таблицу
        internalHashMap.put(day,innerHashMap);
    }

    public V get(K day, N lessonNumber) {
        //получаем хеш-таблицу по первому ключу
        Map<N,V> innerHashMap = internalHashMap.get(day);
        if (innerHashMap == null) {
            return null;
        }
        //получаем элемент из вложенной хеш-таблицы
        return innerHashMap.get(lessonNumber);
    }

    public ArrayList<V> getAll(K day) {
        Map<N,V> innerHashMap = internalHashMap.get(day);
        if (innerHashMap == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(innerHashMap.values());
    }
}