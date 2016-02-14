package ru.grishin.csv.gen;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Random;

public class Generator {

    private static final String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final int len;
    private final int row;
    private final int col;

    public Generator(int col, int row, int len) {
        this.col = col;
        this.row = row;
        this.len = len;
    }

    public byte[] generate() {
        String s = "";
        Type[] t1 = new Type[col];
        for (int i = 0; i < col; i++) {
            t1[i] = randomType();
        }
        for (int i = 0; i < row; i++) {
            if (i == 0) {
                for (int j = 0; j < col; j++) {
                    String si = "Column" + j + " " + t1[j].getType();
                    s += si + ";";
                }
            } else {
                for (int j = 0; j < col; j++) {
                    String s1 = randomString(len, t1[j]);
                    s += s1 + ";";
                }
            }
            s += "\r\n";
        }
        return s.getBytes();
    }

    private String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    private String randomString(int len, Type type) {
        String result = "";
        switch (type) {
            case STRING: {
                Random random = new Random();
                result += generateString(random, ABC, len);
                break;
            }
            case DATE: {
                result += generateDate();
                break;
            }
            case INTEGER: {
                Random random = new Random();
                result += random.nextInt((2001) + 1000);
                break;
            }
            case FLOAT: {
                Random random = new Random();
                result += random.nextFloat() * Math.round(1^10);
                break;
            }
        }
        return result;
    }

    private String generateDate() {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1980, 2000);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(gc.getTime());
    }

    private int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private Type randomType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];
    }
}
