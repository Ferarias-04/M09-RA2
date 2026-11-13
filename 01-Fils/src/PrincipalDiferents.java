public class PrincipalDiferents {
    public static void main(String[] args) {
        Fil juan = new Fil("Juan", 9, 0, 1000);
        Fil pepe = new Fil("Pepe", 9, 0, 1000);

        pepe.setPriority(Thread.MIN_PRIORITY);
        juan.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Acaba thread main");

        pepe.start();
        juan.start();
    }
}