package Lesson13;

public class Main {
    public static void main(String[] args) {
        double[][] numsForA = {{1, 4, 3,},
                               {2, 1, 5,},
                               {3, 2, 1,}};
        Matrix a = new Matrix(numsForA);
//        System.out.println(a.getRows());
//        System.out.println(a.getColumns());;
//        System.out.println(a.getValueAt(0,3));
////        a.setValueAt(0,0,15);
//        System.out.println(a.getValueAt(0,0));

        double[][] numsForB = {{1, 0,},
                               {0, 1,},
                               {0, 0,}};
        Matrix b = new Matrix(numsForB);

        IMatrix resultAdd = a.mul(b);
       resultAdd.printToConsole();
        System.out.println("------------");
        IMatrix resultmul = a.mul(2);
        resultmul.printToConsole();
        System.out.println("------------");
        IMatrix resultTranspose = a.transpose();
        resultTranspose.printToConsole();
        System.out.println("------------");
        a.fillMatrix(3);
        a.printToConsole();
        b.isNullMatrix();
//        b.isSquareMatrix();
        b.isIdentityMatrix();

    }
}
