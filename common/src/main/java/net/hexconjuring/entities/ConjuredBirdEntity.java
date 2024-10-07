package net.hexconjuring.entities;

import com.google.common.collect.Sets;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableShoulderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class ConjuredBirdEntity extends TameableShoulderEntity {

	public ConjuredBirdEntity(EntityType<? extends TameableShoulderEntity> entityType, World world) {
		
		super(entityType, world);
		this.moveControl = new FlightMoveControl(this, 10, false);
		// TODO Auto-generated constructor stub
	}

	private static final Set<Item> SEEDS = Sets.newHashSet(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
	
	public static DefaultAttributeContainer.Builder createAttributes() {
		return MobEntity.createMobAttributes()
				.add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0f)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f)
				.add(EntityAttributes.GENERIC_FLYING_SPEED, 0.8f);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new EscapeDangerGoal(this, 1.25));
		this.goalSelector.add(0, new SwimGoal(this));
		this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
		this.goalSelector.add(2, new SitGoal(this));
		this.goalSelector.add(10, new FollowOwnerGoal(this, 1.0, 5.0f, 1.0f, true));
	}

	@Override
	public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
		return null;
	}

	@Override
	protected EntityNavigation createNavigation(World world) {
		BirdNavigation birdNavigation = new BirdNavigation(this, world);
		birdNavigation.setCanPathThroughDoors(false);
		birdNavigation.setCanSwim(true);
		birdNavigation.setCanEnterOpenDoors(true);
		return birdNavigation;
	}

	@Override
	protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
		return dimensions.height * 0.8f;
	}

	@Override
	public void tickMovement() {
		super.tickMovement();
	}

	@Override
	public ActionResult interactMob(PlayerEntity player, Hand hand) {
		ItemStack itemStack = player.getStackInHand(hand);
		if (itemStack.getItem().isFood() || SEEDS.contains(itemStack.getItem())) {
			if (!player.getAbilities().creativeMode) {
				itemStack.decrement(1);
			}
			if (!this.isSilent()) {
				this.heal(10.0f);
				this.world.sendEntityStatus(this, EntityStatuses.ADD_POSITIVE_PLAYER_REACTION_PARTICLES);
				this.world.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_PARROT_EAT, this.getSoundCategory(), 1.0f, 1.0f + (this.random.nextFloat() - this.random.nextFloat()) * 0.2f);
			}
			return ActionResult.success(this.world.isClient);
		}
		if (!this.isInAir() && this.isTamed() && this.isOwner(player)) {
			if (!this.world.isClient) {
				this.setSitting(!this.isSitting());
			}
			return ActionResult.success(this.world.isClient);
		}
		return super.interactMob(player, hand);
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return false;
	}

	@Override
	public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
		return false;
	}

	@Override
	public boolean canBreedWith(AnimalEntity other) {
		return false;
	}

	@Override
	@Nullable
	public SoundEvent getAmbientSound() {
		return ParrotEntity.getRandomSound(this.world, this.world.random);
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.ENTITY_PARROT_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_PARROT_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(SoundEvents.ENTITY_PARROT_STEP, 0.15f, 1.0f);
	}

	@Override
	public float getSoundPitch() {
		return ConjuredBirdEntity.getSoundPitch(this.random);
	}

	public static float getSoundPitch(Random random) {
		return (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f;
	}

	@Override
	public SoundCategory getSoundCategory() {
		return SoundCategory.NEUTRAL;
	}

	@Override
	public boolean isPushable() {
		return true;
	}

	@Override
	protected void pushAway(Entity entity) {
		if (entity instanceof PlayerEntity) {
			return;
		}
		super.pushAway(entity);
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		if (this.isInvulnerableTo(source)) {
			return false;
		}
		if (!this.world.isClient) {
			this.setSitting(false);
		}
		return super.damage(source, amount);
	}

	public boolean isInAir() {
		return !this.onGround;
	}

}
