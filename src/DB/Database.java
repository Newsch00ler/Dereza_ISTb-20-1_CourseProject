package DB;

import Model.Player;

import java.sql.*;
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
}
