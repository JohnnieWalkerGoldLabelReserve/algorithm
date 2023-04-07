package tree;


public class SegmentTree {

    private int[] data;
    private int[] tree;
    private int size;

    public SegmentTree(int[] arr) {
        this.data = new int[arr.length];
        System.arraycopy(arr, 0, this.data, 0, arr.length);
        this.tree = new int[data.length * 4];
        buildSegmentTree(0, 0, data.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int leftBound, int rightBound) {
        if (leftBound == rightBound) {
            this.tree[treeIndex] = data[leftBound];
            return;
        }
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        int middle = (rightBound - leftBound) / 2 + leftBound;
        buildSegmentTree(leftIndex, leftBound, middle);
        buildSegmentTree(rightIndex, middle + 1, rightBound);
        tree[treeIndex] = merge(tree[leftIndex], tree[rightIndex]);
    }

    public int query(int queryL, int queryR) {
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    private int query(int currentIndexTree, int leftBound, int rightBound, int queryL, int queryR) {
        if (queryL == leftBound && queryR == rightBound) {
            return tree[currentIndexTree];
        }
        int middle = (rightBound - leftBound) / 2 + leftBound;
        int leftIndex = leftChild(currentIndexTree);
        int rightIndex = rightChild(currentIndexTree);
        if (queryL >= middle + 1) {
            return query(rightIndex, middle + 1, rightBound, queryL, queryR);
        } else if (queryR <= middle) {
            return query(leftIndex, leftBound, middle, queryL, queryR);
        }
        int leftResult = query(leftIndex, leftBound, middle, queryL, middle);
        int rightResult = query(rightIndex, middle + 1, rightBound, middle + 1, queryR);
        return leftResult + rightResult;
    }


    public int merge(int a, int b) {
        return a + b;
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int right) {
        return right * 2 + 2;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : tree) {
            sb.append(i);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SegmentTree segmentTree = new SegmentTree(new int[]{-2, 0, 3, -5, 2, -1});
        //SegmentTree segmentTree = new SegmentTree(new int[]{-2, 0, 3, 4});
        System.err.println(segmentTree.query(2, 3));
    }

}
