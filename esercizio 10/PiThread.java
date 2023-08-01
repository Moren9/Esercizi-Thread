public class PiThread extends Thread{
    private double accuracy;

    public PiThread(double accuracy){
        this.accuracy = accuracy;
    }

    @Override
    public void run(){
        double pi = 0.0;
        int sign = 1;
        long n = 1;

        while(!isInterrupted() && Math.abs(Math.PI - pi) >= accuracy){
            pi += sign * 4.0 / n;
            n += 2;
            sign *= -1;

            System.out.println("pi:" + pi);
        }
        System.out.println("Calculation terminated. Value of pi:" + pi);
    }
}
