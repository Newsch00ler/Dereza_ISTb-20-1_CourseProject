package DB;

import Model.BasketballPlayer;
import Model.HockeyPlayer;
import Model.Player;
import Model.SoccerPlayer;

import java.sql.*;
import java.util.ArrayList;

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
        stmt = con.prepareStatement("CREATE TABLE if not exists Sport " +
                "(ID_sport INTEGER PRIMARY KEY UNIQUE NOT NULL CHECK(ID_sport > 0)," +
                "Kind_of_sport TEXT NOT NULL);");
        stmt.execute();
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
        stmt = con.prepareStatement("CREATE TABLE if not exists Statistics " +
                "(ID_player INTEGER NOT NULL CHECK(ID_player > 0)," +
                "Minutes INTEGER NOT NULL CHECK(Minutes >= 0)," +
                "Goals INTEGER NOT NULL CHECK(Goals >= 0)," +
                "Assists INTEGER NOT NULL CHECK(Assists >= 0)," +
                "YC INTEGER CHECK(YC >= 0)," +
                "RC INTEGER CHECK(RC >= 0)," +
                "Succ_passes INTEGER CHECK(Succ_passes >= 0 and Succ_passes <= 100)," +
                "Stick_grip TEXT ," +
                "Penalty_time INTEGER CHECK(Penalty_time >= 0)," +
                "Penalty_count INTEGER CHECK(Penalty_count >= 0)," +
                "Rebounds INTEGER CHECK(Rebounds >= 0)," +
                "Blocks INTEGER CHECK(Blocks >= 0)," +
                "FOREIGN KEY (ID_player) REFERENCES Players(ID_player));");
        stmt.execute();
        /*stmt = con.prepareStatement("CREATE VIEW Playerslist " +
                "as select " +
                "p.ID_player as [ID player], " +
                "sport.ID_sport as [ID sport], " +
                "sport.Kind_of_sport as [Kind of sport], " +
                "p.Name as [Name], " +
                "p.Surname as [Surname], " +
                "p.Number as [Number], " +
                "p.Role as [Role], " +
                "p.Team as [Team], " +
                "stat.Minutes as [Minutes], " +
                "stat.Goals as [Goals], " +
                "stat.Assists as [Assists], " +
                "stat.YC as [Yellow cards], " +
                "stat.RC as [Red cards], " +
                "stat.Succ_passes as [Success passes], " +
                "stat.Stick_grip as [Stick grip], " +
                "stat.Penalty_time as [Penalty time], " +
                "stat.Penalty_count as [Penalty count], " +
                "stat.Rebounds as [Rebounds], " +
                "stat.Blocks as [Blocks] " +
                "from Players as p " +
                "join Statistics as stat on p.ID_player = stat.ID_player " +
                "join Sport as sport on p.ID_sport = sport.ID_sport");
        stmt.execute();
        stmt = con.prepareStatement("INSERT INTO Sport " +
                "(ID_sport, " +
                "Kind_of_sport) " +
                "VALUES (1, 'Football')");
        stmt.execute();
        stmt = con.prepareStatement("INSERT INTO Sport " +
                "(ID_sport, " +
                "Kind_of_sport) " +
                "VALUES (2, 'Hockey')");
        stmt.execute();
        stmt = con.prepareStatement("INSERT INTO Sport " +
                "(ID_sport, " +
                "Kind_of_sport) " +
                "VALUES (3, 'Basketball')");
        stmt.execute();*/
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
                "Team) " +
                "VALUES (?,?,?,?,?,?)");
        stmt.setObject(1, idSport);
        stmt.setObject(2, name);
        stmt.setObject(3, surname);
        stmt.setObject(4, number);
        stmt.setObject(5, role);
        stmt.setObject(6, team);
        stmt.execute();
        //stmt = con.prepareStatement("SELECT COUNT(ID_player) FROM Players AS ID_Player");
        stmt = con.prepareStatement("SELECT MAX(ID_player) FROM Players");
        rs = stmt.executeQuery();
        int idPlayer = rs.getInt("MAX(ID_player)");
        stmt = con.prepareStatement("INSERT INTO Statistics" +
                "(ID_player, " +
                "Minutes, " +
                "Goals, " +
                "Assists, " +
                "YC, " +
                "RC, " +
                "Succ_passes) " +
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
                "Team) " +
                "VALUES (?,?,?,?,?,?)");
        stmt.setObject(1, idSport);
        stmt.setObject(2, name);
        stmt.setObject(3, surname);
        stmt.setObject(4, number);
        stmt.setObject(5, role);
        stmt.setObject(6, team);
        stmt.execute();
        stmt = con.prepareStatement("SELECT MAX(ID_player) FROM Players");
        rs = stmt.executeQuery();
        int idPlayer = rs.getInt("MAX(ID_player)");
        stmt = con.prepareStatement("INSERT INTO Statistics" +
                "(ID_player, " +
                "Minutes, " +
                "Goals, " +
                "Assists, " +
                "Stick_grip, " +
                "Penalty_time, " +
                "Penalty_count) " +
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

    public void addBasketPl(BasketballPlayer basketPl) throws SQLException{
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
                "Team) " +
                "VALUES (?,?,?,?,?,?)");
        stmt.setObject(1, idSport);
        stmt.setObject(2, name);
        stmt.setObject(3, surname);
        stmt.setObject(4, number);
        stmt.setObject(5, role);
        stmt.setObject(6, team);
        stmt.execute();
        stmt = con.prepareStatement("SELECT MAX(ID_player) FROM Players");
        rs = stmt.executeQuery();
        int idPlayer = rs.getInt("MAX(ID_player)");
        stmt = con.prepareStatement("INSERT INTO Statistics" +
                "(ID_player, " +
                "Minutes, " +
                "Goals, " +
                "Assists, " +
                "Rebounds, " +
                "Blocks) " +
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
        stmt = con.prepareStatement("DELETE FROM Statistics WHERE ID_player = ?" +
                "DELETE FROM Players WHERE ID_player = ?");
        stmt.setObject(1, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updatePlayerName(int id, String name) throws SQLException {
        stmt = con.prepareStatement("UPDATE Players set Name = ? WHERE ID_player = ?");
        stmt.setObject(1, name);
        stmt.setObject(2, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updatePlayerSurname(int id, String surname) throws SQLException {
        stmt = con.prepareStatement("UPDATE Players set Surname = ? WHERE ID_player = ?");
        stmt.setObject(1, surname);
        stmt.setObject(2, id);
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

    public void updatePlayerMins(int id, int mins) throws SQLException {
        stmt = con.prepareStatement("UPDATE Statistics set Minutes = ? WHERE ID_player = ?");
        stmt.setObject(1, mins);
        stmt.setObject(2, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updatePlayerGoals(int id, int goals) throws SQLException {
        stmt = con.prepareStatement("UPDATE Statistics set Goals = ? WHERE ID_player = ?");
        stmt.setObject(1, goals);
        stmt.setObject(2, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updatePlayerAssists(int id, int assists) throws SQLException {
        stmt = con.prepareStatement("UPDATE Statistics set Assists = ? WHERE ID_player = ?");
        stmt.setObject(1, assists);
        stmt.setObject(2, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updatePlayerYC(int id, int yc) throws SQLException {
        stmt = con.prepareStatement("UPDATE Statistics set YC = ? WHERE ID_player = ?");
        stmt.setObject(1, yc);
        stmt.setObject(2, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updatePlayerRC(int id, int rc) throws SQLException {
        stmt = con.prepareStatement("UPDATE Statistics set RC = ? WHERE ID_player = ?");
        stmt.setObject(1, rc);
        stmt.setObject(2, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updatePlayerSuccPasses(int id, int succPasses) throws SQLException {
        stmt = con.prepareStatement("UPDATE Statistics set Succ_passes = ? WHERE ID_player = ?");
        stmt.setObject(1, succPasses);
        stmt.setObject(2, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updatePlayerPenTime(int id, int penTime) throws SQLException {
        stmt = con.prepareStatement("UPDATE Statistics set Penalty_time = ? WHERE ID_player = ?");
        stmt.setObject(1, penTime);
        stmt.setObject(2, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updatePlayerPenCount(int id, int penCount) throws SQLException {
        stmt = con.prepareStatement("UPDATE Statistics set Penalty_count = ? WHERE ID_player = ?");
        stmt.setObject(1, penCount);
        stmt.setObject(2, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updatePlayerRebounds(int id, int rebounds) throws SQLException {
        stmt = con.prepareStatement("UPDATE Statistics set Rebounds = ? WHERE ID_player = ?");
        stmt.setObject(1, rebounds);
        stmt.setObject(2, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updatePlayerBlocks(int id, int blocks) throws SQLException {
        stmt = con.prepareStatement("UPDATE Statistics set Blocks = ? WHERE ID_player = ?");
        stmt.setObject(1, blocks);
        stmt.setObject(2, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public ArrayList<Player> getPlayerList(){
        ArrayList<Player> allPlayerList = new ArrayList<>();
        String kindSport = null;
        try{
            stmt = con.prepareStatement("SELECT * FROM Playerslist");
            rs = stmt.executeQuery();
            while(rs.next()){
                kindSport = rs.getString("Kind of sport");
                if(kindSport.equals("Football")){
                    allPlayerList.add(new SoccerPlayer(
                            rs.getString("Name"),
                            rs.getString("Surname"),
                            rs.getInt("Number"),
                            rs.getString("Role"),
                            rs.getString("Team"),
                            rs.getInt("Minutes"),
                            rs.getInt("Goals"),
                            rs.getInt("Assists"),
                            rs.getInt("Yellow cards"),
                            rs.getInt("Red cards"),
                            rs.getInt("Success passes")));
                }
                else if(kindSport.equals("Hockey")){
                    allPlayerList.add(new HockeyPlayer(
                            rs.getString("Name"),
                            rs.getString("Surname"),
                            rs.getInt("Number"),
                            rs.getString("Role"),
                            rs.getString("Team"),
                            rs.getInt("Minutes"),
                            rs.getInt("Goals"),
                            rs.getInt("Assists"),
                            rs.getString("Stick grip"),
                            rs.getInt("Penalty time"),
                            rs.getInt("Penalty count")));
                }
                else if(kindSport.equals("Basketball")){
                    allPlayerList.add(new BasketballPlayer(
                            rs.getString("Name"),
                            rs.getString("Surname"),
                            rs.getInt("Number"),
                            rs.getString("Role"),
                            rs.getString("Team"),
                            rs.getInt("Minutes"),
                            rs.getInt("Goals"),
                            rs.getInt("Assists"),
                            rs.getInt("Rebounds"),
                            rs.getInt("Blocks")));
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return allPlayerList;
    }

    public void closeDB() throws SQLException{
        con.close();
    }
}
