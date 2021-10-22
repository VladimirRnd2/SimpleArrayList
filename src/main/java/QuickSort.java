public class QuickSort<E extends Comparable<? super E>> {

    public static <E extends Comparable<? super E>> void sort(SimpleArrayList<E> list){
        quickSort(list,0, list.size() -1);
    }

    public static <E extends Comparable<? super E>> void quickSort(SimpleArrayList<E> array, int low, int high) {
        if (array.size() == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middleIndex = low + (high - low) / 2;
        E middleElement = array.get(middleIndex);

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array.get(i).compareTo(middleElement) < 0) {
                i++;
            }

            while (array.get(j).compareTo(middleElement) > 0) {
                j--;
            }

            if (i <= j) {//меняем местами
                E temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j,temp);
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}
