private static final int ARRAY_SIZE = 10;
private static final int MAX_REVENUE = 1000;

void main() throws InterruptedException {
    Random random = new Random();

    int[] shop1 = generateRevenueArray(random);
    int[] shop2 = generateRevenueArray(random);
    int[] shop3 = generateRevenueArray(random);

    LongAdder totalRevenue = new LongAdder();

    Thread store1 = new RevenueCalculator("Магазин №1", shop1, totalRevenue);
    Thread store2 = new RevenueCalculator("Магазин №2", shop2, totalRevenue);
    Thread store3 = new RevenueCalculator("Магазин №3", shop3, totalRevenue);

    System.out.println("Начинаем подсчет выручки...\n");

    store1.start();
    store2.start();
    store3.start();

    store1.join();
    store2.join();
    store3.join();

    System.out.println("\nОбщий отчет для налоговой: " + totalRevenue.sum());
}

private static int[] generateRevenueArray(Random random) {

    int[] array = new int[ARRAY_SIZE];

    for (int i = 0; i < array.length; i++) {
        array[i] = random.nextInt(MAX_REVENUE) + 1;
    }

    return array;
}
