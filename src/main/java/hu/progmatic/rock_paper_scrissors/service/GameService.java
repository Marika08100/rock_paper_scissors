package hu.progmatic.rock_paper_scrissors.service;

import hu.progmatic.rock_paper_scrissors.model.GameElement;
import hu.progmatic.rock_paper_scrissors.model.GameResult;

public interface GameService {
    String getUserChoice();
    void display(String userChoice,String computerChoice,String result);
    GameResult determineWinner(GameElement userChoice,GameElement computerChoice);
    GameElement generateComputerChoice();

}
