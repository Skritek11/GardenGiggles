package net.skritek.gardengiggles.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.skritek.gardengiggles.GardenGiggles;
import net.skritek.gardengiggles.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GardenGiggles.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.CATNIP.get(), models().cross(blockTexture(ModBlocks.CATNIP.get()).getPath(),
                blockTexture(ModBlocks.CATNIP.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_CATNIP.get(), models().singleTexture("potted_catnip", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.CATNIP.get())).renderType("cutout"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
