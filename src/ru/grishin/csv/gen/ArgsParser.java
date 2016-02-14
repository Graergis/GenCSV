package ru.grishin.csv.gen;

public class ArgsParser {

    public Args parse(String[] args) throws ParseException {
        int col = 0;
        int row = 0;
        int len = 0;
        String out = "";
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-col": {
                    try {
                        col = Integer.valueOf(args[i + 1]);
                    }
                    catch (NumberFormatException e){
                        throw new ParseException("Неверное значение аргумента col");
                    }
                    break;
                }
                case "-row": {
                    try {
                        row = Integer.valueOf(args[i + 1]);
                    }
                    catch (NumberFormatException e) {
                        throw new ParseException("Неверное значение аргумента row");
                    }
                    break;
                }
                case "-len": {
                    try {
                        len = Integer.valueOf(args[i + 1]);
                    }
                    catch (NumberFormatException e) {
                        throw new ParseException("Неверное значение аргумента len");
                    }
                    break;
                }
                case "-out": {
                    out = args[i + 1];
                    if (!out.endsWith(".csv")){
                        throw new ParseException("Неверное расширение файла");
                    }
                    break;
                }
            }
        }
        System.out.println("Файл : " + out + " - создан.");
        return new Args(col, row, len, out);
    }
}
