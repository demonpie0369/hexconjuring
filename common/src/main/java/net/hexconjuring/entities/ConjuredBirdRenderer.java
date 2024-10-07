package net.hexconjuring.entities;

import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.hexconjuring.HexconjuringClient;
import net.hexconjuring.entities.models.ConjuredBirdEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class ConjuredBirdRenderer extends MobEntityRenderer<ConjuredBirdEntity, ConjuredBirdEntityModel> {

	public ConjuredBirdRenderer(EntityRendererFactory.Context context) {
		super(context, new ConjuredBirdEntityModel(context.getPart(HexconjuringClient.MODEL_BIRD_LAYER)), 0.2f);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Identifier getTexture(ConjuredBirdEntity entity) {
		// TODO Auto-generated method stub
		return new Identifier("hexconjuring:textures/entity/conjured_bird/conjured_bird.png");
	}

}
