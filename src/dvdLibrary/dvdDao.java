package dvdLibrary;

import java.util.List;

public interface dvdDao {

    DVD addDVD(String name, DVD dvd);
    List<DVD> getAllDVDs();
    DVD getDVD(String name);
    DVD removeDVD(String title);
    DVD editDVD(DVD dvd, int choice, String value);
}
