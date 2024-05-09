package Week6.Exercise2;

public class Main {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix();
        Matrix matrix2 = new Matrix();

        System.out.println("Enter elements for first matrix:");
        matrix1.inputMatrix();

        System.out.println("Enter elements for second matrix:");
        matrix2.inputMatrix();

        Matrix sum = matrix1.add(matrix2);
        System.out.println("Sum:\n" + sum);

        Matrix difference = matrix1.subtract(matrix2);
        System.out.println("Difference:\n" + difference);

        Matrix product = matrix1.multiply(matrix2);
        System.out.println("Product:\n" + product);
    }
}
