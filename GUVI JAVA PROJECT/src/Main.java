import javax.swing.SwingUtilities;
import ui.StudentInfoForm;
/**
 * The Main class serves as the entry point for the Quiz Application.
 * It ensures the GUI is started properly on the Event Dispatch Thread.
 */
public class Main {
     /**
     * Main method - program starts execution from here.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // ✅ Start with Student Info Form instead of Quiz directly
                new StudentInfoForm().setVisible(true);
            }
        });
    }
}

