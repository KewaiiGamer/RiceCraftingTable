package kewaiigamer.rice.compat.jei;

import kewaiigamer.rice.crafting.ExtremeShapelessRecipe;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

public class ExtremeShapelessRecipeWrapper extends BlankRecipeWrapper implements IRecipeWrapper{

    private final ExtremeShapelessRecipe recipe;

    public ExtremeShapelessRecipeWrapper(ExtremeShapelessRecipe recipe)
    {
        this.recipe = recipe;
        for(Object input : this.recipe.recipeItems)
        {
            if(input instanceof ItemStack)
            {
                ItemStack itemStack = (ItemStack) input;
                if(itemStack.stackSize != 1)
                    itemStack.stackSize = 1;
            }
        }
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ItemStack recipeOutput = recipe.getRecipeOutput();
        ingredients.setInputs(ItemStack.class, recipe.recipeItems);
        if(recipeOutput != null)
        {
            ingredients.setOutput(ItemStack.class, recipeOutput);
        }
    }
}
