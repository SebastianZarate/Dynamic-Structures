package model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Sebastian Zarate
 */
public class Power {

    public Set<Integer> parseConjunto(String input) {

        Set<Integer> set = new HashSet<>();
        String[] elements = input.split("[{},\\s]+");
        for (String element : elements) {
            if (!element.isEmpty()) {
                set.add(Integer.parseInt(element));
            }
        }

        return set;
    }

    public Set<Set<Integer>> generatingSetPower(Set<Integer> set) {
        Set<Set<Integer>> setPower = new HashSet<>();
        setPower.add(new HashSet<>()); // Agregar el conjunto vacío al conjunto de potencia

        for (Integer element : set) {
            Set<Set<Integer>> newsSubsets = new HashSet<>();
            for (Set<Integer> subset : setPower) {
                Set<Integer> newSubset = new HashSet<>(subset);
                newSubset.add(element);
                newsSubsets.add(newSubset);
            }
            setPower.addAll(newsSubsets);
        }

        return setPower;
    }

}
