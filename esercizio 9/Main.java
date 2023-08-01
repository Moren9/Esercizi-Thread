public class Main{
    public static void main(String[] args){
        SleepThread thread = new SleepThread();
        thread.start();

        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        thread.interrupt();
    }
}