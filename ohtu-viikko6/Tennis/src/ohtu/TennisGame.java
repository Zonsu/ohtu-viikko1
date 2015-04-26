package ohtu;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            player1Scores();
        } else {
            player2Scores();
        }
    }

    public void player1Scores() {
        player1Score += 1;
    }

    public void player2Scores() {
        player2Score += 1;
    }

    public String getTiedScore(int score) {
        String scoreMessages[] = {"Love-All", "Fifteen-All", "Thirty-All", "Forty-All", "Deuce"};
        return scoreMessages[score];
    }

    public String getAdvantageMessage() {

        int playerScoreDifference = player1Score - player2Score;
        if (playerScoreDifference == 1) {
            return "Advantage player1";
        } else {
            return "Advantage player2";
        }
    }

    public String getWinMessage() {

        int playerScoreDifference = player1Score - player2Score;
        if (playerScoreDifference >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    public String playerMessages(int msgIndex) {
        String scoreMessages[] = {"Love", "Fifteen", "Thirty", "Forty"};
        return scoreMessages[msgIndex];
    }

    public String getPlayer1Message() {
        return playerMessages(player1Score);
    }

    public String getPlayer2Message() {
        return playerMessages(player2Score);
    }

    public String getScore() {
        String score = "";

        if (player1Score == player2Score) {
            score = getTiedScore(player1Score);

        } else if (player1Score >= 4 || player2Score >= 4) {
            int playerScoreDifference = Math.abs(player1Score - player2Score);

            if (playerScoreDifference < 2) {
                score = getAdvantageMessage();
            } else {
                score = getWinMessage();
            }

        } else {
            score = getPlayer1Message() + "-" + getPlayer2Message();

        }
        return score;
    }
}
