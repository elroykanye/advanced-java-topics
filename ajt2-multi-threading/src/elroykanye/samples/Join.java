package elroykanye.samples;

import java.util.Arrays;

public class Join {
    public void main() {
        int[] arr = new int[]{3,4,1,6,12,3,8,3,4,8,2,5,8,2,4};
        PrintArray pa = new PrintArray(arr);
        pa.start();
    }
}

class PrintArray extends Thread {
    int[] arr;
    PrintArray (int[] arr) {this.arr = arr;}

    @Override
    public void run() {
        try {
            SortArray sa = new SortArray(arr);

            // sa depends on this thead so it will be joined into this one here.
            sa.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}

class SortArray extends Thread {
    int[] arr;
    SortArray(int[] arr) {
        this.arr = arr;
        start();
    }

    @Override
    public void run() {
        Arrays.sort(arr);
        System.out.println("Complete sorting array");
    }
}
