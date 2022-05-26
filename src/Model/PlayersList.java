package Model;

import java.util.ArrayList;

public class PlayersList {
    ArrayList<Player> playersList;

    public PlayersList() {
        playersList = new ArrayList<>();
    }

    public void addPl(Player player){
        playersList.add(player);
    }

    public void deletePl(int index){
        playersList.remove(index);
    }

    public void deleteAllPl(){
        playersList.clear();
    }

    public int checkSize(){
        return playersList.size();
    }

    public String findSurnamePl(int index){
        return playersList.get(index).getSurname();
    }

    public Player getPlayer(int index){
        return playersList.get(index);
    }
}
