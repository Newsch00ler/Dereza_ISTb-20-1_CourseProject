package Model;

//???https://www.liveresult.ru/football/players/Ronaldo-Cristiano
//???https://1xbet.whoscored.com/Players/300713/Show/Kylian-Mbappé


public class SoccerPlayer extends Player {
    protected int yelCard; //жетлые карточки
    protected int redCard; //красные карточки
    protected int psPerc; //процент успешных передач

    public SoccerPlayer(int ID, String name, String surname, int number, String role, String team,  int mins, int goals, int assists, int yelCard, int redCard, int psPerc){
        super(ID, surname, name, number, role, team, mins, goals, assists);
        this.yelCard = yelCard;
        this.redCard = redCard;
        this.psPerc = psPerc;
    }

   /* public SoccerPlayer(String name, String surname, int number, String role, String team,  int mins, int goals, int assists){
        super(surname, name, number, role, team, mins, goals, assists);
    }*/

    public int getYelCard() {
        return yelCard;
    }
    public int getRedCard() {
        return redCard;
    }
    public int getPsPerc() {
        return psPerc;
    }

    public void setYelCard(int yelCard) {
        this.yelCard = yelCard;
    }
    public void setRedCard(int redCard) {
        this.redCard = redCard;
    }
    public void setPsPerc(int psPerc) {
        this.psPerc = psPerc;
    }
}
