package me.deltawhy.fancycrafting.plugins;

import codechicken.nei.api.API;
import codechicken.nei.recipe.DefaultOverlayHandler;
import me.deltawhy.fancycrafting.GuiTable;

public class NEIPlugin implements IPlugin {
    public void load() {
        API.registerGuiOverlay(GuiTable.class, "crafting");
        API.registerGuiOverlayHandler(GuiTable.class, new DefaultOverlayHandler(), "crafting");
    }
}
