package com.sirniloc.yam.gui;

import com.sirniloc.yam.BaseYAM;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class CharacterInfo extends GuiScreen {
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(BaseYAM.MODID+":assets/gui/CharInfoGUI.png");
	
	private int screenPosX;
	private int screenPosY;

	private EntityPlayer player;
	
	public CharacterInfo(EntityPlayer p){
		player = p;
	}
	
	@Override
	public void initGui() {
		screenPosX = (width / 2) - 4;
		screenPosY = (height / 2) - 8;
	}
	
	@Override
	public boolean doesGuiPauseGame()
    {
        return false;
    }
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		GlStateManager.pushMatrix();
		GlStateManager.color(1, 1, 1, 1);
		GlStateManager.disableLighting();
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();	
		
		Minecraft.getMinecraft().getTextureManager()
				.bindTexture(TEXTURE);
		int menuX = screenPosX - (194 / 2) + 10;
		int menuY = screenPosY - (207 / 2);
		drawTexturedModalRect(menuX, menuY, 0, 0, 194, 207);
		
		fontRenderer.drawString(BaseYAM.TITLE, screenPosX - (194 / 2) + 15, screenPosY - (207 / 2) + 5, 0xFFFFFF);
		
		int buttonStartY = menuY + 19;
		int buttonStartX = menuX + 9;
		/*
		if(mouseX > buttonStartX && mouseX < buttonStartX + 20){
			for(int i = 0; i < 7; i++){
				StatisticsID statisticsID = StatisticsID.values()[i];
				if(!ProgressTransaction.isStatMaxed(StatisticsID.values()[i], player)) {
					if(ProgressTransaction.canBuy(StatisticsID.values()[i], player)){
						if(mouseY > buttonStartY + (i * 23) && mouseY < buttonStartY + 20 + (i * 23) ){
							Minecraft.getMinecraft().getTextureManager()
							.bindTexture(new ResourceLocation("spp:textures/gui/sppmenu.png"));
							drawTexturedModalRect(buttonStartX, buttonStartY + (i * 23), 194, (i * 20), 20, 20);
						}
					}
				}
			}
		}
		
		
		
		for(int i = 0; i < 7; i++){
			
			double modifier = ConfigurationHandler.progress.levelCostModifier;
			int baseCost = ConfigurationHandler.progress.baseLevelCost;
			StatisticsID statisticsID = StatisticsID.values()[i];
			int statLevel = ProgressHandler.getProgress(player, Side.CLIENT).getStatSheet().get(statisticsID.getID());
			
			int levelCost = (int)Math.ceil(baseCost * (modifier * (statLevel + 1)));
			if(!ProgressTransaction.isStatMaxed(StatisticsID.values()[i], player)){
				if(ProgressTransaction.canBuy(StatisticsID.values()[i], player)){
					fontRenderer.drawString("Level up Cost: " + levelCost, buttonStartX + 24, buttonStartY + 7 + (i * 23), 0x99FF99);
				} else {
					fontRenderer.drawString("Level up Cost: " + levelCost, buttonStartX + 24, buttonStartY + 7 + (i * 23), 0xFF9999);
				}
			} else {
				fontRenderer.drawString("MAXED", buttonStartX + 24, buttonStartY + 7 + (i * 23), 0xFFFFFF);
				Minecraft.getMinecraft().getTextureManager()
				.bindTexture(new ResourceLocation("spp:textures/gui/sppmenu.png"));
				drawTexturedModalRect(buttonStartX, buttonStartY + (i * 23), 194 + 20, 0, 20, 20);
			}
			fontRenderer.drawString(StatisticsID.values()[i].getDisplayName(), buttonStartX + 121, buttonStartY + 7 + (i * 23), 0xFFFFFF);
		}
		*/
		GlStateManager.disableBlend();
		GlStateManager.color(1f, 1f, 1f, 1f);
		GlStateManager.enableLighting();
		GlStateManager.disableAlpha();
		GlStateManager.popMatrix();
	}
}
