import java.util.Random;

public class Aufgabe3 {
    int[] messwerte;
    int[] verteilung;

    /**
     * Default-Konstruktor für Aufgabe 3.
     * Instanziiert mit von=0, bis=12, laenge=1000.
     */
    public Aufgabe3(){
        messwerte=new int[1000];
        verteilung=new int[13];
        for(int i = 0; i<1000; i++){
            messwerte[i]=new Random(System.currentTimeMillis()+new Random().nextInt()).nextInt(0, 13);
            verteilung[messwerte[i]]++;
        }
    }

    /**
     * Konstruktor für Aufgabe 3 mit 3 Parametern, um Individualität zu erhöhen
     * @param von
     * Von wo die Messungen sind (z.B.: von 0V)
     * @param bis
     * Bis wo die Messungen gehen (z.B.: bis 12V)
     * @param laenge
     * Wie viele Messungen vorgenommen werden
     */
    public Aufgabe3(int von, int bis, int laenge){
        if(laenge < 0){
            System.err.println("wrong.aufgabe3.<<aufgabe3>>.input.1");
            laenge=1000;
        }
        if(von < 0){
            System.err.println("wrong.aufgabe3.<<aufgabe3>>.input.2");
            von=0;
        }
        if(bis < 0){
            System.err.println("wrong.aufgabe3.<<aufgabe3>>.input.3");
            bis=12;
        }
        if(von>bis){
            int tausch=von;
            von=bis;
            bis=tausch;
        }

        messwerte=new int[laenge];
        verteilung=new int[bis+1-von];
        for(int i = 0; i<laenge; i++){
            messwerte[i]=new Random(System.currentTimeMillis()+new Random().nextInt()).nextInt(von, bis+1);
            verteilung[messwerte[i]-von]++;
        }
    }

    public void ausgabe(){
        System.out.println("      Ausgabe\n" +
                         "-------------------");
        for(int i=0; i < verteilung.length; i++){
            System.out.print(i+"V");
            for(int j=1000000; j>1; j/=10){
                if(i<j) System.out.print(" ");
            }
            System.out.println("|      "+verteilung[i]+"x");
        }
    }
}
