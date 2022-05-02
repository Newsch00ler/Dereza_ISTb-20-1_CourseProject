package Model;

//https://www.liveresult.ru/basketball/players/Kobe-Bean-Bryant

//!!!https://www.espn.com/nba/stats/player

public class BasketballPlayer extends Player {
    protected String role; //амплуа
    protected int countGame; //кол-во игр
    protected float minPerGame; //ср мин за игру
    protected float pointPerGame; //ср кол-во очков за игру
    protected float assistsPerGame; //ср кол-во ассистов за игру
    protected float reboundsPerGame; //ср кол-во подборов за игру
    protected float blockPerGame; //ср кол-во блоков за игру
    protected float threePointPerc; //процент 3очк бросков

    public BasketballPlayer(String surname, String name, String role, int number, int countGame, float minPerGame, float pointPerGame, float assistsPerGame, float reboundsPerGame, float blockPerGame, float threePointPerc){
        super(surname, name, number);
        this.role = role;
        this.countGame = countGame;
        this.minPerGame = minPerGame;
        this.pointPerGame = pointPerGame;
        this.assistsPerGame = assistsPerGame;
        this.reboundsPerGame = reboundsPerGame;
        this.blockPerGame = blockPerGame;
        this.threePointPerc = threePointPerc;
    }

    public String getRole() {
        return role;
    }
    public int getCountGame() {
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
    }

    public void setRole(String role) {
        this.role = role;
    }
    public void setCountGame(int countGame) {
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
    }
}
