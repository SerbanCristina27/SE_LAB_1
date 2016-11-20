package ro.mta.se.lab1;

/**
 * Created by User on 10/17/2016.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        File file;
        List<Animal> animal = new ArrayList<>();
        String nameAnimal;
        String tip;
        int c;
        double f;
        long sec;

        try {
            file = new File(args[0]);
        } catch (Exception e) {
            System.out.println("Fisier inexistent");
            return;
        }
        if (!file.exists() || !file.canRead()) {
            System.out.println("Eroare de citire fisier: " + args[0]);
            return;
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(args[0]));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);

                StringTokenizer stringTokenizer = new StringTokenizer(line, ",");

                while (stringTokenizer.hasMoreElements()) {
                    nameAnimal = stringTokenizer.nextToken().trim();
                    tip = stringTokenizer.nextToken().trim();

                    try {
                        c = Integer.parseInt(stringTokenizer.nextToken().trim());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        throw e;
                    }

                    try {
                        f = Double.parseDouble(stringTokenizer.nextToken().trim());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        throw e;
                    }

                    try {
                        sec = Long.parseLong(stringTokenizer.nextToken().trim());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        throw e;
                    }

                    animal.add(new Animal(nameAnimal, Animal.TypeAnimal.valueOf(tip), c, f, sec));


                }


            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (in != null) {
                try {
                    in.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}





