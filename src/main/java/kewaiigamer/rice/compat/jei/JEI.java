package kewaiigamer.rice.compat.jei;


import kewaiigamer.rice.blocks.ModBlocks;
import kewaiigamer.rice.crafting.ExtremeCraftingManager;
import kewaiigamer.rice.gui.ricecraftingtable.ContainerExtremeCrafting;
import kewaiigamer.rice.gui.ricecraftingtable.GUIExtremeCrafting;
import mezz.jei.api.*;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.item.ItemStack;

//Example: https://github.com/mezz/JustEnoughItems/tree/1.10/src/main/java/mezz/jei/plugins/vanilla/crafting

@JEIPlugin
public class JEI extends BlankModPlugin{

    public static IRecipeRegistry recipeRegistry;

    @Override
    public void register(IModRegistry registry) {
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();

        registry.addRecipeCategories(
                new ExtremeCraftingCategory(guiHelper)
        );

        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.blockRiceCrafting), ExtremeCraftingCategory.UID);

        registry.addRecipeHandlers(
                new ExtremeShapedRecipeHandler(jeiHelpers),
                new ExtremeShapelessRecipeHandler(jeiHelpers)
        );

        registry.addRecipeClickArea(GUIExtremeCrafting.class, 176,80,23, 15, ExtremeCraftingCategory.UID);

        IRecipeTransferRegistry recipeTransferRegistry = registry.getRecipeTransferRegistry();
        recipeTransferRegistry.addRecipeTransferHandler(ContainerExtremeCrafting.class, ExtremeCraftingCategory.UID, 1, 81, 82, 36);


        registry.addRecipes(ExtremeCraftingManager.getInstance().getRecipeList());
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        recipeRegistry = jeiRuntime.getRecipeRegistry();
    }
}
