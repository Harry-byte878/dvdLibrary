package dvdLibrary;

public class App {

    public static void main(String[] args) {
        UserIO myIo= new UserIOConsoleImpl();
        dvdView myView = new dvdView(myIo);
        dvdDao myDao = new dvdDaoFileImpl();
        dvdController controller = new dvdController(myDao, myView);
        controller.run();
    }
}
