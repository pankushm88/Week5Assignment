/**
 * 
 */
package src;

/**
 * @author Pankush
 *
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TicTocThread {
    static class Tic implements Runnable{

        @Override
        public void run() {
            System.out.println("Tic");
        }
    }

    static class Toc implements Runnable{

        @Override
        public void run() {
            System.out.println("Toc");
        }
    }

    public static void main(String[] args) {
        //ExecutorService executorservice = Executors.newSingleThreadExecutor();
        ExecutorService executorservice = Executors.newFixedThreadPool(1);
        for(int i = 0;i<10;i++){
            executorservice.execute(new Tic());
            executorservice.execute(new Toc());
        }
        executorservice.shutdown();
    }
}