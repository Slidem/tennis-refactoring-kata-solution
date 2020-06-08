package tennis.refactoring.kata.solution;

public class TennisGameRefactored implements TennisGame {

	private static final String PLAYER_1 = "player1";

	private int player1Score = 0;
	private int player2Score = 0;

	public void wonPoint(String playerName) {
		if (playerName.equals(PLAYER_1)) {
			player1Score += 1;
		} else {
			player2Score += 1;
		}
	}

	public String getScore() {

		if (!advantagePointReached()) {
			return player1Score == player2Score ? translateScoreForEquality() : translateScore();
		}
		return translateScoreForAdvantagePoint();
	}

	private boolean advantagePointReached() {
		return (player1Score >= 4 || player2Score >= 4) && player1Score != player2Score;
	}

	private String translateScoreForAdvantagePoint() {
        int scoreDiff = player1Score - player2Score;
        if (scoreDiff == 1) {
            return "Advantage player1";
        } else if (scoreDiff == -1) {
            return "Advantage player2";
        } else if (scoreDiff >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String translateScoreForEquality() {
        switch (player1Score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";

        }
    }

    private String translateScore() {

        return translateScoreFor(player1Score) + "-" + translateScoreFor(player2Score);
	}

    private String translateScoreFor(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }


}
