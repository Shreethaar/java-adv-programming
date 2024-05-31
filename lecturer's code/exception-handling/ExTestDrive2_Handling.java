
import javax.swing.JOptionPane;

public class ExTestDrive2_Handling {

    public static void main(String[] args) {
        boolean proceed = true;

        while (proceed) {
            String ageS = JOptionPane.showInputDialog("Enter your age:");
            try 
            {
                int age = Integer.parseInt(ageS);
                if ((age > 25) && (age < 50)) {
                    JOptionPane.showMessageDialog(null, "Congrats. You can apply for the loan.");
                    proceed = false;
                } 
                else if (age < 0)
                {
                    throw new Exception("");
                }else {
                    JOptionPane.showMessageDialog(null, "Sorry. You are not qualified.");
                    proceed = false;
                }
            } //try
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "You must enter an integer value");
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Sorry. You are not allowed to enter negative value.");
            }
        }//while
    }//main
}
