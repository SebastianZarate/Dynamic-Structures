package presenter;

import java.util.PriorityQueue;
import model.Patient;
import view.View;

/**
 *
 * @author Sebastian Zarate
 */
public class Presenter {
    
    View view = new View();
    PriorityQueue<Patient> queueShifts = new PriorityQueue<>();
    
    public void run() {
        
        while (true) {
            String name = view.readData("Ingrese el nombre del paciente (o 'fin' para terminar registro): ");
            
            if (name.equalsIgnoreCase("fin")) {
                break;
            }
            
            int levelGravity = Integer.parseInt(view.readData("Ingrese el nivel de gravedad del paciente: "));
            queueShifts.add(new Patient(name, levelGravity));
        }
        
        view.showMessage("\nPacientes en espera: ");
        while (!queueShifts.isEmpty()) {
            Patient currentPatient = queueShifts.poll();
            view.showMessage("Atendiendo a " + currentPatient.getName() + " - Nivel de gravedad: " + currentPatient.getLevelGravity());
        }
        view.showMessage("Fin del proceso");
    }
    
    public static void main(String[] args) {
        new Presenter().run();
    }
    
}
