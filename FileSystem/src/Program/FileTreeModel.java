package Program;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.io.File;
import java.util.ArrayList;

public class FileTreeModel implements TreeModel {



    protected File root;
    private ArrayList<File> rootList = new ArrayList();


    public FileTreeModel(){
        setRootList();
    }

    @Override
    public Object getRoot() {
        return root;
    }

    private void setRootList(){
        File[] roots = File.listRoots();
        for (File root : roots){
            this.rootList.add(root);
        }
    }
//
//    private final int getRootChild(Object node)
//    {
//        int idx = -1;
//        for (int i = 0; i < rootList.size(); i++){
//            if (rootList.get(i) == node) {
//                idx = i;
//                break;
//            }
//        }
//        return idx;
//    }

    @Override
    public Object getChild(Object parent, int index) {
        String[] child = ((File)parent).list();
        if ((child == null) || (index >= child.length)) return null;
        return new File((File)parent, child[index]);
    }

    @Override
    public int getChildCount(Object parent) {
        String[] child = ((File)parent).list();
        if (child == null) return 0;
        return child.length;
    }

    @Override
    public boolean isLeaf(Object node) {
        return ((File)node).isFile();
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {

    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        String[] children = ((File)parent).list();
        if (children == null) return -1;
        String childName = ((File)child).getName();
        for(int i = 0; i < children.length; i++) {
            if (childName.equals(children[i])) return i;
        }
        return -1;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {

    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {

    }
}
