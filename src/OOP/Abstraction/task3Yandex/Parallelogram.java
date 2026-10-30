package OOP.Abstraction.task3Yandex;

public abstract class Parallelogram implements Figure {
    private final double a;
    private final double h;

    protected Parallelogram(double a, double h){
        this.a = a;
        this.h = h;
    }

    @Override
    public double getArea(){
        return a * h;
    }
}