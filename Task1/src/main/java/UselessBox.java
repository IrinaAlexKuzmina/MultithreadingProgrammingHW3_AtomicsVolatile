import static java.lang.Thread.sleep;
import static utils.Constants.SWITCH_ON_TIME;
import static utils.Constants.USER_ITERATIONS;
import static utils.Logger.log;

public class UselessBox {

    volatile boolean toggle;

    public void switchOffToggle() {
        if (toggle) {
            toggle = false;
            log("Опа-опа!!! Выключаем тумблер!!");
        }
    }

    public void switchOnToggle() {
        try {
            for (int i = 0; i < USER_ITERATIONS; i++) {
                if (!toggle) {
                    toggle = true;
                    log("Включаю тумблер...");
                }
                sleep(SWITCH_ON_TIME);
            }
        } catch (InterruptedException err) { // выходим, если получили сигнал прерывания
            log("я спал");
        }
    }

}
