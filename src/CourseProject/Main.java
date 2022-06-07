package CourseProject;

import DB.Database;
import GUI.Controller;
import GUI.View;

public class Main {
    public static void main(String[] args){
        Database database = new Database();
        try{
            database.initDB();
            /*database.createDB();
            database.addSoccer(new SoccerPlayer(1,"Sasha", "Dereza", 19, "Forward", "Baikal", 669, 34, 46, 3, 0, 73));
            database.addHockeyPl(new HockeyPlayer(2,"Sergey", "Popovich", 17, "Defender", "CSKA", 875, 5, 27, "L", 72, 18));
            database.addBasketPl(new BasketballPlayer(3, "Ars", "Potapov", 55, "Small forward", "Irkut", 1235, 578, 343, 767, 347));*/
            database.setAllPlayerList(database.getAllSoccersList());
            database.closeDB();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        View view = new View(database);
        Controller controller = new Controller();
        controller.execute(database, view);
    }
}
