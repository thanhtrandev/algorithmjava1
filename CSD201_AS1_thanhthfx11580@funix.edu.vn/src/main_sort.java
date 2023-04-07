import java.io.FileWriter;
import java.util.Scanner;

public class main_sort {

	// Hàm main
	public static void main(String[] args) {
		Algorithm al = new Algorithm();
		int choose = 0;
		float[] arrB = null;
		double start, end;
		float searchKey;

		// Sử dụng DO - WHILE để chọn lại chức năng từ menu
		do {
			Scanner sc = new Scanner(System.in);
			menu();
			System.out.print("Choose 0 - 7: ");
			choose = sc.nextInt();

			// Sử dụng SWITCH CASE để thực hiện từng chức năng.
			switch (choose) {

			case 0:
				System.exit(0);
				return;

			// Bước nhập giá trị mảng và ghi file
			case 1:
				arrB = al.inputArray();
				al.writeFile(arrB, "D://input.txt");
				break;

			// Bước đọc file đã được ghi lại
			case 2:
				al.readFile(arrB);
				break;

			// Bước sắp xếp nổi bọt và ghi file mới cho mảng
			case 3:
				start = System.currentTimeMillis();
				al.bubbleSort(arrB, true);
				end = System.currentTimeMillis();
				System.out.println("Bubble Sort's execution time: " + (end - start) + " ms");
				al.writeFile(arrB, "D://output1.txt");
				break;

			// Bước sắp xếp lựa chọn và ghi file mới cho mảng
			case 4:
				start = System.currentTimeMillis();
				al.selectionSort(arrB, true);
				end = System.currentTimeMillis();
				System.out.println(start);
				System.out.println(end);
				System.out.println("Selection Sort's execution time: " + (end - start) + " ms");
				al.writeFile(arrB, "D://output2.txt");
				break;

			// Bước sắp xếp chèn và ghi file mới cho mảng
			case 5:
				start = System.currentTimeMillis();
				al.insertionSort(arrB, true);
				end = System.currentTimeMillis();
				System.out.println("insertion Sort's execution time: " + (end - start) + " ms");
				al.writeFile(arrB, "D://output3.txt");
				break;

			// Bước tìm kiếm tuyến tính và in ra các giá trị lớn hơn giá trị được tìm kiếm

			case 6:
				System.out.println("Linear search: ");
				System.out.print("Input search key: ");
				searchKey = sc.nextFloat();
				System.out.print("Elements greater than  " + searchKey + " in the array: " + "\n");
				al.search(arrB, searchKey);
				break;

			// Bước tìm kiếm nhị nhân
			case 7:
				String found = "";
				System.out.println("Binary search: ");
				System.out.print("Input search key: ");
				searchKey = sc.nextFloat();
				int n = arrB.length;
				int result = al.binarySearch(arrB, 0, n - 1, searchKey);

				if (result == -1) {
					System.out.println("Result not found.");
					found = found.concat("Result not found.");
				} else
					System.out.println("Element " + searchKey + " found at position: " + result);
				found = found.concat("Element " + searchKey + " found at position: " + result);
				al.writeStringFile(found, "D://output5.txt");
				break;
			}

		} while (choose != 0);

	}
	
	// Hàm in chức năng menu.
	public static void menu() {
		System.out.println("+----------------Menu--------------+");
		System.out.printf("%-10s%-25s%s", "|", "1.Input", "|\n");
		System.out.printf("%-10s%-25s%s", "|", "2.Output", "|\n");
		System.out.printf("%-10s%-25s%s", "|", "3.Bubble sort", "|\n");
		System.out.printf("%-10s%-25s%s", "|", "4.Selection sort", "|\n");
		System.out.printf("%-10s%-25s%s", "|", "5.Insertion sort", "|\n");
		System.out.printf("%-10s%-25s%s", "|", "6.Search > value", "|\n");
		System.out.printf("%-10s%-25s%s", "|", "7.Search = value", "|\n");
		System.out.printf("%-10s%-25s%s", "|", "0.Exit", "|\n");
		System.out.println("+----------------------------------+");

	}
}
