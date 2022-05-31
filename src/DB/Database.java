package DB;

import Model.BasketballPlayer;
import Model.HockeyPlayer;
import Model.Player;
import Model.SoccerPlayer;

import java.util.ArrayList;

public class Database extends DBQueries{
    private ArrayList<Player> allPlayerList = new ArrayList<>();
    private ArrayList<SoccerPlayer> allSoccers = new ArrayList<>();
    private ArrayList<HockeyPlayer> allHockeyPl = new ArrayList<>();
    private ArrayList<BasketballPlayer> allBasketPl = new ArrayList<>();

    public ArrayList<Player> getAllPlayerList(){
        return allPlayerList;
    }

    public ArrayList<Player> getListBySport(int idSport){
        ArrayList<Player> list = new ArrayList<>();
        Class aclass = null;
        if(idSport == 1){
            for (Player player : allPlayerList) {
                if (player instanceof SoccerPlayer) {
                    list.add(player);
                }
            }
        }
        else if(idSport == 2){
            for (Player player : allPlayerList) {
                if (player instanceof HockeyPlayer) {
                    list.add(player);
                }
            }
        }
        else if(idSport == 3){
            for (Player player : allPlayerList) {
                if (player instanceof BasketballPlayer) {
                    list.add(player);
                }
            }
        }
        return list;
    }

    public int getSizeList(){
        return allPlayerList.size();
    }

    public void setAllPlayerList(ArrayList<Player> allPlayerList) {
        this.allPlayerList = allPlayerList;
    }

    public void setAllSoccers(ArrayList<SoccerPlayer> allSoccers) {

    }


    public String getPlayerSurname(int index){
        return allPlayerList.get(index).getSurname();
    }

    public Class<? extends Player> getPlayerSport(int index){
        return allPlayerList.get(index).getClass();
    }

    public void addPlayer(Player player){
        this.allPlayerList.add(player);
    }

    public void deletePlayer(int index){
        this.allPlayerList.remove(index);
    }
}
