package hu.progmatic.rock_paper_scrissors.service;

import hu.progmatic.rock_paper_scrissors.model.GameElement;
import hu.progmatic.rock_paper_scrissors.model.GameResult;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BasicGameService implements GameService {
    public GameElement userChoice;


    @Override
    public GameElement getUserChoice() {
        return GameElement.ROCK;
    }

    @Override
    public void display(String userChoice, String computerChoice, String result) {
        System.out.println("User choice : " + userChoice);
        System.out.println("Computer choice : " + computerChoice);
        System.out.println("Result : " + result);

    }

    @Override
    public GameResult determineWinner(GameElement userChoice, GameElement computerChoice) {
        if (userChoice == computerChoice) {
            return GameResult.DRAW;
        } else if (userChoice.beats(computerChoice)) {
            return GameResult.WIN;
        } else {
            return GameResult.LOSE;
        }
    }

    @Override
    public GameElement generateComputerChoice() {
        Random random = new Random();
        int randomIndex = random.nextInt(GameElement.values().length);
        return GameElement.values()[randomIndex];
    }

    public void setUserChoice(GameElement userChoice) {
        this.userChoice = userChoice;
    }


}
