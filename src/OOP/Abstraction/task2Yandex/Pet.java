package OOP.Abstraction.task2Yandex;

public abstract class Pet implements Animal{
    protected int pawsCount;

    protected Pet (int paws){
        this.pawsCount = paws;
    }

    @Override
    public final void sleep() {
        System.out.println("Сплю");
    }

    @Override
    public abstract void giveVoice();

    public void play(){
        System.out.println("Играю");
    }


    public int getPawsCount() {
        return pawsCount;
    }


}