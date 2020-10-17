package com.company;

public class Main {

    public static void bubbleSort(double[] array) {
        boolean sorted = false;
        double temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static void mergeSort(double[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left+right)/2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }
    static void merge(double[] array, int left, int mid, int right) {
        // вычисляем длину
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        // создаем временные подмассивы
        double leftArray[] = new double [lengthLeft];
        double rightArray[] = new double [lengthRight];

        // копируем отсортированные массивы во временные
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left+i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid+i+1];

        // итераторы содержат текущий индекс временного подмассива
        int leftIndex = 0;
        int rightIndex = 0;

        // копируем из leftArray и rightArray обратно в массив
        for (int i = left; i < right + 1; i++) {
            // если остаются нескопированные элементы в R и L, копируем минимальный
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            // если все элементы были скопированы из rightArray, скопировать остальные из leftArray
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            // если все элементы были скопированы из leftArray, скопировать остальные из rightArray
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    public static void selectionSort(double[] array) {
        for (int i = 0; i < array.length; i++) {
            double min = array[i];
            int minId = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }
            // замена
            double temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
    }

    static int partition(double[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                double temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        double temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }

    public static void quickSort(double[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);
    }

    public static void main(String[] args) {
	// write your code here
        double[] array = new double[1000];
        for(int i=0;i<array.length;i++){
            array[i]=1000.0*Math.random()/(Math.random()+Math.random());
        }
        long t1, t2;
        t1=System.currentTimeMillis();
        bubbleSort(array);
        t2=System.currentTimeMillis();
        System.out.println("Bubble sort time = "+(double)(t2-t1)/1000+" s");
        t1=System.currentTimeMillis();
        mergeSort(array,0,999);
        t2=System.currentTimeMillis();
        System.out.println("Insertion Sort time = "+(double)(t2-t1)/1000+" s");
        t1=System.currentTimeMillis();
        selectionSort(array);
        t2=System.currentTimeMillis();
        System.out.println("SelectionSort time = "+(double)(t2-t1)/1000+" s");
        t1=System.currentTimeMillis();
        quickSort(array,0,999);
        t2=System.currentTimeMillis();
        System.out.println("Quick Sort time = "+(double)(t2-t1)/1000+" s");
    }
}
