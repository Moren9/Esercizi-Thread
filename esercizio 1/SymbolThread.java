public class SymbolThread extends Thread{

    private String symbol;

    public SymbolThread(String symbol){
        this.symbol = symbol;
    }

    @Override
    public void run(){
        int counter = 0;

        while(true){
            System.out.print(symbol);
            counter++;

            if(counter % 50 == 0){
                System.out.println();
            }
            try{
                Thread.sleep(100); 
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        SymbolThread thread1 = new SymbolThread("*");
        SymbolThread thread2 = new SymbolThread("#");

        thread1.start();
        thread2.start();
    }
}
