package hu.progmatic.rock_paper_scrissors.model;

public enum GameResult {
    WIN("You win!"),
    LOSE("You lose!"),
    DRAW("It's a draw!");

    private final String message;

    GameResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
