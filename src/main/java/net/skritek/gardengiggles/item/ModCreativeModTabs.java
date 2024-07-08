package net.skritek.gardengiggles.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.skritek.gardengiggles.GardenGiggles;
import net.skritek.gardengiggles.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GardenGiggles.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GARDENGIGGLES_TAB = CREATIVE_MODE_TABS.register("gardengiggles_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CRANBERRY.get()))
                    .title(Component.translatable("creativetab.gardengiggles_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CRANBERRY.get());

                        output.accept(ModBlocks.CATNIP.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
