package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static <T extends Comparable<T>> void mergeSort(T[] data)
    {
        mergeSort(data, 0, data.length-1);
    }

    public static <T extends Comparable<T>> void mergeSort(T[] data, int min, int max)
    {
        if (min < max) {

            int mid = (min + max) / 2;
            mergeSort(data, min, mid);
            mergeSort(data, mid + 1, max);
            merge(data, min, mid, max);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] data, int min, int mid, int max)
    {
        T[] temp = (T[]) new Comparable[data.length];

        int first1 = min;
        int last1 = mid;
        int first2 = mid + 1;
        int last2 = max;

        int index = first1;
        while (first1 <= last1 && first2 <= last2)
        {
            if(data[first1].compareTo(data[first2]) < 0)
            {
                temp[index] = data[first1];
                first1++;

            }
            else
            {
                temp[index] = data[first2];
                first2++;
            }
            index++;
        }
        while (first1 <= last1)
        {
            temp[index] = data[first1];
            first1++;
            index++;
        }
        while (first2 <= last2)
        {
            temp[index] = data[first2];
            first2++;
            index++;
        }

        for (int i = min; i <= max; i++)
        {
            data[i] = temp[i];
        }
    }
}