import java.util.concurrent.Semaphore;

public class Tourist implements Runnable{
    private int touristID;
    private Semaphore semaphore;

    public Tourist(int touristsID, Semaphore semaphore){
        this.touristID = touristsID; 
        this.semaphore = semaphore;
    }

    @Override
    public void run(){
        try{
            System.out.println("The tourist " + touristID + " is waiting to enter the Louvre.");
            Thread.sleep((int) (Math.random() * 5000));   //cast

            System.out.println("The tourist " + touristID + " wants to enter the Louvre.");
            semaphore.acquire();

            System.out.println("The tourist " + touristID + " entered the Louvre.");
            Thread.sleep((int) (Math.random() * 5000));

            System.out.println("The tourist " + touristID + " has finished.");
            semaphore.release();

        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
