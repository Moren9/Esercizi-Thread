public class CokeMachine {
    private static final int N = 50;
    private int count;

    public CokeMachine(){
        this.count = N;
    }

    public synchronized void remove(){
        while(count == 0){
            try{
                System.out.println("The Machine is empty, User is waiting...");
                wait();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        count --;
        System.out.println("User picked up a can. Remaning cans: " + count);
        notifyAll();
    }

    public synchronized void deposit(){
        while(count > 0){
            try{
                System.out.println( "The Machine is not empty, Provider is waiting...");
                wait();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        count = N;
        System.out.println("Provider refueled the machine. Remaning cans:");
        notifyAll();
    }


}


