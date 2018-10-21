import com.genesis.exams.slot.Symbol;
import com.genesis.exams.slot.WeightedRandom;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.EnumMap;
import java.util.List;

/**
 * Created by manboyu.
 * Date: 2018/10/21
 * Time: 下午1:19
 */
public class UnitTest {

    @Test
    public void testWeightedRandom() {
        WeightedRandom<Symbol> weightedRandom = new WeightedRandom<>();
        List<Symbol> symbols = Lists.newArrayList(Symbol.values());
        Assert.assertEquals("6 symbols", 6, symbols.size());
        for (Symbol symbol : symbols) {
            weightedRandom.add(symbol.getWeight(), symbol);
        }
        Symbol symbol = weightedRandom.get();
        System.out.println("weighted random symbol - " + symbol);
        Assert.assertTrue("symbols should contains weighted random symbol", symbols.contains(symbol));
    }

    @Test
    public void testMultiplier() {
        EnumMap<Symbol, Integer> symbolHitCount = new EnumMap<>(Symbol.class);
        symbolHitCount.put(Symbol.BAR, 1);
        symbolHitCount.put(Symbol.BELL, 1);
        symbolHitCount.put(Symbol.PLUM, 1);
        int multiple = Symbol.multiple(symbolHitCount);
        System.out.println("symbol multiple - " + multiple);
        Assert.assertTrue("Symbol not hit !", multiple > 0);
    }
}
