package uwu.lopyluna.create_dd.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class YummyOrePlacedFeatures {

    public static final Holder<PlacedFeature> TIN_ORE_PLACED = PlacementUtils.register("tin_ore_placed",
            YummyOreFeatures.tin_ore, YummyOrePlacement.commonOrePlacement(10, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-45), VerticalAnchor.aboveBottom(128))));

    public static final Holder<PlacedFeature> STONE_BLOBS_PLACED = PlacementUtils.register("stone_blobs_placed",
            YummyOreFeatures.stone_blobs, YummyOrePlacement.commonOrePlacement(16, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(256))));

    public static final Holder<PlacedFeature> LIMESTONE_BLOBS_PLACED = PlacementUtils.register("limestone_blobs_placed",
            YummyOreFeatures.limestone_blobs, YummyOrePlacement.commonOrePlacement(2, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(24))));

    public static final Holder<PlacedFeature> WEATHERED_LIMESTONE_BLOBS_PLACED = PlacementUtils.register("weathered_limestone_blobs_placed",
            YummyOreFeatures.weathered_limestone_blobs, YummyOrePlacement.commonOrePlacement(2, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(0))));

    public static final Holder<PlacedFeature> GABBRO_BLOBS_PLACED = PlacementUtils.register("gabbro_blobs_placed",
            YummyOreFeatures.gabbro_blobs, YummyOrePlacement.commonOrePlacement(1, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(24))));

    public static final Holder<PlacedFeature> ERODED_LIMESTONE_BLOBS_PLACED = PlacementUtils.register("eroded_limestone_blobs_placed",
            YummyOreFeatures.eroded_limestone_blobs, YummyOrePlacement.commonOrePlacement(4, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(256))));

}