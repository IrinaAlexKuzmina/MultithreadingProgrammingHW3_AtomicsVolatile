import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

import static utils.Logger.log;

public class Shop {

    private LongAdder sum = new LongAdder();

    public Long getSum() {
        return sum.sum();
    }

    public void routine() {
        IntStream.range(1, 10).forEach(i -> {
            log("Покупка на " + i + " рублей!");
            sum.add(i);
        });
    }
}
