import java.util.Random;
import java.util.Scanner;

public class Folge {
    /**
     *
     */
    public void folge1(int a) {
        int startwert = -1;           //höchste=immer a+2, der startwert startet bei -1, weil dann unten vor ausgabe +2 gerechnet wir
        int anzahl = 3;               //wie viele Zahlen vor dem nächsten Bildestrich (startet bei 2)
        int hoechste = 3;
        int anzahlwiederholungen = (a - 1) / 2;
        boolean hoch = false;         //schaut dann später, ob es wieder - gerechnet werden muss

        System.out.println("\n<------------------------------------------>FOLGE1<------------------------------------------>");
        if (a < 3) {
            System.err.print("wrong.folge.folge1.input.1");
        } else {
            if (a % 2 == 0) {             //Schaut, mit was es starten muss
                startwert = 0;
                hoechste = 4;
                anzahlwiederholungen = (a - 2) / 2; //muss dann bei geraden Zahlen den Startwert -1 nehmen
            }

            //jetzt weiß das Programm, wie häufig und wie lange es die Methode machen muss

            for (int i = 0; i < anzahlwiederholungen; i++) {  //läuft so lange, bis i == der anzahl der wiederholungen ist
                for (int j = 0; j < anzahl; j++) {            //solange j < der anzahl der Zahlen, die in diesem Abschnitt sein sollen ist
                    if (startwert == hoechste || hoch) {             //schaut, ob - gerechnet werden muss
                        hoch = true;
                        startwert -= 2;
                    } else {
                        startwert += 2;
                    }

                    System.out.print(startwert);
                    //startwert steht für das, was ausgegeben werden soll
                }
                if(i+1<anzahlwiederholungen){
                    System.out.print("-");  //gibt den Bindestrich aus
                }

                hoechste += 2;
                hoch = false;               //Variablen für den nächsten Durchgang vorbereiten;
                anzahl += 2;
                if (a % 2 == 0) {             //gleiches wie oben
                    startwert = 0;
                } else {
                    startwert = -1;
                }
            }
        }
        System.out.println("\n<------------------------------------------>ENDE F1<------------------------------------------>");
    }

    public void folge2(int zahl){
        System.out.println("\n<------------------------------------------>FOLGE2<------------------------------------------>");
        int zaehler=0; //zählt, wie viel abgezogen werden muss

        for(int i=1; i<=zahl-zaehler; i++){
            System.out.print(i+""+(zahl-(i-1)));
            zaehler++;
        }
        System.out.println("\n<------------------------------------------>ENDE F2<------------------------------------------>");
    }


    public static void test(){
        /**
         * Aufruf von folge1(int a)
         */
        System.out.println("\n<<<--------------------------------------------->TEST<--------------------------------------------->>>");
        Scanner testscan=new Scanner(System.in);    //Scanner wird implementiert
        int input=0; //input (dort wird der Input gespeichert)
        Folge folge=new Folge(); //um die nicht-statischen Methoden abzurufen

        System.out.print("Bitte gib eine Zahl ein, die größer als 3 ist: ");
        while(testscan.hasNext()){
            if(testscan.hasNextInt()){
                input=testscan.nextInt();
                break;
            }else{
                System.err.println("wrong.Folge.test.input.1");
                testscan.nextLine();
            }
        }

        folge.folge1(input);
        testscan.close();
        /**
         * Aufruf von folge2(int zahl)
         */

        folge.folge2(new Random().nextInt(5, 10));

        System.out.println("\n<<<-------------------------------------------->ENDE T<-------------------------------------------->>>");
    }
}
