import java.util.concurrent.Semaphore;

public class Telescope {
    private Semaphore semaphore = new Semaphore(1);

    public void observe(String partecipantName){
        try{
            System.out.println(partecipantName + " is waiting for using the telescope");
            semaphore.acquire();

            System.out.println(partecipantName + " is watching the comet.");
            Thread.sleep(3000);

            System.out.println(partecipantName + " finished watching.");
            semaphore.release();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
