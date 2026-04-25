package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureTest01 {
    public static void main(String[] args) {

        //CompletableFuture(): Permite executar tarefas assíncronas e encadear ações sem travar a thread.

        StoreService storeService = new StoreService();
//        searchPricesSync(storeService);
        searchPricesAsysncCompletableFuture(storeService);
    }

    private static void searchPricesSync(StoreService storeService){
        long start = System.currentTimeMillis();
        System.out.println(storeService.getPriceSync("Store 1"));
        System.out.println(storeService.getPriceSync("Store 2"));
        System.out.println(storeService.getPriceSync("Store 3"));
        System.out.println(storeService.getPriceSync("Store 4"));
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPriceSync %dms%n", (end-start));
    }

    private static void searchPricesAsysncFuture(StoreService storeService){
        long start = System.currentTimeMillis();
        Future<Double> priceAsyncFuture1 = storeService.getPricesAsycnFuture(("Store 1"));
        Future<Double> priceAsyncFuture2 = storeService.getPricesAsycnFuture(("Store 2"));
        Future<Double> priceAsyncFuture3 = storeService.getPricesAsycnFuture(("Store 3"));
        Future<Double> priceAsyncFuture4 = storeService.getPricesAsycnFuture(("Store 4"));
        try {
            System.out.println(priceAsyncFuture1.get()); //get(): Obriga a tratar exceções do tipo checked (InterruptedException e ExecutionException), o que pode sujar o código com blocos try-catch.
            System.out.println(priceAsyncFuture2.get());
            System.out.println(priceAsyncFuture3.get());
            System.out.println(priceAsyncFuture4.get());
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPriceSync %dms%n", (end-start));
        StoreService.shutdown();
    }

    private static void searchPricesAsysncCompletableFuture(StoreService storeService){
        long start = System.currentTimeMillis();
        CompletableFuture<Double> priceAsyncFuture1 = storeService.getPricesAsycnCompletableFuture(("Store 1"));
        CompletableFuture<Double> priceAsyncFuture2 = storeService.getPricesAsycnCompletableFuture(("Store 2"));
        CompletableFuture<Double> priceAsyncFuture3 = storeService.getPricesAsycnCompletableFuture(("Store 3"));
        CompletableFuture<Double> priceAsyncFuture4 = storeService.getPricesAsycnCompletableFuture(("Store 4"));

//        try {
//            System.out.println(priceAsyncFuture1.get());
//            System.out.println(priceAsyncFuture2.get());
//            System.out.println(priceAsyncFuture3.get());
//            System.out.println(priceAsyncFuture4.get());
//        }catch (InterruptedException | ExecutionException e){
//            e.printStackTrace();
//        }

        System.out.println(priceAsyncFuture1.join()); //join(): Igual ao get(), mas lança apenas exceções Uncheked e não precisa tratar exceções.
        System.out.println(priceAsyncFuture2.join());
        System.out.println(priceAsyncFuture3.join());
        System.out.println(priceAsyncFuture4.join());
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPriceSync %dms%n", (end-start));
    }
}
