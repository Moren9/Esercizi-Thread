import java.util.Random;

public class Main {
    public static void main(String[] args){
        Conto conto = new Conto();
        
        Thread threadPadre = new Thread(() -> {
            int numThreadFigli = 5;

            for(int i = 0; i < numThreadFigli; i++){
                Thread threadFiglio = new Thread(() -> {
                    while (true) {
                        int importo = new Random().nextInt(1000);
                        conto.prelievo(importo);
                        System.out.println("figlio ha prelevato: " + importo);
                        try{
                            Thread.sleep(1000);
                        } catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                });
                threadFiglio.start();
            }
            while (true) {
                int importo = new Random().nextInt(1000);
                conto.deposito(importo);
                System.out.println("Thread padre ha depositato: " + importo);
                 try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        threadPadre.start();
    }
}
