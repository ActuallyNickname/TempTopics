package OOP.Abstraction.task2Yandex;

public class Hamster extends Pet{
    public Hamster(){
        super(4);
    }

    @Override
    public void giveVoice() {
        System.out.println("Хрум!");
    }

    @Override
    public void play() {
        super.play();
    }

    @Override
    public int getPawsCount() {
        return super.getPawsCount();
    }

    public void hideFood(){
        System.out.println("Вся еда — в щёчках!");
    }
}
