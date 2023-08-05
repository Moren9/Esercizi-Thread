public class Buyer extends Thread{
    private Tickets ticket;
    private int numTicketsToBuy;

    public Buyer(Tickets ticket, int numTicketsToBuy){
        this.ticket = ticket;
        this.numTicketsToBuy = numTicketsToBuy;
    }

    @Override
    public void run(){
        try{
            Thread.sleep((int) (Math.random() * 5000));
            ticket.buyTickets(numTicketsToBuy);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
