package com.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rafa on 09.09.14.
 */
public class Combinations {

    private int array[];
    private int n;
    private static List<Integer> listaSekcji = new ArrayList<Integer>();
    private static List<String> listaOpisu = new ArrayList<String>();

    public Combinations(int[] a, int n) {

        this.array = a;
        this.n = n;

    }


    public List<int[]> getVariations() {

        int l = array.length;
        int permutations = (int) Math.pow(l, n);
        int[][] table = new int[permutations][n];

        for (int x = 0; x < n; x++) {

            int t2 = (int) Math.pow(l, x);

            for (int p1 = 0; p1 < permutations;) {

                for (int al = 0; al < l; al++) {

                    for (int p2 = 0; p2 < t2; p2++) {

                        table[p1][x] = array[al];

                        p1++;

                    }

                }

            }

        }



        List<int[]> result = new ArrayList<int[]>();

        for (int[] permutation : table) {

            result.add(permutation);

        }

        return result;

    }



    public static void add(int liczbaPozycji) {

        listaSekcji.add(liczbaPozycji);
//        System.out.println(listaSekcji);

    }


    public static int getCombinations (List<Integer> list) {

        int suma = 0;

        Iterator <Integer> it = list.iterator();
            while(it.hasNext()){
                suma = suma + it.next();
//                System.out.println(suma);
            }
        return suma;
    }



    public static List getOpis(String sekcja, int liczbaPozycji) {

        String underscore = "_";
        List<String> sek = new ArrayList<String>();

        for (int n = 1; n < liczbaPozycji; n++) {

            sek.add(underscore);

            //System.out.println(sek);
        }
        sek.add(sekcja);
        listaOpisu.addAll(sek);

        return listaOpisu;
    }

    public static void onRun () {
       // int x = getCombinations(add(4));
        Combinations gen = new Combinations(new int[]{0, 1}, getCombinations(listaSekcji));
        List<int[]> v = gen.getVariations();

        for (int[] s : v) {


            System.out.println(Arrays.toString(s));
        }
        System.out.println(" - Sekcje - ");
        System.out.println(listaOpisu);
//        System.out.println("Liczba wariacji: " + v.size());

        T1.connectToDatabase(v, listaOpisu.toString(), listaSekcji);
    }



}


