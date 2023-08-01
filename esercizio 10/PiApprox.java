import java.util.Scanner;

public class PiApprox{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the accuracy parameter: ");
        double accuracy = scanner.nextDouble();

        System.out.println("Insert the max time for the wait in milliseconds: ");
        long timeout = scanner.nextLong();

        scanner.close();

        Thread piThread = new PiThread(accuracy);
        piThread.start();

        try{
            piThread.join();
            if(piThread.isAlive()){
                piThread.interrupt();
                System.out.println("The calculation was interrupted after: " + timeout + " milliseconds.");
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}