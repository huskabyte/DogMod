package solaralpha.dogswithgenetics.dogs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import solaralpha.dogswithgenetics.dogs.EntityDog;
import solaralpha.dogswithgenetics.dogs.genetics.GeneticsHandler;

/**
 * SiberianHusky - Undefined
 * Created using Tabula 7.1.0
 */
public class ModelDog extends ModelBase {
	private boolean rendered = false;
	
    public ModelRenderer Body;
    public ModelRenderer Under;
    public ModelRenderer Butt;
    public ModelRenderer Under2;
    public ModelRenderer Front;
    public ModelRenderer Tail;
    public ModelRenderer BackLeftLeg;
    public ModelRenderer BackRightLeg;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer Tail4;
    public ModelRenderer Tail5;
    public ModelRenderer Tail6;
    public ModelRenderer BackLeftLeg2;
    public ModelRenderer BackRightLeg2;
    public ModelRenderer FrontUnder;
    public ModelRenderer Neck;
    public ModelRenderer FrontLeftLeg;
    public ModelRenderer FrontRightLeg;
    public ModelRenderer Head;
    public ModelRenderer Muzzle;
    public ModelRenderer NoseHelper;
    public ModelRenderer LEar1;
    public ModelRenderer REar1;
    public ModelRenderer Nose;
    public ModelRenderer Mouth;
    public ModelRenderer LEar2;
    public ModelRenderer REar2;
    public ModelRenderer FrontLeftLeg2;
    public ModelRenderer FrontRightLeg2;
    
    public ModelRenderer LeftFrontLeg;
    public ModelRenderer RightFrontLeg;
    public ModelRenderer REar1_1;
    public ModelRenderer HeadFluff;
    public ModelRenderer REar2_1;
    public ModelRenderer LeftFrontLeg2;
    public ModelRenderer RightFrontLeg2;
    public ModelRenderer Tail1;
    public ModelRenderer LeftBackLeg;
    public ModelRenderer RightBackLeg;
    public ModelRenderer LeftBackLeg2;
    public ModelRenderer RightBackLeg2;

    public ModelDog() {
    	this.FrontRightLeg2 = new ModelRenderer(this, 68, 17);
        this.BackLeftLeg2 = new ModelRenderer(this, 6, 3);
        this.BackRightLeg2 = new ModelRenderer(this, 110, 9);
        this.FrontLeftLeg2 = new ModelRenderer(this, 118, 9);
        
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	if(GeneticsHandler.getBody(((EntityDog)entity).getGenotype()).equals("HH")) {
    		husky();
    	}else if(GeneticsHandler.getBody(((EntityDog)entity).getGenotype()).equals("EE")) {
    		eskimo();
    	}
    	GlStateManager.pushMatrix();
        GlStateManager.translate(this.Body.offsetX, this.Body.offsetY, this.Body.offsetZ);
        GlStateManager.translate(this.Body.rotationPointX * f5, this.Body.rotationPointY * f5, this.Body.rotationPointZ * f5);
        GlStateManager.scale(GeneticsHandler.getSize(((EntityDog)entity).getGenotype()) * 0.25D + 0.25, GeneticsHandler.getSize(((EntityDog)entity).getGenotype()) * 0.25D + 0.25, GeneticsHandler.getSize(((EntityDog)entity).getGenotype()) * 0.25D + 0.25);
        GlStateManager.translate(-this.Body.offsetX, -this.Body.offsetY, -this.Body.offsetZ);
        GlStateManager.translate(-this.Body.rotationPointX * f5, -this.Body.rotationPointY * f5, -this.Body.rotationPointZ * f5);
        this.Body.render(f5);
        GlStateManager.popMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scaleFactor, Entity entityIn) {
    	
    	if(GeneticsHandler.getBody(((EntityDog)entityIn).getGenotype()).equals("HH") && !rendered) {
    		husky();
    		rendered = true;
    		return;
    	}else if(GeneticsHandler.getBody(((EntityDog)entityIn).getGenotype()).equals("EE") && !rendered) {
    		eskimo();
    		rendered = true;
    		return;
    	}

		if (!((EntityDog) entityIn).isSitting()) {
			this.FrontRightLeg2.rotateAngleX = MathHelper.cos(-limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.FrontLeftLeg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * -limbSwingAmount;
			this.BackLeftLeg2.rotateAngleX = (float) (MathHelper.cos(-limbSwing * 0.6662F) * 1.4F * -limbSwingAmount
					- (10 * Math.PI / 180));
			this.BackRightLeg2.rotateAngleX = (float) (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount
					- (10 * Math.PI / 180));
		}
	}
    
    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount,
    		float partialTickTime) {
    	if(GeneticsHandler.getBody(((EntityDog)entitylivingbaseIn).getGenotype()).equals("HH") && !rendered) {
    		husky();
    		rendered = true;
    		return;
    	}else if(GeneticsHandler.getBody(((EntityDog)entitylivingbaseIn).getGenotype()).equals("EE") && !rendered) {
    		eskimo();
    		rendered = true;
    		return;
    	}
    	
    	if(((EntityDog)entitylivingbaseIn).isSitting() && GeneticsHandler.getBody(((EntityDog)entitylivingbaseIn).getGenotype()).equals("HH")) {
    		Body.rotateAngleX = (float) (-57 * Math.PI / 180);
    		Butt.rotateAngleX = (float) (-25 * Math.PI / 180);
    		Front.rotateAngleX = (float) (18 * Math.PI / 180);
    		this.Body.setRotationPoint(0.0F, 15.0F, 0.0F);
    	}else if(GeneticsHandler.getBody(((EntityDog)entitylivingbaseIn).getGenotype()).equals("HH")){
    		Body.rotateAngleX = 0F;
    		Butt.rotateAngleX = 0F;
    		Front.rotateAngleX = 0F;
    		this.Body.setRotationPoint(0.0F, 12.0F, 0.0F);
    	}
    }
    
    public void husky() {
    	this.textureWidth = 128;
        this.textureHeight = 45;
        this.Under2 = new ModelRenderer(this, 71, 15);
        this.Under2.setRotationPoint(0.0F, 1.0F, -0.9F);
        this.Under2.addBox(-3.5F, 0.0F, -4.5F, 7, 4, 13, 0.0F);
        this.setRotateAngle(Under2, 0.15707963267948966F, 0.0F, 0.0F);
        this.BackRightLeg = new ModelRenderer(this, 110, 0);
        this.BackRightLeg.setRotationPoint(-4.0F, 6.0F, 4.5F);
        this.BackRightLeg.addBox(0.0F, 0.0F, 0.0F, 3, 4, 5, 0.0F);
        this.Tail6 = new ModelRenderer(this, 5, 0);
        this.Tail6.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.Tail6.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(Tail6, 0.5585053606381855F, 0.0F, 0.0F);
        this.Under = new ModelRenderer(this, 42, 0);
        this.Under.setRotationPoint(0.0F, 1.0F, -0.9F);
        this.Under.addBox(-3.5F, 0.0F, -5.5F, 7, 3, 14, 0.0F);
        this.setRotateAngle(Under, -0.19687313962496036F, 0.0F, 0.0F);
        this.LEar1 = new ModelRenderer(this, 9, 0);
        this.LEar1.setRotationPoint(1.0F, -5.0F, 0.0F);
        this.LEar1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        this.BackLeftLeg2.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.BackLeftLeg2.addBox(0.0F, -1.0F, 1.0F, 2, 8, 2, 0.0F);
        this.LEar2 = new ModelRenderer(this, 27, 0);
        this.LEar2.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.LEar2.addBox(0.0F, -1.0F, 0.0F, 1, 2, 1, 0.0F);
        this.REar1 = new ModelRenderer(this, 43, 0);
        this.REar1.setRotationPoint(-1.0F, -5.0F, 0.0F);
        this.REar1.addBox(-2.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        this.REar2 = new ModelRenderer(this, 51, 0);
        this.REar2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.REar2.addBox(-2.0F, -1.0F, 0.0F, 1, 2, 1, 0.0F);
        this.Front = new ModelRenderer(this, 35, 17);
        this.Front.setRotationPoint(0.0F, -3.5F, -2.0F);
        this.Front.addBox(-3.5F, 0.0F, -7.0F, 7, 9, 7, 0.0F);
        this.Tail = new ModelRenderer(this, 0, 0);
        this.Tail.setRotationPoint(0.0F, 0.0F, 9.0F);
        this.Tail.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Tail, 0.3740240587023848F, -0.05899212871740834F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 38, 0);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.Tail2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Tail2, 0.593411945678072F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 104, 33);
        this.Head.setRotationPoint(0.0F, -2.5F, -1.8F);
        this.Head.addBox(-3.0F, -4.0F, -3.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(Head, -0.6799802765769908F, 0.0F, 0.0F);
        this.Mouth = new ModelRenderer(this, 75, 0);
        this.Mouth.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Mouth.addBox(-1.0F, 0.0F, -1.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(Mouth, -0.15455541180735036F, 0.0F, 0.0F);
        this.Tail3 = new ModelRenderer(this, 46, 0);
        this.Tail3.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.Tail3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Tail3, 0.8377580409572781F, 0.0F, 0.0F);
        this.BackRightLeg2.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.BackRightLeg2.addBox(1.0F, -1.0F, 1.0F, 2, 9, 2, 0.0F);
        this.FrontUnder = new ModelRenderer(this, 98, 20);
        this.FrontUnder.setRotationPoint(0.0F, 7.1F, -3.5F);
        this.FrontUnder.addBox(-3.5F, 0.0F, -2.5F, 7, 2, 6, 0.0F);
        this.setRotateAngle(FrontUnder, -0.15707963267948966F, 0.0F, 0.0F);
        this.FrontRightLeg2.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.FrontRightLeg2.addBox(-1.0F, -1.0F, 1.0F, 2, 8, 2, 0.0F);
        this.Tail5 = new ModelRenderer(this, 78, 0);
        this.Tail5.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.Tail5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Tail5, 1.1344640137963142F, 0.0F, 0.0F);
        this.BackLeftLeg = new ModelRenderer(this, 27, 0);
        this.BackLeftLeg.setRotationPoint(1.0F, 7.0F, 4.5F);
        this.BackLeftLeg.addBox(0.0F, -1.0F, 0.0F, 3, 4, 5, 0.0F);
        this.Butt = new ModelRenderer(this, 84, 0);
        this.Butt.setRotationPoint(0.0F, -3.5F, 0.0F);
        this.Butt.addBox(-3.5F, 0.0F, 4.0F, 7, 9, 6, 0.0F);
        this.FrontRightLeg = new ModelRenderer(this, 39, 5);
        this.FrontRightLeg.setRotationPoint(-2.0F, 7.0F, -5.0F);
        this.FrontRightLeg.addBox(-2.0F, 0.0F, 0.0F, 3, 3, 4, 0.0F);
        this.FrontLeftLeg = new ModelRenderer(this, 70, 4);
        this.FrontLeftLeg.setRotationPoint(2.0F, 7.0F, -5.0F);
        this.FrontLeftLeg.addBox(-1.0F, 0.0F, 0.0F, 3, 3, 4, 0.0F);
        this.NoseHelper = new ModelRenderer(this, 104, 0);
        this.NoseHelper.setRotationPoint(0.0F, -1.1F, -5.0F);
        this.NoseHelper.addBox(-1.5F, -0.3F, 0.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(NoseHelper, 0.2935643801854462F, 0.0F, 0.0F);
        this.Nose = new ModelRenderer(this, 56, 17);
        this.Nose.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Nose.addBox(-1.5F, -1.5F, -2.0F, 3, 3, 3, 0.0F);
        this.Muzzle = new ModelRenderer(this, 27, 9);
        this.Muzzle.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.Muzzle.addBox(-2.0F, -1.0F, -1.0F, 4, 3, 2, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 22);
        this.Neck.setRotationPoint(0.0F, 2.0F, -5.0F);
        this.Neck.addBox(-3.0F, -4.0F, -4.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(Neck, 0.6799802765769908F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.Body.addBox(-3.0F, -3.0F, -7.5F, 6, 7, 15, 0.0F);
        this.FrontLeftLeg2.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.FrontLeftLeg2.addBox(-1.0F, -1.0F, 1.0F, 2, 8, 2, 0.0F);
        this.Tail4 = new ModelRenderer(this, 70, 0);
        this.Tail4.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.Tail4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Tail4, 0.7155849933176751F, 0.0F, 0.0F);
        this.Body.addChild(this.Under2);
        this.Butt.addChild(this.BackRightLeg);
        this.Tail5.addChild(this.Tail6);
        this.Body.addChild(this.Under);
        this.Head.addChild(this.LEar1);
        this.BackLeftLeg.addChild(this.BackLeftLeg2);
        this.LEar1.addChild(this.LEar2);
        this.Head.addChild(this.REar1);
        this.REar1.addChild(this.REar2);
        this.Body.addChild(this.Front);
        this.Butt.addChild(this.Tail);
        this.Tail.addChild(this.Tail2);
        this.Neck.addChild(this.Head);
        this.Muzzle.addChild(this.Mouth);
        this.Tail2.addChild(this.Tail3);
        this.BackRightLeg.addChild(this.BackRightLeg2);
        this.Front.addChild(this.FrontUnder);
        this.FrontRightLeg.addChild(this.FrontRightLeg2);
        this.Tail4.addChild(this.Tail5);
        this.Butt.addChild(this.BackLeftLeg);
        this.Body.addChild(this.Butt);
        this.Front.addChild(this.FrontRightLeg);
        this.Front.addChild(this.FrontLeftLeg);
        this.Head.addChild(this.NoseHelper);
        this.Muzzle.addChild(this.Nose);
        this.Head.addChild(this.Muzzle);
        this.Front.addChild(this.Neck);
        this.FrontLeftLeg.addChild(this.FrontLeftLeg2);
        this.Tail3.addChild(this.Tail4);
    }
    
    public void eskimo() {
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
}

