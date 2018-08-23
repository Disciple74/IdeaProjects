package Task7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KeyboardAndMouseTester {
    public static void main(String args[]){
        JFrame window = new JFrame();
        GridBagLayout gbl = new GridBagLayout();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setBounds(150,150,500,500);
        window.setLayout(gbl);
        window.setTitle("Keyboard and Mouse Tester");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NORTH;
        c.anchor = GridBagConstraints.NORTH;



        JLabel firstLabel = new JLabel("Number pressed: [0]");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.ipady = 25;
        firstLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        gbl.setConstraints(firstLabel, c);
        window.add(firstLabel, c);

        JLabel secondLabel = new JLabel("Mouse clicked: [X: x; Y: y]");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.ipady = 25;
        secondLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        gbl.setConstraints(secondLabel, c);
        window.add(secondLabel, c);

        JPanel panel = new JPanel();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = 1;
        c.gridheight = 2;
        c.gridwidth = 2;
        c.weightx = 1.0;
        c.weighty = 1.0;
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX(), y = e.getY();
                secondLabel.setText("Mouse clicked: [X: " + x + "; Y:" + y +"]");

            }
        });
        gbl.setConstraints(panel, c);

        window.add(panel);
        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' && !e.isControlDown() && !e.isShiftDown() && !e.isAltDown()) {
                    firstLabel.setText("Number pressed: [" + String.valueOf(e.getKeyChar()) + "]");
                }
            }
        });

        window.setVisible(true);
    }
}
