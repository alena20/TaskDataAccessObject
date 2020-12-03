package edu.epam.taskoop.reader;

import edu.epam.taskoop.entity.BindingType;
import edu.epam.taskoop.entity.Book;
import edu.epam.taskoop.entity.PublishCountry;
import edu.epam.taskoop.entity.Publisher;
import edu.epam.taskoop.exception.FileReaderException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private static final Logger logger = LogManager.getLogger(FileReader.class);
    private static final String FILE_PATH = "file/book.txt";

    public List<Book> readFromFile() throws FileReaderException{
        List<Book> list = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(FILE_PATH))) {
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] dataObject;
                Book book = new Book();
                Publisher publisher = new Publisher();
                dataObject  = line.split(" ");
                book.setName(dataObject[0]);
                book.setAuthors(dataObject[1]);
                publisher.setName(dataObject[2]);
                publisher.setCountry(PublishCountry.valueOf(dataObject[3]));
                publisher.setYear(Integer.parseInt(dataObject[4]));
                book.setPublisher(publisher);
                book.setPagesCount(Integer.parseInt(dataObject[5]));
                book.setPrice(Integer.parseInt(dataObject[6]));
                book.setBindingType(BindingType.valueOf(dataObject[7]));
                list.add(book);
                logger.log(Level.INFO, "book "+book);
            }
        }catch (FileNotFoundException e) {
            throw new FileReaderException("Cannot read from file");
        }
        return list;
    }
}
