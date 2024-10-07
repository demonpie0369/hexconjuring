package net.hexconjuring.entities.models;// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

import net.hexconjuring.entities.ConjuredBirdEntity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class ConjuredBirdEntityModel extends EntityModel<ConjuredBirdEntity> {
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart rightleg;
	private final ModelPart leftleg;
	private final ModelPart rightwing;
	private final ModelPart leftwing;
	private final ModelPart head;
	public ConjuredBirdEntityModel(ModelPart root) {
		this.body = root.getChild("body");
		this.tail = this.body.getChild("tail");
		this.rightleg = this.body.getChild("rightleg");
		this.leftleg = this.body.getChild("leftleg");
		this.rightwing = this.body.getChild("rightwing");
		this.leftwing = this.body.getChild("leftwing");
		this.head = root.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 20.7477F, 1.7029F));

		ModelPartData cube_r1 = body.addChild("cube_r1", ModelPartBuilder.create().uv(0, 2).cuboid(-0.5F, -0.4F, -1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 8).cuboid(-0.5F, -1.3F, -2.7F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, 0.7523F, -0.7029F, -0.2443F, 0.0F, 0.0F));

		ModelPartData cube_r2 = body.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, 0.7523F, -0.7029F, -0.8552F, 0.0F, 0.0F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(12, 11).cuboid(-3.0F, 0.7523F, 1.2971F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rightleg = body.addChild("rightleg", ModelPartBuilder.create().uv(7, 8).cuboid(-0.5F, 0.2F, 0.25F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(2, 0).cuboid(-0.5F, 2.2F, -0.75F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.5F, 1.0523F, -1.4529F));

		ModelPartData leftleg = body.addChild("leftleg", ModelPartBuilder.create().uv(2, 2).cuboid(-0.5F, 2.2F, -0.75F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 10).cuboid(-0.5F, 0.2F, 0.25F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 1.0523F, -1.4529F));

		ModelPartData rightwing = body.addChild("rightwing", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, -1.8F, -2.1F));

		ModelPartData cube_r3 = rightwing.addChild("cube_r3", ModelPartBuilder.create().uv(11, 3).cuboid(-2.0F, -2.4F, -2.0F, 1.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, 2.5523F, 1.3971F, -0.2443F, 0.0F, 0.0F));

		ModelPartData leftwing = body.addChild("leftwing", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, -2.0F));

		ModelPartData cube_r4 = leftwing.addChild("cube_r4", ModelPartBuilder.create().uv(0, 8).cuboid(-0.5F, -1.5F, -2.5F, 1.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 2.0F, -0.2443F, 0.0F, 0.0F));

		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(7, 9).cuboid(-0.5F, -1.6F, -4.0667F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-0.5F, -0.7F, -3.0667F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(9, 15).cuboid(-1.0F, -2.6F, -2.4667F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 19.1F, 0.2667F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(ConjuredBirdEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
	
	
}