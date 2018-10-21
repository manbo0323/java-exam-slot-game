package com.genesis.exams.slot;

import java.util.EnumMap;

/**
 * Created by manboyu.
 * Date: 2018/10/21
 * Time: 上午1:15
 */
public enum Symbol {

    BAR(1),
    BELL(1),
    PLUM(1),
    ORANGE(2),
    CHERRY(3),
    LEMON(4);

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
     * BAR BAR BAR * 20
     * BELL BELL BELL * 20
     * PLUM PLUM PLUM * 20
     * BAR BELL PLUM * 30
     */
    public static int multiple(EnumMap<Symbol, Integer> symbolHitCounts) {
        if ((symbolHitCounts.get(BAR) != null && symbolHitCounts.get(BAR) >= 3) ||
                (symbolHitCounts.get(BELL) != null && symbolHitCounts.get(BELL) >= 3) ||
                (symbolHitCounts.get(PLUM) != null && symbolHitCounts.get(PLUM) >= 3)) {
            return 20;
        } else if (symbolHitCounts.get(BAR) != null && (symbolHitCounts.get(BAR) == 1) &&
                symbolHitCounts.get(BELL) != null && (symbolHitCounts.get(BELL) == 1) &&
                symbolHitCounts.get(PLUM) != null && (symbolHitCounts.get(PLUM) == 1)) {
            return 30;
        }
        return 0;
    }
}
