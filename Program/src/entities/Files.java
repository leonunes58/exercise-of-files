package entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Files {
    private String pathFileReader;
    private String pathFileWriter;
    private List <Product> productList = new ArrayList<>();

    public Files(String pathFile, String pathFileWriter) {
        this.pathFileReader = pathFile;
        this.pathFileWriter = pathFileWriter;
    }

    public String getPathFileWriter() {
        return pathFileWriter;
    }

    public void setPathFileWriter(String pathFileWriter) {
        this.pathFileWriter = pathFileWriter;
    }

    public String getPathFile() {
        return pathFileReader;
    }

    public void setPathFile(String pathFile) {
        this.pathFileReader = pathFile;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(pathFileReader))){
            Locale locale = new Locale("en");
            String line = br.readLine();
            while(line != null) {
                String[] parts = line.split(", ");
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                int quantity = Integer.parseInt(parts[2]);
                Product product = new Product(name, price, quantity);
                productList.add(product);
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathFileWriter, true))){
            for (Product product : productList) {
                bw.write(product.getName() + ", " + product.totalValue());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
