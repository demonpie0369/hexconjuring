package net.hexconjuring.registry;

import at.petrak.hexcasting.api.PatternRegistry;
import at.petrak.hexcasting.api.spell.Action;
import at.petrak.hexcasting.api.spell.math.HexDir;
import at.petrak.hexcasting.api.spell.math.HexPattern;
import kotlin.Triple;
import net.hexconjuring.casting.patterns.math.OpSignum;
import net.hexconjuring.casting.patterns.spells.OpConjureAxe;
import net.hexconjuring.casting.patterns.spells.OpConjureBird;
import net.hexconjuring.casting.patterns.spells.OpConjureHoe;
import net.hexconjuring.casting.patterns.spells.OpConjurePickaxe;
import net.hexconjuring.casting.patterns.spells.OpConjureShovel;
import net.hexconjuring.casting.patterns.spells.OpConjureSword;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static net.hexconjuring.Hexconjuring.id;

public class HexconjuringPatternRegistry {
    public static List<Triple<HexPattern, Identifier, Action>> PATTERNS = new ArrayList<>();
    public static List<Triple<HexPattern, Identifier, Action>> PER_WORLD_PATTERNS = new ArrayList<>();
    // IMPORTANT: be careful to keep the registration calls looking like this, or you'll have to edit the hexdoc pattern regex.
    public static HexPattern CONJUREPICKAXE = register(HexPattern.fromAngles("wwdwaqwqwqawq", HexDir.NORTH_EAST), "conjurepickaxe", new OpConjurePickaxe());
    public static HexPattern CONJUREAXE = register(HexPattern.fromAngles("wweqqwqqwqqqw", HexDir.NORTH_EAST), "conjureaxe", new OpConjureAxe());
    public static HexPattern CONJUREHOE = register(HexPattern.fromAngles("wweawqwaqe", HexDir.NORTH_EAST), "conjurehoe", new OpConjureHoe());
    public static HexPattern CONJURESHOVEL = register(HexPattern.fromAngles("wwdawqqqwaq", HexDir.NORTH_EAST), "conjureshovel", new OpConjureShovel());
    public static HexPattern CONJURESWORD = register(HexPattern.fromAngles("wdqqadwqqqwdaqqqw", HexDir.NORTH_EAST), "conjuresword", new OpConjureSword());
    public static HexPattern CONJUREBIRD = register(HexPattern.fromAngles("qeweeewedw", HexDir.NORTH_EAST), "conjurebird", new OpConjureBird());
    public static HexPattern SIGNUM = register(HexPattern.fromAngles("edd", HexDir.NORTH_WEST), "signum", new OpSignum());

    public static void init() {
        try {
            for (Triple<HexPattern, Identifier, Action> patternTriple : PATTERNS) {
                PatternRegistry.mapPattern(patternTriple.getFirst(), patternTriple.getSecond(), patternTriple.getThird());
            }
            for (Triple<HexPattern, Identifier, Action> patternTriple : PER_WORLD_PATTERNS) {
                PatternRegistry.mapPattern(patternTriple.getFirst(), patternTriple.getSecond(), patternTriple.getThird(), true);
            }
        } catch (PatternRegistry.RegisterPatternException e) {
            e.printStackTrace();
        }
    }

    private static HexPattern register(HexPattern pattern, String name, Action action) {
        Triple<HexPattern, Identifier, Action> triple = new Triple<>(pattern, id(name), action);
        PATTERNS.add(triple);
        return pattern;
    }

    private static HexPattern registerPerWorld(HexPattern pattern, String name, Action action) {
        Triple<HexPattern, Identifier, Action> triple = new Triple<>(pattern, id(name), action);
        PER_WORLD_PATTERNS.add(triple);
        return pattern;
    }
}
