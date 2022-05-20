package game.PlayerManagement;

import org.json.simple.JSONObject;

public class PlayerStats {

    public static String [][]info = new String[100][4];
    int id = 0;

    /**
     * Setting a Player stats in our database.
     * @param name Player name.
     * @param id Player ID.
     * @param wins Player number of wins.
     */
    public static void setStats (String name,int id,String wins,String played){
        info[id][0] = name;
        info[id][1] = wins;
        info[id][2] = played;
    }


    /**
     * Calculates the win rate of the player.
     * @param id Player ID.
     * @return Returns the player win rate.
     */
    public String getWinPercentage(int id){
        String winpt;
        float win =  Integer.parseInt(getWins(id));
        float played = Integer.parseInt(getPlayed(id));
        float wpt = (win/played)*100;
        winpt = wpt+" %";
        return winpt;
    }


    /**
     * Give us the Player name by ID.
     * @param id the Player ID.
     */
    public String getName(int id) {
        return info[id][0];
    }


    /**
     * Give us the Player ID.
     * @param name the player name.
     * @return the ID of our searched player.
     */
    public int getID(String name){

        for(int i = 0;i<100;i++){
            if(name.equals(info[i][0])){
                id = i;
                break;
            }}
        return id;
    }


    /**
     * Checks if this Player is already in our database or not.
     * @param name Player name ,we want to know if it exist or not.
     * @return boolean.
     */
    public boolean isExist(String name) {
        boolean exist = false;
        for (int i = 0; i < 100; i++) {
            if (name.equals(info[i][0])) {
                exist = true;
                break;
            } else {
                exist = false;
            }
        }
        return exist;
    }


    /**
     * Give the number of our player current wins.
     * @param id player ID.
     */
    public String getWins(int id) {return info[id][1];}


    /**
     * Give the number of our player current played games.
     * @param id player ID.
     */
    public String getPlayed(int id) {return info[id][2];}


    /**
     * Set the player number of wins.
     * @param wins current wins.
     * @param id the Player ID.
     */
    public void setWins(int wins,int id){
        info[id][1] = String.valueOf(wins);
    }


    /**
     * Set the player number of played games.
     * @param played current played games.
     * @param id the Player ID.
     */
    public void setPlayed(int played,int id){
        info[id][2] = String.valueOf(played);
    }


    /**
     * Converts the players data to a JSON object.
     * @param id player ID.
     * @return JSON Object.
     */
    public JSONObject toJSONObject(int id){
        JSONObject jo = new JSONObject();
        jo.put("Name",info[id][0]);
        jo.put("ID",getID(info[id][0]));
        jo.put("WINS",info[id][1]);
        jo.put("PLAYED",info[id][2]);
        return jo;}
}
