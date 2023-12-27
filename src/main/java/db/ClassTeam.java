package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClassTeam {
    private int mId;
    private  String mName;
    private  String  mGamePriority;
    private int mTotalPlayer;
    private String mGamePlane;
    private String  mAwards;
    public ArrayList<ClassPlayer> mPlayers;
    private  ClassPlayer mCurrentPlayer;
    private  ConnexionASdb connexionASdb;
    public ClassTeam(int id) throws Exception {
        mId = id;
        connexionASdb = new ConnexionASdb();
    }
    public void initialiseTeam() throws SQLException {
        String sqlReqCoach = "SELECT * FROM ba_Team WHERE id"+mId;
        Statement statementCoach= connexionASdb.getStatement();
        ResultSet res =  statementCoach.executeQuery(sqlReqCoach);
        if(res != null && res.next()){
        //
            this.mId =  res.getInt("id");
            this.mGamePlane = res.getString("gamePlan");
            this.mGamePriority = res.getString("gamePriority");
        // Filling of  mPlayers...
            String sqlReqPlayer="SELECT * FROM ba_player WHERE idTeam="+mId;
            Statement statementPlayer = connexionASdb.getStatement();
            ResultSet resultSet = statementPlayer.executeQuery(sqlReqPlayer);
            while(resultSet!=null && resultSet.next()){
                this.mPlayers.add(new ClassPlayer(resultSet.getInt("id")));
            }
        }
    }
    public void add(String []fields,String[] values) throws Exception {
        int id = connexionASdb.insert("ba_player",fields,values);
        mPlayers.add(new ClassPlayer(id));
    }
    public void update(String[] fields,String[] values) throws SQLException {
        connexionASdb.update(mCurrentPlayer.getId(),"ba_player",fields,values);
    }
    public void delete(int id) throws SQLException {
        mPlayers.remove(mCurrentPlayer);
        connexionASdb.delete("ba_player",id);
    }
    public void setId(int mId) { this.mId = mId;}
    public void setGamePlane(String mGamePlane) { this.mGamePlane = mGamePlane;}
    public void setName(String mName) {this.mName = mName;}
    public void setCurrentPlayer(ClassPlayer mCurrentPlayer) {this.mCurrentPlayer = mCurrentPlayer; }
    public void setGamePriority(String mGamePriority) {this.mGamePriority = mGamePriority;}
    public void setTotalPlayer(int mTotalPlayer) {this.mTotalPlayer = mTotalPlayer;}
    public void setAwards(String mAwards) {this.mAwards = mAwards;}
    public int getId() { return mId;}
    public static void main(String[] args){
        String[] fields;
        String[] values;

    }
}