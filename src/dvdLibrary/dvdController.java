package dvdLibrary;

import java.util.List;

public class dvdController {
    private dvdView view;
    private dvdDao dao;

    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        printMenu();
        menuSelection = getMenuSelection();
        while (keepGoing) {

            switch (menuSelection) {
                case 1:
                    listDVDs();
                    printMenu();
                    menuSelection = getMenuSelection();
                    break;
                case 2:
                    addDVD();
                    printMenu();
                    menuSelection = getMenuSelection();
                    break;
                case 3:
                    viewDVD();
                    printMenu();
                    menuSelection = getMenuSelection();
                    break;
                case 4:
                    removeDVD();
                    printMenu();
                    menuSelection = getMenuSelection();
                    break;
                case 5:
                    //io.print("EDIT DVD");
                    editDVD();
                    printMenu();
                    menuSelection = getMenuSelection();
                    break;
                case 6:
                    keepGoing = false;
                    break;


                default:
                    unknownCommand();
            }

        }
        exitMessage();
    }

    private void printMenu(){
        view.printMenu();
    }
    private int getMenuSelection() {
        return view.getSelection();
    }

    private void addDVD() {
        view.displayAddDVDBanner();
        DVD NewDVD = view.getNewDVDInfo();
        dao.addDVD(NewDVD.getTitle(), NewDVD);
        view.displayAddDVDSuccessBanner();
    }

    private void listDVDs(){
        view.displayDisplayAllBanner();
        List<DVD> DVDList = dao.getAllDVDs();
        view.displayDVDList(DVDList);
    }

    private void viewDVD(){
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }

    private void removeDVD(){
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD removedDVD = dao.removeDVD(title);
        view.displayRemovedResult(removedDVD);
    }

    private void editDVD(){
        view.displayEditDVDBanner();
        String title = view.getDVDToBeEditedTitleChoice();
        int editVariableChoice = view.displayEditVariableChoices();
        DVD dvd = dao.getDVD(title);
        String value = view.editVariableValue(editVariableChoice);
        DVD editedDVD = dao.editDVD(dvd, editVariableChoice, value);
        view.displayEditResult();
    }

    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }

    private void exitMessage(){
        view.displayExitBanner();
    }

    public dvdController(dvdDao dao, dvdView view){
        this.dao = dao;
        this.view = view;
    }
}
