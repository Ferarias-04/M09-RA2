public class PrincipalEstricte {
    public static void main(String[] args) throws InterruptedException {
        Fil juan = new Fil("Juan", 9, 10, 0);
        Fil pepe = new Fil("Pepe", 9, 10, 0);

        System.out.println("Termina thread main");

        juan.start();
        Thread.sleep(5);  
        pepe.start();
    }
}