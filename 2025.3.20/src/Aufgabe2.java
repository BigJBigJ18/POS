import java.util.Random;

public class Aufgabe2 {
    int[] gummibaerchen;

    /**
     * Konstruktor für Aufgabe 2.
     * @param anzahl
     * "anzahl" gibt an, wie viele Packungen instanziiert werden sollen. Wird auf "anzahl<0" geprüft.
     * Gibt die Errornachricht "wrong.aufgabe2.<<aufgabe2>>.input.1" aus, sollte dieses Statement nicht true sein und setzt "anzahl" standardmäßig auf 10.
     */
    public Aufgabe2(int anzahl){
        if(anzahl<0){
            anzahl=0;
            System.err.println("wrong.aufgabe2.<<aufgabe2>>.input.1");
        }
        gummibaerchen=new int[anzahl];
        for(int i=0; i<anzahl; i++) gummibaerchen[i]=new Random(System.currentTimeMillis()+new Random().nextInt()).nextInt(10, 15);
    }

    /**
     * Eine Methode, um die Häufigkeit richtiger Packungen zu finden.
     * @return
     * Gibt einen ganzzahligen Integer-Wert zurück, der die Anzahl in Nummern angibt.
     */
    public int anzKorrekt(){
        int counter=0;
        for(int i : gummibaerchen) if(i==12) counter++;
        return counter;
    }

    public int anzUnter(){
        int counter=0;
        for(int i:gummibaerchen) if(i<12) counter++;
        return counter;
    }

    public int anzUeber(){
        int counter=0;
        for(int i:gummibaerchen) if(i>12) counter++;
        return counter;
    }

    /**
     * Eine Methode, um die Häufigkeit richtiger Packungen zu finden.
     * @return
     * Gibt einen Float-Wert zurück, der die Anzahl in Prozent zurückgibt.
     */
    public float proKorrekt(){
        return (float)anzKorrekt()/gummibaerchen.length*100;
    }

    public float proUnter(){
        return (float)anzUnter()/gummibaerchen.length*100;
    }

    public float proUeber(){
        return (float)anzUeber()/gummibaerchen.length*100;
    }

    /**
     * Eine Methode, um die Summe aller Packungen zusammen auszugeben
     * @return
     * Gibt alle Gummibärchen aus allen Packungen zusammen als Integer-Wert zurück.
     */
    public int summe(){
        Aufgabe1 aufgabe1=new Aufgabe1(gummibaerchen, false);
        return aufgabe1.summe();
    }

    public int minimum(){
        Aufgabe1 aufgabe1=new Aufgabe1(gummibaerchen, false);
        return aufgabe1.minimum();
    }

    public int maximum(){
        Aufgabe1 aufgabe1=new Aufgabe1(gummibaerchen, false);
        return aufgabe1.maximum();
    }

    public float mittelwert(){
        Aufgabe1 aufgabe1=new Aufgabe1(gummibaerchen, false);
        return aufgabe1.mittelwert();
    }

    public void ausgabe(){
        System.out.print("[");
        for(int i=0; i<gummibaerchen.length; i++){
            System.out.print(gummibaerchen[i]);
            if(!(i+1>=gummibaerchen.length)) System.out.print(", ");
        }
        System.out.print("]");
    }
}
