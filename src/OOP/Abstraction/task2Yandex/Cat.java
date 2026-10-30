package OOP.Abstraction.task2Yandex;

public class Cat extends Pet{
    public Cat(){
        super(4);
    }

    @Override
    public void giveVoice() {
        System.out.println("Мяу!");
    }

    @Override
    public void play() {
        super.play();
    }

    @Override
    public int getPawsCount() {
        return super.getPawsCount();
    }

    public void catchMouse(){
        System.out.println("Поймала мышку!");
    }
}
