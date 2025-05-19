package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    private final String FILE_PATH = "src/main/resources/contracts.csv";

    public void writeContractToFile(Contract contract){
        try{
            FileWriter fw = new FileWriter(FILE_PATH);
        }
        catch (IOException ex){

        }
    }
}
