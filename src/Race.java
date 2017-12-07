import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Race {
    int counter;
    private int nomer;
    int count = getCounter() + 3;
    CountDownLatch START = new CountDownLatch( count );

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    ArrayList<Integer> finisher = new ArrayList<>();

    public void getRace() throws InterruptedException {
        Random sleep = new Random();
        for (int a = 1; a < getCounter() + 1; a++) {
            new Thread( new Horse( a, 300 + (sleep.nextInt( 100 ) + 1) ) ).start();
            Thread.sleep( 500 );

        }
        while (START.getCount() > 3)
            Thread.sleep( 200 );

        Thread.sleep( 300 );
        System.out.println( '\n' + "LET’S GET READY TO RUMBLE!" );
        START.countDown();
        Thread.sleep( 300 );
        System.out.println( '\n' + " ARE YOU READY?" );
        START.countDown();
        Thread.sleep( 300 );
        System.out.println( '\n' + "GO!" );
        START.countDown();
    }

    public class Horse implements Runnable {

        private int number;
        private static final int trackLength = 1000;
        private int nemnogoZameshcalsa;
        Random rand = new Random();
        private int fintrack = 0;
        private int distance;

        public Horse(int number, int sleep) {
            this.number = number;
            this.nemnogoZameshcalsa = sleep;
        }

        @Override
        public void run() {
//       String[]phrases ={"Сука,давай быстрее!","Если не выиграем пущу на мясо!","Но!-Но!","Чтоб ты всралась,кляча старая!","Я бегу быстрее своей лошади","На нас поставили, не приедем первыми нам пиздец"};
            try {
                System.out.printf( "Лошадь на дорожке №%d готова к старту.\n", number );
                START.countDown();
                START.await();

                while (fintrack <= trackLength) {
                    distance = 30 + (rand.nextInt( 20 ) + 1);
                    //             int number = nomer.nextInt(6);
                    fintrack += distance;
                    Thread.sleep( nemnogoZameshcalsa );
                    //   System.out.printf( "Слышно что наездник лошади N%d кричит %s\n", number); //phrases[number] );
                }
                System.out.printf( "Лошадь на дорожке№%d финишировала!\n", number );
                finisher.add( number );
            } catch (InterruptedException e) {
            }
        }

    }

    public Integer pobeditel() {
        nomer = finisher.get( 0 );
        return nomer;
    }

    public void clear() {
        finisher.clear();
    }
}


