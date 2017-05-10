package zhanw.test;

public class SortExamples {
	public static void main(String[] args) {
		int[] arr = new int[]{3,53,32,43,21,34,54,23,6,232,214};
//		insertSort(arr);
//		bubbleSort(arr);
		selectionSort(arr);
		for(int i : arr){
			System.out.println(i);
		}
		System.out.println("find in index : " + binarySearch(arr, 54));
	}
	
	/**
	 * 插入排序，最坏的情况下复杂度为O(N^2),
	 * 最好的情况下是序列已经是升序排列了，需要进行的比较操作只需n-1次复杂度O(N)
	 * <br/>
	 * 因而，插入排序不适合对于数据量比较大的排序应用。
	 * 但是，如果需要排序的数据量很小，例如，量级小于千，那么插入排序还是一个不错的选择。
	 *  插入排序在工业级库中也有着广泛的应用
	 *  
	 *  <br/>
	 *  它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
	 *  具有n个元素时它需要经过n-1趟排序。
	 *  对于p = 1到p = n-1趟，插入排序保证从位置0到位置p上的元素为已排序状态
	 *  
	 * @param arr
	 */
	static void insertSort(int[] arr){
		int j;
		for(int p = 1; p < arr.length; p++){
			int temp = arr[p]; //记住可能要移动的值
			for(j = p; j > 0 && temp < arr[j-1]; j--){
				//直到不符合条件，j坐标都已经赋了值，j-1还是原来的值，
				arr[j] = arr[j-1]; 
			}
			arr[j] = temp; //，j最后进行了--操作，所以把-1的j坐标的值= temp
		}
	}
	
	/**
	 * 冒泡排序
	 * 
	 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
	 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
	 * 针对所有的元素重复以上的步骤，除了最后一个。
	 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
	 * 
	 * @param arr
	 */
	static void bubbleSort(int[] arr){
		for(int i = 1; i < arr.length; i++){
			for(int j = 0; j < arr.length - i; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * 选择排序
	 * 
	 * 找到最小的,然后依次放到(交换位置)0,1,2,3...
	 * @param arr
	 */
	static void selectionSort(int[] arr){
		for(int i = 0; i < arr.length - 1; i++){
			int minIndex = i;
			for(int j = i + 1; j < arr.length; j++){
				if(arr[j] < arr[minIndex]){
					//只需要改变最小值角标就行，不用交换值
					//后面的继续和这个min值做对比，直到找到最小值的index
					minIndex = j; 
				}
			}
			
			if(minIndex > i){ //交换和最小值的位置
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
			
		}
	}
	
	/**
	 * 二分查找,O(logn)
	 */
	static int binarySearch(int[] arr, int key){
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right){
//			int mid = (left + right) /2;
			int mid = left + (right - left) /2;
			if(arr[mid] == key){
				return mid;	
			}else if(arr[mid] > key){
				right = mid -1;
			}else{
				left = mid + 1;
			}
			
		}
		return -1;
	}
}
