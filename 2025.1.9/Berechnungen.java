import java.util.Scanner;

/**
 * Beschreiben Sie hier die Klasse Berechnungen.
 * 
 * @author JR
 * @version 9.1.2025
 */
public class Berechnungen
{
    public static void xHochN(float x){
        Scanner Scan = new Scanner(System.in);
        System.out.println("Gib eine ganze Zahl ein");
        while(Scan.hasNext()){
            if(Scan.hasNextInt()){
                int n = Scan.nextInt();
                if(n<0){
                    n*=-1;
                    double output = Math.pow(x, n);
                    System.out.println("1/"+output);
                    System.out.println(1/output);
                    break;
                }else{
                    double output = Math.pow(x, n);
                    System.out.println(output);
                    break;
                }
            }else{
                System.err.println("wrong.berechnungen.xhochn.input");
                break;
            }
        }
        Scan.close();
    }

    public static void folge1(int a, int b){
        if(a<0){
            a*=-1;
        }
        if(b<0){
            b*=-1;
        }
        if(a<b){
            int o=0;
            o=a;
            a=b;
            b=o;
        }
        int i = (a-b)/2;
        int n=-1;
        int m=a;
        for(int j=0; j<=i; j++){
            if(n<0){
                System.out.print(n+"/"+m+"   ");
            }else{
                System.out.print("+"+n+"/"+m+"   ");
            }
            n*=-3;
            m-=2;
        }
        System.out.println();
    }

    public static int ziffersumme(int zahl){
        if(zahl>9){
            if(zahl<0){
                zahl*=-1;
            }
            int output=0;
            int zahl1=zahl;
            for(int i=1; i<zahl; i++){
                output+=zahl1%10;
                zahl1/=10;
            }
            return output;
        }else if(zahl<0){
            return zahl*-1;
        }else{
            return zahl;
        }
    }

    public static void falling(int startHoehe, int zeit){
        double m=0;//Meter Entfernung
        int t=0;   //Zeit in s (vergangen)
        System.out.println("Sekunden   ->   Entfernung (Abwurf-Höhe: "+startHoehe+")");
        System.out.println("--------   ->   ----------------------------------------");
        if(startHoehe<1||zeit<0){
            System.err.println("wrong.berechnungen.falling.input");
        }else{
            for(int i=0; i<=zeit;i++){
                System.out.println(t+"          ->      "+m);
                t++;
                m=0.5*9.80665*t*t;
                if(m>startHoehe){
                    m=startHoehe;
                    System.out.println(t+"          ->      "+m);
                    break;
                }
            }
        }
    }
    
    /**
     * Das ist egal, nur um Platz zu sparen
     */
    public static void menutxt(){
        System.out.println();
        System.out.println("Bitte geben Sie ein: ");
        System.out.println("1 - für x hoch n");
        System.out.println("2 - für folge");
        System.out.println("3 - für Ziffernsumme");
        System.out.println("4 - für \"Handy fliegt\"");
        System.out.println("0 - für Ausstieg");
        System.out.print("ANTWORT: ");
    }
        
    public static void menu(){
        Scanner Scan=new Scanner(System.in); //Scanner zum erhalten von antworten erstellen
        menutxt();  //menütext ausgeben
        String trash=null;  //das ist für später
        while(Scan.hasNext()){ //jetzt wird so lange gewartet bis ein Imput kommt
            if(Scan.hasNextInt()){  //checkt ob der input ein Int ist
                int i=Scan.nextInt();   //wenn ja, speichert es den Input
                if(i==1){   //checkt ob der Input gleich eins ist, dh ob xHochN abgerufen werden soll
                    System.out.println("-------------------------------------------");
                    System.out.println("Gib eine Zahl, die potenziert werden soll.");   //Falls ja, fragt es nach der ersten Zahl
                    System.out.println("-------------------------------------------");
                    while(Scan.hasNext()){  //also, wartet es wieder auf den Input des users (diesmal bezogen auf das:)
                        if(Scan.hasNextInt()){  //checkt pb es ein Int ist
                            int x=Scan.nextInt(); 
                            xHochN(x);  //falls ja, wird in der Variable TEMPORÄR gespeichert, was der Input war. Danach führt es die Methode aus
                            break; // jetzt bricht es die Schleife; dh. stoppt sie
                        }else{  //sollte das nicht der fall sein, wird das ausgeführt:
                            trash=Scan.next(); // der Scanner wird geleert
                            System.err.println("wrong.berechnungen.menu.input.2.1");    //Fehlermeldung wird ausgegeben und es startet von vorn
                        }
                    }
                    menutxt(); //nach allem wird wieder das Menü ausgegeben
                }else if(i==2){ //falls nicht, geht es zum nächsten
                    int a=0; //für a bei folge1
                    int b=0; //für b bei folge1
                    System.out.println("-------------------------------------------");
                    System.out.println("Gib deine Erste Zahl ein");                         //wieder das gleiche wie oben
                    System.out.println("-------------------------------------------");
                    while(Scan.hasNext()){
                        if(Scan.hasNextInt()){
                            a=Scan.nextInt();
                            break;
                        }else{
                            trash=Scan.next();
                            System.err.println("wrong.berechnungen.menu.input.2.2.1");
                        }
                    }
                    System.out.println("-------------------------------------------");
                    System.out.println("Gib deine Zweite Zahl ein");                        //jetzt halt 2x,weil die Methode zwei Zahlen benötigt
                    System.out.println("-------------------------------------------");
                    while(Scan.hasNext()){
                        if(Scan.hasNextInt()){
                            b=Scan.nextInt();
                            break;
                        }else{
                            trash=Scan.next();
                            System.err.println("wrong.berechnungen.menu.input.2.2.2");
                        }
                    }
                    folge1(a, b);   //methode wird ausgeführt
                    menutxt();         //danach wird wieder das Menü ausgegeben
                }else if(i==3){ //wieder das gleiche
                    System.out.println("-------------------------------------------");
                    System.out.println("Bitte gib eine Zahl ein.");
                    System.out.println("-------------------------------------------");
                    while(Scan.hasNext()){
                        if(Scan.hasNextInt()){
                            int a=Scan.nextInt();
                            System.out.println(ziffersumme(a));
                            break;
                        }else{
                            trash=Scan.next();
                            System.err.println("wrong.berechnungen.menu.intput.2.3.1");
                        }
                    }
                    menutxt();
                }else if(i==4){     //wieder
                    int h=0; //Starthöhe Speichervariable
                    int s=0; //Sekunden Fallzeit                    
                    System.out.println("-------------------------------------------");
                    System.out.println("Was ist deine Starthöhe?");
                    System.out.println("-------------------------------------------");
                    while(Scan.hasNext()){
                        if(Scan.hasNextInt()){
                            h=Scan.nextInt();
                            break;
                        }else{
                            trash=Scan.next();
                            System.err.println("wrong.berechnungen.menu.intput.2.4.1");
                        }
                    }
                    System.out.println("-------------------------------------------");
                    System.out.println("Wie viele Sekunden sollen angegeben werden?");  //wieder 2 Inputs gebraucht
                    System.out.println("-------------------------------------------");
                    while(Scan.hasNext()){
                        if(Scan.hasNextInt()){
                            s=Scan.nextInt();
                            break;
                        }else{
                            trash=Scan.next();
                            System.err.println("wrong.berechnungen.menu.input.2.4.2");
                        }
                    }
                    falling(h,s);       //methode wird ausgeführt
                    menutxt();          //menü...
                }else if(i==0){     //sollte es jetzt null sein, wird das Programm beendet (sprich: break;)
                    System.out.println("-------------------------------------------");
                    System.out.println("___________________________________________");
                    System.out.println("                **Ende**");                     //ende wird ausgegeben
                    System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                    System.out.println("-------------------------------------------");
                    System.out.println(Secret.secret());
                    break;              //wird gebreaked
                }
            }else{ //else Zweig, falls bei der "Originalabfrage" keine ganze Zahl ausgegeben wird
                trash=Scan.next();
                System.err.println("wrong.berechnungen.menu.input.1.1");
                menutxt();
            }
        }
    }
}

