package net.hexconjuring.casting.patterns.spells;

import java.util.List;

import net.minecraft.entity.EntityStatuses;
import org.jetbrains.annotations.NotNull;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.RegistrySupplier;
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
import net.hexconjuring.entities.HexconjuringEntityRegistry;
import net.hexconjuring.Hexconjuring;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.hexconjuring.entities.ConjuredBirdEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;

public class OpConjureBird implements SpellAction {
    /**
     * The number of arguments from the stack that this action requires.
     */
    public OpConjureBird(){
    }

    @Override
    public int getArgc(){ return 1;}

    public boolean hasCastingSound(@NotNull CastingContext ctx){
        return true;
    }

    public boolean awardsCastingStat(@NotNull CastingContext ctx){
        return true;
    }

    @Override
    public boolean isGreat(){ return true;}

    @Override
    public boolean getCausesBlindDiversion(){ return true;}

    @Override 
    public boolean getAlwaysProcessGreatSpell(){ return true;}

    @Override
    public Text getDisplayName(){ 
        return DefaultImpls.getDisplayName(this);
    }

    @Override
    public Triple<RenderedSpell, Integer, List<ParticleSpray>> execute(List<? extends Iota> args, CastingContext context){

        Vec3d pos = OperatorUtils.getVec3(args, 0, getArgc());
        
        context.assertVecInRange(pos);
        
        EntityType<ConjuredBirdEntity> type = HexconjuringEntityRegistry.CONJURED_BIRD_ENTITY_TYPE.get();
        
        ConjuredBirdEntity bird = new ConjuredBirdEntity(type, context.getWorld());
        
        bird.setPosition(pos);
        bird.setOwner(context.getCaster());
        context.getWorld().sendEntityStatus(bird, EntityStatuses.ADD_POSITIVE_PLAYER_REACTION_PARTICLES);
        
        return new Triple<RenderedSpell, Integer, List<ParticleSpray>>(new Spell(bird), MediaConstants.DUST_UNIT * 1000, List.of());
        // return List.of(new EntityIota(snack));
    }

    /**
     * This class is responsible for actually making changes to the world. It accepts parameters to
     * define where/what it should affect (for this example the parameter is [player]), and the
     * [cast] method within is responsible for using that data to alter the world.
     */
    public class Spell implements RenderedSpell{
        private ConjuredBirdEntity bird;
        public Spell(ConjuredBirdEntity bird){
            this.bird = bird;
        }

        public void cast(CastingContext ctx){
            ctx.getWorld().spawnEntity(bird);
        }
    }

    @Override
    public OperationResult operate(SpellContinuation continuation, List<Iota> stack, Iota ravenmind, CastingContext castingContext){
        return DefaultImpls.operate(this, continuation, stack, ravenmind, castingContext);
    }
}