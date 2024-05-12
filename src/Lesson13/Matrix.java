package Lesson13;

public class Matrix implements IMatrix {
    private double nums[][];

    public Matrix() {
        nums = new double[DEFAULT_MATRIX_SIZE][DEFAULT_MATRIX_SIZE];
    }

    public Matrix(double[][] nums) {
        this.nums = nums;
    }

    public Matrix(int row, int columns) {
        nums = new double[row][columns];
    }

    @Override
    public int getRows() {
        return nums.length;
    }

    @Override
    public int getColumns() {
        return nums[0].length;
    }

    @Override
    public double getValueAt(int rowIndex, int colIndex) throws IndexOutOfBoundsException {
        if (rowIndex < 0 || rowIndex >= getRows()) {
            System.out.println("rowIndex не подходит");
            return -1;
        }
        if (colIndex < 0 || colIndex >= getColumns()) {
            System.out.println("colIndex не подходит");
            return -1;
        }
        return nums[rowIndex][colIndex];
    }

    @Override
    public void setValueAt(int rowIndex, int colIndex, double value) throws IndexOutOfBoundsException {
        if (rowIndex < 0 || rowIndex >= getRows()) {
            System.out.println("rowIndex не подходит");
            return;
        }
        if (colIndex < 0 || colIndex >= getColumns()) {
            System.out.println("colIndex не подходит");
            return;
        }
        nums[rowIndex][colIndex] = value;

    }

    @Override
    public IMatrix add(IMatrix otherMatrix) throws IllegalArgumentException, NullPointerException {
        if (this.getRows() != otherMatrix.getRows()) {
            System.out.println("не совпадает количество строк");
            return null;
        }
        if (this.getColumns() != otherMatrix.getColumns()) {
            System.out.println("не совпадает количество колонок");
            return null;
        }
        Matrix result = new Matrix(getRows(), getColumns());
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                result.setValueAt(i, j, this.getValueAt(i, j) + otherMatrix.getValueAt(i, j));
            }
        }

        return result;
    }

    @Override
    public IMatrix sub(IMatrix otherMatrix) throws IllegalArgumentException, NullPointerException {
        if (this.getRows() != otherMatrix.getRows()) {
            System.out.println("не совпадает количество строк");
            return null;
        }
        if (this.getColumns() != otherMatrix.getColumns()) {
            System.out.println("не совпадает количество колонок");
            return null;
        }
        Matrix result = new Matrix(getRows(), getColumns());
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                result.setValueAt(i, j, this.getValueAt(i, j) - otherMatrix.getValueAt(i, j));
            }
        }

        return result;
    }

    @Override
    public IMatrix mul(IMatrix otherMatrix) throws IllegalArgumentException, NullPointerException {
        if (this.getColumns() != otherMatrix.getRows()) {
            System.out.println("Такие матрицы невозможно перемножить");
            return null;
        }
        Matrix result = new Matrix(this.getRows(), otherMatrix.getColumns());

        for (int i = 0; i < result.getColumns(); i++) {
            for (int j = 0; j < result.getRows(); j++) {
                for (int k = 0; k < this.getColumns(); k++) {
                    result.setValueAt(i, j, result.getValueAt(i, j) + this.getValueAt(i, k) * otherMatrix.getValueAt(k, j));
                }
            }
        }

        return result;
    }

    @Override
    public IMatrix mul(double value) {
        Matrix result = new Matrix(this.getRows(), this.getColumns());

        for (int i = 0; i < result.getColumns(); i++) {
            for (int j = 0; j < result.getRows(); j++) {
                result.setValueAt(i, j, this.getValueAt(i, j) * value);
            }
        }
        return result;

    }

    @Override
    public IMatrix transpose() {

        Matrix result = new Matrix(this.getRows(), this.getColumns());
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                result.setValueAt(j, i, this.getValueAt(i, j));

            }
        }
        return result;
    }

    @Override
    public void fillMatrix(double value) {


        for (int i = 0; i < this.getColumns(); i++) {
            for (int j = 0; j < this.getRows(); j++) {
                this.setValueAt(i, j, value);
            }
        }


    }


    @Override
    public double determinant() {
        return 0;
    }

    @Override
    public boolean isNullMatrix() {
        for (int i = 0; i < this.getColumns(); i++) {
            for (int j = 0; j < this.getRows(); j++) {
                if (this.getValueAt(i, j) != 0) {
                    System.out.println("матрица не нулевая!");
                    return false;
                }
            }

        }
        System.out.println("Матрица нулевая!");
        return true;
    }

    @Override
    public boolean isIdentityMatrix() {
        if (this.isSquareMatrix()) {
            for (int i = 0; i < this.getColumns(); i++) {
                for (int j = 0; j < this.getRows(); j++) {
                    if (i == j && this.getValueAt(i, j) != 1) {
                        System.out.println("Матрица не Единичная!");
                        return false;
                    }
                    if (i != j && this.getValueAt(i, j) != 0) {
                        System.out.println("Матрица не Единичная!");
                        return false;
                    }
                }

            }
            System.out.println("Матрица Единичная!");
            return true;
        }
        System.out.println("По определению такую матрицу нельзя рассматривать как единичную;\nЕдиничная матрица должна быть квадратной!");
        return false;

    }

    @Override
    public boolean isSquareMatrix() {
        if (this.getRows() == this.getColumns()) {
            System.out.println("Матрица Квадратная!");
            return true;
        }
        System.out.println("Матрица не Квадратная!");
        return false;
    }

    @Override
    public void printToConsole() {
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                System.out.print(this.getValueAt(i, j) + " ");
            }
            System.out.println();
        }

    }
}
