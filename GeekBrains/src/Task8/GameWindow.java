package Task8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    public GameWindow(){
        setTitle("Tic Tac Toe");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150,150, 306, 329);
        setResizable(false);
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));

        JButton firstType = new JButton("Player vs Computer");
        firstType.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        firstType.setAlignmentY(JComponent.TOP_ALIGNMENT);
        firstType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new GameField(true));
                setVisible(true);
            }
        });


        JButton secondType = new JButton("Player vs Player");
        secondType.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        secondType.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        secondType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new GameField(false));
                setVisible(true);
            }
        });

        menu.add(firstType);
        menu.add(secondType);
        getContentPane().add(menu);

        setVisible(true);


    }
}
