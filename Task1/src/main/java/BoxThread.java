import static utils.Logger.log;

public class BoxThread extends Thread {
    private final UselessBox uselessBox;

    public BoxThread(UselessBox uselessBox, String threadName) {
        this.uselessBox = uselessBox;
        this.setName(threadName);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                uselessBox.switchOffToggle();
            }
        } finally {
            log("Поток завершен");
        }
    }
}
