
import javax.swing.JOptionPane;

public class ExTestDrive2 {

    public static void main(String[] args) {
        String ageS = JOptionPane.showInputDialog("Enter your age:");
        int age = Integer.parseInt(ageS);
        if ((age > 25) && (age < 50)) {
            JOptionPane.showMessageDialog(null, "Congrats. You can apply for the loan.");
        } else {
            JOptionPane.showMessageDialog(null, "Sorry. You are not qualified.");
        }
    }
}
