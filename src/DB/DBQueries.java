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
        stmt = con.prepareStatement("CREATE TABLE if not exists Players "    +
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

    public int maxID() throws SQLException {
       stmt = con.prepareStatement("SELECT MAX(ID_player) FROM Players");
       rs = stmt.executeQuery();
       int id = rs.getInt("MAX(ID_player)") + 1;
       return  id;
   }

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
                "(ID_sport," +
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

    public void deletePl(int id) throws SQLException {
        stmt = con.prepareStatement("DELETE FROM Statistics WHERE ID_player = ?");
        stmt.setObject(1, id);
        stmt.execute();
        stmt = con.prepareStatement("DELETE FROM Players WHERE ID_player = ?");
        stmt.setObject(1, id);
        stmt.execute();
        stmt.close();
    }

    public void updateSoccer(String name, String surname, int number, String role, String team, int mins, int goals, int assists, int yc, int rc, int succPasses, int ID) throws SQLException {
        stmt = con.prepareStatement("UPDATE Statistics set Minutes = ?, Goals = ?, Assists = ?, YC = ?, RC = ?, Succ_passes = ? WHERE ID_player = ?");
        stmt.setObject(1, mins);
        stmt.setObject(2, goals);
        stmt.setObject(3, assists);
        stmt.setObject(4, yc);
        stmt.setObject(5, rc);
        stmt.setObject(6, succPasses);
        stmt.setObject(7, ID);
        stmt.executeUpdate();
        stmt = con.prepareStatement("UPDATE Players set Name = ?, Surname = ?, Number = ?, Role = ?, Team = ? WHERE ID_player = ?");
        stmt.setObject(1, name);
        stmt.setObject(2, surname);
        stmt.setObject(3, number);
        stmt.setObject(4, role);
        stmt.setObject(5, team);
        stmt.setObject(6, ID);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updateHockeyPl(String name, String surname, int number, String role, String team, int mins, int goals, int assists, String stickGrip, int penTime, int penCount, int ID) throws SQLException {
        stmt = con.prepareStatement("UPDATE Statistics set Minutes = ?, Goals = ?, Assists = ?, Stick_grip = ?, Penalty_time = ?, Penalty_count = ? WHERE ID_player = ?");
        stmt.setObject(1, mins);
        stmt.setObject(2, goals);
        stmt.setObject(3, assists);
        stmt.setObject(4, stickGrip);
        stmt.setObject(5, penTime);
        stmt.setObject(6, penCount);
        stmt.setObject(7, ID);
        stmt.executeUpdate();
        stmt = con.prepareStatement("UPDATE Players set Name = ?, Surname = ?, Number = ?, Role = ?, Team = ? WHERE ID_player = ?");
        stmt.setObject(1, name);
        stmt.setObject(2, surname);
        stmt.setObject(3, number);
        stmt.setObject(4, role);
        stmt.setObject(5, team);
        stmt.setObject(6, ID);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updateBasketPl(String name, String surname, int number, String role, String team, int mins, int goals, int assists, int rebounds, int blocks, int ID) throws SQLException {
        stmt = con.prepareStatement("UPDATE Statistics set Minutes = ?, Goals = ?, Assists = ?, Rebounds = ?, Blocks = ? WHERE ID_player = ?");
        stmt.setObject(1, mins);
        stmt.setObject(2, goals);
        stmt.setObject(3, assists);
        stmt.setObject(4, rebounds);
        stmt.setObject(5, blocks);
        stmt.setObject(6, ID);
        stmt.executeUpdate();
        stmt = con.prepareStatement("UPDATE Players set Name = ?, Surname = ?, Number = ?, Role = ?, Team = ? WHERE ID_player = ?");
        stmt.setObject(1, name);
        stmt.setObject(2, surname);
        stmt.setObject(3, number);
        stmt.setObject(4, role);
        stmt.setObject(5, team);
        stmt.setObject(6, ID);
        stmt.executeUpdate();
        stmt.close();
    }

    public SoccerPlayer getSoccer(int id) throws SQLException{
        SoccerPlayer soccerPlayer = null;
        stmt = con.prepareStatement("SELECT * FROM Playerslist WHERE [ID player] = ?");
        stmt.setObject(1, id);
        rs = stmt.executeQuery();
        while(rs.next()){
            soccerPlayer = new SoccerPlayer(
                    rs.getInt("ID player"),
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
                    rs.getInt("Success passes"));
        }
        stmt.close();
        return soccerPlayer;
    }

    public HockeyPlayer getHockeyPl(int id) throws SQLException{
        HockeyPlayer hockeyPlayer = null;
        stmt = con.prepareStatement("SELECT * FROM Playerslist WHERE [ID player] = ?");
        stmt.setObject(1, id);
        rs = stmt.executeQuery();
        while (rs.next()){
            hockeyPlayer = new HockeyPlayer(
                    rs.getInt("ID player"),
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
                    rs.getInt("Penalty count"));
        }
        stmt.close();
        return hockeyPlayer;
    }

    public BasketballPlayer getBasketPl(int id) throws SQLException{
        BasketballPlayer basketballPlayer = null;
        stmt = con.prepareStatement("SELECT * FROM Playerslist WHERE [ID player] = ?");
        stmt.setObject(1, id);
        rs = stmt.executeQuery();
        while (rs.next()){
            basketballPlayer = new BasketballPlayer(
                    rs.getInt("ID player"),
                    rs.getString("Name"),
                    rs.getString("Surname"),
                    rs.getInt("Number"),
                    rs.getString("Role"),
                    rs.getString("Team"),
                    rs.getInt("Minutes"),
                    rs.getInt("Goals"),
                    rs.getInt("Assists"),
                    rs.getInt("Rebounds"),
                    rs.getInt("Blocks"));
        }
        stmt.close();
        return basketballPlayer;
    }

    public ArrayList<Player> getAllSoccersList() {
        ArrayList<Player> allSoccersList = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM Playerslist WHERE [ID sport] = 1");
            rs = stmt.executeQuery();
            while(rs.next()){
                allSoccersList.add(new SoccerPlayer(
                        rs.getInt("ID player"),
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
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return allSoccersList;
    }

    public ArrayList<Player> getAllHockeyPlsList() throws SQLException {
        ArrayList<Player> allHockeyPlsList = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM Playerslist WHERE [ID sport] = 2");
            rs = stmt.executeQuery();
            while(rs.next()){
                allHockeyPlsList.add(new HockeyPlayer(
                        rs.getInt("ID player"),
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
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return allHockeyPlsList;
    }

    public ArrayList<Player> getAllBasketPlsList() throws SQLException {
        ArrayList<Player> allBasketPlsList = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM Playerslist WHERE [ID sport] = 3");
            rs = stmt.executeQuery();
            while(rs.next()){
                allBasketPlsList.add(new BasketballPlayer(
                        rs.getInt("ID player"),
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
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return allBasketPlsList;
    }

    public ArrayList<Player> getAllPlayersList() {
        ArrayList<Player> allPlayerList = new ArrayList<>();
        String kindSport = null;
        try{
            stmt = con.prepareStatement("SELECT * FROM Playerslist");
            rs = stmt.executeQuery();
            while(rs.next()){
                kindSport = rs.getString("Kind of sport");
                if(kindSport.equals("Football")){
                    allPlayerList.add(new SoccerPlayer(
                            rs.getInt("ID player"),
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
                            rs.getInt("ID player"),
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
                            rs.getInt("ID player"),
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

    public void closeDB() throws SQLException {
        con.close();
    }
}
