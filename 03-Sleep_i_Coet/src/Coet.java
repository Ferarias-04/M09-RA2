import java.util.*;
public class Coet {
    private static final int NUM_MOTORS = 4;
    private final Motor[] motors = new Motor[NUM_MOTORS];

    public Coet() {
        for (int i = 0; i < NUM_MOTORS; i++) {
            motors[i] = new Motor(i);
        }
    }
    
    public boolean passaAPotencia(int p) {
        if(p < 0 || p > 10) {
            System.err.println("Error: la potència ha d'estar entre 0 i 10 (" + p + ")");
            return false;
        }
        System.out.println("Passant a potència " + p);
        for (Motor m : motors) {
            m.setPotencia(p);
        }
        return true;
    }
    public void arranca() {
        for(Motor m : motors) {
            m.start();
        }
    }
    public static void main(String[] args) {
        Coet coet = new Coet();
        Scanner sc = new Scanner(System.in);
        boolean arrancat = false;
        int p = -1;

        while(p != 0 && sc.hasNextLine()) {
            String linia = sc.nextLine().trim();
            try {
                p = Integer.parseInt(linia);
            } catch (NumberFormatException e) {
                System.err.println("Error: valor numèric (" + linia + ")");
                p = -1;
                continue;
            }
            if(!coet.passaAPotencia(p)) {
                p = -1;
                continue;
            }
            if(!arrancat) {
                coet.arranca();
                arrancat = true;
            }
        }
    }
}
