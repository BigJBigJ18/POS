import java.util.Random;
import java.util.Scanner;

public class Spiel {
    private int compRaetZahl(int von, int bis) {
        Scanner userScan = new Scanner(System.in);

        int minimum;
        int maximum;
        int dieZahl;
        int guess;
        int input ;

        if (von < 0 || bis < 0) {
            System.err.println("wrong.spiel.compraetzahl.input.1");
            return -1;
        }

        if (von > bis) {
            int change = von;
            von = bis;
            bis = change;
        }

        System.out.print("DIE ZAHL: ");
        dieZahl = compRaetZahlInput(von, bis);

        maximum = bis+1;
        minimum = von-1;
        guess = (von + bis) / 2;
        System.out.println("ANGABE: " + guess);
        System.out.print("Tipp: ");
        while (userScan.hasNext()) {
            if (userScan.hasNextInt()) {
                input = userScan.nextInt();
                if(input==0){
                    if(guess==dieZahl){
                        System.out.println("GEWONNEN");
                        break;
                    }else{
                        System.out.println("GELOGEN HAST DU!");
                        break;
                    }
                }else if(guess==dieZahl){
                    System.out.println("Lüg nd");
                    break;
                }else if(input==1){
                    if(guess>dieZahl){
                        System.out.println("DAS KANN NICHT SEIN>");
                        break;
                    }
                    minimum=guess;
                    guess+=maximum;
                    guess/=2;
                    System.out.println(guess);
                    System.out.print("Tipp: ");
                }else if(input==-1){
                    if(guess<dieZahl){
                        System.out.println("DAS KANN NICHT SEIN<");
                        break;
                    }
                    maximum=guess;
                    guess+=minimum;
                    guess/=2;
                    System.out.println(guess);
                    System.out.print("Tipp: ");
                }
            }
        }
        return -1;
    }

    private int compRaetZahlInput(int von, int bis) {
        Scanner input = new Scanner(System.in);
        int dieZahl;

        while (input.hasNext()) {
            if (input.hasNextInt()) {
                dieZahl = input.nextInt();
                if (dieZahl > von || dieZahl < bis) {
                    return dieZahl;
                } else {
                    System.err.println("wrong.spiel.compraetzahlinput.input.1");
                }
            } else {
                System.err.println("wrong.spiel.compraetzahlinput.input.2");
            }
        }

        System.err.println("fatal error 1");
        return 0;
    }

    private void userRaetZahl(int von, int bis) {
        int input = 0;
        int raet = 0;
        int versuche = 1;

        if (von < 0 || bis < 0) {
            System.err.println("wrong.spiel.userraetzahl.input.1");
        } else {
            if (von > bis) {
                int change = von;
                von = bis;
                bis = change;
            }

            input = new Random(System.currentTimeMillis() + new Random().nextInt()).nextInt(von, bis);
            System.out.print("Dein Guess: ");
            raet = userRaetZahlInput(von, bis);
            while (true) {
                if (raet == input) {
                    System.out.println("DU HAST GEWONNEN, DU HAST " + input + " VERSUCHE GEBRAUCHT!");
                    break;
                }

                System.out.println("Leider Falsch");
                System.out.print("Dein Guess: ");
                raet=userRaetZahlInput(von, bis);
                versuche++;
            }


        }

    }

    private int userRaetZahlInput(int von, int bis) {
        Scanner input = new Scanner(System.in);
        int eingabe = 0;

        while (input.hasNext()) {
            if (input.hasNextInt()) {
                eingabe = input.nextInt();
                if (eingabe > von && eingabe < bis) {
                    return eingabe;
                } else {
                    System.err.println("wrong.spiel.userraetzahlinput.input.1");
                }
            } else {
                System.err.println("wrong.spiel.userraetzahlinput.input.1");
                input.next();
            }
        }
        System.err.println("fatal error 2");
        return 0;
    }

    public void menu(){

        switch (menuscan()){
            case 0:
                System.out.println("ENDE");
                break;

            case 1:
                Scanner scan1=new Scanner(System.in);
                Spiel spiel=new Spiel();

                int eingabe=0;
                int x=-1;
                int y=-1;

                System.out.print("VON: ");
                while(scan1.hasNext()){
                    if(scan1.hasNextInt()){
                        eingabe=scan1.nextInt();
                        if(eingabe<0){
                            System.err.println("wrong.spiel.menu.input.2.1");
                            if(x>=0){
                                System.out.print("BIS: ");
                            }else{
                                System.out.print("VON: ");
                            }
                        }else{
                            if(x>=0){
                                y=eingabe;
                                break;
                            }else{
                                x=eingabe;
                                System.out.print("BIS: ");
                            }
                        }
                    }else{
                        System.err.println("wrong.spiel.menu.input.2.2");
                        if(x>=0){
                            System.out.print("BIS: ");
                        }else{
                            System.out.print("VON: ");
                        }
                    }
                }

                spiel.compRaetZahl(x,y);
                break;

            case 2:
                Scanner scan2 =new Scanner(System.in);
                Spiel spiel1 =new Spiel();

                int eingabe1 =0;
                int x1=-1;
                int y1=-1;

                while(scan2.hasNext()){
                    if(x1<0){
                        System.out.print("VON: ");
                    }else{
                        System.out.print("BIS: ");
                    }
                    if(scan2.hasNextInt()){
                        eingabe1 = scan2.nextInt();
                        if(eingabe1 <0){
                            System.err.println("wrong.spiel.menu.input.2.1");
                        }else{
                            if(x1>0){
                                y1= eingabe1;
                                break;
                            }else{
                                x1= eingabe1;
                            }
                        }
                    }
                }

                spiel1.userRaetZahl(x1,y1);
                break;
        }
    }

    private int menuscan(){
        Scanner menuscan=new Scanner(System.in);
        int eingabe=0;
        menutxt();
        while(menuscan.hasNext()){

            if(menuscan.hasNextInt()){
                eingabe=menuscan.nextInt();
                if(eingabe<0||eingabe>2){
                    System.err.println("wrong.spiel.menuscan.input.1");
                    menuscan.next();
                    menutxt();
                }else{
                    return eingabe;
                }
            }else{
                System.err.println("wrong.spiel.menuscan.input.2");
                menutxt();
            }
        }
        System.err.println("fatal error 3");
        return 0;
    }

    private void menutxt(){
        System.out.println("\n-------------------------------------------");
        System.out.println("1 - Computer rät Zahl");
        System.out.println("2 - User rät Zahl");
        System.out.println("0 - EXIT");
        System.out.println("-------------------------------------------");

    }
}