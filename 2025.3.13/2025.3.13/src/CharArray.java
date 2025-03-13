public class CharArray {
    private char[] satz;
    private int anz;

    public CharArray(char satz[]) {
        setSatz(satz);
        setAnz();
    }

    public char[] getSatz() {
        return satz;
    }
    public void setSatz(char[] satz) {
        if(satz.length ==0) {
            satz= new char[]{'a', 'b', 'c'};
        }
        this.satz = satz;
    }
    public int getAnz() {
        return anz;
    }
    public void setAnz() {
        this.anz = satz.length;
    }

    public void entferneZeichen(char c){
        for(int i=0; i<satz.length; i++){
            if(satz[i]==c){
                satz[i]=' ';
                for(int j=i; j<satz.length; j++){
                    if(!(j+1>=satz.length)){
                        satz[j]=satz[j+1];
                    }else{
                        satz[j]=' ';
                    }
                }
                i--;
            }
        }
    }
    public void ausgeben(){
        for(int i=0; i<satz.length; i++){
            System.out.print(satz[i]);
        }
    }
    public void reverseZeile(){
        char[] tausch=new char[satz.length];
        for(int i=satz.length-1; i>=0; i--){
            tausch[satz.length-i-1]=satz[i];
        }
        satz=tausch;
    }
    public boolean istIdentMit(char[] satz){
        boolean check = true;
        if(this.satz.length == satz.length){
            for(int i=0; i<satz.length; i++){
                if(this.satz[i]!=satz[i]){
                    check=false;
                    break;
                }
            }
        }else{
            check = false;
        }
        return check;
    }
    public String istTeilVon(char[] satzteil){
        boolean enthalten=false;
        StringBuilder stringSatz=new StringBuilder("\"");
        for(int i=0; i<satzteil.length; i++){
            stringSatz.append(satzteil[i]);
        }
        stringSatz.append("\"");

        for(int i=0; i<satz.length; i++){
            if(satzteil[0]==satz[i]){
                for(int j=0; j<satzteil.length; j++){
                    if(satzteil[j]!=satz[i+j]){
                        enthalten=false;
                        break;
                    }else{
                        enthalten=true;
                    }
                }
            }
        }
        if(enthalten){
            stringSatz.append(" ist in \"");
        }else{
            stringSatz.append(" ist nicht in \"");
        }
        for(int i=0; i<satz.length; i++){
            stringSatz.append(satz[i]);
        }
        stringSatz.append("\" enthalten.");
        return stringSatz.toString();
    }
    public int ersterIndexVon(char c){
        int position=0;
        for(int i=0; i<satz.length-1; i++){
            if(satz[i]==c){
                System.out.println("Von 1 gezählt befindet sich der Character \""+c+"\" an der Position "+(i+1));
                return i;
            }
        }
        System.out.println("Es gibt dieses Character nicht im Array!");
        return -1;
    }
    public int ersterIndexVon(char c, int abIndex){
        for(int i=abIndex; i<satz.length; i++){
            if(satz[i]==c){
                System.out.println("Ab der Stelle "+abIndex+" ist an der Stelle "+i+" der Character \""+c+"\"");
                return i;
            }
        }
        System.out.println("Es gibt dieses Character nicht im Array!");
        return -1;
    }
    public int letzterIndexVon(char c){
        int position=-1;
        for(int i=0; i<satz.length; i++){
            if(satz[i]==c){
                position=i;
            }
        }
        if(position==-1){
            System.out.println("Es gibt dieses Character nicht im Array!");
        }else{
            System.out.println("Die letze Position der Characters \""+c+"\" ist an der Position "+position);
        }
        return position;
    }
    public void sort(){
        for(int j=0; j<satz.length; j++){
            int posGross=0;
            char charGross=satz[0];
            for(int i=0; i<anz; i++){
                if(satz[i]>charGross){
                    posGross=i;
                    charGross=satz[i];
                }
            }
            char tausch=satz[anz-1];
            satz[anz-1]=charGross;
            satz[posGross]=tausch;
            anz--;
        }
    }
}
