package me.deltawhy.fancycrafting;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

@Mod(modid="fancycrafting", name="FancyCrafting", version="0.1dev")
public class FancyCrafting {
    @Instance(value = "fancycrafting")
    public static FancyCrafting instance;

    public static Block table;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        table = new BlockTable(Material.wood).setHardness(2.5F)
                .setStepSound(Block.soundTypeWood).setBlockName("fancyTable")
                .setCreativeTab(CreativeTabs.tabDecorations).setBlockTextureName("fancycrafting:fancyTable");
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        GameRegistry.registerBlock(table, "fancyTable");
        ItemStack melon = new ItemStack(Blocks.melon_block);
        GameRegistry.addShapelessRecipe(new ItemStack(table), melon, melon, melon, melon);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        GameRegistry.registerTileEntity(TileEntityTable.class, "fancycrafting.tileentitytable");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
