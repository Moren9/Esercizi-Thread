public class Provider extends Thread{
    private CokeMachine cokeMachine;

    public Provider(CokeMachine cokeMachine){
        this.cokeMachine = cokeMachine;
    }

    @Override
    public void run(){
        while(true){
            cokeMachine.deposit();
            try{
                Thread.sleep(2000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
