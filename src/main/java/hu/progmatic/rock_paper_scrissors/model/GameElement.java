package hu.progmatic.rock_paper_scrissors.model;

import hu.progmatic.rock_paper_scrissors.service.GameService;

public enum GameElement {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");
    private final String displayName;

    GameElement(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public boolean beats(GameElement opponent) {
        switch (this) {
            case ROCK -> {
                return opponent == SCISSORS;
            }
            case SCISSORS -> {
                return opponent == PAPER;
            }
            case PAPER -> {
                return opponent == ROCK;
            }
            default -> throw new IllegalArgumentException("Invalid choice!");
        }
    }


}
