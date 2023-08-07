import java.util.concurrent.Semaphore;

public class GoKartRace{
    private static final int MAX_PILOTS = 8;
    private static final int MAX_KART = 4;
    private static Semaphore lockerRoomSem;
    private static Semaphore kartSem;

    public GoKartRace(){
        kartSem = new Semaphore(MAX_KART);
        lockerRoomSem = new Semaphore(MAX_PILOTS);
    }
    
    public void enterLockerRoom() throws InterruptedException{
        lockerRoomSem.acquire();
    }

    public void leaveLockerRoom() throws InterruptedException{
        lockerRoomSem.release();
    }

    public void enterKart() throws InterruptedException{
        kartSem.acquire();
    }

    public void leaveKart() throws InterruptedException{
        kartSem.release();
    }
}