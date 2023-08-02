public class Observatory{
    public static void main(String[] args){
        Telescope telescope = new Telescope();
        
        for(int i = 0; i <= 10; i++){
            Thread partecipant = new Thread(new Participant("Person " + i, telescope));
            partecipant.start();
        }
    }
}