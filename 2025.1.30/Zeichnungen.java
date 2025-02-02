import java.util.Scanner;

/**
 * Sehr geehrter Herr Prof.Knon,
 * in  Ihrer Aufgabenstellung haben Sie im Bild Höhe und Breite vertauscht.
 * Daher ist dieses 6 "*" breit und 4 Zeilen hoch (nicht umgekehrt).
 * Ich würde Sie darum bitten, dies zu ändern, da es zu Meinungsverschiedenheiten geführt hat.
 * Mfg,
 * Jornandes Raible
 */


public class Zeichnungen {
    public void parallelogramm(int breite, int hoehe){

        for(int i=0; i<hoehe; i++){ //für die Höhe, i steht zudem für die "Leerzeichen"
            for(int j=0;j<i; j++){  //gibt die Leerzeichen aus
                System.out.print(" ");
            }

            for(int l=0; l<breite; l++){
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public void Baum(){
        Scanner baumscan=new Scanner(System.in);
        int input=0;
        int zaehler=1;

        System.out.print("Schichten: ");
        while(baumscan.hasNext()){
            if(baumscan.hasNextInt()){
                input=baumscan.nextInt();
                if(input<0){
                    System.err.println("wrong.Zeichnungen.baum.input.2");
                    System.out.print("Schichten: ");
                    input = 0;
                }else{
                    break;
                }
            }else{
                System.out.println("wong.Zeichnungen.baum.input.1");
                System.out.print("Schichten: ");
                baumscan.nextLine();
            }
        }

        /**
         * jetzt wird der Baum mit dem Input des users erstellt
         */

        for(int i=0; i<input; i++){
            for(int j=0; j<input-1-i; j++){
                System.out.print(" ");
            }
            for(int j=0; j<zaehler; j++){
                System.out.print("*");
            }
            System.out.println();
            zaehler+=2;
        }

        /**
         * (ZUSATZ) Hier wird noch ein Stamm hinzugefügt
         */

        //für die Breite
        int count=4*(zaehler/9); //wie viele Leerzeichgen bis zum Stamm (verhält sich 1:8)
        for(int j=0; j<count/2; j++){
            for(int i=0; i<count; i++){
                System.out.print(" ");
            }
            for(int i=0; i<zaehler/9; i++){
                System.out.print("*");
                if((2*(zaehler/9))%2==0){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }



    public static void test(){
        Zeichnungen zeichnungen=new Zeichnungen();
        Scanner testscan =new Scanner(System.in);

        int hoehe=0;
        int breite=0;

        System.out.print("Höhe: ");
        while(testscan.hasNext()){
            if(testscan.hasNextInt()){
                hoehe= testscan.nextInt();
                if(hoehe<=0){
                    System.err.println("wrong.Zeichnungen.test.input.2");
                    System.out.println("Höhe: ");
                    hoehe=0;
                }else{
                    break;
                }
            }else{
                testscan.nextLine();
                System.err.println("wrong.Zeichnungen.test.input.2");
                System.out.print("Höhe: ");
            }
        }

        System.out.print("Breite: ");
        while(testscan.hasNext()){
            if(testscan.hasNextInt()){
                breite= testscan.nextInt();
                if(breite<=0){
                    breite=0;
                    System.err.println("wrong.Zeichnungen.test.input.4");
                    System.out.print("Breite: ");
                }else{
                    break;
                }
            }else{
                testscan.nextLine();
                System.err.println("wrong.Zeichnungen.test.input.3");
                System.out.print("Breite: ");
            }
        }



        zeichnungen.parallelogramm(breite, hoehe);
    }
}
