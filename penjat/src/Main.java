import java.util.Random;

public class Main {

    static final int FILS = 8;
    static final int COLS = 12;

    public static void main(String[] args) {

        String paraulaAleatoria= trobarParaulaSecreta();

        char [] guions = trobarGuions(paraulaAleatoria);

        final char[][] penjat = {
                {'-','-','-','-','-','-','-','-','-','-','-',' '},
                {'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {'-','-','-','-','-',' ',' ',' ',' ',' ',' ',' '},

        };


        boolean acabar = false;
        int intents = 6;

        System.out.println("Anem a jugar al penjat!!");
        do {
            System.out.println("Pots fallar "+ intents + " vegades");
            System.out.println(guions);
            System.out.print("Escriu una lletra: ");
            char lletra= Teclat.llegirChar();

            boolean lletraCorrecte= false;
            for (int i = 0; i < paraulaAleatoria.length(); i++) {
                if (paraulaAleatoria.charAt(i) == lletra){
                    guions[i] = lletra;
                    lletraCorrecte = true;
                }
            }
            if (!lletraCorrecte){
                System.out.println("No has acertat");
                --intents;
                dibuix(penjat,intents);
                mostrarPenjat(penjat);

                if (intents == 0){
                    System.out.println("No queden mes intents!");
                    System.out.println("La paraula és: " + paraulaAleatoria);
                    acabar=true;
                }
            }else {
                boolean guanyar = !siGuions(guions);
                if (guanyar){
                    System.out.println("Has guanyat!");
                    System.out.println("La paraula és: " + paraulaAleatoria);
                    acabar=true;
                }
            }

        }while (!acabar );


    }
    private static String trobarParaulaSecreta (){
        String [] paraules= {"aigua", "arbre", "casa", "sol", "lluna", "estrella", "mar", "aire", "terra", "amor", "odi", "alegria", "tristesa", "lluitar", "esperança", "somni", "realitat", "pensament", "sentiment", "accio", "passio", "llibertat", "igualtat", "justícia", "caminar", "perdo"};
        Random random = new Random();
        int n = random.nextInt(paraules.length);

        return paraules [n];
    }
    private static char [] trobarGuions (String paraulaAleatoria){
        int nLletrasParaulaAleatoria = paraulaAleatoria.length();
        char [] guions  = new char[nLletrasParaulaAleatoria];

        for (int i = 0; i < guions.length; i++) {
            guions [i]= '*';
        }
        return guions;
    }
    private static boolean siGuions (char[] paraula){
        for (char lletra: paraula ){
            if (lletra == '*'){
                return true;
            }
        }return false;
    }
    private static void dibuix (char[][] penjat, int intents){
        switch (intents){
            case 0:
                penjat[4][9]='/';
                penjat[4][11]='\\';
                break;
            case 1:
                penjat[3][9]='/';
                penjat[3][11]='\\';
                break;
            case 2:
                penjat[3][10]='|';
                break;
            case 3:
                penjat[2][10]='O';
                break;
            case 4:
                penjat[1][10]='|';
                break;
            case 5:
                break;
            default:
                break;
        }
    }
    private static void mostrarPenjat(char[][] estat) {

        for (int i=0; i<FILS; i++) {
            for (int j=0; j<COLS; j++) {
                System.out.print(estat[i][j]);
            }
            System.out.println("");
        }
    }

}