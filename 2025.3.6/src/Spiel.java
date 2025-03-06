import java.util.Random;

import static java.lang.System.currentTimeMillis;

public class Spiel {
    public static void spielen(){
        int[] würfel=new int[2]; //hier kann man die Anzahl der Würfel ändern
        int punkte=0; //wie viele Punkte man insgesamt hat
        int win=0;
        boolean ertesmal=true;
        Spiel spiel=new Spiel();
        spiel.ausgabe();

        for(int i=0; i<würfel.length; i++){
            int random=new Random(System.currentTimeMillis()+new Random().nextInt()).nextInt(1, 7);
            würfel[i]=random;
            punkte+=random;
        }

        /**
         * NOCH NICHT FERTG!
         */

    }
    private void ausgabe(){
        System.out.println("-------------------------------------------\n" +
                "Willkommen im Spiel!\n" +
                "Hier sind die Regeln:\n" +
                "1) Die Zahlen zu manipulieren ist verboten!\n" +
                "2) Den Code zu den eigenen Gunsten zu verändern ist verboten!\n" +
                "3) Keinen Spaß zu haben ist verboten!\n" +
                "4) Viel Glück zu haben ist erlaubt!\n" +
                "-------------------------------------------");
    }

    private String gewonnen(int wert){
        if(wert==1){
            return "gewonnen";
        }else if(wert==0){
            return "verloren";
        }else if(wert==-1){
            return "ist nichts passiert";
        }
        return "ERROR!!!";
    }
}
