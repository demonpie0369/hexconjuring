package net.hexconjuring.casting.patterns.spells;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import at.petrak.hexcasting.api.misc.MediaConstants;
import at.petrak.hexcasting.api.spell.OperationResult;
import at.petrak.hexcasting.api.spell.OperatorUtils;
import at.petrak.hexcasting.api.spell.ParticleSpray;
import at.petrak.hexcasting.api.spell.RenderedSpell;
import at.petrak.hexcasting.api.spell.SpellAction;
import at.petrak.hexcasting.api.spell.casting.CastingContext;
import at.petrak.hexcasting.api.spell.casting.eval.SpellContinuation;
import at.petrak.hexcasting.api.spell.iota.Iota;
import kotlin.Triple;
import net.hexconjuring.items.HexconjuringItemRegistry;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class OpConjureAxe implements SpellAction {
    /**
     * The number of arguments from the stack that this action requires.
     */
    public OpConjureAxe(){
    }

    @Override
    public int getArgc(){ return 2;}

    public boolean hasCastingSound(@NotNull CastingContext ctx){
        return true;
    }

    public boolean awardsCastingStat(@NotNull CastingContext ctx){
        return true;
    }

    @Override
    public boolean isGreat(){ return false;}

    @Override
    public boolean getCausesBlindDiversion(){ return false;}

    @Override 
    public boolean getAlwaysProcessGreatSpell(){ return false;}

    @Override
    public Text getDisplayName(){ 
        return DefaultImpls.getDisplayName(this);
    }

    @Override
    public Triple<RenderedSpell, Integer, List<ParticleSpray>> execute(List<? extends Iota> args, CastingContext context){

        ServerPlayerEntity player = OperatorUtils.getPlayer(args, 0, getArgc());
        Vec3d pos = player.getPos();
        
        context.assertVecInRange(pos);
        
        Integer durability = OperatorUtils.getPositiveInt(args, 1, getArgc());
        
        ItemStack axeStack = HexconjuringItemRegistry.CONJURED_AXE.get().getDefaultStack();
        axeStack.setCount(1);
        
        axeStack.getOrCreateNbt().putInt("durability", durability);
        
        ItemEntity axe = new ItemEntity(context.getWorld(), pos.getX(), pos.getY(), pos.getZ(), axeStack);
        
        return new Triple<RenderedSpell, Integer, List<ParticleSpray>>(new Spell(axe), MediaConstants.DUST_UNIT, List.of());
        // return List.of(new EntityIota(snack));
    }

    /**
     * This class is responsible for actually making changes to the world. It accepts parameters to
     * define where/what it should affect (for this example the parameter is [player]), and the
     * [cast] method within is responsible for using that data to alter the world.
     */
    public class Spell implements RenderedSpell{
        private ItemEntity axe;
        public Spell(ItemEntity axe){
            this.axe = axe;
        }

        public void cast(CastingContext ctx){
            ctx.getWorld().spawnEntity(axe);
        }
    }

    @Override
    public OperationResult operate(SpellContinuation continuation, List<Iota> stack, Iota ravenmind, CastingContext castingContext){
        return DefaultImpls.operate(this, continuation, stack, ravenmind, castingContext);
    }
}