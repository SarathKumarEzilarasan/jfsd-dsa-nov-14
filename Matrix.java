import java.util.ArrayList;
import java.util.List;

public class Matrix {

    public static int[][] setZeros(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        boolean rowZero = false;
        boolean colZero = false;

        for (int i = 0; i < rows; i++) {
            if (arr[i][0] == 0) {
                colZero = true;
                break;
            }
        }

        for (int i = 0; i < cols; i++) {
            if (arr[0][i] == 0) {
                rowZero = true;
                break;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        if (colZero) {
            for (int i = 1; i < rows; i++) {
                arr[i][0] = 0;
            }
        }

        if (rowZero) {
            for (int i = 1; i < cols; i++) {
                arr[0][i] = 0;
            }
        }

        return arr;
    }

    public static List<Integer> spiral(int[][] arr) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        int top = 0, bottom = arr.length - 1;
        int left = 0, right = arr[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(arr[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(arr[i][right]);
            }
            right--;
            for (int i = right; i >= left; i--) {
                result.add(arr[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                result.add(arr[i][left]);
            }
            left++;
        }
        return result;
    }

    public static int[][] rotate(int[][] arr) {
        arr = transpose(arr);

        //reverse each row
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][n - 1 - j];
                arr[i][n - 1 - j] = temp;
            }
        }
        return arr;
    }

    public static int[][] transpose(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        return arr;
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };
        print(setZeros(arr));

    }
}
