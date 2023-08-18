package net.smazeee.signaling.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.smazeee.signaling.SignalingDetection;
import net.smazeee.signaling.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SignalingDetection.MOD_ID);

    public static final RegistryObject<BlockEntityType<BlockDetecterBlockEntity>> BLOCK_DETECTOR_BE =
            BLOCK_ENTITIES.register("block_detector_block_entity", () ->
                    BlockEntityType.Builder.of(BlockDetecterBlockEntity::new,
                            ModBlocks.BLOCK_DETECTOR.get()).build(null));



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
