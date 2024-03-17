class BinomialHeapNode {

    int key, degree;
    BinomialHeapNode parent;
    BinomialHeapNode sibling;
    BinomialHeapNode child;

    // Конструктор класса
    public BinomialHeapNode(int k)
    {

        key = k;
        degree = 0;
        parent = null;
        sibling = null;
        child = null;
    }

    // Метод 1 (поворот)
    public BinomialHeapNode reverse(BinomialHeapNode sibl)
    {
        BinomialHeapNode ret;
        if (sibling != null)
            ret = sibling.reverse(this);
        else
            ret = this;
        sibling = sibl;
        return ret;
    }

    // Метод 2 (поиск минимального узла)
    public BinomialHeapNode findMinNode()
    {
        BinomialHeapNode x = this, y = this;
        int min = x.key;
        while (x != null) {
            if (x.key < min) {
                y = x;
                min = x.key;
            }
            x = x.sibling;
        }
        return y;
    }

    // Метод 3 (найти узел со значением ключа)
    public BinomialHeapNode findANodeWithKey(int value)
    {

        BinomialHeapNode temp = this, node = null;

        while (temp != null) {
            if (temp.key == value) {
                node = temp;
                break;
            }

            if (temp.child == null)
                temp = temp.sibling;

            else {
                node = temp.child.findANodeWithKey(value);
                if (node == null)
                    temp = temp.sibling;
                else
                    break;
            }
        }

        return node;
    }

    // Метод 4 (получить размер)
    public int getSize()
    {
        return (
                1 + ((child == null) ? 0 : child.getSize())
                        + ((sibling == null) ? 0 : sibling.getSize()));
    }
}
