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

        while (!validTeam) {
            System.out.println("Enter the home team");
            home = in.nextLine();
            validTeam = validTeam(home);
        }
        System.out.println("Enter the number of goals scored by" + home);
        int hg = in.nextInt();
        in.nextLine();

        while (!validTeam) {
            System.out.println("Enter the away team");
            away = in.nextLine();
            validTeam = validTeam(away);
        }
        System.out.println("Enter the number of goals scored by "+ away);
        int ag = in.nextInt();
        in.nextLine();

        System.out.println("\n"+ home + " " + hg + "-" + ag + " " + away + "\n");
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
}
