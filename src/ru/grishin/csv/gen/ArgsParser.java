package ru.grishin.csv.gen;

import ru.grishin.csv.gen.exception.ParseException;

public class ArgsParser {

    public Args parse(String[] args) throws ParseException {
        String col = "";
        String row = "";
        String len = "";
        String out = "";
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-col": {
                    col = args[i + 1];
                    break;
                }
                case "-row": {
                    row = args[i + 1];
                    break;
                }
                case "-len": {
                    len = args[i + 1];
                    break;
                }
                case "-out": {
                    out = args[i + 1];
                    break;
                }
            }
        }
        if ("".equals(col)) {
            throw new ParseException("Не заполнен параметр -col");
        } else {
            try {
                Integer.valueOf(col);
            } catch (NumberFormatException e) {
                throw new ParseException("Не верный параметр -col");
            }
        }
        if ("".equals(row)) {
            throw new ParseException("Не заполнен параметр -row");
        } else {
            try {
                Integer.valueOf(row);
            } catch (NumberFormatException e) {
                throw new ParseException("Не верный параметр -row");
            }
        }
        if ("".equals(len)) {
            throw new ParseException("Не заполнен параметр -len");
        } else {
            try {
                Integer.valueOf(len);
            } catch (NumberFormatException e) {
                throw new ParseException("Не верный параметр -len");
            }
        }
        if ("".equals(out)) {
            throw new ParseException("Не заполнен параметр -out");
        } else {
            if (!out.endsWith(".csv")) {
                throw new ParseException("Неверное расширение файла");
            }
        }
        return new Args(Integer.valueOf(col), Integer.valueOf(row), Integer.valueOf(len), out);
    }
}
