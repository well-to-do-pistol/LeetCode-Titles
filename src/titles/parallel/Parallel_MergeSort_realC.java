package titles.parallel;

import java.util.Arrays;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Parallel_MergeSort_realC {
    private static final int N = 5_000_000;
    private static final int TIMES = 5;

    public static void main(String[] args) {
        int[] arr = new int[N];
        SplittableRandom rand = new SplittableRandom();
        for (int i = 0; i < N; i++) {
            arr[i] = rand.nextInt(N);
        }

        // JVM预热
        for (int i = 0; i < 3; ++i) {
            int[] warm = Arrays.copyOf(arr,arr.length);
            SerialMergeSort.sort(warm);
        }

        long serialTime = 0;
        long parallelTime = 0;

        for (int i=0; i < TIMES; ++i) {
            int[] a1 = Arrays.copyOf(arr,arr.length);
            int[] a2 = Arrays.copyOf(arr,arr.length);

            long t1 = System.nanoTime();
            SerialMergeSort.sort(a1);
            long t2 = System.nanoTime();

            long t3 = System.nanoTime();
            ParallelMergeSort.sort(a2);
            long t4 = System.nanoTime();

            serialTime += (t2-t1);
            parallelTime += (t4-t3);
        }

        System.out.printf("Serial time: %.2f ms;    Serial avg: %.2f ms%n",serialTime/1e6,serialTime/1e6/TIMES);
        System.out.printf("Parallel time: %.2f ms;  Parallel avg: %.2f ms%n",parallelTime/1e6,parallelTime/1e6/TIMES);
        System.out.printf("Speedup: %.2fx%n",(double)serialTime/parallelTime);
    }
}


class ParallelMergeSort {
    public static void sort(int[] arr) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        int[] tmp = new int[arr.length];
        pool.invoke(new MergeSortTask(arr,0,arr.length-1,tmp));
    }
}

class SerialMergeSort {
    public static void sort(int[] arr) {
        int[] tmp = new int[arr.length];  // 只用new一次tmp数组， 比在里面new性能更好，即使传了很多次, 平均快了70ms左右
        mergeSort(arr,0,arr.length-1,tmp);
    }

    private static void mergeSort(int[] arr, int l, int r, int[] tmp) {
        if (l>=r) return;
        int mid = l+((r-l)>>1);
        mergeSort(arr,l,mid,tmp);
        mergeSort(arr,mid+1,r,tmp);
        merge(arr,l,mid,r,tmp);
    }

    private static void merge(int[] arr, int l, int mid, int r, int[] tmp) {
        int p1 = l;
        int p2 = mid+1;
        int i = 0;
        while (p1<=mid && p2<=r) {
            tmp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1<=mid) {
            tmp[i++] = arr[p1++];
        }
        while (p2<=r) {
            tmp[i++] = arr[p2++];
        }
        i = 0;
        System.arraycopy(tmp,0,arr,l,r-l+1);
    }
}

class MergeSortTask extends RecursiveAction {
    private static final int THRESHOLD = 1_000;

    int[] arr;
    int[] tmp;
    int l, r;

    MergeSortTask(int[] arr, int l, int r, int[] tmp) {
        this.arr = arr;
        this.l = l;
        this.r = r;
        this.tmp = tmp;
    }

    @Override
    protected void compute() {
        if (r-l<=THRESHOLD) {
            insertSort(arr,l,r);
            return;
        }
        int m = l+((r-l)>>1);
        MergeSortTask lTask = new MergeSortTask(arr,l,m,tmp);
        MergeSortTask rTask = new MergeSortTask(arr,m+1,r,tmp);
        invokeAll(lTask,rTask);
        merge(arr,l,m,r,tmp);
    }

    private void insertSort(int[] arr, int l, int r) {
        for (int j=l+1; j<=r; ++j) {
            int i=j-1;
            int pivot = arr[j];
            while (i>=l && arr[i]>pivot) {
                arr[i+1]=arr[i];
                --i;
            }
            arr[i+1]=pivot;
        }
    }

    private void merge(int[] arr, int l, int mid, int r, int[] tmp) {
        int p1 = l;
        int p2 = mid+1;
        int i = 0;
        while (p1<=mid && p2<=r) {
            tmp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1<=mid) {
            tmp[i++] = arr[p1++];
        }
        while (p2<=r) {
            tmp[i++] = arr[p2++];
        }
        i = 0;
        System.arraycopy(tmp,0,arr,l,r-l+1);
    }
}




