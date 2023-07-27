public class HoldInteger{
    private int value;

    public synchronized void set(int value){
        this.value = value;
    } 

    public synchronized int get(){
        return value;
    }
}