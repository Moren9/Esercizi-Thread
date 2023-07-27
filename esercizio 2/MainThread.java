import java.util.Scanner;

public class MainThread{
    public static void main(String[] args){
        HoldInteger result = new HoldInteger();
        int num1, num2;

        Scanner scanner = new Scanner(System.in);
        System.out.print("inserire il primo numero: ");
        num1 = scanner.nextInt();
        System.out.print("inserire il secondo numero: ");
        num2 = scanner.nextInt();

        SumThread sumThread = new SumThread(result, num1, num2);
        sumThread.start();

        try{
            sumThread.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        int sumResult = result.get();
        System.out.println("La somma dei numeri " + num1 + " e " + num2 + " è: " + sumResult);
    }
}