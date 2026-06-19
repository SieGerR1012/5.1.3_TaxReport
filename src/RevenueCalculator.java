import java.util.concurrent.atomic.LongAdder;

public class RevenueCalculator extends Thread {
    private final int[] revenues;
    private final LongAdder totalRevenue;

    public RevenueCalculator(
            String name,
            int[] revenues,
            LongAdder totalRevenue) {

        super(name);
        this.revenues = revenues;
        this.totalRevenue = totalRevenue;
    }

    @Override
    public void run() {

        long localSum = 0;

        for (int revenue : revenues) {
            localSum += revenue;
        }

        System.out.printf("%s посчитал выручку: %d%n", getName(), localSum);
        totalRevenue.add(localSum);
    }
}
