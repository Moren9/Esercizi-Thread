public class Concert {
    public static void main(String[] args){
        Tickets ticket = new Tickets();

        for(int i = 0; i <= 200; i++){
            int numTicketsToBuy = 1;
            Buyer buyer = new Buyer(ticket, numTicketsToBuy);
            buyer.setName("Buyer " + i);
            buyer.start();
        }

    }
}
