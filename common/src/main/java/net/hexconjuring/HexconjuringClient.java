package net.hexconjuring;

import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.hexconjuring.entities.ConjuredBirdRenderer;
import net.hexconjuring.entities.HexconjuringEntityRegistry;
import net.hexconjuring.entities.models.ConjuredBirdEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

/**
 * Common client loading entrypoint.
 */
public class HexconjuringClient {
	
	public static final EntityModelLayer MODEL_BIRD_LAYER = new EntityModelLayer(new Identifier("hexconjuring:conjured_bird"), "main");
	
    public static void init() {
    	
    	EntityRendererRegistry.register(HexconjuringEntityRegistry.CONJURED_BIRD_ENTITY_TYPE, ConjuredBirdRenderer::new);

        EntityModelLayerRegistry.register(MODEL_BIRD_LAYER, ConjuredBirdEntityModel::getTexturedModelData);
    	
    }
}
