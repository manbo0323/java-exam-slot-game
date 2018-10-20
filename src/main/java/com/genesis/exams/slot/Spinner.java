package com.genesis.exams.slot;

/**
 * Spins a reels and returning the symbol
 * as a result of the spin.
 * @author etc
 *
 */
public interface Spinner {

    Symbol spin(Reel reel);
}
