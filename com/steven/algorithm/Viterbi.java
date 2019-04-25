package com.steven.algorithm;

/**
 * viterbi algorithm
 * @author steven
 * modified version for hankcs's code. (https://github.com/hankcs/Viterbi)
 */
public class Viterbi
{
    /**
     * solve HMM
     * @param obs observe
     * @param states hidden states
     * @param start_p initial states
     * @param trans_p transfer matrix
     * @param emit_p emit matrix
     * @return max prob path
     */
    public static int[] compute(int[] obs, int[] states, double[] start_p, double[][] trans_p, double[][] emit_p)
    {
        double[][] V = new double[obs.length][states.length];
        int[][] path = new int[states.length][obs.length];
        int[] maxPath = new int[obs.length];

        for (int y : states)
        {
            V[0][y] = start_p[y] * emit_p[y][obs[0]];
        }

        for (int t = 1; t < obs.length; ++t)
        {
            for (int y : states)
            {
                double prob = -1;
                int maxy0 = -1;
                for (int y0 : states)
                {
                    double nprob = V[t - 1][y0] * trans_p[y0][y] * emit_p[y][obs[t]];
                    if (nprob > prob)
                    {
                        prob = nprob;
                        // max prob
                        V[t][y] = prob;
                        // max prob path
                        maxy0 = y0;
                    }
                }
                path[y][t-1] = maxy0;
                path[y][t] = y;
            }
        }

        //find final max prob
        double prob = -1;
        int state = 0;
        for (int y : states)
        {
            if (V[obs.length - 1][y] > prob)
            {
                prob = V[obs.length - 1][y];
                state = y;
            }
        }

        //reverse to get path
        maxPath[obs.length - 1] = state;
        for (int o = obs.length - 1; o >= 0; o--) {
            state = path[state][o];
            maxPath[o] = state;
        }
        return maxPath;
    }
}
