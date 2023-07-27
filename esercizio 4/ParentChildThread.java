public class ParentChildThread{
    public static void main(String[] args){
        System.out.println("thread principale avviato");

        ChildThread childThread = new ChildThread(5, 1000);
        Thread child = new Thread(childThread);

        child.start();

        while(child.isAlive()){
            try{
                System.out.println("Controllo del thread figlio. Il thread figlio è ancora vivo");
                Thread.sleep(500);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }
        System.out.println("il thread figlio ha terminato. thread principale terminato");
    }
    
}