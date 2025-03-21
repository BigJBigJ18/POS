import java.util.Scanner;

public class Aufgabe1 {
    private int[] input=new int[10];
    int[] korrektur ={1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Falls die Eingabe nicht valid ist, wird das verwendet



    /**
     * Konstruktor für die Instanziierung von Aufgabe1 mit dem Scanner. Der Input muss manuell über die Konsole erfolgen.
     * Keine Errornachrichten werden durch diesen Konstruktor ausgegeben.
     */
    public Aufgabe1(){
        setInput(Aufgabe1.scannerAbfrage());
    }

    /**
     * Konstruktor für die Instanziierung von Aufgabe1 mit einem vorgefertigten Array, um Zeit zu sparen und Routinearbeit zu vereinfachen
     * @param array
     * int[] array ist für den Array, mit dem das Objekt instanziiert werden soll. Hierbei muss ein vollständiger Array übergeben werden
     * Throws "NullPointerException: Falsche Instanziierung" bei array==null
     * Bei limit==true && array.length != wird Errornachricht ausgegeben und die Werte auf den Default gesetzt.
     *
     * @param limit
     * boolean limit steht für die Beschränkung von array.length auf 10.
     * Wenn limit == true, dann wird array auf die Länge 10 geprüft.
     * Wenn limit != true, dann wird array direkt zugewiesen (nach Überprüfung auf null).
     */
    public Aufgabe1(int[] array, boolean limit){
        if(array==null){
            System.err.println("wrong.aufgabe1.<<aufgabe1>>.input.1");
            throw new NullPointerException("Falsche Instanziierung");
        }else if(limit && array.length != 10){
            System.err.println("wrong.aufgabe1.<<aufgabe1>>.input.2");
            setInput(korrektur);
        }else{
            setInput(array);
        }
    }

    private void setInput(int[] input) {
        if(input==null){
            input=korrektur;
            System.err.println("wrong.aufgabe1.setInput.input.1");
        }
        this.input=input;
    }

    /**
     * Es ist die Scannerabfrage für den Konstruktor ohne Parameter. Gibt bei falschem Input im Scanner eine Errornachricht mit diesem Dateipfad aus:
     * "wrong.aufgabe1.scannerAbfrage.input.1".
     * @return
     * Gibt den eingegebenen Array durch den User über die Scanner zurück, um diesem weiterzuverwenden.
     */
    private static int[] scannerAbfrage(){
        Scanner scan = new Scanner(System.in);
        int[] safe= new int[10];    //Temporärer Speicher für den return


        for(int i=0; i<10; i++){
            System.out.print("Zahl "+(i+1)+": ");
            while(scan.hasNext()){
                if(scan.hasNextInt()){
                    safe[i]=scan.nextInt();
                    break;
                }else{
                    System.err.println("wrong.aufgabe1.scannerAbfrage.input.1");
                    scan.next();
                    System.out.print("\nZahl "+(i+1)+": ");
                }
            }
        }
        return safe;
    }

    public int summe(){
        int counter=0;
        for(int i : input) counter+=i;
        return counter;
    }

    public int minimum(){
        int min=input[0];
        for(int i : input) if(i<min) min=i;
        return min;
    }

    public int maximum(){
        int max=input[0];
        for(int i : input) if(i>max) max=i;
        return max;
    }

    public float mittelwert(){
        return (float)summe()/input.length;
    }

    public int anzPos(){
        int anz=0;
        for(int i : input) if(i>0) anz++;
        return anz;
    }
}
