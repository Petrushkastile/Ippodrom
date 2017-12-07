import java.lang.Thread;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Race race = new Race();
        ArrayList<String> zabeg = new ArrayList();
        ArrayList<String> stavka = new ArrayList();
        int pobedit = 0;
        System.out.println( "Velcome to the hippodrome *CHANSE*" );
        System.out.println( "----------------------------------" );
        System.out.println( new Zastavka().zastavka() );
        System.out.println( "----------------------------------" );
        System.out.println( "Add horse to the race[1];See all horses[2];Bets[3];See bets[4];Seat down and looking for race[5];See Won Bet[6]; Exit[7]" );
        Scanner vibor = new Scanner( System.in );
        Scanner name = new Scanner( System.in );
        Scanner number = new Scanner( System.in );
        Scanner stavka1 = new Scanner( System.in );
        Scanner nameStavka = new Scanner( System.in );
        int i = 0;

        while (i != 7) {
            System.out.println( "Make your choise" );
            i = vibor.nextInt();
            switch (i) {
                case 1:
                    System.out.println( "Add   number and name of horse" );
                    zabeg.add( number.nextInt() + " " + name.nextLine() );
                    break;
                case 2:
                    for (int b = 0; b < zabeg.size(); b++) {
                        System.out.println( zabeg.get( b ) );
                    }
                    break;
                case 3:
                    System.out.println( "Please make your bets:enter number of horse,your bet,your name;" );
                    stavka.add( number.nextInt() + " " + stavka1.nextInt() + " " + nameStavka.nextLine() );
                    break;
                case 4:
                    for (int c = 0; c < stavka.size(); c++) {
                        System.out.println( stavka.get( c ) );
                    }
                    break;
                case 5:
                    race.setCounter( zabeg.size() );
                    race.getRace();
                    Thread.sleep( 10000 );
                    pobedit = race.pobeditel();
                    String pobeda = zabeg.get( pobedit - 1 );
                    System.out.printf( '\n' + "WINNER OF THIS RACE HORSE: " + pobeda + " ON TRACK  %s \n", pobedit );
                    race.clear();
                    break;
                case 6:
                    String[] names = zabeg.get( pobedit - 1 ).split( "[,;:.!?\\s]+" );
                    int numberHorse = Integer.parseInt( names[0] );
                    for (int b = 0; b < stavka.size(); b++) {
                        String[] st = stavka.get( b ).split( "[,;:.!?\\s]+" );
                        int numberStavka = Integer.parseInt( st[0] );
                        if (numberHorse == numberStavka) {
                            System.out.println( "Сыграла ставка" + stavka.get( b ) );
                            int stavkaWin = Integer.parseInt( st[1] ) * 100;
                            System.out.println( "YOU WON: " + stavkaWin );
                            break;
                        }
                    }


            }

        }


    }


}