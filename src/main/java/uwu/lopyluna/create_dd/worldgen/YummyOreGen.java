package uwu.lopyluna.create_dd.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class YummyOreGen {
    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);


        base.add(YummyOrePlacedFeatures.STONE_BLOBS_PLACED);
        base.add(YummyOrePlacedFeatures.LIMESTONE_BLOBS_PLACED);
        base.add(YummyOrePlacedFeatures.WEATHERED_LIMESTONE_BLOBS_PLACED);
        base.add(YummyOrePlacedFeatures.GABBRO_BLOBS_PLACED);
        base.add(YummyOrePlacedFeatures.ERODED_LIMESTONE_BLOBS_PLACED);
        base.add(YummyOrePlacedFeatures.TIN_ORE_PLACED);
    }
}