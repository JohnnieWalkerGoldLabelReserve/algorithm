package tree;

/**
 * @author zhaoyang
 * @date 2022/9/3 12:36 下午
 */
public class BSTSet implements Set {

    private BinarySearchTree bst;

    public BSTSet() {
        bst = new BinarySearchTree();
    }

    @Override
    public void add(int val) {
        bst.add(val);
    }

    @Override
    public void remove(int val) {
        bst.remove(val);
    }

    @Override
    public boolean contains(int val) {
        return bst.contains(val);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public static void main(String[] args) {
        BSTSet set = new BSTSet();
        for (int i = 0; i <10 ; i++) {
            set.add(i);
            set.add(i);
            set.add(i);
        }
        System.err.println(set.getSize());
    }
}
