package Week6.Exercise2;

import java.util.Scanner;
public class Matrix {
    int[][] arr;
    Matrix() {
        arr = new int[2][2];
    }

    public void inputMatrix() {
        System.out.println("Enter the elements of the matrix (2x2:");
        Scanner sc = new Scanner(System.in);

        this.arr[0][0] = sc.nextInt();
        this.arr[0][1] = sc.nextInt();
        this.arr[1][0] = sc.nextInt();
        this.arr[1][1] = sc.nextInt();
    }

    public Matrix add(Matrix other) {
        Matrix n = new Matrix();
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                n.arr[i][j] = this.arr[i][j] + other.arr[i][j];
            }
        }

        return n;
    }
    public Matrix subtract(Matrix other) {
        Matrix n = new Matrix();
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                n.arr[i][j] = this.arr[i][j] - other.arr[i][j];
            }
        }

        return n;
    }

    public Matrix multiply(Matrix other) {
        Matrix n = new Matrix();

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                n.arr[i][j] = 0;
                for(int k = 0; k < 2; k++) {
                    n.arr[i][j] += this.arr[i][k] * other.arr[k][j];
                }
            }
        }

        return n;
    }

    public String toString() {
        return arr[1][1] + " " + arr[1][0] + "\n" + arr[0][1] + " " + arr[0][0];
    }

}
