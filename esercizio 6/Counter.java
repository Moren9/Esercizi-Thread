public class Counter{
    private int counter = 0;

    public synchronized void increment(){
        if(counter < 10){
            counter++;
        }
    }

    public synchronized void decrement(){
        if(counter > 0){
            counter--;
        }
    }

    public synchronized int getCount(){
        return counter;
    }
}