package OOP.Abstraction.task2Yandex;

public class Dog extends Pet{

    protected Dog() {
        super(4);
    }



    @Override
    public void play() {
        super.play();
    }

    @Override
    public int getPawsCount() {
        return super.getPawsCount();
    }

    @Override
    public void giveVoice() {
        System.out.println("Гав!");
    }

    public void bringStick(){
        System.out.println("Принёс палочку, как хороший мальчик!");
    }
}
