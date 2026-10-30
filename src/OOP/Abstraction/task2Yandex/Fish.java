package OOP.Abstraction.task2Yandex;

public class Fish extends Pet{
    protected Fish() {
        super(0);
    }

    @Override
    public void giveVoice() {
        System.out.println("...");
    }

    @Override
    public int getPawsCount() {
        return super.getPawsCount();
    }

    @Override
    public void play() {
        super.play();
    }


}
