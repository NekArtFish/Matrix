package lesson16;

public class Main2 {
    public static void main(String[] args) {


        Fridge fridge = new Fridge();
        fridge.addProduct("Яблоко", 200);
        fridge.addProduct("Яблоко", 400);
        fridge.addProduct("Груша", 800);
        fridge.addProduct("Слива", 1000);
        fridge.addProduct("Виноград", 200);
        fridge.addProduct("Персик", 700);
        fridge.addProduct("Манго", 500);
        fridge.addProduct("Арбуз", 6500);
        fridge.addProduct("Дыня", 2500);

        fridge.printAllProducts2();
        System.out.println("-------------");
        fridge.printAllProducts();
        System.out.println("-------------");
        fridge.getProduct("Яблоко", 600);//достаем продукт из холодильника(не стал делать через scanner, оно тут не нужно)
        fridge.printAllProducts();
        System.out.println("-------------");
        fridge.endingProduct();
        System.out.println("-------------");
        fridge.productsWeight();
        System.out.println("-------------");
        fridge.sortByWeight();
        System.out.println("-------------");
        fridge.sortByName();
        System.out.println("-------------");


    }
}
