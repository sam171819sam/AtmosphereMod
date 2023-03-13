package net.mcreator.atmosphere.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.0.4
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelsaddler<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("atmosphere", "modelsaddler"), "main");
	public final ModelPart Body;
	public final ModelPart rightleg;
	public final ModelPart leftleg;

	public Modelsaddler(ModelPart root) {
		this.Body = root.getChild("Body");
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -20.0F, -10.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
				.addBox(-10.0F, -20.0F, -10.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.5F)).texOffs(0, 40).addBox(-10.0F, 0.0F, -10.0F, 20.0F, 6.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));
		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(64, 44).addBox(-10.0F, 0.0F, 0.0F, 20.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 10.0F, -1.0472F, 0.0F, 0.0F));
		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(48, 0).mirror().addBox(-4.0F, 0.0F, -10.0F, 4.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0472F));
		PartDefinition cube_r3 = Body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(64, 40).addBox(-10.0F, 0.0F, -4.0F, 20.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -18.0F, -10.0F, 1.0472F, 0.0F, 0.0F));
		PartDefinition cube_r4 = Body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(64, 48).mirror().addBox(-10.0F, 0.0F, 0.0F, 20.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -6.0F, 10.0F, -1.0472F, 0.0F, 0.0F));
		PartDefinition cube_r5 = Body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(64, 48).addBox(-10.0F, 0.0F, 0.0F, 20.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -12.0F, 10.0F, -1.0472F, 0.0F, 0.0F));
		PartDefinition cube_r6 = Body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(64, 44).mirror().addBox(-10.0F, 0.0F, 0.0F, 20.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -18.0F, 10.0F, -1.0472F, 0.0F, 0.0F));
		PartDefinition cube_r7 = Body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-4.0F, 0.0F, -10.0F, 4.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-10.0F, -12.0F, 0.0F, 0.0F, 0.0F, -1.0472F));
		PartDefinition cube_r8 = Body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(40, 40).mirror().addBox(-4.0F, 0.0F, -10.0F, 4.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-10.0F, -6.0F, 0.0F, 0.0F, 0.0F, -1.0472F));
		PartDefinition cube_r9 = Body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(48, 0).mirror().addBox(-4.0F, 0.0F, -10.0F, 4.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-10.0F, -18.0F, 0.0F, 0.0F, 0.0F, -1.0472F));
		PartDefinition cube_r10 = Body
				.addOrReplaceChild(
						"cube_r10", CubeListBuilder.create().texOffs(40, 40).addBox(11.9282F, -4.6603F, -10.0F, 4.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(40, 0)
								.addBox(17.1244F, -1.6603F, -10.0F, 4.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(48, 0).addBox(6.7321F, -7.6603F, -10.0F, 4.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, -20.0F, 0.0F, 0.0F, 0.0F, 1.0472F));
		PartDefinition cube_r11 = Body.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(48, 0).addBox(5.0F, -8.6603F, -10.0F, 4.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(40, 40)
				.addBox(10.1962F, -5.6603F, -10.0F, 4.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(40, 0).addBox(15.3923F, -2.6603F, -10.0F, 4.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -18.0F, 0.0F, 0.0F, 0.0F, 1.0472F));
		PartDefinition cube_r12 = Body.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(40, 0).addBox(0.0F, 0.0F, -10.0F, 4.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(10.0F, -6.0F, 0.0F, 0.0F, 0.0F, 1.0472F));
		PartDefinition cube_r13 = Body.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(48, 0).addBox(0.0F, 0.0F, -10.0F, 4.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(10.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0472F));
		PartDefinition cube_r14 = Body.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(40, 40).addBox(0.0F, 0.0F, -10.0F, 4.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(10.0F, -12.0F, 0.0F, 0.0F, 0.0F, 1.0472F));
		PartDefinition cube_r15 = Body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(48, 0).addBox(0.0F, 0.0F, -10.0F, 4.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(10.0F, -18.0F, 0.0F, 0.0F, 0.0F, 1.0472F));
		PartDefinition saddle = Body.addOrReplaceChild("saddle",
				CubeListBuilder.create().texOffs(0, 66).addBox(-6.0F, -36.0F, -8.0F, 12.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(40, 66).addBox(-6.0F, -43.0F, 8.0F, 12.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 15.0F, 0.0F));
		PartDefinition rightleg = partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 9.5F, 0.0F));
		PartDefinition leftleg = partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 9.5F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, buffer, packedLight, packedOverlay);
		rightleg.render(poseStack, buffer, packedLight, packedOverlay);
		leftleg.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.rightleg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leftleg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}
