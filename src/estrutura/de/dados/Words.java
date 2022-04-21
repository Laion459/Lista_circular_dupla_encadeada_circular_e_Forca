package estrutura.de.dados;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Words {

    public void readCsvFile() {
        String filename = "src\\estrutura\\de\\dados\\Words";
        String row;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while ((row = reader.readLine()) != null) {
                String[] data = row.split(",");
                Arrays.stream(data).forEach(System.out::println);
                System.out.println("-----------------");
            }
        } catch (FileNotFoundException e) {
            // erro na abertura do arquivo
        } catch (IOException e) {
            // erro na leitura do arquivo
        }
    }

    public void scannerFileDemo() {
        File file = new File("src\\estrutura\\de\\dados\\Words");
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String line = input.nextLine();
                System.out.println(line);
            }
        } catch (
                FileNotFoundException e) {
            // erro na abertura do arquivo
        }
    }

    public void gamePlay(CircularDoubleList list){
        CircularDoubleList list2 = new CircularDoubleList();
        CircularDoubleList list3 = new CircularDoubleList();

        list3.addToTopOfList(list.getEnd().getElement());

        list.setAux(list.getHead());
        do {
            if (list.checksIfElementIsInTheList(list.getAux().getElement())){
                list3.addToTopOfList(list.getAux().getElement());
            }else{
                list3.addToTopOfList("_");
            }
            //System.out.print(" " + list.getAux().getElement());
            list.setAux(list.getAux().getNext());
        }while (list.getAux() != list.getHead());

        list2.showList2();
    }

}
