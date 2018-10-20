package com.genesis.exams.slot;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.ObjectArrays;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by manboyu.
 * Date: 2018/10/19
 * Time: 下午7:08
 */
public class SlotMachineSimulation {

    public static void main(String[] args) {
        int numberOfReels = 3;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the amount you would like to bet: $");
        long bet = input.nextLong();
        List<Reel> reelList = Lists.newArrayListWithCapacity(numberOfReels);
        for (int i = 0; i < numberOfReels; i++) {
            reelList.add(new Reel(Lists.newArrayList(Symbol.values())));
        }
        Reel[] reels = Iterables.toArray(reelList, Reel.class);
        Evaluator evaluator = new EvaluatorImpl();
        Spinner spinner = new SpinnerImpl();
        SlotMachine slotMachine = new SlotMachine(reels, spinner, evaluator);
        SpinResult result = slotMachine.spin(bet);
        DecimalFormat dollar = new DecimalFormat("#,##0.00");
        System.out.println("You win $" + dollar.format(result.getPayout()));
    }
}
