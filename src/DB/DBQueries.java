package DB;

import Model.BasketballPlayer;
import Model.HockeyPlayer;
import Model.Player;
import Model.SoccerPlayer;
import com.sun.org.apache.bcel.internal.classfile.Constant;

import java.sql.*;

public abstract class DBQueries {
    private static final String PATH_TO_DB_FILE = "statPlayers.db";
    private static final String URL = "jdbc:sqlite:" + PATH_TO_DB_FILE;
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    public void initDB() throws SQLException{
        con = DriverManager.getConnection(URL);
        if(con != null){
            DatabaseMetaData metaData = con.getMetaData();
        }
    }

    public void createDB() throws SQLException, Exception{
        stmt = con.prepareStatement("CREATE TABLE if not exists Players " +
                "(ID_player INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL CHECK(ID_player > 0)," +
                "ID_sport INTEGER NOT NULL CHECK(ID_sport > 0)," +
                "Name TEXT NOT NULL," +
                "Surname TEXT NOT NULL," +
                "Number INTEGER NOT NULL CHECK(Number > 0)," +
                "Role TEXT NOT NULL," +
                "Team TEXT NOT NULL," +
                "FOREIGN KEY (ID_sport) REFERENCES Sport(ID_sport));");
        stmt.execute();
        stmt = con.prepareStatement("CREATE TABLE if not exists Sport " +
                "ID_sport INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL CHECK(ID_sport > 0)," +
                "Kind_of_sport TEXT NOT NULL,");
        stmt.execute();
        stmt = con.prepareStatement("CREATE TABLE if not exists Statistics " +
                "(ID_player INTEGER NOT NULL CHECK(ID_player > 0)," +
                "Minutes INTEGER NOT NULL CHECK(Minutes > 0)," +
                "Goals INTEGER NOT NULL CHECK(Goals > 0)," +
                "Assists INTEGER NOT NULL CHECK(Assists > 0))," +
                "YC INTEGER CHECK(YC > 0)," +
                "RC INTEGER CHECK(RC > 0)," +
                "Succ_passes INTEGER CHECK(Succ_passes > 0)," +
                "Stick_grip TEXT ," +
                "Penalty_time INTEGER CHECK(Penalty_time > 0)," +
                "Penalty_count INTEGER CHECK(Penalty_count > 0)," +
                "Rebounds INTEGER CHECK(Rebounds > 0)," +
                "Blocks INTEGER CHECK(Blocks > 0));" +
                "FOREIGN KEY (ID_player) REFERENCES Players(ID_player));");
        stmt.execute();
        stmt = con.prepareStatement("CREATE VIEW Playerslist" +
                "as select" +
                "p.ID_player as [ID player]," +
                "p.Name as [Name]," +
                "p.Surname as [Surname]," +
                "p.Mumber as [Number]," +
                "p.Role as [Role]," +
                "p.Team as [Team]," +
                "p.Minutes as [Minutes]," +
                "p.Goals as [Goals]," +
                "p.Assists as [Assists]," +
                "s.Kind_of_sport as [Kind of sport]" +
                "from Players as p" +
                "join Sport as s on p.ID_sport = s.ID_sport");
        stmt.execute();
        stmt = con.prepareStatement("INSERT INTO Sport " +
                "(ID_sport, " +
                "Kind_of_sport)" +
                "VALUES (1,Football)");
        stmt.execute();
        stmt = con.prepareStatement("INSERT INTO Sport " +
                "(ID_sport, " +
                "Kind_of_sport)" +
                "VALUES (2,Hockey)");
        stmt.execute();stmt = con.prepareStatement("INSERT INTO Sport " +
                "(ID_sport, " +
                "Kind_of_sport)" +
                "VALUES (3,Basketball)");
        stmt.execute();
        stmt.close();
    }

   /* public void addPlayer(Player player) throws SQLException{
        String surname = player.getSurname();
        String name = player.getName();
        int number = player.getNumber();
        String role = player.getRole();
        String team = player.getTeam();
        int idSport = 0;
        if(player instanceof SoccerPlayer){
            idSport = 1;
        }
        else if(player instanceof HockeyPlayer){
            idSport = 2;
        }
        else if(player instanceof BasketballPlayer){
            idSport = 3;
        }
        stmt = con.prepareStatement("INSERT INTO Players" +
                "(ID_sport, " +
                "Name, " +
                "Surname, " +
                "Number, " +
                "Role, " +
                "Team, " +
                "VALUES (?,?,?,?,?,?)");
        stmt.setObject(1, idSport);
        stmt.setObject(2, name);
        stmt.setObject(3, surname);
        stmt.setObject(4, number);
        stmt.setObject(5, role);
        stmt.setObject(6, team);
        stmt.execute();
        stmt.close();
    }*/

    public void addSoccer(SoccerPlayer soccer) throws SQLException{
        String surname = soccer.getSurname();
        String name = soccer.getName();
        int number = soccer.getNumber();
        String role = soccer.getRole();
        String team = soccer.getTeam();
        int mins = soccer.getMins();
        int goals = soccer.getGoals();
        int assists = soccer.getAssists();
        int yelCard = soccer.getYelCard();
        int redCard = soccer.getRedCard();
        int psPerc = soccer.getPsPerc();
        int idSport = 1;
        stmt = con.prepareStatement("INSERT INTO Players" +
                "(ID_sport, " +
                "Name, " +
                "Surname, " +
                "Number, " +
                "Role, " +
                "Team, " +
                "VALUES (?,?,?,?,?,?)");
        stmt.setObject(1, idSport);
        stmt.setObject(2, name);
        stmt.setObject(3, surname);
        stmt.setObject(4, number);
        stmt.setObject(5, role);
        stmt.setObject(6, team);
        stmt.execute();
        stmt = con.prepareStatement("SELECT COUNT(ID_player) FROM Players AS ID_Player");
        rs = stmt.executeQuery();
        int idPlayer = rs.getInt("ID_Player");
        stmt = con.prepareStatement("INSERT INTO Statistics" +
                "(ID_player, " +
                "Minutes, " +
                "Goals, " +
                "Assists, " +
                "YC, " +
                "RC, " +
                "Succ_passes, " +
                "VALUES (?,?,?,?,?,?,?)");
        stmt.setObject(1, idPlayer);
        stmt.setObject(2, mins);
        stmt.setObject(3, goals);
        stmt.setObject(4, assists);
        stmt.setObject(5, yelCard);
        stmt.setObject(6, redCard);
        stmt.setObject(7, psPerc);
        stmt.execute();
        stmt.close();
    }

    public void addHockeyPl(HockeyPlayer hockeyPl) throws SQLException{
        String surname = hockeyPl.getSurname();
        String name = hockeyPl.getName();
        int number = hockeyPl.getNumber();
        String role = hockeyPl.getRole();
        String team = hockeyPl.getTeam();
        int mins = hockeyPl.getMins();
        int goals = hockeyPl.getGoals();
        int assists = hockeyPl.getAssists();
        String stickGrip = hockeyPl.getStickGrip();
        int penaltyTime = hockeyPl.getPenaltyTime();
        int countPenalty = hockeyPl.getCountPenalty();
        int idSport = 2;
        stmt = con.prepareStatement("INSERT INTO Players" +
                "(ID_sport, " +
                "Name, " +
                "Surname, " +
                "Number, " +
                "Role, " +
                "Team, " +
                "VALUES (?,?,?,?,?,?)");
        stmt.setObject(1, idSport);
        stmt.setObject(2, name);
        stmt.setObject(3, surname);
        stmt.setObject(4, number);
        stmt.setObject(5, role);
        stmt.setObject(6, team);
        stmt.execute();
        stmt = con.prepareStatement("SELECT COUNT(ID_player) FROM Players AS ID_Player");
        rs = stmt.executeQuery();
        int idPlayer = rs.getInt("ID_Player");
        stmt = con.prepareStatement("INSERT INTO Statistics" +
                "(ID_player, " +
                "Minutes, " +
                "Goals, " +
                "Assists, " +
                "Stick_grip, " +
                "Penalty_time, " +
                "Penalty_count, " +
                "VALUES (?,?,?,?,?,?,?)");
        stmt.setObject(1, idPlayer);
        stmt.setObject(2, mins);
        stmt.setObject(3, goals);
        stmt.setObject(4, assists);
        stmt.setObject(5, stickGrip);
        stmt.setObject(6, penaltyTime);
        stmt.setObject(7, countPenalty);
        stmt.execute();
        stmt.close();
    }

    public void addHockeyPl(BasketballPlayer basketPl) throws SQLException{
        String surname = basketPl.getSurname();
        String name = basketPl.getName();
        int number = basketPl.getNumber();
        String role = basketPl.getRole();
        String team = basketPl.getTeam();
        int mins = basketPl.getMins();
        int goals = basketPl.getGoals();
        int assists = basketPl.getAssists();
        int rebounds = basketPl.getRebounds();
        int blocks = basketPl.getBlocks();
        int idSport = 3;
        stmt = con.prepareStatement("INSERT INTO Players" +
                "(ID_sport, " +
                "Name, " +
                "Surname, " +
                "Number, " +
                "Role, " +
                "Team, " +
                "VALUES (?,?,?,?,?,?)");
        stmt.setObject(1, idSport);
        stmt.setObject(2, name);
        stmt.setObject(3, surname);
        stmt.setObject(4, number);
        stmt.setObject(5, role);
        stmt.setObject(6, team);
        stmt.execute();
        stmt = con.prepareStatement("SELECT COUNT(ID_player) FROM Players AS ID_Player");
        rs = stmt.executeQuery();
        int idPlayer = rs.getInt("ID_Player");
        stmt = con.prepareStatement("INSERT INTO Statistics" +
                "(ID_player, " +
                "Minutes, " +
                "Goals, " +
                "Assists, " +
                "Rebounds, " +
                "Blocks, " +
                "VALUES (?,?,?,?,?,?)");
        stmt.setObject(1, idPlayer);
        stmt.setObject(2, mins);
        stmt.setObject(3, goals);
        stmt.setObject(4, assists);
        stmt.setObject(5, rebounds);
        stmt.setObject(6, blocks);
        stmt.execute();
        stmt.close();
    }

    public void deletePlayer(int id) throws SQLException{
        stmt = con.prepareStatement("DELETE FROM Players WHERE ID_player = ?");
        stmt.setObject(1, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updatePlayerNumber(int id, int number) throws SQLException {
        stmt = con.prepareStatement("UPDATE Players set Number = ? WHERE ID_player = ?");
        stmt.setObject(1, number);
        stmt.setObject(2, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updatePlayerRole(int id, String role) throws SQLException {
        stmt = con.prepareStatement("UPDATE Players set Role = ? WHERE ID_player = ?");
        stmt.setObject(1, role);
        stmt.setObject(2, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updatePlayerTeam(int id, String team) throws SQLException {
        stmt = con.prepareStatement("UPDATE Players set Team = ? WHERE ID_player = ?");
        stmt.setObject(1, team);
        stmt.setObject(2, id);
        stmt.executeUpdate();
        stmt.close();
    }


    /*(ID_player IN
Minutes INTEG
Goals INTEGER
Assists INTEG
YC INTEGER CH
RC INTEGER CH
Succ_passes I
Stick_grip TE
Penalty_time
Penalty_count
Rebounds INTE
Blocks INTEGE*/
    /*public void addStatistic(int idpl, int mins, int goals, int assists, int yc, int rc, int sucPasses, String stickGrip, int penTime, int penCount, int rebs, int blocks){
        if(){
            idSport = 1;
        }
        else if(player instanceof HockeyPlayer){
            idSport = 2;
        }
        else if(player instanceof BasketballPlayer){
            idSport = 3;
        }
        stmt = con.prepareStatement("INSERT INTO Statistics" +
                "(ID_sport, " +
                "Name, " +
                "Surname, " +
                "Number, " +
                "Role, " +
                "Team, " +
                "VALUES (?,?,?,?,?,?)");
        stmt.setObject(1, idSport);
        stmt.setObject(2, name);
        stmt.setObject(3, surname);
        stmt.setObject(4, number);
        stmt.setObject(5, role);
        stmt.setObject(6, team);
        stmt.execute();
        stmt.close();
    }*/

    public void closeDB() throws SQLException{
        con.close();
    }
}
