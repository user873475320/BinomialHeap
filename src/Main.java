public class Main {
	public static void main(String[] args) {
		BinomialHeapTest binomialHeapTest = new BinomialHeapTest();
		binomialHeapTest.testInsert10();
		binomialHeapTest.testInsert100();
		binomialHeapTest.testInsert1000();
		binomialHeapTest.testInsert10000();
		binomialHeapTest.testInsert100000();
		binomialHeapTest.testInsert1000000();
		binomialHeapTest.testDelete10();
		binomialHeapTest.testDelete100();
		binomialHeapTest.testDelete1000();
		binomialHeapTest.testDelete10000();
		binomialHeapTest.testDelete30000();
		binomialHeapTest.testDelete50000();
		binomialHeapTest.testMerge10000();
		binomialHeapTest.testMerge100000();
		binomialHeapTest.testMerge300000();
		binomialHeapTest.testMerge500000();
		binomialHeapTest.testMerge700000();
		binomialHeapTest.testMerge1000000();
	}
}
