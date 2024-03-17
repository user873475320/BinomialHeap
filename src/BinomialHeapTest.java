import java.util.Random;

public class BinomialHeapTest {
	private static final long SEED = 123123L;
	private static final long MAX_VAL = Long.MAX_VALUE;
	private static final Random RAND = new Random(SEED);
	private static long start;
	private static BinomialHeap binheap = new BinomialHeap();
	private static BinomialHeap binheap2 = new BinomialHeap();

	private static long rand(long max) {
		return RAND.nextLong();
	}

	private static void fill(int n) {
		for (int i = 0; i < n; i++)
			binheap.insert((int) rand(MAX_VAL));
	}

	private static void fill2(int n) {
		for (int i = 0; i < n; i++)
			binheap2.insert((int) rand(MAX_VAL));
	}

	private static void testDelete(int n) {
		for (int i = 0; i < n; i++)
			binheap.delete((int) rand(MAX_VAL));
	}


	void testInsert10() {
		binheap = new BinomialHeap();
		System.out.println("Test 1 - inserting 10 times");
		start = System.nanoTime();
		fill(10);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}


	void testInsert100() {
		binheap = new BinomialHeap();
		System.out.println("Test 2 - inserting 100 times");
		start = System.nanoTime();
		fill(100);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}


	void testInsert1000() {
		binheap = new BinomialHeap();
		System.out.println("Test 3 - inserting 1000 times");
		start = System.nanoTime();
		fill(1000);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}


	void testInsert10000() {
		binheap = new BinomialHeap();
		System.out.println("Test 4 - inserting 10000 times");
		start = System.nanoTime();
		fill(10000);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}


	void testInsert100000() {
		binheap = new BinomialHeap();
		System.out.println("Test 5 - inserting 100000 times");
		start = System.nanoTime();
		fill(100000);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}


	void testInsert1000000() {
		binheap = new BinomialHeap();
		System.out.println("Test 6 - inserting 1000000 times");
		start = System.nanoTime();
		fill(1000000);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}


	void testDelete10() {
		binheap = new BinomialHeap();
		System.out.println("Test 7 - deleting 10 times");
		fill(20);
		start = System.nanoTime();
		testDelete(10);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}


	void testDelete100() {
		binheap = new BinomialHeap();
		System.out.println("Test 8 - deleting 100 times");
		fill(120);
		start = System.nanoTime();
		testDelete(100);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}


	void testDelete1000() {
		binheap = new BinomialHeap();
		System.out.println("Test 9 - deleting 1000 times");
		fill(1200);
		start = System.nanoTime();
		testDelete(1000);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}


	void testDelete10000() {
		binheap = new BinomialHeap();
		System.out.println("Test 10 - deleting 10000 times");
		fill(12000);
		start = System.nanoTime();
		testDelete(10000);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}


	void testDelete30000() {
		binheap = new BinomialHeap();
		System.out.println("Test 11 - deleting 30000 times");
		fill(32000);
		start = System.nanoTime();
		testDelete(30000);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}


	void testDelete50000() {
		binheap = new BinomialHeap();
		System.out.println("Test 12 - deleting 50000 times");
		fill(52000);
		start = System.nanoTime();
		testDelete(50000);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}


	void testMerge10000() {
		binheap = new BinomialHeap();
		binheap2 = new BinomialHeap();
		System.out.println("Test 13 - merging 10000");
		fill(10000);
		fill2(10000);

		start = System.nanoTime();
		binheap.merge(binheap2.Nodes);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}


	void testMerge100000() {
		binheap = new BinomialHeap();
		binheap2 = new BinomialHeap();
		System.out.println("Test 14 - merging 100000");
		fill(100000);
		fill2(100000);

		start = System.nanoTime();
		binheap.merge(binheap2.Nodes);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}


	void testMerge300000() {
		binheap = new BinomialHeap();
		binheap2 = new BinomialHeap();
		System.out.println("Test 15 - merging 300000");
		fill(300000);
		fill2(300000);

		start = System.nanoTime();
		binheap.merge(binheap2.Nodes);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}


	void testMerge500000() {
		binheap = new BinomialHeap();
		binheap2 = new BinomialHeap();
		System.out.println("Test 16 - merging 500000");
		fill(500000);
		fill2(500000);

		start = System.nanoTime();
		binheap.merge(binheap2.Nodes);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}


	void testMerge700000() {
		binheap = new BinomialHeap();
		binheap2 = new BinomialHeap();
		System.out.println("Test 17 - merging 700000");
		fill(700000);
		fill2(700000);

		start = System.nanoTime();
		binheap.merge(binheap2.Nodes);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}


	void testMerge1000000() {
		binheap = new BinomialHeap();
		binheap2 = new BinomialHeap();
		System.out.println("Test 18 - merging 1000000 times");
		fill(1000000);
		fill2(1000000);

		start = System.nanoTime();
		binheap.merge(binheap2.Nodes);
		System.out.println("Time: " + (System.nanoTime() - start) + " nanoseconds");
	}

}
