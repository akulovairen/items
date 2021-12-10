import java.io.*;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class logic {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public static void main(String[] args) throws FileNotFoundException {

        List<Item> items = readItemsFromFile("C:\\Users\\Alexander\\Desktop\\items.csv");
        System.out.println(items);

        double sumProduct = getSumByCategory(items, "Продукты");

        double sumBytov = getSumByCategory(items, "Бытовые");

        double sumFruits = getSumByCategory(items, "Овощи и фрукты");

        Map<String, Double> itemMap = new HashMap<>();
        itemMap.put("Продукты", sumProduct);
        itemMap.put("Бытовые", sumBytov);
        itemMap.put("Овощи и фрукты", sumFruits);

        System.out.println();
        System.out.println(itemMap);
    }

    private static double getSumByCategory(List<Item> items, String category) {
        return items
                .stream()
                .filter(item -> item.getCategory().equals(category))
                .filter(item -> item.getExpirationDate().before(new Date()))
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    private static List<Item> readItemsFromFile(String path) throws FileNotFoundException {
        FileInputStream fileInputStream= new FileInputStream(path);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("CP1251"));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.lines()
                .map(s -> {
                    String[] strArray = s.split(";");
                    Date d=null;
                    try {
                        d=dateFormat.parse(strArray[4]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return new Item(strArray[0], strArray[1], Integer.parseInt(strArray[2]), Double.parseDouble(strArray[3]),d);
                })
                .collect(Collectors.toList());

    }

}
