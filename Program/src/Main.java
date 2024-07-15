import entities.Files;
import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List <Product> list = new ArrayList<>();
        String pathReader = "C:\\Users\\Leonardo Nunes\\IdeaProjects\\exercise-of-files\\Program\\src\\files\\Product of Sales.csv";
        String pathWriter = "C:\\Users\\Leonardo Nunes\\IdeaProjects\\exercise-of-files\\Program\\src\\files\\out\\Output Product of Sales.csv";

        Files files = new Files(pathReader, pathWriter);
        files.readFile();
        files.writeFile();


    }
}