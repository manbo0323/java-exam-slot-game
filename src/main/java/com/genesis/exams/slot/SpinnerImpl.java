package com.genesis.exams.slot;

import org.apache.commons.lang3.RandomUtils;

import java.util.List;

import static com.google.common.base.Preconditions.checkElementIndex;

/**
 * Created by manboyu.
 * Date: 2018/10/20
 * Time: 下午12:59
 */
public class SpinnerImpl implements Spinner {

    @Override
    public Symbol spin(Reel reel) {
        WeightedRandom<Symbol> weightedRandom = new WeightedRandom<>();
        List<Symbol> symbols = reel.getSymbols();
        for (Symbol symbol : symbols) {
            weightedRandom.add(symbol.getWeight(), symbol);
        }
        return weightedRandom.get();
    }
}
