import static utils.Logger.log;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final UselessBox box = new UselessBox();
        BoxThread boxThread = new BoxThread(box, "Ыгрушка");

        Thread userThread = new Thread(null, box::switchOnToggle, "Пользователь");

        boxThread.start();
        userThread.start();

        userThread.join();
        log("Заджойнились, останавливаем поток-игрушку");
        boxThread.interrupt();
        log("Конец-программы");
    }
}
