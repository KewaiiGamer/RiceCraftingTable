package kewaiigamer.rice.compat.jei;

import kewaiigamer.rice.Rice;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.ICraftingGridHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.wrapper.ICustomCraftingRecipeWrapper;
import mezz.jei.api.recipe.wrapper.IShapedCraftingRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public class ExtremeCraftingCategory extends BlankRecipeCategory<IRecipeWrapper> {

    public static final String UID = "rice.crafting";
    public static final String TITLE = "rice.crafting.name";

    public static final int WIDTH = 220;
    public static final int HEIGHT = 162;

    private final IDrawable background;
    //private final String localizedName;
    private final ICraftingGridHelper craftingGridHelper;

    public ExtremeCraftingCategory(IGuiHelper guiHelper)
    {
        ResourceLocation location = new ResourceLocation(Rice.MODID, "textures/gui/rice_crafting_gui.png");
        background = guiHelper.createDrawable(location, 11, 7, WIDTH, HEIGHT);
        craftingGridHelper = guiHelper.createCraftingGridHelper(1, 0);
    }

    @Override
    public String getUid() {
        return UID;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper, IIngredients ingredients) {
        IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

        guiItemStacks.init(0, false, 94, 18);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int index = 1 + j + (i * 9);
                guiItemStacks.init(index, true, j * 18, j * 18);
            }
        }

        List<List<ItemStack>> inputs = ingredients.getInputs(ItemStack.class);
        List<ItemStack> outputs = ingredients.getOutputs(ItemStack.class);

        if(recipeWrapper instanceof IShapedCraftingRecipeWrapper)
        {
            IShapedCraftingRecipeWrapper wrapper = (IShapedCraftingRecipeWrapper) recipeWrapper;
            craftingGridHelper.setInputStacks(guiItemStacks, inputs, wrapper.getWidth(), wrapper.getHeight());
            craftingGridHelper.setOutput(guiItemStacks, outputs);
        }
        else
        {
            craftingGridHelper.setInputStacks(guiItemStacks, inputs);
            craftingGridHelper.setOutput(guiItemStacks, outputs);
        }
    }
}
