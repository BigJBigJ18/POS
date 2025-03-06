public class Personen {
    private String[] personen={
            "Peter Hans Müller",
            "Annemarie Berger",
            "Dr. Hans Knopp" ,
            "Martin Schmied",
            "Mag. Angelika Bayer",
            "Hans-Jörg Metz",
            "Maria Müller",
            "Anne Peprny",
            "Dr. Joachim Hans"
    };


    public void hansImNamen(){
        for(int i=0; i<personen.length; i++){
            if(personen[i].contains("Hans")){
                System.out.println(personen[i]);
            }
        }
    }
    public void beginntMitBuchstaben(char b){
        for(int i=0; i<personen.length; i++){
            if(personen[i].toLowerCase().charAt(0) == b||personen[i].toUpperCase().charAt(0) == b){
                System.out.println(personen[i]);
            }
        }
    }
    public void hansAlsVorname(){
        String regex = " ";
        for(int i=0; i<personen.length; i++){
            String[] check=personen[i].split(regex);
            for(int j=0; j<check.length-1; j++){
                if(check[j].equals("Hans")){
                    System.out.println(personen[i]);
                }
            }
        }
    }
    public void printTitelVonPersonen(){
        String regex=" ";
        for(int i=0; i<personen.length; i++){
            if(personen[i].startsWith("Dr.")||personen[i].startsWith("Mag.")){
                String[] check=personen[i].split(regex);
                for(int j=1; j<check.length-1; j++){
                    System.out.print(check[j]+" ");
                }
                System.out.println("ist "+check[0]);
            }
        }
    }
    public void printUnterschiedlicheTitel(){
        String regex = " ";
        String[] titel=new String[personen.length];
        for(int i=0; i<personen.length; i++){
            String[] check=personen[i].split(regex);
            for(int j=0; j<check[0].length(); j++){
                if(check[0].charAt(j)=='.'){
                    for(int h=0; h<titel.length-1; h++){
                        if(titel[h]!=null&&titel[h].contains(check[0])){
                            break;
                        }
                        if(titel[h]==null){
                            titel[h]=check[0];
                            break;
                        }
                    }
                }
            }
        }
        for(int i=0; i<titel.length; i++){
            if(titel[i]==null){
                break;
            }
            System.out.print(titel[i]+" ");
        }
    }
    public void laengsterNamen(){
        int pos=0;
        int laenge=0;
        for(int i=0;i<personen.length;i++){
            if(personen[i].length()>laenge){
                laenge=personen[i].length();
                pos=i;
            }
        }
        System.out.println("Der längste Name besteht aus "+laenge+" Zeichen:\n" + personen[pos]);
    }
    public void ersteNachnameImAlphabet(){
        String ersteNachnameImAlphabet=personen[0];
        String regex=" ";
        for(int i=0; i<personen.length; i++){
            String[] check=personen[i].split(regex);
            if(ersteNachnameImAlphabet.compareTo(check[check.length-1])>0){
                ersteNachnameImAlphabet =check[check.length-1];
            }
        }
        System.out.println("Der erste Nachname im Alphabet ist: "+ersteNachnameImAlphabet);
    }
    public boolean istVorhanden(String person){
        if(person==null){
            System.err.println("wrong.personen.istvorhanden.input.1");
        }
        for(int i=0; i<personen.length; i++){
            if(personen[i].equals(person)){
                return true;
            }
        }
        return false;
    }
    public static void test(){
        Personen p = new Personen();
        System.out.println("---------------------------------TEST---------------------------------");
        System.out.println("----------------HANS IM NAMEN-----------------\n" +
                "Erwartet: Alle Personen der Liste mit Hans im Namen");
        p.hansImNamen();
        System.out.println("----------------BEGINNT MIT BUCHSTABEN-----------------\n" +
                "Erwartet: Alle Personen die mit 'A' Buchstaben beginnen");
        p.beginntMitBuchstaben('a');
        System.out.println("----------------HANS ALS VORNAMEN-----------------\n" +
                "Erwartet: Alle Personen die Hans als Vornamen haben");
        p.hansAlsVorname();
        System.out.println("----------------PRINT TITEL VON PERSONEN-----------------\n" +
                "Erwartet: Alle Titel von den Personen");
        p.printTitelVonPersonen();
        System.out.println("----------------PRINT UNTERSCHIEDLICHE TITEL-----------------\n" +
                "Erwartet: Alle Tiel");
        p.printUnterschiedlicheTitel();
        System.out.println("\n----------------LÄNGSTER NAME-----------------\n" +
                "Erwartet: Den längsten Namen");
        p.laengsterNamen();
        System.out.println("---------------------------------ENDE TEST-----------------------------");

    }
}
