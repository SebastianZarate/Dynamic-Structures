package presenter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import view.View;
import model.*;

/**
 *
 * @author Sebastian Zarate
 */
public class Presenter {

    View view = new View();
    Power hash = new Power();

    public void run() {

        String elements = view.readData("Ingrese los elementos del conjunto de la siguiente manera: {1, 2, 3} ");
        Set<Integer> inputSet = hash.parseConjunto(elements);
        printPowerSet(inputSet);

    }

    public void printPowerSet(Set<Integer> set) {
        Set<Set<Integer>> powerAssembly = hash.generatingSetPower(set);

        view.showMessage("Los conjuntos de potencia serían:");
        for (Set<Integer> subset : powerAssembly) {
            view.showMessage("" + subset);
        }
    }

    public static void main(String[] args) {
        new Presenter().run();
    }
}
