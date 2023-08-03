import java.util.concurrent.Semaphore;

public class Louvre{
    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(5);

        for(int i = 0; i <= 50; i++){
            Thread tourist = new Thread(new Tourist(i, semaphore));
            tourist.start();
        }
    }
}