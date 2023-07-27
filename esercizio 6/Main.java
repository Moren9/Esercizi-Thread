import java.util.Random;

public class Main {
    public static void main(String[] args){
        Counter counter = new Counter();
        int numThreads = 5;

        for(int i = 0; i < numThreads; i++){
            Thread taskI = new Thread(() -> {
                Random rand = new Random();
                
                while(true){
                    try{
                        Thread.sleep(rand.nextInt(1000));
                    } catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    counter.increment();
                    System.out.println("Incrementato: " + counter.getCount());
                }
            });
            taskI.start();
        }

        for(int i = 0; i < numThreads; i++){
            Thread taskD = new Thread(() -> {
                Random rand = new Random();

                while(true){
                    try{
                        Thread.sleep(rand.nextInt(1000));
                    } catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    counter.decrement();
                    System.out.println("Decrementato: " + counter.getCount());
                }
            });
            taskD.start();
        }
    }
}
