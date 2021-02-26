public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** Return the size of the list using... recursion! */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    //难点在于怎么删除节点，有两个节点可以删，删第一个比较难，删后面的简单(p.rest = p.rest.rest)
    //这个问题相当于就是两倍一个节点，删除一个节点。
    public void addAdjacent() {
        IntList p = this;
        while(p.rest != null) {
            if(p.first == p.rest.first){
                p.first = p.first * 2;
                p.rest = p.rest.rest;
            }
            p = p.rest;
        }
    }

    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /** Returns the ith item of this IntList. */
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    //难点就是在于学会怎么插入节点，然后要注意一下指针不会越界。
    public void insert(int i) {
        IntList p = this;
        while (p != null) {
            IntList square = new IntList(p.first * p.first, p.rest);
            p.rest = square;
            p = p.rest;
            if(p.rest == null){
                IntList tmp = new IntList(i,null );
                p.rest = tmp;
                return;
            }
            p = p.rest;
        }

    }
    public static void main (String[] args) {
        IntList L = new IntList(2, null);
        L = new IntList(1, L);

        L.insert(5);
        L.insert(7);
    }
}