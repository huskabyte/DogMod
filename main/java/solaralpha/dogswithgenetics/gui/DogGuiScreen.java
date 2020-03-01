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
        this.drawCenteredString(this.fontRenderer, I18n.format("dog.genotype" + " = " + dog.getGenotype()), this.width / 2, 60, 16777215);
        if(dog.isTamed()) {
        	this.drawCenteredString(this.fontRenderer, I18n.format("dog.owner" + " " + dog.getOwner().getName()), this.width / 2, 80, 16777215);
        }else {
        	this.drawCenteredString(this.fontRenderer, I18n.format("dog.untamed"), this.width / 2, 100, 16777215);
        }
        
        this.drawCenteredString(this.fontRenderer, I18n.format("dog.phenotype"), this.width / 2, 140, 16777215);
        
        if(GeneticsHandler.isMale(dog.getGenotype())) {
        	this.drawCenteredString(this.fontRenderer, I18n.format("dog.gender" + " " + ChatFormatting.BLUE + "dog.male"), this.width / 2, 150, 16777215);
        }else {
        	this.drawCenteredString(this.fontRenderer, I18n.format("dog.gender" + " " + ChatFormatting.LIGHT_PURPLE + "dog.female"), this.width / 2, 150, 16777215);
        }
        
        if(GeneticsHandler.getSize(dog.getGenotype()) == 100) {
        	this.drawCenteredString(this.fontRenderer, I18n.format("dog.size" + " = " + "dog.large"), this.width / 2, 160, 16777215);
        }else if(GeneticsHandler.getSize(dog.getGenotype()) == 75) {
        	this.drawCenteredString(this.fontRenderer, I18n.format("dog.size" + " = " + "dog.medium"), this.width / 2, 160, 16777215);
        }else {
        	this.drawCenteredString(this.fontRenderer, I18n.format("dog.size" + " = " + "dog.small"), this.width / 2, 160, 16777215);
        }
        
        if(GeneticsHandler.getEyeColorAlleles(dog.getGenotype()).contains("P")) {
        	this.drawCenteredString(this.fontRenderer, I18n.format("dog.eyecolor" + " = " + "dog.brown"), this.width / 2, 170, 16777215);
        } else if(GeneticsHandler.getEyeColorAlleles(dog.getGenotype()).contains("p") && GeneticsHandler.getEyeColorAlleles(dog.getGenotype()).contains("y")) {
        	this.drawCenteredString(this.fontRenderer, I18n.format("dog.eyecolor" + " = " + "dog.bi"), this.width / 2, 170, 16777215);
        }else if(GeneticsHandler.getEyeColorAlleles(dog.getGenotype()).contains("p")) {
        	this.drawCenteredString(this.fontRenderer, I18n.format("dog.eyecolor" + " = " + "dog.green"), this.width / 2, 170, 16777215);
        }else {
        	this.drawCenteredString(this.fontRenderer, I18n.format("dog.eyecolor" + " = " + "dog.blue"), this.width / 2, 170, 16777215);
        }
        this.drawCenteredString(this.fontRenderer, I18n.format("dog.color"), this.width / 2, 180, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
