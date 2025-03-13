//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        char[] array={'H', 'a', 'l', 'l', 'o', ' ', 'W', 'e', 'l', 't', '!'};
        char[] test={'H', 'a', 'l', 'l', 'o'};
        CharArray charArray=new CharArray(array);
//        charArray.ausgeben();
//        System.out.println();
//        charArray.entferneZeichen('l');
        charArray.ausgeben();
        System.out.println();
        charArray.reverseZeile();
//        System.out.println();
//        System.out.println(charArray.istIdentMit(test));
//        System.out.println(charArray.istTeilVon(test));
//        charArray.letzterIndexVon('l');
//        charArray.sort();
        charArray.ausgeben();

    }
}