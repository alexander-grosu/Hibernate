public class Main {

    public static void main(String[] args) {
        final String placeholder = "***";
        String pasport;
        pasport = "Номер паспорта <45 08 361>513";
        String pin;
        pin = "Пин код <6160>";
        String cardVisa;
        cardVisa = "Номер кредитной карты <2345> 4545 <6789> 0909";
        String cardMasterCard;
        cardMasterCard = "Номер кредитной карты <1234 5555 1234> 0484";

        System.out.println(searchAndReplaceDiamonds(cardVisa,placeholder));
        System.out.println(searchAndReplaceDiamonds(cardMasterCard,placeholder));
        System.out.println(searchAndReplaceDiamonds(pasport,placeholder));
        System.out.println(searchAndReplaceDiamonds(pin,placeholder));
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {

       return text.replaceAll("<\\d.+?>", placeholder);
    }

}