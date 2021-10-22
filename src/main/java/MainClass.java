import java.util.Collections;

public class MainClass {
    public static void main(String[] args) {
        SimpleArrayList<String> list = new SimpleArrayList<>();

        list.add("Vovan");
        list.add("Kolian");
        list.add("Moscow");
        list.add("Cow");
        list.add("Dog");
        list.add(3,"Cat");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("----------------------------------------");
        System.out.println(list.get(0));

        list.set(0,"Maman");

        System.out.println("------------------");

        System.out.println(list.get(0));

        System.out.println(list.remove("Moscow"));

        System.out.println("-----------------------");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("-------------------");

//        list.clear();

        System.out.printf("list size = %d", list.size());

        QuickSort.sort(list);

        System.out.println("--------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
