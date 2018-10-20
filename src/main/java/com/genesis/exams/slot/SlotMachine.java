package com.genesis.exams.slot;

/**
 * A slot machine is composition of {@link com.genesis.exams.slot.Reel reels}.
 * Each reels is spun using {@link com.genesis.exams.slot.Spinner spinner}, the result of
 * the spin will be evaluated by {@link com.genesis.exams.slot.Evaluator evaluator}.
 *
 * @author etc
 */
public class SlotMachine {

    private Reel[] reels;
    private Spinner spinner;
    private Evaluator evaluator;

    /**
     * Creates an instance of SlotMachine using parameters: reels, spinner and evaluator
     *
     * @param reels     reels of the SlotMachine
     * @param spinner   spinner used to spin the SlotMachine
     * @param evaluator evaluator to be used by this SlotMachine
     */
    public SlotMachine(Reel[] reels, Spinner spinner, Evaluator evaluator) {
        this.reels = reels;
        this.spinner = spinner;
        this.evaluator = evaluator;
    }

    /**
     * Spins the reels in this machine using the {@link com.genesis.exams.slot.Spinner} passed to the constructor.
     * The resulting symbols will be evaluated by {@link com.genesis.exams.slot.Evaluator evaluator} passed to the constructor.
     *
     * @param bet amount of bet
     * @return SpinResult with the symbols and payout.
     */
    public SpinResult spin(long bet) {
        Symbol[] symbols = new Symbol[reels.length];
        for (int i = 0; i < symbols.length; i++) {
            symbols[i] = spinner.spin(reels[i]);
        }
        long payout = evaluator.evaluate(symbols, bet);
        return new SpinResult(symbols, payout);
    }
}
