import java.math.BigDecimal;

public class Rechner{
    public BigDecimal plus(BigDecimal x, BigDecimal y){
        BigDecimal rechnung=x.add(y);
//        System.out.println(rechnung.setScale(2, BigDecimal.ROUND_HALF_UP));
        return rechnung.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal minus(BigDecimal x, BigDecimal y){
        BigDecimal rechnung=x.subtract(y);
        return rechnung.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal mult(BigDecimal x, BigDecimal y){
        BigDecimal rechnung=x.multiply(y);
        return rechnung.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal div(BigDecimal x, BigDecimal y){
        if(y.compareTo(BigDecimal.ZERO) ==0){
            System.err.println("wrong.rechner.div.input.divide/0");
        }else {
            BigDecimal rechnung = x.divide(y);
//            System.out.println(rechnung.intValue());
            return rechnung.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return new BigDecimal(0);
    }
    public BigDecimal faktorielle(BigDecimal x){
        BigDecimal rechnung=x;
        System.out.print(x.intValue());
        for(BigDecimal i=x.subtract(BigDecimal.ONE); i.compareTo(BigDecimal.ZERO) > 0; i=i.subtract(BigDecimal.ONE)){
            System.out.print("*"+i);
            rechnung=rechnung.multiply(i);
        }
        System.out.println(" = "+rechnung);
        return x;
    }
    public BigDecimal quadrat(BigDecimal x){
        BigDecimal rechnung=x.multiply(x);
        return rechnung.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public static void test(){
        Rechner rechner=new Rechner();
        System.out.println("\n-----------------------------------------TEST-----------------------------------------" +
                "\n Test start" +
                "\n---------------------Plus--------------------" +
                "\n(2.3456+3.4567=5.8023=5.80) erwartet");
        System.out.println(rechner.plus(new BigDecimal(2.3456),new BigDecimal(3.4567)));

        System.out.println("\n---------------------Minus--------------------" +
                "\n(2.3456-3.4567=-1.1111=-1.11) erwartet");
        System.out.println(rechner.minus(new BigDecimal(2.3456),new BigDecimal(3.4567)));

        System.out.println("\n---------------------Mult--------------------" +
                "\n(2.3456 * 3.4567=8,10803552=8.11) erwartet");
        System.out.println(rechner.mult(new BigDecimal(2.3456),new BigDecimal(3.4567)));

        System.out.println("\n---------------------Div--------------------" +
                "\n(10/2=5) erwartet");
        System.out.println(rechner.div(new BigDecimal(10),new BigDecimal(2)));

        System.out.println("\n---------------------Faktorielle--------------------" +
                "\n(6*5*4*3*2*1=720) erwartet");
        rechner.faktorielle(new BigDecimal(6));

        System.out.println("\n---------------------Quadrat--------------------" +
                "\n(2*2=4) erwartet");
        System.out.println(rechner.quadrat(new BigDecimal(2)));

        System.out.println("--------------------------------------------------------------------------------------");
    }
}
