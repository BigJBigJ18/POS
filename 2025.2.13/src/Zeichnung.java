public class Zeichnung {
    public void zeichneX(int hoehe){
        int counter=0; //zählt die Äbstände vor dem ersten Stern
        int hoehegerade;
        int dazwischen;

        if(hoehe<0){
            System.err.println("wrong.zeichnung.zeichnex.input.1");
        }else{

            if(hoehe%2==0){
                hoehegerade=hoehe;
            }else{
                hoehegerade=hoehe-1;
            }

            dazwischen=hoehe-2;

            for(int i=0; i<hoehe; i++){
                for(int j=0; j<counter; j++){
                    System.out.print(" ");
                }

                System.out.print("*");


                if(hoehe/2-1<i){
                    for(int j=0; j<dazwischen; j++){
                        System.out.print(" ");
                    }
                    if(!(hoehegerade/2==i)){
                        System.out.println("*");
                    }else{
                        System.out.println();
                    }
                    counter--;
                    dazwischen+=2;
                }else{
                    for(int j=0; j<dazwischen; j++){
                        System.out.print(" ");
                    }
                    System.out.println("*");
                    counter++;
                    dazwischen-=2;
                }
            }
        }
    }

    public void zeichneZahlenX(int hoehe){
        int counter=0; //zählt die Äbstände vor dem ersten Stern
        int hoehegerade;
        int dazwischen;
        int ausgabelinks=0;
        int ausgaberechts=(hoehe%10)-2;

        if(ausgaberechts<0){
            ausgaberechts=0;
        }

        if(hoehe<0){
            System.err.println("wrong.zeichnung.zeichnex.input.1");
        }else{

            if(hoehe%2==0){
                hoehegerade=hoehe;
            }else{
                hoehegerade=hoehe-1;
            }

            dazwischen=hoehe-2;

            for(int i=0; i<hoehe; i++){
                for(int j=0; j<counter; j++){
                    System.out.print(" ");
                }


                System.out.print(ausgabelinks);

                if(hoehe/2-1<i){

                    for(int j=0; j<dazwischen; j++){
                        System.out.print(" ");
                    }
                    if(!(hoehegerade/2==i)){
                        System.out.println(ausgaberechts);
                    }else{
                        System.out.println();
                    }
                    counter--;
                    dazwischen+=2;

                    ausgabelinks--;
                    if(ausgabelinks==-1){
                        ausgabelinks=9;
                    }

                    ausgaberechts++;
                    if(ausgaberechts==10){
                        ausgaberechts=0;
                    }
                }else{

                    for(int j=0; j<dazwischen; j++){
                        System.out.print(" ");
                    }
                    System.out.println(ausgaberechts);
                    counter++;
                    dazwischen-=2;

                    ausgabelinks++;
                    if(ausgabelinks==10){
                        ausgabelinks=0;
                    }

                    ausgaberechts--;
                    if(ausgaberechts==-1){
                        ausgaberechts=9;
                    }
                }
            }
        }
    }
}
