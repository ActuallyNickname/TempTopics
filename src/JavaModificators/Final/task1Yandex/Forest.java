package JavaModificators.Final.task1Yandex;

import java.util.ArrayList;

public class Forest {
    private static String season;

    private ArrayList<MountainHare> hares;

    public Forest(ArrayList<MountainHare> hares, String season) {
        this.hares = hares;
        setSeason(season);
    }

    public void setSeason(String newSeason){
        MountainHare.getAddepted(newSeason);
    }

    public void printHares(){
        for (MountainHare hare : hares) {
            System.out.println(hare);
        }
    }
}
