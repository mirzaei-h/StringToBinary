import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringToBinary {

    public static void main(String[] args) {


        String input = "52831";
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            indexMap.put(i, Character.getNumericValue(input.charAt(i)));
        }

        List<String> result = new ArrayList<>();
        while (indexMap.values().stream().distinct().count() > 1) {
            List<Integer> item = new ArrayList<>();
            indexMap.entrySet().forEach((x) -> {
                        item.add(x.getKey(), x.getValue() > 0 ? 1 : 0);
                        x.setValue(x.getValue() > 0 ? x.getValue() - 1 : 0);
                    });
            result.add(item.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining("")));

        }
        System.out.println(result);

    }
}