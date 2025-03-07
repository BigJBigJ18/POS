import java.util.Random;

public class Spiel {
    public static void spielen() {
        int punkte = 0; //wie viele Punkte man insgesamt hat
        int win = 0;
        int ersterWurf = 0;
        boolean erstesmal = true;
        Spiel spiel = new Spiel();
        spiel.ausgabe();

        while (true) {
            punkte=0;
            for (int i = 0; i < 2; i++) {
                int random = new Random(System.currentTimeMillis() + new Random().nextInt()).nextInt(1, 7);
                punkte += random;
//                punkte=7;
            }
            if (erstesmal) {
                ersterWurf=punkte;
                System.out.print("Du hast " + punkte);
                erstesmal = false;
                switch (punkte) {
                    case 7:
                        System.out.println(" gewürfelt und gewonnen!");
                        win = 1;
                        break;

                    case 11:
                        System.out.println(" gewürfelt und gewonnen!");
                        win = 1;
                        break;

                    case 2:
                        System.out.println(" gewürfelt und verloren!");
                        win = -1;
                        break;

                    case 3:
                        System.out.println(" gewürfelt und verloren!");
                        win = -1;
                        break;

                    case 12:
                        System.out.println(" gewürfelt und verloren!");
                        win = -1;
                        break;
                }
            } else {
                if(punkte==ersterWurf){
                    win=1;
                }else{
                    switch (punkte){
                        case 7:
                            win=-1;
                            break;
                    }
                }

                if (win == 1 || win == -1) {
                    System.out.println(", "+punkte+" gewuerfelt und "+spiel.gewonnen(win));;
                } else {
                    System.out.print(spiel.gewonnen(win)+punkte);
                }
            }
            if(win==1||win==-1){
                break;
            }
        }
    }




    private void ausgabe(){
        System.out.println("-------------------------------------------\n" +
                "Willkommen im Spiel!\n" +
                "Hier sind die Regeln:\n" +
                "1) Die Zahlen zu manipulieren ist verboten!\n" +
                "2) Den Code zu den eigenen Gunsten zu verändern ist verboten!\n" +
                "3) Keinen Spaß zu haben ist verboten!\n" +
                "4) Viel Glück zu haben ist erlaubt!\n" +
                "-------------------------------------------");
    }

    private String gewonnen(int wert){
        if(wert==1){
            return "gewonnen";
        }else if(wert==-1){
            return "verloren";
        }else if(wert==0){
            return ", ";
        }
        return "ERROR!!!";
    }
}
