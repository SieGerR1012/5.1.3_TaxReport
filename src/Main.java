private static final int ARRAY_SIZE = 10;
private static final int MAX_REVENUE = 1000;

void main() throws InterruptedException {
    Random random = new Random();

    int[] shop1 = generateRevenueArray(random);
    int[] shop2 = generateRevenueArray(random);
    int[] shop3 = generateRevenueArray(random);

    LongAdder totalRevenue = new LongAdder();
}
