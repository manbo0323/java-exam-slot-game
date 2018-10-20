package com.genesis.exams.slot;

import java.util.List;

/**
 * A Reel instance is composed of symbols.
 *
 * @author etc
 */
public class Reel {

    private List<Symbol> symbols;

    /**
     * Creates an instance of Reel with symbols
     *
     * @param symbols
     */
    public Reel(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    /**
     * Returns the symbols of this reel
     *
     * @return the symbols of this reel
     */
    public List<Symbol> getSymbols() {
        return symbols;
    }

}
