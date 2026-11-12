public class Fil extends Thread {
    private int repeticions;
    private int delay;       
    private int feina;        

    public Fil(String nom, int repeticions, int delay, int feina) {
        super(nom);
        this.repeticions = repeticions;
        this.delay = delay;
        this.feina = feina;
    }

    @Override
    public void run() {
        for (int i = 1; i <= repeticions; i++) {
            System.out.println(getName() + " " + i);
            if (delay > 0) {
                try { Thread.sleep(delay); } catch (InterruptedException e) { return; }
            } else {
                long x = 0;
                for (int j = 0; j < feina; j++) x += j;   
            }
        }
        System.out.println("Acaba el fil " + getName());
    }
}