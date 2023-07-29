public class Main{
    public static void main(String[] args){
        CokeMachine cokeMachine = new CokeMachine();

        for(int i = 0; i < 5; i++){
            Thread userThread = new User(cokeMachine);
            userThread.start();
        }

        Thread providerThread = new Provider(cokeMachine);
        providerThread.start();
    }
    } 