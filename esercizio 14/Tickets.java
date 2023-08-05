import java.util.concurrent.Semaphore;

public class Tickets{
    private int avaibleTickets = 100;
    private Semaphore ticketSemaphore = new Semaphore(5);

    public void buyTickets(int numTickets){
        try{
            ticketSemaphore.acquire();

            if(avaibleTickets >= numTickets){
                System.out.println(Thread.currentThread().getName() + " bought " + numTickets + " tickets.");
                avaibleTickets -= numTickets;
            } else{
                System.out.println(Thread.currentThread().getName() + " tried to buy " + numTickets + " tickets but only " + avaibleTickets + " tickets are avaible.");
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        } finally {
            ticketSemaphore.release();
        }
    }
}