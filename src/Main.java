import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 5; i++) {
            Callable<Integer> myCallable = new MyThread(i);
            // Отправляем задачу на выполнение в пул потоков
            final Future<Integer> task = threadPool.submit(myCallable);
            // Получаем результат
            final Integer resultOfTask = task.get();
            System.out.println("Кол-во сообщений:" + (resultOfTask + 1));
        }
        // Завершаем работу пула потоков
        threadPool.shutdown();
    }
}
