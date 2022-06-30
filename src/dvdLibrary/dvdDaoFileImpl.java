package dvdLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dvdDaoFileImpl implements dvdDao{

    private Map<String, DVD> DVDs = new HashMap<>();

    @Override
    public DVD addDVD(String name, DVD dvd) {
        DVD disc = DVDs.put(name, dvd );
        return disc;
    }

    @Override
    public List<DVD> getAllDVDs() {
        return new ArrayList<DVD>(DVDs.values());
    }

    @Override
    public DVD getDVD(String title) {
        return DVDs.get(title);
    }

    @Override
    public DVD removeDVD(String title) {
        DVD removedDVD = DVDs.remove(title);
        return removedDVD;
    }

    @Override
    public DVD editDVD(DVD dvd, int varChoice, String value) {
        switch (varChoice){
            case 1:
                dvd.setTitle(value);
                break;
            case 2:
                dvd.setReleaseDate(value);
                break;
            case 3:
                dvd.setMpaaRating(value);
                break;
            case 4:
                dvd.setDirectorName(value);
                break;
            case 5:
                dvd.setStudio(value);
                break;
            case 6:
                dvd.setUserRating(value);
                break;
            default:
                System.out.println("UNKNOWN COMMAND");
        }
        return dvd;
    }
}
