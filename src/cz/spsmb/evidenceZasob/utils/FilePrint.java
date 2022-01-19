package cz.spsmb.evidenceZasob.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrint {

    private File file;
    private FileWriter fileWriter;

    public FilePrint() throws IOException {
        this.file = new File("stats.txt");
        this.fileWriter = new FileWriter(file, true);
    }

    public void printToFile(String content) throws IOException {
        fileWriter.write(content+"\n");
        fileWriter.flush();
    }



}
