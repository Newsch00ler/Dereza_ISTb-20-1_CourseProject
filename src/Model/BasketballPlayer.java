package Model;

//https://www.liveresult.ru/basketball/players/Kobe-Bean-Bryant

//!!!https://www.espn.com/nba/stats/player

public class BasketballPlayer extends Player {
    protected int rebounds; //ср кол-во подборов за игру
    protected int blocks; //ср кол-во блоков за игру
    /*protected int countGame;
    protected float minPerGame; //ср мин за игру
    protected float pointPerGame; //ср кол-во очков за игру
    protected float assistsPerGame; //ср кол-во ассистов за игру

    protected float threePointPerc; //процент 3очк бросков*/

    //public BasketballPlayer(String name, String surname, int number, int countGame, float minPerGame, float pointPerGame, float assistsPerGame, float reboundsPerGame, float blockPerGame, float threePointPerc){
    public BasketballPlayer(String name, String surname, String role, String team, int number, int mins, int goals, int assists, int rebounds, int blocks){
        super(name, surname, number, role, team, mins, goals, assists);
        this.rebounds = rebounds;
        this.blocks = blocks;
        /*this.countGame = countGame;
        this.minPerGame = minPerGame;
        this.pointPerGame = pointPerGame;
        this.assistsPerGame = assistsPerGame;
        this.reboundsPerGame = reboundsPerGame;
        this.blockPerGame = blockPerGame;
        this.threePointPerc = threePointPerc;*/
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

    /*public int getCountGame() {
        return countGame;
    }
    public float getMinPerGame() {
        return minPerGame;
    }
    public float getPointPerGame() {
        return pointPerGame;
    }
    public float getAssistsPerGame() {
        return assistsPerGame;
    }
    public float getReboundsPerGame() {
        return reboundsPerGame;
    }
    public float getBlockPerGame() {
        return blockPerGame;
    }
    public float getThreePointPerc() {
        return threePointPerc;
    }*/

    /*public void setCountGame(int countGame) {
        this.countGame = countGame;
    }
    public void setMinPerGame(float minPerGame) {
        this.minPerGame = minPerGame;
    }
    public void setPointPerGame(float pointPerGame) {
        this.pointPerGame = pointPerGame;
    }
    public void setAssistsPerGame(float assistsPerGame) {
        this.assistsPerGame = assistsPerGame;
    }
    public void setReboundsPerGame(float reboundsPerGame) {
        this.reboundsPerGame = reboundsPerGame;
    }
    public void setBlockPerGame(float blockPerGame) {
        this.blockPerGame = blockPerGame;
    }
    public void setThreePointPerc(float threePointPerc) {
        this.threePointPerc = threePointPerc;
    }*/
}
