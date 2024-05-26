package lesson16;


import java.util.*;





public class Fridge {
    private HashMap<String, Integer> products = new HashMap<>();

    public void addProduct(String nameOfProduct, int value) {
        if (products.containsKey(nameOfProduct)) {
            int currentValue = products.get(nameOfProduct);
            products.put(nameOfProduct, value + currentValue);

        } else {
            products.put(nameOfProduct, value);
        }
    }

    public void printAllProducts() {

        for (Map.Entry<String, Integer> prod : products.entrySet()) {
            System.out.println(prod.getKey() + " - " + prod.getValue());
        }
    }

    public void printAllProducts2() {
        for (String prod : products.keySet()) {
            System.out.println(prod + " - " + products.get(prod));
        }
    }

    public void getProduct(String choiseProduct, int choiseValue) {
        if (products.containsKey(choiseProduct) && products.get(choiseProduct) >= choiseValue) {
            products.put(choiseProduct, products.get(choiseProduct) - choiseValue);

        } else {
            System.out.println("Нет такого продукта или нет нужного количества в холодильнике!");
        }
        if (products.get(choiseProduct) == 0) {
            products.remove(choiseProduct);
        }
    }

    public void endingProduct() {
        String endingProd = null;
        int minValue = 0;
        for (Map.Entry<String, Integer> prod : products.entrySet()) {
            if (prod != null) {

                if (minValue == 0 || minValue > products.get(prod.getKey())) {
                    minValue = prod.getValue();
                    endingProd = prod.getKey();
                }
            }
        }
        System.out.println("Заканчивается продукт : " + endingProd + " - " + minValue);

    }

    public void productsWeight() {

        int totalWeigth = 0;
        for (Map.Entry<String, Integer> prod : products.entrySet()) {
            totalWeigth += prod.getValue();
        }
        System.out.println("Суммарный вес продуктов в холодильнике : " + totalWeigth);

    }

    public void sortByWeight() {
        Set<Map.Entry<String, Integer>> entrySet = products.entrySet();
        List<Map.Entry<String, Integer>> productList = new ArrayList<>(entrySet);
        productList.sort((o1, o2) -> o1.getValue() - o2.getValue());
        System.out.println("\nОтсортированный список товаров по Весу:\n");
        for (Map.Entry<String, Integer> x : productList) {
            System.out.println(x.getKey() + " - " + x.getValue());
        }

//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        });
//        System.out.println("Сортировка по Весу :\n");
//
//        list.forEach(s->{
//            System.out.println(s.getKey()+ " - " + s.getValue());
//        });
////        Это прям красиво)) но я сделал еще красивее)
//        Map<String,Integer> sortedMap = products.entrySet().stream().
//                sorted(Map.Entry.comparingByValue()).
//                collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
//                        (e1,e2) ->e1,LinkedHashMap::new));
//        sortedMap.forEach((key,value)->
//            System.out.println(key + " - " + value));

    }

    public void sortByName() {
        Set<Map.Entry<String, Integer>> entrySet = products.entrySet();
        List<Map.Entry<String, Integer>> productList = new ArrayList<>(entrySet);
        productList.sort((o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        System.out.println("\nОтсортированный список товаров по Названию:\n");
        for (Map.Entry<String, Integer> x : productList) {
            System.out.println(x.getKey() + " - " + x.getValue());
        }

    }
}


// 1 - взять продукт с холодильника
// 2 - вывести на терминал какой продукт закончится первым
// 3 - вывести вес всех продуктов в холодильнике
// 4 - вывести продукты и вес в отсортированном формате по Названию
// 5 - вывести продукты и вес в отсортированном формате по весу

