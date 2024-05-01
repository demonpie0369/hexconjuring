package net.hexconjuring.entities;

import dev.architectury.registry.registries.Registries;
import net.fabricmc.api.ModInitializer;
import net.hexconjuring.Hexconjuring;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityType.Builder;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

public class HexconjuringEntityRegistry implements ModInitializer{

	public static final EntityType<BirdEntity> BIRD = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(Hexconjuring.MOD_ID, "bird"),
            EntityType.register("bird", Builder.create(BirdEntity::new, SpawnGroup.CREATURE)).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );
	
	@Override
	public void onInitialize() {
		// TODO Auto-generated method stub
		
	}
	
}
