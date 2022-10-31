import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Team> teams = new ArrayList<>();
    private static ArrayList<String> names = new ArrayList<>();

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader();

        teams = fr.readFile("ranking.txt");
        listOfTeamNames();
        addGames();

        for (Team t:teams) {
            t.computeScore();
        }

        teams = sort(teams);

        for (int i = 0; i < teams.size(); i++) {
            teams.get(i).setRanking(i+1);
        }

        fr.writeTeams(teams);
    }

    private static void addGames(){
        String more = "yes";
        while (more.equalsIgnoreCase("yes") || more.equalsIgnoreCase("y")){
            newGame();
            System.out.println("Add another game?");
            more = in.nextLine();
        }
    }

    private static void newGame(){
        boolean validTeam = false;
        String home = null;
        String away = null;
        Game newGame = null;

        String correct = "no";
        while (!correct.equalsIgnoreCase("yes") && !correct.equalsIgnoreCase("y")){
            while (!validTeam) {
                System.out.println("Enter the home team");
                home = in.nextLine();
                validTeam = validTeam(home);
            }
            System.out.println("Enter the number of goals scored by " + home);
            int hg = in.nextInt();
            in.nextLine();

            validTeam = false;
            while (!validTeam) {
                System.out.println("Enter the away team");
                away = in.nextLine();
                validTeam = validTeam(away);
            }
            System.out.println("Enter the number of goals scored by " + away);
            int ag = in.nextInt();
            in.nextLine();

            newGame = new Game(teams.get(names.indexOf(home)), teams.get(names.indexOf(away)), hg,
                            ag);
            System.out.println("\n" + newGame.print());

            System.out.println("\nCorrect?");
            correct = in.nextLine();
        }
        computeResult(newGame);
    }

    private static void computeResult(Game g){
        g.getHome().setNewGamesPlayed(g.getHome().getNewGamesPlayed()+1);
        g.getAway().setNewGamesPlayed(g.getAway().getNewGamesPlayed()+1);

        if (g.getHg() > g.getAg()){
            g.getHome().setPoints(g.getHome().getPoints()+win(g.getAway()));
            g.getAway().setPoints(g.getAway().getPoints()+loss(g.getHome()));
        } else if (g.getHg() == g.getAg()){
            g.getHome().setPoints(g.getHome().getPoints()+draw(g.getAway()));
            g.getAway().setPoints(g.getAway().getPoints()+draw(g.getHome()));
        } else if (g.getHg() < g.getAg()){
            g.getHome().setPoints(g.getHome().getPoints()+loss(g.getAway()));
            g.getAway().setPoints(g.getAway().getPoints()+win(g.getHome()));
        } else {
            throw new IllegalStateException("?");
        }
    }

    private static double win (Team t){
        return Math.round((3*(50-t.getRanking()))*100.0)/100.0;
    }

    private static double draw (Team t){
        return Math.round(((50-t.getRanking()))*100.0)/100.0;
    }

    private static double loss (Team t){
        return Math.round((0.01*(50-t.getRanking()))*100.0)/100.0;
    }

    private static void listOfTeamNames(){
        for (Team t:teams) {
            names.add(t.getName());
        }
    }

    private static boolean validTeam(String name){
        if (names.contains(name)){
            return true;
        } else {
            return false;
        }
    }

    private static ArrayList<Team> sort (ArrayList<Team> listOfTeams){
        boolean changesMade = true;
        Team temp;
        while (changesMade){
            changesMade = false;
            for (int i = 0; i < listOfTeams.size(); i++) {
                if (i != listOfTeams.size()-1) {
                    if (listOfTeams.get(i).combinedScore() <
                            listOfTeams.get(i + 1).combinedScore()) {
                        temp = listOfTeams.get(i);
                        listOfTeams.set(i, listOfTeams.get(i + 1));
                        listOfTeams.set(i + 1, temp);
                        changesMade = true;
                    }
                }
            }
        }
        return listOfTeams;
    }
}
