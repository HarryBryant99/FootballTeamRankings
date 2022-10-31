public class Team {
    private final String name;
    private int ranking;
    private int gamesPlayed;
    private double score1;
    private double score2;

    public Team(String name, int ranking, int gamesPlayed, double score1, double score2) {
        this.name = name;
        this.ranking = ranking;
        this.gamesPlayed = gamesPlayed;
        this.score1 = score1;
        this.score2 = score2;
    }

    public String getName() {
        return name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public double getScore1() {
        return score1;
    }

    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public double getScore2() {
        return score2;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
    }

    public String print(){
        return getName() + "," +
                getRanking() + "," +
                getGamesPlayed() + "," +
                getScore1() + "," +
                getScore2() + ",";
    }
}
