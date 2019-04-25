package com.steven.algorithm;

import static com.steven.algorithm.DoctorExample.Status.*;
import static com.steven.algorithm.DoctorExample.Feel.*;

public class DoctorExample
{
    enum Status
    {
        Healthy,
        Fever,
    }
    enum Feel
    {
        normal,
        cold,
        dizzy,
    }
    static int[] states = new int[]{Healthy.ordinal(), Fever.ordinal()};
    static int[] observations = new int[]{normal.ordinal(), cold.ordinal(), dizzy.ordinal(), cold.ordinal(), cold.ordinal(), dizzy.ordinal(), normal.ordinal(), normal.ordinal()};
    static double[] start_probability = new double[]{0.6, 0.4};
    static double[][] transititon_probability = new double[][]{
            {0.7, 0.3},
            {0.4, 0.6},
    };
    static double[][] emission_probability = new double[][]{
            {0.5, 0.4, 0.1},
            {0.1, 0.3, 0.6},
    };

    public static void main(String[] args)
    {
        int[] result1 = Viterbi.compute(observations, states, start_probability, transititon_probability, emission_probability);
        for (int r : result1)
        {
            System.out.print(Status.values()[r] + " ");
        }
        System.out.println();
    }
}
