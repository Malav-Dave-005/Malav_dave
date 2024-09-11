//NAME:-CRICKET SCORE TRACKER.
//ENROLLMENTNNO:-2202171510009.
//DATE:-06-10-2023.
//SUBJECT:-JAVA-2.
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CricketMatch
{
    private String team1;
    private String team2;
    private int score1;
    private int score2;

    public CricketMatch(String team1, String team2)
    {
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = 0;
        this.score2 = 0;
    }

    public void updateScore(int teamNumber, int runs)
    {
        if (teamNumber == 1)
        {
            score1 += runs;
        }
        else if (teamNumber == 2)
        {
            score2 += runs;
        }
    }

    public String getMatchSummary()
    {
        return team1 + " vs " + team2 + ": " + score1 + " - " + score2;
    }
}

public class CricketScoreTracker
{
    private static Map<Integer, CricketMatch> matchMap = new HashMap<>();
    private static int matchCounter = 1;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("Cricket Score Tracker Menu:");
            System.out.println("1. Start a new match");
            System.out.println("2. Update score");
            System.out.println("3. View match details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice)
            {
                case 1:
                    startNewMatch(scanner);
                    break;
                case 2:
                    updateScore(scanner);
                    break;
                case 3:
                    viewMatchDetails(scanner);
                    break;
                case 4:
                    //saveMatchDataToFile();
                    scanner.close();
                    System.out.println("Exiting the Cricket Score Tracker");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void startNewMatch(Scanner scanner)
    {
        System.out.print("Enter Team 1 name: ");
        String team1 = scanner.nextLine();

        System.out.print("Enter Team 2 name: ");
        String team2 = scanner.nextLine();

        CricketMatch match = new CricketMatch(team1, team2);
        matchMap.put(matchCounter, match);
        System.out.println("New match started with ID: " + matchCounter);
        matchCounter++;
    }

    private static void updateScore(Scanner scanner)
    {
        System.out.print("Enter match ID: ");
        int matchId = scanner.nextInt();

        if (matchMap.containsKey(matchId))
        {
            CricketMatch match = matchMap.get(matchId);
            System.out.print("Enter team number (1 or 2): ");
            int teamNumber = scanner.nextInt();
            System.out.print("Enter runs scored: ");
            int runs = scanner.nextInt();
            match.updateScore(teamNumber, runs);
            System.out.println("Score updated.");
        }
        else
        {
            System.out.println("Match not found.");
        }
    }

    private static void viewMatchDetails(Scanner scanner)
    {
        System.out.print("Enter match ID: ");
        int matchId = scanner.nextInt();

        if (matchMap.containsKey(matchId))
        {
            CricketMatch match = matchMap.get(matchId);
            System.out.println(match.getMatchSummary());
        }
        else
        {
            System.out.println("Match not found.");
        }
    }
}