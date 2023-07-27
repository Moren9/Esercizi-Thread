public class MainThread extends Thread{
    public static void main(String[] args){
        System.out.println("Thread principale: " + Thread.currentThread().getName());

        Runner runner1 = new Runner("Pippo");
        Runner runner2 = new Runner("Caio");

        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);

        thread1.start();
        thread2.start();
    }
}