public class Participant implements Runnable{
    private String name;
    private Telescope telescope;

    public Participant(String name, Telescope telescope){
        this.name = name;
        this.telescope = telescope;
    }

    @Override
    public void run(){
        telescope.observe(name);
    }
}    

