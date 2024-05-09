package Week7;

import java.util.Scanner;

public class Practice1 {
    public static int[][] drawSnail(int n) {
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = 0;
            }
        }
        int[][] directions = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        int cur_idx = 0;
        int row = 0, col = 0;
        int number = 1;

        while(number <= n*n) {
            arr[row][col] = number++;
            int next_row = row + directions[cur_idx][0];
            int next_col = col + directions[cur_idx][1];

            if((next_row >= 0 && next_row < n) && (next_col >= 0 && next_col < n) && arr[next_row][next_col] == 0) {
                row = next_row;
                col = next_col;
            } else {
                cur_idx++;
                cur_idx%=4;
                row += directions[cur_idx][0];
                col += directions[cur_idx][1];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a matrix size n: ");
        int n = sc.nextInt();
        int[][] Snail = drawSnail(n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.printf("%4d", Snail[i][j]);
            }
            System.out.println();
        }
    }
}
