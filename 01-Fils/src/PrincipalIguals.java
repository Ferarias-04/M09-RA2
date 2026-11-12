public class PrincipalIguals {
    public static void main(String[] args) {
        Fil juan = new Fil("Juan", 9, 0, 1000);
        Fil pepe = new Fil("Pepe", 9, 0, 1000);

        juan.setPriority(Thread.MAX_PRIORITY);
        pepe.setPriority(Thread.MAX_PRIORITY);

        pepe.start();
        juan.start();

        System.out.println("Acaba thread main");
    }
}