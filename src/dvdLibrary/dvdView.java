package dvdLibrary;

import java.util.List;

public class dvdView {

    private UserIO io;

    public void printMenu() {
        io.print("Main Menu");
        io.print("1. List DVDs");
        io.print("2. Add a DVD");
        io.print("3. Search for a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Edit a DVD");
        io.print("6. Exit");
    }

    public int getSelection(){
        return io.readInt("Please select from the above choices.");
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter the title of the film");
        String releaseDate = io.readString("Please enter the film's release date");
        String mpaaRating = io.readString("Please enter the film's MPAA rating");
        String director = io.readString("Please enter the director's name");
        String studio = io.readString("Please enter the studio");
        String userRating = io.readString("Please enter your rating or comments");
        DVD newDVD = new DVD(title);
        newDVD.setReleaseDate(releaseDate);
        newDVD.setMpaaRating(mpaaRating);
        newDVD.setDirectorName(director);
        newDVD.setStudio(studio);
        newDVD.setUserRating(userRating);
        return newDVD;
    }

    public void displayAddDVDBanner(){
        io.print("=== Add DVD ===");
    }

    public void displayAddDVDSuccessBanner(){
        io.readDouble("DVD successfully added. Please hit enter to continue");
    }

    public void displayDVDList(List<DVD> dvdList){
        for (DVD dvd : dvdList){
            String dvdInfo = String.format("%s : %s %s %s %s %s",
                    dvd.getTitle(),
                    dvd.getReleaseDate(),
                    dvd.getMpaaRating(),
                    dvd.getDirectorName(),
                    dvd.getStudio(),
                    dvd.getUserRating());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner(){
        io.print("=== Display all DVDs ===");
    }

    public void displayDisplayDVDBanner(){
        io.print("=== Display DVD ===");
    }

    public String getDVDTitleChoice(){
        return io.readString("Please enter the title of the DVD.");
    }

    public String getDVDToBeEditedTitleChoice(){
        return io.readString("Please enter the title of the DVD you want to edit.");
    }

    public void displayDVD(DVD dvd){
        if (dvd != null){
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRating());
            io.print(" ");
        } else {
            io.print("No such DVD");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner(){
        io.print("=== Remove DVD ===");
    }

    public void displayRemovedResult(DVD dvdRecord){
        if(dvdRecord != null){
            io.print("DVD successfully removed.");
        }else{
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayEditDVDBanner(){
        io.print("=== Edit DVD ===");
    }

    public void displayEditResult(){
        io.print("DVD successfully edited.");
    }

    public int displayEditVariableChoices(){
        io.print("What do you want to edit?");
        io.print("1. Title");
        io.print("2. Release Date");
        io.print("3. MPAA Rating");
        io.print("4. Director's Name");
        io.print("5. Studio");
        io.print("6. User Rating");

        return io.readInt("Please select what you want to edit from the above choices",1,6);
    }

    public String editVariableValue(int editVariableChoice){
        String value = "";
        switch (editVariableChoice){
            case 1:
                value = io.readString("Please enter the new title of the DVD.");
                break;
            case 2:
                value = io.readString("Please enter the new release date of the DVD.");
                break;
            case 3:
                value = io.readString("Please enter the new MPAA rating of the DVD.");
                break;
            case 4:
                value = io.readString("Please enter the new director's name of the DVD.");
                break;
            case 5:
                value = io.readString("Please enter the new studio of the DVD.");
                break;
            case 6:
                value = io.readString("Please enter the new user rating of the DVD.");
                break;
        }
        return value;
    }

    public void displayExitBanner(){
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner(){
        io.print("Unknown Command!!!");
    }

    public dvdView(UserIO io){
        this.io = io;
    }

}
