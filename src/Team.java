public class Team {
    private final String name;
    private int ranking;
    private int gamesPlayed;
    private int newGamesPlayed;
    private double score;
    private double score1;
    private double score2;
    private double points;

    public Team(String name, int ranking, double score, int gamesPlayed, double score1, double score2) {
        this.name = name;
        this.ranking = ranking;
        this.score = score;
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
                getScore() + "," +
                getGamesPlayed() + "," +
                getScore1() + "," +
                getScore2() + ",";
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public int getNewGamesPlayed() {
        return newGamesPlayed;
    }

    public void setNewGamesPlayed(int newGamesPlayed) {
        this.newGamesPlayed = newGamesPlayed;
    }

    public void computeScore(){
        if (getNewGamesPlayed() > 0){
            setGamesPlayed(getGamesPlayed()+getNewGamesPlayed());
            setScore2(getScore1());
            setScore1(getPoints()/newGamesPlayed);
        }
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double combinedScore(){
        setScore(getScore1() + getScore2());
        return getScore();
    }
}
