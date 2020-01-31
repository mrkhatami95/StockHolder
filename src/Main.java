import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main extends Thread {

    public static void main(String[] args) {

        final int amount = 10_000;
        int z = 0;
        int[] stockPrice = new int[]{100,120,150,200,220,250,300,320,350,400};
        String[] stockTitle = new String[]{"gas","petrol","oil","steel","metal","bronze","silver",
                "gold","goldImam","diamond"};
        String[] stockHolderNames = new String[]{"jack","bill","anton","kurt","rudy","sonia","connor"
                ,"william","olivier","eric"};

        List<StockHolder> stockHolderList = new ArrayList<>();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Stock stock = new Stock(i, stockTitle[i], stockPrice[i], i+1);
                StockHolder legalStockHolder = new StockHolder(i, stockHolderNames[i], stockPrice[i] + amount, stock);
                stockHolderList.add(legalStockHolder);
            }
        });

        thread.start();

        Thread thread2 = new Thread(() -> {
            calculateStockHolderBudget(stockHolderList);
        });

        thread2.start();

        try{
            thread.join(1000);
            thread2.join(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void calculateStockHolderBudget(List<StockHolder> stockHolderList) {

        for (StockHolder stockHolder : stockHolderList) {
            List<StockHolder> legalStockHolders = Stream.of(stockHolder)
                    .filter(x -> (x.getStock().getCount() * x.getStock().getPrice()) < x.getBudget())
                    .collect(Collectors.toList());
            System.out.println(legalStockHolders);
        }
    }
}
