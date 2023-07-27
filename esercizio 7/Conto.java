public class Conto{
    private double saldo = 10000;

    public synchronized void prelievo(double importo){
        while(saldo < importo){
            try{
                wait();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        saldo -= importo;
    }

    public synchronized void deposito(double importo){
        saldo += importo;
        notifyAll();
    }

    public double getSaldo(){
        return saldo;
    }
}