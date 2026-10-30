package OOP.Abstraction.task1Yandex;


abstract class PaymentProcessor {
    public final void processPayment() {
        System.out.println("Начинаю обрабатывать транзакцию.");
        // Добавьте вызовы соответствующих методов
        verifyDetails();
        makePayment();
        sendNotification();
    }

    protected abstract void makePayment();

    private void verifyDetails() {
        System.out.println("Данные проверены.");
    }

    private void sendNotification() {
        System.out.println("Уведомление отправлено.");
    }
}

class MirCardPayment extends PaymentProcessor {
    @Override
    protected void makePayment() {
        System.out.println("Оплата через карту Мир.");
    }
}

class SbpPayment extends PaymentProcessor {
    @Override
    protected void makePayment() {
        System.out.println("Оплата через СПБ.");
    }
}

public class Practicum {
    public static void main(String[] args) {
        MirCardPayment mir = new MirCardPayment();
        SbpPayment sbp = new SbpPayment();

        sbp.processPayment();
        mir.processPayment();

    }
}



