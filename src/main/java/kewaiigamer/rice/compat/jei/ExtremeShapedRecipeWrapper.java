package kewaiigamer.rice.compat.jei;


import kewaiigamer.rice.crafting.ExtremeShapedOreRecipe;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import mezz.jei.api.recipe.wrapper.IShapedCraftingRecipeWrapper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ExtremeShapedRecipeWrapper extends BlankRecipeWrapper {

    private final ExtremeShapedOreRecipe recipe;

    public ExtremeShapedRecipeWrapper(ExtremeShapedOreRecipe recipe)
    {
        this.recipe = recipe;
        for(Object obj: this.recipe.getInput())
        {
            if(obj instanceof ItemStack) {
                ItemStack itemStack = (ItemStack)obj;
                if (itemStack != null && itemStack.stackSize != 1) {
                    itemStack.stackSize = 1;
                }
            }
        }
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        List<ItemStack> recipeItems = new ArrayList<>();
        for (Object object : recipe.getInput()) {
            recipeItems.add((ItemStack)object);
        }
        ItemStack recipeOutput = recipe.getRecipeOutput();
        ingredients.setInputs(ItemStack.class, recipeItems);
        if(recipeOutput != null)
            ingredients.setOutput(ItemStack.class, recipeOutput);
    }

}
