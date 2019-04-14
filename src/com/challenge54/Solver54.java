package com.challenge54;

import com.util.Reader;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by gabor on 2019.03.17..
 */
public class Solver54 {

    public void solve() {
        List<Deal> deals = readFile();
        deals.stream().forEach(System.out::println);

        Map<Player, Long> winning = deals.stream().collect(Collectors.groupingBy(Deal::getWinner, Collectors.counting()));

        System.out.println("Wins : " + winning);
    }

    private List<Deal> readFile() {
        String fileName = "/p054_poker.txt";
        Reader reader = new Reader();

        List<String> lines = reader.readResource(fileName);

        return lines.stream().map(line->convertToHand(line)).collect(Collectors.toList());
    }

    private  Deal convertToHand(String line) {
        String[] cards = line.split(" ");

        Hand hand1 = new Hand(Player.Player1);
        Hand hand2 = new Hand(Player.Player2);

        for (int i=0; i<5; i++) {
            hand1.addCard(CardReader.read(cards[i]));
        }
        for (int i=5; i<10; i++) {
            hand2.addCard(CardReader.read(cards[i]));
        }

        PriorityCalculator priorityCalculator = new PriorityCalculator();
        hand1.setPriority(priorityCalculator.calculate(hand1));
        hand2.setPriority(priorityCalculator.calculate(hand2));

        return new Deal(hand1, hand2);
    }
}
