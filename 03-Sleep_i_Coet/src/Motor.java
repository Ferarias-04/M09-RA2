import java.util.*;
public class Motor extends Thread {
    private final int id;
    private volatile int potenciaObjectiu = 0;
    private int potenciaActual = 0;
    private final Random random = new Random();

    public Motor(int id) {
        this.id = id;
    }
    public void setPotencia(int p) {
        this.potenciaObjectiu = p;
    }

    @Override 
    public void run() {
        try {
            while (true) { 
                int objectiu = potenciaObjectiu;
                if(potenciaActual == objectiu) {
                    if(objectiu == 0) break;
                    Thread.sleep(50);
                    continue;
                }
                Thread.sleep(1000 + random.nextInt(1001));

                objectiu = potenciaObjectiu;
                if(potenciaActual == objectiu) continue;

                String accio = potenciaActual < objectiu ? "Incre." : "Decre.";
                potenciaActual += potenciaActual < objectiu ? 1 : -1;
                if(potenciaActual == objectiu) accio = "FerRes";

                System.out.printf("Motor %d: %s Objectiu: %d Actual: %d%n",
                        id, accio, objectiu, potenciaActual);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
