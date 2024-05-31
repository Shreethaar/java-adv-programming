import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class MainGUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("String Printer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	frame.setSize(400, 200);
        	frame.setLayout(new FlowLayout());
		JTextField textField = new JTextField(20);
        	frame.add(textField);
		JButton button = new JButton("Print String");
		frame.add(button);
		JLabel label = new JLabel();
		frame.add(label);
		
		Consumer<String> printString = input -> label.setText(input);
		ActionListener actionListener = e -> printString.accept(textField.getText());
		button.addActionListener(actionListener);
		
		frame.setVisible(true);
	}
}
