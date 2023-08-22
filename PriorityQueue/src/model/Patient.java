package model;

/**
 *
 * @author Sebastian Zarate
 */
public class Patient implements Comparable<Patient> {

    String name;
    int levelGravity;

    public Patient(String name, int levelGravity) {
        this.name = name;
        this.levelGravity = levelGravity;
    }

    @Override
    public int compareTo(Patient otherPatient) {
        // Ordenamos de forma inversa para que el paciente más grave tenga mayor prioridad
        return Integer.compare(otherPatient.levelGravity, this.levelGravity);
    }

    public String getName() {
        return name;
    }

    public int getLevelGravity() {
        return levelGravity;
    }

    @Override
    public String toString() {
        return "Paciente{"
                + "nombre='" + name + '\''
                + ", nivelGravedad=" + levelGravity
                + '}';
    }
}
