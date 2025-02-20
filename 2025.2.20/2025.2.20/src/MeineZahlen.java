import java.util.Random;

public class MeineZahlen {
    private float[] zahlen;

    public float[] getZahlen() {
        return zahlen;
    }
    public void setZahlen(float[] zahlen) {
        this.zahlen = zahlen;
    }

    public MeineZahlen(int anz){
        if(anz < 0){
            System.err.println("wrong.meineZahlen.<<<meinezahlen>>>.input.1");
            anz=0;
        }
        zahlen=new float[anz];
        for(int i=0;i<anz;i++) {
            zahlen[i] = new Random(System.currentTimeMillis() + new Random().nextInt()).nextFloat(1.0f, 10.0f);
        }
    }
    public MeineZahlen(float[] zahlen){
        this. zahlen=new float[zahlen.length];
        for(int i=0;i<zahlen.length;i++) {
            if(zahlen[i]<0) {
                System.err.println("wrong.meineZahlen.<<<meineZahlen>>>.input.1");
                break;
            }else {
                this.zahlen[i] = zahlen[i];
            }
        }
    }
    public void ausgeben(){
        for(int i=zahlen.length-1;i>0;i--) {
            System.out.print(zahlen[i]+", ");
        }
        System.out.println();
    }
    public void ausgebennormal(){
        for(int i=0;i<zahlen.length;i++) {
            System.out.print(zahlen[i]+", ");
        }
        System.out.println();
    }
    public void min(){
        float kleinste=zahlen[0];
        for(int i=0;i<zahlen.length;i++) {
            if(zahlen[i]<kleinste) {
                kleinste=zahlen[i];
                i=0;
            }
        }
        System.out.println("\nMin: "+kleinste);
    }
    public int indexVonMin(boolean letztePosition){
        int stellemin=0;
        float kleinste=zahlen[0];

        if(letztePosition){
            stellemin=zahlen.length;
            for(int i=0;i<zahlen.length-1;i++) {
                if(kleinste>zahlen[i]) {
                    stellemin=i+1;
                    kleinste=zahlen[i];
                    i=0;
                }
            }
        }else{
            for(int i= zahlen.length-1;i>0;i--) {
                if(kleinste>zahlen[i]) {
                    stellemin=i;
                    kleinste=zahlen[i];
                    i=zahlen.length-1;
                }
            }
        }
        System.out.println("\nMin (Stelle, von 0 gezählt): "+stellemin);
        return stellemin;
    }
    public void diff(){
        float ausgabe;

        for(int i=0;i<zahlen.length-1;i++) {
            ausgabe=zahlen[i+1]-zahlen[i];
            if(ausgabe<0){
                ausgabe*=-1;
            }
            System.out.print(ausgabe+", ");
        }

        System.out.println();
    }
    public float sum(){
        float summe=0;
        System.out.print("(");
        for(int i=0; i<zahlen.length;i++) {
            summe+=zahlen[i];
            System.out.print(zahlen[i]);
            if(!(i+1>=zahlen.length)) {
                System.out.print(", ");
            }
        }
        System.out.print(")");
        return summe;
    }
    public int kleinerDurchschnitt(){
        float zusammen=sum();
        float[] udurchz=elementeKleinerDurchschnitt();
        int counter=0;

        System.out.println("/"+zahlen.length+"="+zusammen/zahlen.length);
        System.out.print("Unterdurchschnittliche Zahlen: ");
        for(int i=0; i<udurchz.length-1; i++){
            System.out.print(udurchz[i]);
            if(i+1>=udurchz.length){
                System.out.println();
            }else{
                System.out.print(", ");
            }
        }
        return udurchz.length;
    }
    public float[] elementeKleinerDurchschnitt(){
        float summe=0;
        for(int i=0; i<zahlen.length-1; i++){
            summe+=zahlen[i];
        }
        float[] unterdurchschnnitt;
        int counter=0;  //wie viele Stellen unterdurchschnitt haben muss
        int counter2=0; //welche posiionen schon im Unterdurchschnitt besetzt sind

        for(int i=0; i<zahlen.length-1;i++) {
            if(zahlen[i]<summe/zahlen.length) {
                counter++;
            }
        }

        unterdurchschnnitt=new float[counter];

        for(int i=0; i<zahlen.length-1;i++) {
            if(zahlen[i]<summe/zahlen.length) {
                unterdurchschnnitt[counter2]=zahlen[i];
                counter2++;
            }
        }
        return unterdurchschnnitt;
    }
    public void tauscheKleinstesErstesPos(){
        int pos=indexVonMin(false);
        float change=zahlen[pos];
        zahlen[pos]=zahlen[0];
        zahlen[0]=change;
    }
    public static void test(){
        MeineZahlen meineZahlen=new MeineZahlen(10);
        float[] zahlen={1.2f, 4.3f, 2.3f, 7.6f, 1.2f, 5.6f, 4.5f, 9.8f, 4.5f, 3.4f};
        MeineZahlen meineZahlen1=new MeineZahlen(zahlen);

        System.out.println("\n--------------------------------------------TEST--------------------------------------------\n");
        System.out.println("Minimalsuche");
        meineZahlen1.ausgebennormal();
        meineZahlen1.min();
        System.out.println("\n--------------------------------------------");
        System.out.println("Index Von Minimum (erste kleine)");
        meineZahlen1.ausgebennormal();
        meineZahlen1.indexVonMin(false);
        System.out.println("Index Von Minimum (letzte kleine");
        meineZahlen1.ausgebennormal();
        meineZahlen1.indexVonMin(true);
        System.out.println("\n--------------------------------------------");
        System.out.println("Diiferenz von allen");
        meineZahlen1.ausgebennormal();
        meineZahlen1.diff();
        System.out.println("\n--------------------------------------------");
        System.out.println("SUMME VON ALLEM");
        meineZahlen1.ausgebennormal();
        System.out.println(meineZahlen1.sum());
        System.out.println("\n--------------------------------------------");
        System.out.println("Kleiner Durchschnitt");
        meineZahlen1.ausgebennormal();
        meineZahlen1.kleinerDurchschnitt();
        System.out.println("\n--------------------------------------------");
        System.out.println("Tausch des Kleinsten und des Ersten");
        meineZahlen1.ausgebennormal();
        meineZahlen1.tauscheKleinstesErstesPos();
        meineZahlen1.ausgebennormal();
        System.out.println("\n--------------------------------------------TEST--------------------------------------------");
    }
}
