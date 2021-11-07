import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static utils.Logger.log;

public class Main {

    public static void main(String[] args) {
        final Shop shop = new Shop();

        final ExecutorService shopPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        shopPool.submit(new Thread(null, shop::routine, "Магазин 1"));
        shopPool.submit(new Thread(null, shop::routine, "Магазин 2"));
        shopPool.submit(new Thread(null, shop::routine, "Магазин 3"));

        shopPool.shutdown();

        boolean isStop = false;
        while (!isStop) {
            if (shopPool.isTerminated()) {
                log("Общая выручка = " + shop.getSum());
                isStop = true;
            }
        }
    }
}
