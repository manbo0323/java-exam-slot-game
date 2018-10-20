package com.genesis.exams.slot;

import java.util.EnumMap;

/**
 * Created by manboyu.
 * Date: 2018/10/21
 * Time: 上午1:15
 */
public enum Symbol {

    BAR(0.05 * 100),
    BELL(0.10 * 100),
    PLUM(0.11 * 100),
    ORANGE(0.16 * 100),
    CHERRY(0.21 * 100),
    LEMON(0.45 * 100);

    private double weight;

    Symbol(double weight) {
        this.weight = weight;
    }

    /**
     * Method to get the weight of the symbol. Weight usually defines
     * the probability of the symbol to come out of a slot machine.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * BAR BAR BAR * 1,000
     * BELL BELL BELL or BAR * 200
     * PLUM PLUM PLUM or BAR * 150
     * ORANGE ORANGE ORANGE or BAR * 90
     * CHERRY CHERRY CHERRY * 20
     * CHERRY CHERRY --- * 5
     * CHERRY --- --- * 2
     * LEMON LEMON LEMON * 3
     */
    public static int multiple(EnumMap<Symbol, Integer> symbolHitCounts) {
        if (symbolHitCounts.get(BAR) != null && symbolHitCounts.get(BAR) >= 3) {
            return 1000;
        } else if (symbolHitCounts.get(BELL) != null && (symbolHitCounts.get(BELL) >= 3 ||
                symbolHitCounts.get(BELL) == 2 && symbolHitCounts.get(BAR) == 1)) {
            return 200;
        } else if (symbolHitCounts.get(PLUM) != null && (symbolHitCounts.get(PLUM) >= 3 ||
                symbolHitCounts.get(PLUM) == 2 && symbolHitCounts.get(BAR) == 1)) {
            return 150;
        } else if (symbolHitCounts.get(ORANGE) != null && (symbolHitCounts.get(ORANGE) >= 3 ||
                symbolHitCounts.get(ORANGE) == 2 && symbolHitCounts.get(BAR) == 1)) {
            return 90;
        } else if (symbolHitCounts.get(LEMON) != null && symbolHitCounts.get(LEMON) >= 3) {
            return 3;
        } else {
            if (symbolHitCounts.get(CHERRY) != null) {
                switch (symbolHitCounts.get(CHERRY)) {
                    case 3:
                        return 20;
                    case 2:
                        return 5;
                    case 1:
                        return 2;
                    default:
                        return 0;
                }
            }
        }
        return 0;
    }
}
