/*                                                 №1
 * Используя Collector напишите свою реализацию метода Collectors.toSet()
 * */

/*                                                 №2
 * Используя Collector соберите в карту, только те слова в потоке строк, в которых есть гласные.
 * */

import java.util.*;

public class MethodCollect {
    public static void main(String[] args) {
        //1
        List<Integer> list = new ArrayList<>(List.of(1, 23, 43, 1, 5, 6, 83, 4, 6));

        Set<Integer> set1 = list.stream().
                collect(HashSet::new, HashSet::add, AbstractCollection::addAll);

        set1.forEach(s -> System.out.print(s + " "));
        System.out.println();

        //2
        List<String> strings = new ArrayList<>(
                List.of("So", "we", "need", "new", "stories", "new", "heroes", "and", "new", "tools"));

        Map<String, List<String>> map = strings.stream().
                collect(HashMap::new, (mapa, str) -> {
                    List<String> l = new ArrayList<>();
                    for (char c : str.toCharArray()) {
                        if (isVowel(c))
                            l.add(Character.toString(c));
                        mapa.put(str, l);
                    }
                }, HashMap::putAll);

        System.out.println(map);
    }

    public static boolean isVowel(char c) {
        return Character.toString(c).matches("[aeiou]");
    }
}
