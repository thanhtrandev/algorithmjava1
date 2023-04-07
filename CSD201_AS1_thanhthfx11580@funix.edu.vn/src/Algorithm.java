import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Algorithm {

	// Khai báo lớp Scanner và các biến cần thiết
	Scanner sc = new Scanner(System.in);
	private float[] arr;
	private int n;

	public Algorithm() {
	}

	// Hàm nhập mảng arr
	public float[] inputArray() {
		System.out.print("Input number of elements: ");
		n = sc.nextInt();

		// Điều kiện đúng khi nhập giá trị n
		if (n > 20) {
			System.out.println("The maximum number of elements in the array is 20, please re-enter");
			n = sc.nextInt();
		}

		// tạo lại mảng a toàn cục theo kích thước mới
		arr = new float[n];
		System.out.print("Input elements: \n");
		for (int i = 0; i < n; i++) {
			System.out.printf("Number " + (i + 1) + " = ");
			arr[i] = sc.nextInt();

		}
		return arr;
	}

	// In giá trị các bước sắp xếp ra màn hình
	public void display(float[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}

	// Hàm ghi dữ liệu mảng vào file
	public void writeFile(float arr[], String path) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			for (float f : arr) {
				bw.write(String.valueOf(f + "\t"));
			}
			bw.newLine();
			bw.close();
		} catch (Exception e) {

		}

	}

	// Hàm Ghi dữ liệu chuỗi vào file
	public void writeStringFile(String found, String path) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

			bw.write(found);
			bw.close();

		} catch (Exception e) {

		}
	}

	// Hàm đọc dữ liệu đã được ghi
	public void readFile(float arr[]) {
		try {
			FileReader fr = new FileReader("D://input.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";

			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}

				System.out.println(line);
			}

		} catch (Exception e) {

		}
	}

	// Hàm hoán vị
	public static void swap(int i, int k, float[] arr) {
		float x;
		x = arr[i];
		arr[i] = arr[k];
		arr[k] = x;
	}

	// Hàm sắp xếp nổi bọt
	public float[] bubbleSort(float arr[], boolean displaySteps) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(j, j + 1, arr);
				}
			}

			System.out.println("Vong lap thu " + (i + 1));

			if (displaySteps) {

				display(arr);

			}

		}

		return arr;

	}

	// Sắp xếp lựa chọn
	public float[] selectionSort(float arr[], boolean displaySteps) {
		// Duyệt qua từng phần tử của mảng
		for (int i = 0; i < arr.length - 1; i++) {

			// Tìm phần tử nhỏ nhất trong mảng chưa được sắp xếp
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			// Hoán đổi phần tử nhỏ nhất và phần tử đầu tiên
			int temp = (int) arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;

			System.out.println("Vong lap thu " + (i + 1));

			if (displaySteps) {

				// In các bước sắp xếp
				display(arr);
			}
		}

		return arr;

	}

	// Sắp xếp chèn
	public float[] insertionSort(float arr[], boolean displaySteps) {
		int valueToInsert;
		int holePosition;
		int i;

		// lặp qua các giá trị của mảng
		for (i = 1; i < arr.length; i++) {

			// Chọn một giá trị để chèn
			valueToInsert = (int) arr[i];

			// Lựa chọn vị trí để chèn
			holePosition = i;

			// Kiểm tra xem số liền trước có lớn hơn giá trị được chèn không
			while (holePosition > 0 && arr[holePosition - 1] > valueToInsert) {
				arr[holePosition] = arr[holePosition - 1];
				holePosition--;
				System.out.println("Di chuyen phan tu: " + arr[holePosition]);
			}

			if (holePosition != i) {
				System.out.println(" Chen phan tu: " + valueToInsert + ", tai vi tri: " + holePosition);
				// Chèn phần tử tại vị trí chèn
				arr[holePosition] = valueToInsert;
			}

			System.out.println("Vong lap thu " + i);

			if (displaySteps) {

				// In ra từng bước sắp xếp
				display(arr);

			}
		}

		return arr;
	}
	
	// Tìm kiếm tuyến tính.
	public void search(float arr[], float value) {
		String found = "";
		boolean check = false;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (arr[i] > value) {

				found = found.concat(arr[i] + "\t");
				check = true;
				System.out.println(arr[i] + "\t");

				writeStringFile(found, "D://output4.txt");
			}

		}

		if (!check) {
			System.out.println("There is no value greater than " + value + " in the array. ");
		}

	}

	// Tìm kiếm nhị phân
	public int binarySearch(float arr[], int left, int right, float value) {
		if (right >= left) {
			int mid = left + (right - left) / 2;

			// Nếu phần tử có ở chính giữa
			if (arr[mid] == value)
				return mid;

			// Nếu phần tử nhỏ hơn mid, thì giá trị chỉ có thể
			// hiện diện trong mảng con bên trái
			if (arr[mid] > value)
				return binarySearch(arr, left, mid - 1, value);

			// Ngược lại, phần tử chỉ có thể có mặt
			// trong mảng con bên phải
			return binarySearch(arr, mid + 1, right, value);
		}

		// Nếu phần tử không có trong mảng
		return -1;
	}

}
