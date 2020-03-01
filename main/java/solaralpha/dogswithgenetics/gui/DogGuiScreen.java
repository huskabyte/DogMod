package solaralpha.dogswithgenetics.gui;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import solaralpha.dogswithgenetics.dogs.EntityDog;
import solaralpha.dogswithgenetics.dogs.genetics.GeneticsHandler;

@SideOnly(Side.CLIENT)
public class DogGuiScreen extends GuiScreen
{
    private int saveStep;
    private int visibleTime;
    
    private EntityDog dog;
    
    public DogGuiScreen(EntityDog dog) {
    	this.dog = dog;
    }

    public void initGui()
    {
        this.saveStep = 0;
        this.buttonList.clear();
    }

    public void updateScreen()
    {
        super.updateScreen();
        ++this.visibleTime;
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, I18n.format("menu.dog"), this.width / 2, 40, 16777215);
        this.drawCenteredString(this.fontRenderer, I18n.format("Genotype" + " = " + dog.getGenotype()), this.width / 2, 60, 16777215);
        if(dog.isTamed()) {
        	this.drawCenteredString(this.fontRenderer, I18n.format("Owned By" + " " + dog.getOwner().getName()), this.width / 2, 80, 16777215);
        }else {
        	this.drawCenteredString(this.fontRenderer, I18n.format("dog.untamed"), this.width / 2, 100, 16777215);
        }
        
        this.drawCenteredString(this.fontRenderer, I18n.format(ChatFormatting.UNDERLINE + "PHENOTYPE"), this.width / 2, 140, 16777215);
        
        if(GeneticsHandler.getBody(dog.getGenotype()).equals("HH")) {
        	this.drawCenteredString(this.fontRenderer, I18n.format("Primary Breed:" + " " + ChatFormatting.DARK_GREEN + "Siberian Husky"), this.width / 2, 160, 16777215);
        }else {
        	this.drawCenteredString(this.fontRenderer, I18n.format("Primary Breed:" + " " + ChatFormatting.DARK_GREEN + "American Eskimo"), this.width / 2, 160, 16777215);
        }
        
        if(GeneticsHandler.isMale(dog.getGenotype())) {
        	this.drawCenteredString(this.fontRenderer, I18n.format("Sex" + " " + ChatFormatting.BLUE + "MALE"), this.width / 2, 170, 16777215);
        }else {
        	this.drawCenteredString(this.fontRenderer, I18n.format("Sex" + " " + ChatFormatting.LIGHT_PURPLE + "FEMALE"), this.width / 2, 170, 16777215);
        }
        
        if(GeneticsHandler.getSize(dog.getGenotype()) == 3) {
        	this.drawCenteredString(this.fontRenderer, I18n.format("Size" + " = " + "Large"), this.width / 2, 180, 16777215);
        }else if(GeneticsHandler.getSize(dog.getGenotype()) == 2) {
        	this.drawCenteredString(this.fontRenderer, I18n.format("Size" + " = " + "Medium"), this.width / 2, 180, 16777215);
        }else {
        	this.drawCenteredString(this.fontRenderer, I18n.format("Size" + " = " + "Small"), this.width / 2, 180, 16777215);
        }
        
        if(GeneticsHandler.getEyeColorAlleles(dog.getGenotype()).contains("P")) {
        	this.drawCenteredString(this.fontRenderer, I18n.format(ChatFormatting.GRAY + "(COMING SOON) Eye Color" + " = " + "Brown"), this.width / 2, 190, 16777215);
        } else if(GeneticsHandler.getEyeColorAlleles(dog.getGenotype()).contains("p") && GeneticsHandler.getEyeColorAlleles(dog.getGenotype()).contains("y")) {
        	this.drawCenteredString(this.fontRenderer, I18n.format(ChatFormatting.GRAY + "(COMING SOON) Eye Color" + " = " + "Heterochromatic"), this.width / 2, 190, 16777215);
        }else if(GeneticsHandler.getEyeColorAlleles(dog.getGenotype()).contains("p")) {
        	this.drawCenteredString(this.fontRenderer, I18n.format(ChatFormatting.GRAY + "(COMING SOON) Eye Color" + " = " + "Green"), this.width / 2, 190, 16777215);
        }else {
        	this.drawCenteredString(this.fontRenderer, I18n.format(ChatFormatting.GRAY + "(COMING SOON) Eye Color" + " = " + "Blue"), this.width / 2, 190, 16777215);
        }
        if(GeneticsHandler.getCoatColorAlleles(dog.getGenotype()).contains("b")) {
        	this.drawCenteredString(this.fontRenderer, I18n.format("Coat Color" + " = " + "Black"), this.width / 2, 200, 16777215);
        } else if(GeneticsHandler.getCoatColorAlleles(dog.getGenotype()).contains("g")) {
        	this.drawCenteredString(this.fontRenderer, I18n.format("Coat Color" + " = " + "Gray"), this.width / 2, 200, 16777215);
        }else if(GeneticsHandler.getCoatColorAlleles(dog.getGenotype()).contains("r")) {
        	this.drawCenteredString(this.fontRenderer, I18n.format("Coat Color" + " = " + "Red"), this.width / 2, 200, 16777215);
        }else if(GeneticsHandler.getCoatColorAlleles(dog.getGenotype()).contains("a")){
        	this.drawCenteredString(this.fontRenderer, I18n.format("Coat Color" + " = " + "Agouti"), this.width / 2, 200, 16777215);
        }else {
        	this.drawCenteredString(this.fontRenderer, I18n.format("Coat Color" + " = " + "White"), this.width / 2, 200, 16777215);
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
