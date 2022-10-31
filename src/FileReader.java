import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class FileReader {
    /**
     * Takes in the filename and creates a scanner if the file exists and is readable. If not an exception is thrown
     *
     * @param filename The file that is to be read.
     * @return a list of names stored in an array list is returned.
     */
    public ArrayList readFile(String filename) {
        Scanner in = null;
        File inputFile = new File(filename);

        //Try catch block to remove the FileNotFoundException if the user enters a file not recognised by the program.
        try {
            in = new Scanner(inputFile);
            //This sets the scanner to look in the input file rather than null.
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open " + filename);
            System.exit(0);
            /* If the file the user is trying to open isn't found the exception is caught and dealt with so that the
             * program doesn't crash. The user gets an error message on screen alerting them that the file hasn't been
             * opened and therefore the program won't continue.
             */
        }

        return readNames(in);
    }

    /**
     * Returns all the current users of the system.
     *
     * @param lineIn The scanner to read the lines in the file.
     * @return The contents of the file is returned.
     */
    private ArrayList<Team> readNames(Scanner lineIn) {
        // Array list to store all the users read from the file.
        ArrayList<Team> listRead = new ArrayList<>();

        lineIn.useDelimiter(",");

        String teamname = "";
        int ranking = 0;
        double score = 0.0;
        int gp = 0;
        double score1 = 0.0;
        double score2 = 0.0;

        // Loop runs until there are no more rows left to read, adding each user to the array list.
        while (lineIn.hasNext()) {
            teamname = lineIn.next();
            if (teamname.contains("\r\n")) {
                teamname = teamname.substring(2);
            } else if (teamname.substring(0,1).equalsIgnoreCase("\n")){
                teamname = teamname.substring(1);
            }

            ranking = lineIn.nextInt();
            score = lineIn.nextDouble();
            gp = lineIn.nextInt();
            score1 = lineIn.nextDouble();
            score2 = lineIn.nextDouble();

            Team newTeam = new Team(teamname, ranking, score, gp, score1, score2);
            listRead.add(newTeam);


        }
        return listRead;
    }

    public void writeTeams(ArrayList<Team> teams) throws IOException {
        Writer fileWriter = new FileWriter("ranking.txt");
        int counter = 0;
        for (Team t:teams) {
            fileWriter.write(t.print());
            counter++;
            if (counter < teams.size()) {
                fileWriter.write("\n");
            }
        }
        fileWriter.close();
    }
}
