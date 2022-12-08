import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/*
Задание
        У вас имеется текстовый файл text.txt.
        Посчитайте в этом тексте, как часто встречается каждое слово, затем выведите в отдельный файл result.txt данную информацию.
        Также, в конец этого файла выведите самое часто встречаемое слово и его частоту.
*/

public class HomeWorkHashMap {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> words = new HashMap<>();
        //Чтение файла text.txt
        File fileRead = new File("text.txt");
        FileReader fileReader = new FileReader(fileRead);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (bufferedReader.ready()) {
            String[] s = bufferedReader.readLine().split("[^A-za-z]+");
            for (String str : s) {

                if (!str.equals("")) {
                    String lowerCaseWord = str.toLowerCase();
                    if (words.get(lowerCaseWord) == null) {
                        words.put(lowerCaseWord, 1);

                    } else {
                        int old = words.get(lowerCaseWord);
                        words.replace(lowerCaseWord, old + 1);


                    }
                }
            }

        }
        bufferedReader.close();

        String maxWord = new String();
        Integer max = Integer.MIN_VALUE;

        //Запись в файл Result.txt
        File file1Write = new File("Result.txt");
        FileWriter fileWriter = new FileWriter(file1Write);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Map.Entry<String, Integer> mapEntry : words.entrySet()) {
            bufferedWriter.write("Слово " + mapEntry.getKey() + " встречается " + mapEntry.getValue() + " раз\n");
            if (max < mapEntry.getValue()) {
                max = mapEntry.getValue();
                maxWord = (mapEntry.getKey());
            }
        }
        bufferedWriter.write("Самое часто встречаемое слово: " + maxWord + " оно встречается " + max + " раз");
        bufferedWriter.close();




    }
}

