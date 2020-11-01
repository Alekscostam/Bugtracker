package pl.kowalski.demo;

import pl.kowalski.demo.model.Progress;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Integer> Atr2 = Arrays.asList(2, 4, 2, 2, 2, 0, 3, 1, 2, 1, 4, 4, 4, 4, 4, 4, 4, 4, 3, 4, 3, 3, 4, 3, 2, 3, 3, 3, 4, 3, 4, 3, 3, 4, 4, 3, 3, 3, 3, 3, 2, 2, 4, 3, 2, 3, 3, 3, 2, 3, 2, 3, 3, 3, 3, 3, 4, 4, 3, 2, 2, 2, 2, 2, 3, 3, 3, 2, 3, 4, 3, 2, 3, 3, 2, 4, 2, 2, 2, 2, 0, 4, 4, 3, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 1, 1, 0, 0, 0, 1, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 0, 1, 2, 1, 3, 0, 0, 0, 1, 0, 0, 1, 3, 1, 0, 2, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0);

        Map<Integer, Integer> result = new HashMap<>();
        result.put(0, (int) Atr2.stream().filter(integer -> integer.equals(0)).count());
        result.put(1, (int) Atr2.stream().filter(integer -> integer.equals(1)).count());
        result.put(2, (int) Atr2.stream().filter(integer -> integer.equals(2)).count());
        result.put(3, (int) Atr2.stream().filter(integer -> integer.equals(3)).count());
        result.put(4, (int) Atr2.stream().filter(integer -> integer.equals(4)).count());


        var ref = new Object() {
            double mean = 0;
            double variance = 0;

        };

        result.forEach((key, value) -> ref.mean +=(key * value));

        ref.mean = ref.mean/ (long) Atr2.size();


        Atr2.forEach(element-> ref.variance += Math.pow((Double.valueOf(element) - ref.mean),2));

        double variance = ref.variance / (long) Atr2.size();

        double std = Math.sqrt(variance);


        System.out.println(Progress.DONE.name().equals("DONE"));


    }
}
