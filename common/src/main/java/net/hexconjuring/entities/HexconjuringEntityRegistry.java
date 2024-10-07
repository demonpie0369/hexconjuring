package net.hexconjuring.entities;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.ModInitializer;
import net.hexconjuring.Hexconjuring;
import net.hexconjuring.entities.ConjuredBirdEntity;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

public class HexconjuringEntityRegistry{

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Hexconjuring.MOD_ID, Registry.ENTITY_TYPE_KEY);
    
    public static void init() {
        ENTITY_TYPES.register();
        EntityAttributeRegistry.register(CONJURED_BIRD_ENTITY_TYPE, ConjuredBirdEntity::createAttributes);
    }
    
    public static final RegistrySupplier<EntityType<ConjuredBirdEntity>> CONJURED_BIRD_ENTITY_TYPE = ENTITY_TYPES.register(
    		"conjured_bird", () ->
    		EntityType.Builder.create(ConjuredBirdEntity::new, SpawnGroup.MISC)
    			.setDimensions(0.35f, 0.5f)
    			.build("conjured_bird")
    		);
}