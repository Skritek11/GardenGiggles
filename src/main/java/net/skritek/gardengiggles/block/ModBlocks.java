package net.skritek.gardengiggles.block;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skritek.gardengiggles.GardenGiggles;
import net.skritek.gardengiggles.item.ModItems;

import java.rmi.registry.Registry;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GardenGiggles.MOD_ID);


    public static final RegistryObject<Block> CATNIP = registerBlock("catnip",
            () -> new RootsBlock(
                    BlockBehaviour.Properties.copy(Blocks.POPPY).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_CATNIP = BLOCKS.register("potted_catnip",
            () -> new FlowerPotBlock(()-> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.CATNIP,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_WARPED_ROOTS).noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
