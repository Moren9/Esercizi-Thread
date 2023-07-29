public class User extends Thread{
    private CokeMachine cokeMachine;

    public User(CokeMachine cokeMachine){
        this.cokeMachine = cokeMachine;
    }

    @Override
    public void run(){
        while(true){
            cokeMachine.remove();
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }     
    }
}
