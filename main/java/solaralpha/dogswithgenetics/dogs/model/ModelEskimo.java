package solaralpha.dogswithgenetics.dogs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import solaralpha.dogswithgenetics.dogs.breeds.DogEskimo;
import solaralpha.dogswithgenetics.dogs.genetics.GeneticsHandler;

/**
 * Pomeranian - Undefined
 * Created using Tabula 7.1.0
 */
public class ModelEskimo extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Front;
    public ModelRenderer Butt;
    public ModelRenderer Under;
    public ModelRenderer Neck;
    public ModelRenderer LeftFrontLeg;
    public ModelRenderer RightFrontLeg;
    public ModelRenderer Head;
    public ModelRenderer Muzzle;
    public ModelRenderer REar1;
    public ModelRenderer REar1_1;
    public ModelRenderer HeadFluff;
    public ModelRenderer Nose;
    public ModelRenderer Mouth;
    public ModelRenderer REar2;
    public ModelRenderer REar2_1;
    public ModelRenderer LeftFrontLeg2;
    public ModelRenderer RightFrontLeg2;
    public ModelRenderer Tail1;
    public ModelRenderer LeftBackLeg;
    public ModelRenderer RightBackLeg;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer Tail4;
    public ModelRenderer Tail5;
    public ModelRenderer Tail6;
    public ModelRenderer LeftBackLeg2;
    public ModelRenderer RightBackLeg2;

    public ModelEskimo() {
    	this.textureWidth = 128;
        this.textureHeight = 64;
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 17.5F, 0.0F);
        this.Body.addBox(-3.0F, 0.5F, -5.0F, 6, 6, 10, 0.0F);
        this.RightFrontLeg = new ModelRenderer(this, 89, 0);
        this.RightFrontLeg.setRotationPoint(-1.0F, 7.0F, -10.0F);
        this.RightFrontLeg.addBox(-3.1F, 0.0F, 0.0F, 3, 3, 4, 0.0F);
        this.Under = new ModelRenderer(this, 96, 0);
        this.Under.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Under.addBox(-3.5F, 4.2F, -3.0F, 7, 4, 8, 0.0F);
        this.setRotateAngle(Under, 0.2617993877991494F, 0.0F, 0.0F);
        this.Butt = new ModelRenderer(this, 68, 0);
        this.Butt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Butt.addBox(-3.5F, 0.0F, 2.0F, 7, 7, 7, 0.0F);
        this.HeadFluff = new ModelRenderer(this, 0, 16);
        this.HeadFluff.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HeadFluff.addBox(-4.5F, 2.0F, -3.0F, 9, 5, 6, 0.0F);
        this.RightFrontLeg2 = new ModelRenderer(this, 0, 3);
        this.RightFrontLeg2.setRotationPoint(-2.0F, 1.0F, 1.0F);
        this.RightFrontLeg2.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.LeftFrontLeg2 = new ModelRenderer(this, 118, 0);
        this.LeftFrontLeg2.setRotationPoint(0.0F, 1.0F, -1.0F);
        this.LeftFrontLeg2.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.REar1 = new ModelRenderer(this, 0, 0);
        this.REar1.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.REar1.addBox(-2.0F, -1.0F, 0.0F, 2, 2, 1, 0.0F);
        this.Tail4 = new ModelRenderer(this, 84, 14);
        this.Tail4.setRotationPoint(0.0F, 1.0F, 2.0F);
        this.Tail4.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(Tail4, 1.117010721276371F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 50);
        this.Head.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.Head.addBox(-3.5F, 0.0F, -4.0F, 7, 8, 6, 0.0F);
        this.setRotateAngle(Head, 0.5759586531581287F, 0.0F, 0.0F);
        this.Mouth = new ModelRenderer(this, 110, 12);
        this.Mouth.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.Mouth.addBox(-1.5F, 0.0F, -3.0F, 3, 2, 3, 0.0F);
        this.setRotateAngle(Mouth, -0.3490658503988659F, 0.0F, 0.0F);
        this.Front = new ModelRenderer(this, 32, 0);
        this.Front.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Front.addBox(-3.5F, 0.0F, -11.0F, 7, 9, 11, 0.0F);
        this.REar2 = new ModelRenderer(this, 6, 0);
        this.REar2.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.REar2.addBox(-2.0F, -2.0F, 0.0F, 1, 4, 1, 0.0F);
        this.REar2_1 = new ModelRenderer(this, 22, 0);
        this.REar2_1.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.REar2_1.addBox(1.0F, -2.0F, 0.0F, 1, 4, 1, 0.0F);
        this.REar1_1 = new ModelRenderer(this, 37, 0);
        this.REar1_1.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.REar1_1.addBox(0.0F, -1.0F, 0.0F, 2, 1, 1, 0.0F);
        this.RightBackLeg = new ModelRenderer(this, 111, 21);
        this.RightBackLeg.setRotationPoint(-1.0F, 5.0F, 3.0F);
        this.RightBackLeg.addBox(-3.0F, 0.0F, 0.0F, 3, 3, 5, 0.0F);
        this.Tail6 = new ModelRenderer(this, 116, 17);
        this.Tail6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail6.addBox(-1.0F, 1.0F, 0.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(Tail6, 1.117010721276371F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 57, 7);
        this.Tail2.setRotationPoint(0.0F, 1.0F, 1.0F);
        this.Tail2.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(Tail2, 0.890117918517108F, 0.0F, 0.0F);
        this.Tail5 = new ModelRenderer(this, 24, 16);
        this.Tail5.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.Tail5.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(Tail5, 0.9948376736367678F, 0.0F, 0.0F);
        this.RightBackLeg2 = new ModelRenderer(this, 70, 23);
        this.RightBackLeg2.setRotationPoint(0.0F, 1.0F, 2.0F);
        this.RightBackLeg2.addBox(-2.0F, 0.0F, 0.0F, 2, 7, 2, 0.0F);
        this.LeftFrontLeg = new ModelRenderer(this, 57, 0);
        this.LeftFrontLeg.setRotationPoint(1.0F, 7.0F, -8.0F);
        this.LeftFrontLeg.addBox(0.0F, 0.0F, -2.0F, 3, 3, 4, 0.0F);
        this.Tail1 = new ModelRenderer(this, 67, 0);
        this.Tail1.setRotationPoint(0.0F, 0.0F, 8.0F);
        this.Tail1.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(Tail1, 0.6457718232379019F, 0.0F, 0.0F);
        this.Muzzle = new ModelRenderer(this, 68, 14);
        this.Muzzle.setRotationPoint(0.0F, 2.7F, -2.0F);
        this.Muzzle.addBox(-3.0F, 0.0F, -3.0F, 6, 5, 4, 0.0F);
        this.LeftBackLeg2 = new ModelRenderer(this, 62, 21);
        this.LeftBackLeg2.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.LeftBackLeg2.addBox(0.0F, 0.0F, 2.0F, 2, 7, 2, 0.0F);
        this.Neck = new ModelRenderer(this, 22, 0);
        this.Neck.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.Neck.addBox(-2.5F, 0.0F, -4.0F, 5, 5, 5, 0.0F);
        this.setRotateAngle(Neck, -0.593411945678072F, 0.0F, 0.0F);
        this.Nose = new ModelRenderer(this, 30, 20);
        this.Nose.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.Nose.addBox(-2.0F, 0.0F, -5.0F, 4, 3, 4, 0.0F);
        this.Tail3 = new ModelRenderer(this, 119, 12);
        this.Tail3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail3.addBox(-1.0F, 1.0F, 1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(Tail3, 0.6632251157578453F, 0.0F, 0.0F);
        this.LeftBackLeg = new ModelRenderer(this, 46, 20);
        this.LeftBackLeg.setRotationPoint(1.0F, 5.0F, 3.0F);
        this.LeftBackLeg.addBox(0.0F, 0.0F, 0.0F, 3, 3, 5, 0.0F);
        this.Front.addChild(this.RightFrontLeg);
        this.Body.addChild(this.Under);
        this.Body.addChild(this.Butt);
        this.Head.addChild(this.HeadFluff);
        this.RightFrontLeg.addChild(this.RightFrontLeg2);
        this.LeftFrontLeg.addChild(this.LeftFrontLeg2);
        this.Head.addChild(this.REar1);
        this.Tail3.addChild(this.Tail4);
        this.Neck.addChild(this.Head);
        this.Muzzle.addChild(this.Mouth);
        this.Body.addChild(this.Front);
        this.REar1.addChild(this.REar2);
        this.REar1_1.addChild(this.REar2_1);
        this.Head.addChild(this.REar1_1);
        this.Butt.addChild(this.RightBackLeg);
        this.Tail5.addChild(this.Tail6);
        this.Tail1.addChild(this.Tail2);
        this.Tail4.addChild(this.Tail5);
        this.RightBackLeg.addChild(this.RightBackLeg2);
        this.Front.addChild(this.LeftFrontLeg);
        this.Butt.addChild(this.Tail1);
        this.Head.addChild(this.Muzzle);
        this.LeftBackLeg.addChild(this.LeftBackLeg2);
        this.Front.addChild(this.Neck);
        this.Muzzle.addChild(this.Nose);
        this.Tail2.addChild(this.Tail3);
        this.Butt.addChild(this.LeftBackLeg);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Body.offsetX, this.Body.offsetY, this.Body.offsetZ);
        GlStateManager.translate(this.Body.rotationPointX * f5, this.Body.rotationPointY * f5, this.Body.rotationPointZ * f5);
        GlStateManager.scale(GeneticsHandler.getSize(((DogEskimo)entity).getGenotype()) * 0.25D + 0.25, GeneticsHandler.getSize(((DogEskimo)entity).getGenotype()) * 0.25D + 0.25, GeneticsHandler.getSize(((DogEskimo)entity).getGenotype()) * 0.25D + 0.25);
        GlStateManager.translate(-this.Body.offsetX, -this.Body.offsetY, -this.Body.offsetZ);
        GlStateManager.translate(-this.Body.rotationPointX * f5, -this.Body.rotationPointY * f5, -this.Body.rotationPointZ * f5);
        this.Body.render(f5);
        GlStateManager.popMatrix();
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
    		float headPitch, float scaleFactor, Entity entityIn) {
    	if (!((DogEskimo) entityIn).isSitting()) {
			this.RightFrontLeg2.rotateAngleX = MathHelper.cos(-limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LeftFrontLeg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * -limbSwingAmount;
			this.LeftBackLeg2.rotateAngleX = (float) (MathHelper.cos(-limbSwing * 0.6662F) * 1.4F * -limbSwingAmount
					- (10 * Math.PI / 180));
			this.RightBackLeg2.rotateAngleX = (float) (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount
					- (10 * Math.PI / 180));
		}
    }
    
    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount,
    		float partialTickTime) {
    	if(((DogEskimo)entitylivingbaseIn).isSitting()) {
    		Body.rotateAngleX = (float) (-55.12 * Math.PI / 180);
    		Butt.rotateAngleX = (float) (-29.76 * Math.PI / 180);
    		Front.rotateAngleX = (float) (13.17 * Math.PI / 180);
    		LeftFrontLeg.rotateAngleX = (float) (44.88 * Math.PI / 180);
    		RightFrontLeg.rotateAngleX = (float) (39.02 * Math.PI / 180);
    		this.Body.setRotationPoint(0.0F, 18.5F + (-GeneticsHandler.getSize(((DogEskimo)entitylivingbaseIn).getGenotype())+1)*3, 0.0F);
    	}else{
    		Body.rotateAngleX = 0F;
    		Butt.rotateAngleX = 0F;
    		Front.rotateAngleX = 0F;
    		LeftFrontLeg.rotateAngleX = 0F;
    		RightFrontLeg.rotateAngleX = 0F;
    		this.Body.setRotationPoint(0.0F, 17.5F + (-GeneticsHandler.getSize(((DogEskimo)entitylivingbaseIn).getGenotype())+1)*3, 0.0F);
    	}
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

