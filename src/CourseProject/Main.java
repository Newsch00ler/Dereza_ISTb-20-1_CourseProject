package CourseProject;

import DB.Database;
import GUI.Controller;
import GUI.View;
import Model.BasketballPlayer;
import Model.HockeyPlayer;
import Model.Player;
import Model.SoccerPlayer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Database database = new Database();
        try{
            database.initDB();
            /*database.createDB();
            database.addSoccer(new SoccerPlayer("Sasha", "Dereza", 19, "Forward", "Baikal", 669, 34, 46, 3, 0, 73));
            database.addHockeyPl(new HockeyPlayer("Sergey", "Popovich", 17, "Defender", "CSKA", 875, 5, 27, "L", 72, 18));
            database.addBasketPl(new BasketballPlayer("Ars", "Potapov", 55, "Small forward", "Irkut", 1235, 578, 343, 767, 347));*/
            database.setAllPlayerList(database.getAllPlayersList());
            //database.setAllSoccersList(database.getAllSoccersList());
            database.closeDB();
        }
        catch(Exception ex){
            //System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        View view = new View(database);
        Controller controller = new Controller();
        controller.execute(database, view);

        //ArrayList<Player> ddd = database.getListBySport("ssss");
    }
}
