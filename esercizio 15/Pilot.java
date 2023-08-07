public class Pilot extends Thread{
    private static final int NUM_LAPS = 15;
    private static int nextRacerID = 1;
    private int racerID;
    private GoKartRace kartTrack;

    public Pilot(GoKartRace kartTrack){
        this.kartTrack = kartTrack;
        this.racerID = nextRacerID++;
    }

    @Override
    public void run(){
        try{
            kartTrack.enterLockerRoom();
            System.out.println("KartRacer " + racerID + " is wearing the suit.");
            Thread.sleep((int) (Math.random() * 1000));
            kartTrack.leaveLockerRoom();

            kartTrack.enterKart();
            System.out.println("KartRacer " + racerID + " is racing.");
            for (int lap = 2; lap <= NUM_LAPS; lap++){
                System.out.println("KartRacer " + racerID + " lap " + lap);
                Thread.sleep((int) (Math.random() * 500));
            }
            kartTrack.leaveKart();

            kartTrack.enterLockerRoom();
            System.out.println("KartRacer " + racerID + " is taking off the suit.");
            Thread.sleep((int) (Math.random() * 1000));
            kartTrack.leaveLockerRoom();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        GoKartRace kartTrack = new GoKartRace();
        for (int i = 1; i <= 8; i++){
            Thread racer = new Thread(new Pilot(kartTrack));
            racer.start();
        }
    }
}
