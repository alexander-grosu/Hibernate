public class Main {
    public static void main(String[] args) {
        Client clientIndividual = new IndividualBusinessman();
        Client clientPhysical = new PhysicalPerson();
        Client clientLegal = new LegalPerson();
        Client clentLegal2 = new LegalPerson(5777);

        clientIndividual.put(1000); // put >= 1000 minus 0,5% ... 1000 = 995
        System.out.println("Client individual count " + clientIndividual.getAmount()); // 995
        clientIndividual.put(900);  // put < 1000 minus 1% ... 900 = 891
        System.out.println("Client individual count " + clientIndividual.getAmount()); // 891+995=1886
        clientLegal.put(2000);
        System.out.println("Client legal count " + clientLegal.getAmount()); //2000
        clientLegal.take(1000);
        System.out.println("Client legal count " + clientLegal.getAmount()); // take 2000 - 1000 - 1% = 990
        clientPhysical.put(3500);
        System.out.println("Client physical count " + clientPhysical.getAmount()); //3500
        clientPhysical.take(2700); // 3500 - 2700
        System.out.println("Client physical count " + clientPhysical.getAmount());
        System.out.println("Client legal2 count " + clentLegal2.getAmount());
    }
}
