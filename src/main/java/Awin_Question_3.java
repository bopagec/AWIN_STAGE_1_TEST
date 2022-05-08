import java.util.function.*;
import java.util.stream.IntStream;

class Awin_Question_3 {

    void findTipTop(){
        Predicate<Integer> canPrintTip = number -> number % 7 == 0;
        Predicate<Integer> canPrintTop = number -> number % 5 == 0;

        IntStream.rangeClosed(25, 250)
                .forEach(value -> {
                    String output = canPrintTip.and(canPrintTop).test(value) ? "TipTop" : canPrintTip.test(value)
                            ? "Tip" : canPrintTop.test(value)
                            ? "Top" : String.valueOf(value);
                    System.out.println(output);
                });
    }
}
