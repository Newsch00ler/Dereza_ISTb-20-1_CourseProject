package Model;

//https://www.liveresult.ru/basketball/players/Kobe-Bean-Bryant

//!!!https://www.espn.com/nba/stats/player

public class BasketballPlayer extends Player {
    protected int rebounds; //ср кол-во подборов за игру
    protected int blocks; //ср кол-во блоков за игру

    public BasketballPlayer(String name, String surname, int number, String role, String team, int mins, int goals, int assists, int rebounds, int blocks){
        super(name, surname, number, role, team, mins, goals, assists);
        this.rebounds = rebounds;
        this.blocks = blocks;
    }

    public int getRebounds() {
        return rebounds;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }
}
