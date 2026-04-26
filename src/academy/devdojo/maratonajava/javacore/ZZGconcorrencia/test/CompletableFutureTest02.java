package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureTest02 {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();
        searchPricesAsysncCompletableFuture(storeService);
    }

    private static void searchPricesAsysncCompletableFuture(StoreService storeService) {
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

        /*
           Se tentar mapear os objetos para CompletableFuture e chamar o ".join()" na mesma pipeline de Stream, o código voltará a ser síncrono.
           Para garantir que todas as tarefas sejam disparadas simultaneamente, deve quebrar o processo em dois passos distintos:
        * */

        //Primeira Pipeline: Mapeia a lista original para uma lista de CompletableFuture (Isto dispara todas as threads de uma só vez).
        List<CompletableFuture<Double>> completableFutures = stores.stream()
                .map(storeService::getPricesAsycnCompletableFuture)
                .collect(Collectors.toList());

        //Segunda Pipeline: Percorre a lista de Futures já criados e chama o .join() para recolher os resultados.
        List<Double> prices = completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());

        /*
            Desta forma, enquanto a segunda pipeline espera pelo resultado do primeiro Future,
            todos os outros já estão a ser processados em paralelo nas outras threads.
        * */

        System.out.println(prices);
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPriceSync %dms%n", (end - start));
    }
}
