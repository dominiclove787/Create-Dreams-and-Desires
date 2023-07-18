package uwu.lopyluna.create_dd.worldgen;

import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import uwu.lopyluna.create_dd.block.YIPPEE;
import uwu.lopyluna.create_dd.block.YIPPEEPaletteStoneTypes;

import java.util.List;

public class YummyOreFeatures {

    public static final RuleTest weathered_limestone_replaceable = new TagMatchTest(YummyTags.AllBlockTags.weathered_limestone_replaceable.tag);
    public static final RuleTest limestone_replaceable = new TagMatchTest(YummyTags.AllBlockTags.limestone_replaceable.tag);
    public static final RuleTest potassic_replaceable = new TagMatchTest(YummyTags.AllBlockTags.potassic_replaceable.tag);
    public static final RuleTest gabbro_replaceable = new TagMatchTest(YummyTags.AllBlockTags.gabbro_replaceable.tag);

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_STONE_BLOBS = List.of(
            OreConfiguration.target(YummyOreFeatures.gabbro_replaceable, YIPPEEPaletteStoneTypes.gabbro.getBaseBlock().get().defaultBlockState()),
            OreConfiguration.target(YummyOreFeatures.weathered_limestone_replaceable, YIPPEEPaletteStoneTypes.weathered_limestone.getBaseBlock().get().defaultBlockState()),
            OreConfiguration.target(YummyOreFeatures.potassic_replaceable, YIPPEEPaletteStoneTypes.potassic.getBaseBlock().get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_LIMESTONE_BLOBS = List.of(
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, AllPaletteStoneTypes.LIMESTONE.getBaseBlock().get().defaultBlockState()),
            OreConfiguration.target(YummyOreFeatures.limestone_replaceable, AllPaletteStoneTypes.LIMESTONE.getBaseBlock().get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_WEATHERED_LIMESTONE_BLOBS = List.of(
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, YIPPEEPaletteStoneTypes.weathered_limestone.getBaseBlock().get().defaultBlockState()),
            OreConfiguration.target(YummyOreFeatures.weathered_limestone_replaceable, YIPPEEPaletteStoneTypes.weathered_limestone.getBaseBlock().get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_ERODED_LIMESTONE_BLOBS = List.of(
            OreConfiguration.target(YummyOreFeatures.weathered_limestone_replaceable, YIPPEEPaletteStoneTypes.weathered_limestone.getBaseBlock().get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_GABBRO_BLOBS = List.of(
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, YIPPEEPaletteStoneTypes.gabbro.getBaseBlock().get().defaultBlockState()),
            OreConfiguration.target(YummyOreFeatures.gabbro_replaceable, YIPPEEPaletteStoneTypes.gabbro.getBaseBlock().get().defaultBlockState()));


    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_TIN_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, YIPPEE.tin_ore.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, YIPPEE.deepslate_tin_ore.get().defaultBlockState()));



    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> stone_blobs = FeatureUtils.register("stone_blobs",
            Feature.ORE, new OreConfiguration(OVERWORLD_STONE_BLOBS,48));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> limestone_blobs = FeatureUtils.register("limestone_blobs",
            Feature.ORE, new OreConfiguration(OVERWORLD_LIMESTONE_BLOBS,32));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> weathered_limestone_blobs = FeatureUtils.register("weathered_limestone_blobs",
            Feature.ORE, new OreConfiguration(OVERWORLD_WEATHERED_LIMESTONE_BLOBS,24));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> gabbro_blobs = FeatureUtils.register("gabbro_blobs",
            Feature.ORE, new OreConfiguration(OVERWORLD_GABBRO_BLOBS,48));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> eroded_limestone_blobs = FeatureUtils.register("eroded_blobs",
            Feature.SCATTERED_ORE, new OreConfiguration(OVERWORLD_ERODED_LIMESTONE_BLOBS,12));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> tin_ore = FeatureUtils.register("tin_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_TIN_ORES, 12));
}