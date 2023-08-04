import java.util.concurrent.Semaphore;

public class Drinker implements Runnable{
    private int drinkerID;
    private WineBarrel wineBarrel;

    public Drinker(int drinkerID, WineBarrel wineBarrel){
        this.drinkerID = drinkerID;
        this.wineBarrel = wineBarrel;
    }
    
    @Override
    public void run(){
        try{
            while(true){
            System.out.println("Drinker " + drinkerID + " is waiting to drink.");
            Thread.sleep((int) (Math.random() * 5000));

            System.out.println("Drinker " + drinkerID + " wants to drink.");
            Semaphore taps = wineBarrel.getSemaphore();
            taps.acquire();

            int litersToDrink = 1;
            int remainingWine = wineBarrel.getWineLiters();
            if(remainingWine >= litersToDrink){
                wineBarrel.drink(litersToDrink);
                System.out.println("Drinker " + drinkerID + " is drinking. Liters remaining: " + wineBarrel.getWineLiters());
            } else{
                System.out.println("There is no more wine");
                break;
            }
            taps.release();
        }
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
