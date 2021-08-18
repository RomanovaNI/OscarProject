package com.oscar.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public static Iterator<Object[]> registerNegativeEmailUsingFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/negativeEmail.csv")));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(","));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }
    @DataProvider
    public static Iterator<Object[]> registerNegativePswdUsingFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/negativePswd.csv")));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(","));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }
    @DataProvider
    public static Iterator<Object[]> loginNegativePswdUsingFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/negativeLoginPswd.csv")));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(","));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }
    @DataProvider
    public static Iterator<Object[]> loginNegativeEmailUsingFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/negativeLoginEmail.csv")));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(","));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }
}