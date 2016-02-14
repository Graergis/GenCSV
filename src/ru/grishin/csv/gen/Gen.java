package ru.grishin.csv.gen;

import ru.grishin.csv.gen.exception.ParseException;

import java.io.FileOutputStream;
import java.io.IOException;

public class Gen {
    public static void main(String[] args) throws IOException {
        try {
            ArgsParser parser = new ArgsParser();
            Args arguments = parser.parse(args);
            try (FileOutputStream fos = new FileOutputStream(arguments.getOut())) {
                Generator generator = new Generator(arguments.getCol(), arguments.getRow(), arguments.getLen());
                fos.write(generator.generate());
                fos.close();
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
