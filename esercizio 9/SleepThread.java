public class SleepThread extends Thread{
    
    @Override
    public void run(){
        long start = System.currentTimeMillis();
        
        try{
            Thread.sleep(10000);
        } catch(InterruptedException e){
            e.printStackTrace();
            long end = System.currentTimeMillis();
            long time = end - start;
            System.out.println("Il thread è stato interrotto dopo: " + time/1000 + " secondi.");
        }
    }
}
