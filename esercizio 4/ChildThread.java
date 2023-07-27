public class ChildThread implements Runnable{
    private int num;
    private int duration;

    public ChildThread(int num, int duration){
        this.num = num;
        this.duration = duration;
    }

    @Override
    public void run() {
        for(int i = 0; i < num; i++){
            System.out.println("Esecuzione " + i + " dell'attività A. Durata: " + duration);
        }
        try{
            Thread.sleep(duration);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread figlio ha completato l'esecuzione");
    }
}
