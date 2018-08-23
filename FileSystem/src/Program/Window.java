package Program;

import javax.swing.*;
import java.io.File;

public class Window extends JFrame {



    public Window(){
        setTitle("FileSystem");
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500,500);
        JTree tree = new JTree();

        FileTreeModel model = new FileTreeModel();
        tree.setRootVisible(true);
        tree.setModel(model);


        JScrollPane scrollPane = new JScrollPane(tree);
        getContentPane().add(scrollPane, "Center");
    }

}
