class BinomialHeap {

	public BinomialHeapNode Nodes;
	private int size;

	public BinomialHeap() {
		Nodes = null;
		size = 0;
	}

	public boolean isEmpty() {
		return Nodes == null;
	}

	// Метод 1 (получение размера кучи)
	public int getSize() {
		return size;
	}

	// Метод 2 (очистка кучи)
	public void makeEmpty() {
		Nodes = null;
		size = 0;
	}

	// Метод 3 (вставка)
	public void insert(int value) {
		if (value > 0) {
			BinomialHeapNode temp = new BinomialHeapNode(value);
			if (Nodes == null) {
				Nodes = temp;
				size = 1;
			} else {
				unionNodes(temp);
				size++;
			}
		}
	}

	// Метод 4 (объединение двух биномиальных куч)
	public void merge(BinomialHeapNode binHeap) {
		BinomialHeapNode temp1 = Nodes, temp2 = binHeap;

		while ((temp1 != null) && (temp2 != null)) {

			if (temp1.degree == temp2.degree) {

				BinomialHeapNode tmp = temp2;
				temp2 = temp2.sibling;
				tmp.sibling = temp1.sibling;
				temp1.sibling = tmp;
				temp1 = tmp.sibling;
			} else {

				if (temp1.degree < temp2.degree) {

					if ((temp1.sibling == null) || (temp1.sibling.degree > temp2.degree)) {
						BinomialHeapNode tmp = temp2;
						temp2 = temp2.sibling;
						tmp.sibling = temp1.sibling;
						temp1.sibling = tmp;
						temp1 = tmp.sibling;
					} else {
						temp1 = temp1.sibling;
					}
				} else {
					BinomialHeapNode tmp = temp1;
					temp1 = temp2;
					temp2 = temp2.sibling;
					temp1.sibling = tmp;

					if (tmp == Nodes) {
						Nodes = temp1;
					}
				}
			}
		}

		if (temp1 == null) {
			temp1 = Nodes;

			while (temp1.sibling != null) {
				temp1 = temp1.sibling;
			}
			temp1.sibling = temp2;
		}
	}

	// Метод 5 (для объединения узлов)
	private void unionNodes(BinomialHeapNode binHeap) {
		merge(binHeap);

		BinomialHeapNode prevTemp = null, temp = Nodes,
				nextTemp = Nodes.sibling;

		while (nextTemp != null) {

			if ((temp.degree != nextTemp.degree)
					|| ((nextTemp.sibling != null)
					&& (nextTemp.sibling.degree
					== temp.degree))) {
				prevTemp = temp;
				temp = nextTemp;
			} else {

				if (temp.key <= nextTemp.key) {
					temp.sibling = nextTemp.sibling;
					nextTemp.parent = temp;
					nextTemp.sibling = temp.child;
					temp.child = nextTemp;
					temp.degree++;
				} else {

					if (prevTemp == null) {
						Nodes = nextTemp;
					} else {
						prevTemp.sibling = nextTemp;
					}

					temp.parent = nextTemp;
					temp.sibling = nextTemp.child;
					nextTemp.child = temp;
					nextTemp.degree++;
					temp = nextTemp;
				}
			}
			nextTemp = temp.sibling;
		}
	}

	// Метод 6 (возвращение минимального ключа)
	public int findMinimum() {
		return Nodes.findMinNode().key;
	}

	// Метод 7 (удаление определенного элемента)
	public void delete(int value) {
		if ((Nodes != null) && (Nodes.findANodeWithKey(value) != null)) {
			decreaseKeyValue(value, findMinimum() - 1); // уменьшение ключа до минимально возможного значения
			extractMin(); // удаление минимального элемента
		}
	}

	// Метод 8 (изменение значения)
	public void decreaseKeyValue(int old_value, int new_value) {
		BinomialHeapNode temp = Nodes.findANodeWithKey(old_value);
		if (temp == null)
			return;
		temp.key = new_value;
		BinomialHeapNode tempParent = temp.parent;

		while ((tempParent != null) && (temp.key < tempParent.key)) {
			int z = temp.key;
			temp.key = tempParent.key;
			tempParent.key = z;

			temp = tempParent;
			tempParent = tempParent.parent;
		}
	}

	// Метод 9 (извлечение узла с минимальным ключом)
	public int extractMin() {
		if (Nodes == null)
			return -1;

		BinomialHeapNode temp = Nodes, prevTemp = null;
		BinomialHeapNode minNode = Nodes.findMinNode();

		while (temp.key != minNode.key) {
			prevTemp = temp;
			temp = temp.sibling;
		}

		if (prevTemp == null) {
			Nodes = temp.sibling;
		} else {
			prevTemp.sibling = temp.sibling;
		}

		temp = temp.child;
		BinomialHeapNode fakeNode = temp;

		while (temp != null) {
			temp.parent = null;
			temp = temp.sibling;
		}

		if ((Nodes == null) && (fakeNode == null)) {
			size = 0;
		} else {
			if ((Nodes == null) && (fakeNode != null)) {
				Nodes = fakeNode.reverse(null);
				size = Nodes.getSize();
			} else {
				if ((Nodes != null) && (fakeNode == null)) {
					size = Nodes.getSize();
				} else {
					unionNodes(fakeNode.reverse(null));
					size = Nodes.getSize();
				}
			}
		}

		return minNode.key;
	}

	// Метод 10 (отображение кучи)
	public void displayHeap() {
		System.out.print("\nHeap : ");
		displayHeap(Nodes);
		System.out.println("\n");
	}

	private void displayHeap(BinomialHeapNode r) {
		if (r != null) {
			displayHeap(r.child);
			System.out.print(r.key + " ");
			displayHeap(r.sibling);
		}
	}
}