package ah;

import javax.naming.ldap.SortKey;

/**
 * Hello world!
 */
public final class App {
    public static Object convertor;

    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static boolean isLeap(int year) {
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            return true; // étape 1 : année divisible par 400 = bissextile
        } // étape 2 : année divisible par 4 mais pas par 100 = bissextile
        return false;
    }

    public static String convert(int chiffreDepart) {
        String[] deZeroAVingt = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
                "nineteen", "twenty" };
        String[] dizaines = { "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };
        String[] centaines = { "one hundred", "two hundred", "three hundred", "four hundred", "five hundred",
                "six hundred", "seven hundred", "eight hundred", "nine hundred" };
        int dizainePilePoil = diviserPuisMultiplierPar10LEntier(chiffreDepart);
        int centainePilePoil = diviserPuisMultiplierPar100LEntier(chiffreDepart);

        if (chiffreDepart >220 && chiffreDepart != centainePilePoil && chiffreDepart != dizainePilePoil) {
            return centaines[chiffreDepart / 100 - 1] + " and " + dizaines[(chiffreDepart-200) /10 -1] + " " + deZeroAVingt[chiffreDepart - dizainePilePoil];
        }

        if (chiffreDepart>220 && cEstUneDizaine(chiffreDepart - 100) && chiffreDepart != centainePilePoil) {
            return centaines[chiffreDepart / 100 - 1] + " and " + dizaines[(chiffreDepart-200) /10 -1];
        }

        if (chiffreDepart>200 && chiffreDepart<=220) {
           return centaines[chiffreDepart / 100 - 1] + " and " + deZeroAVingt[chiffreDepart - centainePilePoil];
        }
        
        if (centaineSuperieureA120(chiffreDepart) && chiffreDepart != centainePilePoil && chiffreDepart != dizainePilePoil) {
            return centaines[chiffreDepart / 100 - 1] + " and " + dizaines[(chiffreDepart - 100) / 10 - 1] + " " + deZeroAVingt[chiffreDepart - dizainePilePoil];
        }
        if (chiffrePlusGrandQue100EtInferieurOuEgalA120(chiffreDepart)) {
            return centaines[chiffreDepart / 100 - 1] + " and " + deZeroAVingt[chiffreDepart - centainePilePoil];
        }

        if (centaineSuperieureA120(chiffreDepart) && cEstUneDizaine(chiffreDepart - 100) && chiffreDepart != centainePilePoil) {
            return centaines[chiffreDepart / 100 - 1] + " and " + dizaines[(chiffreDepart - 100) / 10 - 1];
        }

        if (nombreSuperieurA20HorsDizainePilePoil(chiffreDepart, dizainePilePoil)) {
            return dizaines[chiffreDepart / 10 - 1] + " " + deZeroAVingt[chiffreDepart - dizainePilePoil];
        }

        if (cEstUneCentaine(chiffreDepart)) {
            return centaines[chiffreDepart / 100 - 1];
        }

        if (cEstUneDizaine(chiffreDepart)) {
            return dizaines[chiffreDepart / 10 - 1];
        }

        return deZeroAVingt[chiffreDepart];
    }

    private static boolean chiffrePlusGrandQue100EtInferieurOuEgalA120(int chiffreDepart) {
        return chiffreDepart > 100 && chiffreDepart <= 120;
    }

    private static boolean centaineSuperieureA120(int chiffreDepart) {
        return chiffreDepart > 120;
    }

    private static boolean nombreSuperieurA20HorsDizainePilePoil(int chiffreDepart, int dizainePilePoil) {
        return chiffreDepart > 20 && chiffreDepart != dizainePilePoil;
    }

    private static boolean cEstUneDizaine(int chiffreDepart) {
        return chiffreDepart > 20;
    }

    private static boolean cEstUneCentaine(int chiffreDepart) {
        return chiffreDepart >= 100;
    }

    private static int diviserPuisMultiplierPar10LEntier(int number) {
        return number / 10 * 10;
    }

    private static int diviserPuisMultiplierPar100LEntier(int number) {
        return number / 100 * 100;
    }

}
