package top.theillusivec4.polymorph.gui;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import top.theillusivec4.polymorph.Polymorph;

public class RecipeSelectWidget extends Widget {

  private static final ResourceLocation SWITCH = new ResourceLocation(Polymorph.MODID,
      "textures/gui/switch.png");
  public IRecipe<CraftingInventory> recipe;
  public CraftingInventory craftingMatrix;

  public RecipeSelectWidget(CraftingInventory craftingMatrix, IRecipe<CraftingInventory> recipe) {
    super(0, 0, 25, 25, "");
    this.recipe = recipe;
    this.craftingMatrix = craftingMatrix;
  }

  public void setPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public void renderButton(int p_renderButton_1_, int p_renderButton_2_, float p_renderButton_3_) {
    Minecraft minecraft = Minecraft.getInstance();
    minecraft.getTextureManager().bindTexture(SWITCH);
    int i = 16;
    int j = 0;

    if (this.x + 25 >= p_renderButton_1_ && this.x <= p_renderButton_1_) {

      if (this.y + 25 >= p_renderButton_2_ && this.y <= p_renderButton_2_) {
        j += 25;
      }
    }
    this.blit(this.x, this.y, i, j, this.width, this.height);
    int k = 4;
    minecraft.getItemRenderer()
        .renderItemAndEffectIntoGUI(this.recipe.getCraftingResult(this.craftingMatrix), this.x + k,
            this.y + k);
  }

  public List<String> getTooltipText(Screen screen) {
    return screen.getTooltipFromItem(this.recipe.getCraftingResult(this.craftingMatrix));
  }

  @Override
  public int getWidth() {
    return 25;
  }

  @Override
  protected boolean isValidClickButton(int p_isValidClickButton_1_) {
    return p_isValidClickButton_1_ == 0 || p_isValidClickButton_1_ == 1;
  }
}