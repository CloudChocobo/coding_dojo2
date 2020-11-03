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
        if ((year % 400 == 0) || (year % 4 == 0 && modulo(year) != 0)) {
            return true; // étape 1 : année divisible par 400 = bissextile
        } // étape 2 : année divisible par 4 mais pas par 100 = bissextile
        return false;
    }






    public static String convert(String montant) {
        return convert2(Integer.valueOf(montant.substring(0, montant.length() - 1))) + " dollars"; // on ne garde que les chiffres et pas le $
    }

    private static String convert2(int chiffreDepart) {
        String[] deZeroAVingt = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
                "twenty" };
        String[] dizaines = { "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };
        String[] centaines = { "one hundred", "two hundred", "three hundred", "four hundred", "five hundred",
                "six hundred", "seven hundred", "eight hundred", "nine hundred" };
        int dizainePilePoil = diviserPuisMultiplierPar10LEntier(chiffreDepart);
        int centainePilePoil = diviserPuisMultiplierPar100LEntier(chiffreDepart);
        int moduloCentaine = modulo(chiffreDepart);

        if (chiffreDepart > 100 && moduloCentaine >= 1 && moduloCentaine <= 20) {
            return centaines[chiffreDepart / 100 - 1] + " and " + deZeroAVingt[chiffreDepart - centainePilePoil];
        }

        if (chiffreDepart > 100 && moduloCentaine > 20 && moduloCentaine < 100 && !cEstUneDizaine(chiffreDepart)) {
            return centaines[chiffreDepart / 100 - 1] + " and " + dizaines[(chiffreDepart - centainePilePoil) / 10 - 1]
                    + " " + deZeroAVingt[chiffreDepart - dizainePilePoil];
        }
        if (chiffreDepart > 100 && moduloCentaine > 20 && moduloCentaine < 100 && cEstUneDizaine(chiffreDepart)) {
            return centaines[chiffreDepart / 100 - 1] + " and " + dizaines[(chiffreDepart - centainePilePoil) / 10 - 1];
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

    private static int modulo(int chiffreDepart) {
        return chiffreDepart % 100;
    }

    private static boolean nombreSuperieurA20HorsDizainePilePoil(int chiffreDepart, int dizainePilePoil) {
        return chiffreDepart > 20 && chiffreDepart != dizainePilePoil;
    }

    private static boolean cEstUneDizaine(int chiffreDepart) {
        return chiffreDepart >= 10 && chiffreDepart % 10 == 0;
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

	public static String fooBarQix(int number) {
    
        String FBQ = Integer.toString(number);   
          
        if (number % 3 == 0 && number > 3 ) {
            return "FooFoo";
        }   
        if (number % 5 == 0 && number > 5) {
            return "BarBar";
        }
        if (number == 0) {
            return "";
        }
      
        if (number % 3 == 0) {
            return "Foo";
        }

         if (number % 5 == 0) {
            return "Bar";
        }

        if (number % 7 == 0) {
            return "Qix";
        }
      

       
        return FBQ;
	}



   
}
