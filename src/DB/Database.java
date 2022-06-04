package DB;

import Model.BasketballPlayer;
import Model.HockeyPlayer;
import Model.Player;
import Model.SoccerPlayer;

import java.util.ArrayList;

public class Database extends DBQueries{
    private ArrayList<Player> allPlayerList = new ArrayList<>();

    public ArrayList<Player> getAllPlayerList(){
        return allPlayerList;
    }

    public int getSizeList(){
        return allPlayerList.size();
    }

    public void setAllPlayerList(ArrayList<Player> allPlayerList) {
        this.allPlayerList = allPlayerList;
    }

    public void deletePlayer(int index){
        this.allPlayerList.remove(index);
    }
}
