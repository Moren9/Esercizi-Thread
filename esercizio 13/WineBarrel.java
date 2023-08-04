import java.util.concurrent.Semaphore;

public class WineBarrel{
    private int wineLiters = 100;
    private Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args){
        WineBarrel wineBarrel = new WineBarrel();

        for(int i = 0; i <= 20; i++){
            Thread drinker = new Thread(new Drinker(i, wineBarrel));
            drinker.start();
        }
    }

    public synchronized int getWineLiters(){
        return wineLiters;
    }

    public synchronized void drink(int liters){
        wineLiters -= liters;
    }

    public Semaphore getSemaphore(){
        return semaphore;
    }
}