package Task7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIApplication {
    public static void main(String args[]){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setBounds(150,150,250,300);
        window.setLayout(new GridLayout(3, 1,10, 10));
        window.setResizable(false);

        JLabel counter = new JLabel("0", JLabel.RIGHT);
        counter.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        window.add(counter);

        JButton counter_plus = new JButton("+1");
        counter_plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int counterValue = Integer.valueOf(counter.getText());
                counter.setText(String.valueOf(++counterValue));
            }
        });
        counter_plus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        window.add(counter_plus);

        JButton counter_minus = new JButton("-1");
        counter_minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int counterValue = Integer.valueOf(counter.getText());
                counter.setText(String.valueOf(--counterValue));
            }
        });
        window.add(counter_minus);

        window.setVisible(true);

    }
}
