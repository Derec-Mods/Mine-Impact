// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelgeocrystal extends EntityModel<Entity> {
	private final ModelRenderer cube;
	private final ModelRenderer glass;

	public Modelgeocrystal() {
		textureWidth = 64;
		textureHeight = 32;

		cube = new ModelRenderer(this);
		cube.setRotationPoint(0.0F, 14.0F, 0.0F);
		cube.setTextureOffset(15, 8).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		glass = new ModelRenderer(this);
		glass.setRotationPoint(0.0F, 14.0F, 0.0F);
		glass.setTextureOffset(14, 12).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		cube.render(matrixStack, buffer, packedLight, packedOverlay);
		glass.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.glass.rotateAngleY = f2 / 20.f;
		this.cube.rotateAngleX = f2 / 20.f;
	}
}