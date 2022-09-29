import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttemptsInGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JLabel label = new JLabel("Guess a number between 1 and 10");
        frame.add(label);

        final int[] random = {(int) (Math.random() * 10 + 1)};

        JTextField textField = new JTextField(10);
        frame.add(textField);

        JButton button = new JButton("Guess");
        frame.add(button);

        JLabel result = new JLabel();
        frame.add(result);

        final int[] attempts = {0};
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int guess = Integer.parseInt(textField.getText());
                attempts[0]++;
                if (guess == random[0]) {
                    result.setText("You guessed right! Attempts: " + attempts[0]);
                    textField.setEditable(false);
                    button.setEnabled(false);
                    textField.setText("");
                } else {
                    result.setText("You guessed wrong! Attempts: " + attempts[0]);
                    textField.setText("");
                }
            }
        });

        JButton reset = new JButton("Reset");
        frame.add(reset);
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                random[0] = (int) (Math.random() * 10 + 1);
                attempts[0] = 0;
                result.setText("Attempts: " + attempts[0]);
                textField.setEditable(true);
                button.setEnabled(true);
            }
        });
    }
}