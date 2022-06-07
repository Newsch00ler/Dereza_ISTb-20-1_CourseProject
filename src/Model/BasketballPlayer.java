package Model;

public class BasketballPlayer extends Player {
    protected int rebounds;
    protected int blocks;

    public BasketballPlayer(int ID, String name, String surname, int number, String role, String team, int mins, int goals, int assists, int rebounds, int blocks){
        super(ID, name, surname, number, role, team, mins, goals, assists);
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
