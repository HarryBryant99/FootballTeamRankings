public class Game {
    final Team home;
    final Team away;
    final int hg;
    final int ag;

    public Game(Team home, Team away, int hg, int ag) {
        this.home = home;
        this.away = away;
        this.hg = hg;
        this.ag = ag;
    }

    public Team getHome() {
        return home;
    }

    public Team getAway() {
        return away;
    }

    public int getHg() {
        return hg;
    }

    public int getAg() {
        return ag;
    }

    public String print(){
        return getHome().getName() + " " + getHg() + "-" + getAg() + " " + getAway().getName();
    }
}
