package code.structure.workforce.service.service;

public class WorkforceManager {

	private int structureSize;
	private int seniorCapacity;
	private int juniorCapacity;
	private int[] arrangement;

	public WorkforceManager(int structureSize, int seniorCapacity, int juniorCapacity) {
		System.out.println("Processing structureSize : " + structureSize);
		this.structureSize = structureSize;
		this.seniorCapacity = seniorCapacity;
		this.juniorCapacity = juniorCapacity;
		arrangeWorkforce();
		printArrangement();
	}

	public int getSeniorCount() {
		return getCount(seniorCapacity);
	}

	public int getJuniorCount() {
		return getCount(juniorCapacity);
	}

	private void arrangeWorkforce() {
		int arraySize = (structureSize / seniorCapacity) + 1;
		arrangement = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			for (int j = 0; j < arraySize; j++) {
				arrangement[j] = i >= j ? seniorCapacity : juniorCapacity;
			}
			if (computeWorkforceCapacity() >= structureSize) {
				return;
			}
		}
	}

	private int computeWorkforceCapacity() {
		int workforceCapacity = 0;
		for (int i = 0; i < arrangement.length; i++) {
			workforceCapacity += arrangement[i];
		}
		return workforceCapacity;
	}

	private int getCount(int capacity) {
		int count = 0;
		for (int colIdx = 0; colIdx < arrangement.length; colIdx++) {
			if (capacity == arrangement[colIdx]) {
				count++;
			}
		}
		return count;
	}

	private void printArrangement() {
		System.out.print("Optimal arrangement with minimum one senior : ");
		for (int capacity : arrangement) {
			System.out.printf("%-4d", capacity);
		}
		System.out.println();
	}
}
