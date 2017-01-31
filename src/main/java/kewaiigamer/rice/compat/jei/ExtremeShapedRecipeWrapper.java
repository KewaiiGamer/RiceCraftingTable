package kewaiigamer.rice.compat.jei;


import kewaiigamer.rice.crafting.ExtremeShapedRecipe;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import mezz.jei.api.recipe.wrapper.IShapedCraftingRecipeWrapper;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.List;

public class ExtremeShapedRecipeWrapper extends BlankRecipeWrapper implements IShapedCraftingRecipeWrapper{

    private final ExtremeShapedRecipe recipe;

    public ExtremeShapedRecipeWrapper(ExtremeShapedRecipe recipe)
    {
        this.recipe = recipe;
        for(ItemStack itemStack: this.recipe.recipeItems)
        {
            if(itemStack != null && itemStack.stackSize != 1) {
                itemStack.stackSize = 1;
            }
        }
    }

    @Override
    public int getWidth() {
        return 9;
    }

    @Override
    public int getHeight() {
        return 9;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        List<ItemStack> recipeItems = Arrays.asList(recipe.recipeItems);
        ItemStack recipeOutput = recipe.getRecipeOutput();
        ingredients.setInputs(ItemStack.class, recipeItems);
        if(recipeOutput != null)
            ingredients.setOutput(ItemStack.class, recipeOutput);
    }

}
