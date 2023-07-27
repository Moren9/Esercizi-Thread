public class Runner implements Runnable{

    String name;

    public Runner(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " nome: " + name);
    }
}
