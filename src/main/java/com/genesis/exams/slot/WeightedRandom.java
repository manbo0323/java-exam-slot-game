package com.genesis.exams.slot;

import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by manboyu.
 * Date: 2018/10/21
 * Time: 上午3:44
 */
public class WeightedRandom<E> {

    private final TreeMap<Double, E> map = new TreeMap<Double, E>();
    private double totalWeight = 0;

    public void add(double weight, E result) {
        if (weight <= 0 || map.containsValue(result)) {
            return;
        }
        totalWeight += weight;
        map.put(totalWeight, result);
    }

    public E get() {
        double value = ThreadLocalRandom.current().nextDouble() * totalWeight;
        return map.ceilingEntry(value).getValue();
    }
}
