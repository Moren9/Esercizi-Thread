public class SumThread extends Thread {
    private HoldInteger result;
    private int num1, num2;

    public SumThread(HoldInteger result, int num1, int num2){
        this.result = result;
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run(){
        int sum = num1 + num2;
        result.set(sum);
    }
}