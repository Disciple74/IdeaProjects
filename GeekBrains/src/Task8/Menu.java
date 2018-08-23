package Task8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {

    public Menu(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JButton firstType = new JButton("Player vs Computer");
        firstType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(new GameField(true));
                setVisible(true);
            }
        });
        firstType.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        firstType.setAlignmentY(JComponent.TOP_ALIGNMENT);

        JButton secondType = new JButton("Player vs Player");
        secondType.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        secondType.setAlignmentY(JComponent.CENTER_ALIGNMENT);

        JButton exit = new JButton("Exit");
        exit.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        exit.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(firstType);
        add(secondType);
        add(exit);
    }


}
