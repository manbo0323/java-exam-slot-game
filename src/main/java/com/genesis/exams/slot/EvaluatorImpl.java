package com.genesis.exams.slot;

import com.google.common.base.Joiner;
import com.google.common.collect.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manboyu.
 * Date: 2018/10/20
 * Time: 下午12:58
 */
public class EvaluatorImpl implements Evaluator {

    @Override
    public long evaluate(Symbol[] symbolArray, long bet) {
        List<Symbol> symbols = Lists.newArrayList(symbolArray);
        System.out.println(Joiner.on("--").join(symbols));
        EnumMap<Symbol, Integer> symbolHitCounts = symbolHitCount(symbols);
        System.out.println("Symbols Hit - " + symbolHitCounts);
        int multiple = Symbol.multiple(symbolHitCounts);
        System.out.println("multiple - " + multiple);
        return bet * multiple;
    }

    private EnumMap<Symbol, Integer> symbolHitCount(List<Symbol> symbols) {
        Multiset<Symbol> symbolCount = HashMultiset.create();
        symbolCount.addAll(symbols);
        ImmutableMultiset<Symbol> copyHighestCountFirst = Multisets.copyHighestCountFirst(symbolCount);
        EnumMap<Symbol, Integer> symbolHitCount = new EnumMap<>(Symbol.class);
        for (Multiset.Entry<Symbol> entry : copyHighestCountFirst.entrySet()) {
            symbolHitCount.put(entry.getElement(), entry.getCount());
        }
        return symbolHitCount;
    }
}
