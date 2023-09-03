package uwu.lopyluna.create_dd.block;

import com.jozufozu.flywheel.core.PartialModel;
import com.simibubi.create.foundation.render.CachedBufferer;
import com.simibubi.create.foundation.render.SuperByteBuffer;
import com.simibubi.create.foundation.utility.Couple;
import net.minecraft.resources.ResourceLocation;
import uwu.lopyluna.create_dd.DDcreate;

import java.util.HashMap;
import java.util.Map;

public class YIPPEEPartialModel {


    public static final PartialModel
            BRONZE_SAW_BLADE_HORIZONTAL_ACTIVE = block("bronze_saw/blade_horizontal_active"),
            BRONZE_SAW_BLADE_HORIZONTAL_INACTIVE = block("bronze_saw/blade_horizontal_inactive"),
            BRONZE_SAW_BLADE_HORIZONTAL_REVERSED = block("bronze_saw/blade_horizontal_reversed"),
            BRONZE_SAW_BLADE_VERTICAL_ACTIVE = block("bronze_saw/blade_vertical_active"),
            BRONZE_SAW_BLADE_VERTICAL_INACTIVE = block("bronze_saw/blade_vertical_inactive"),
            BRONZE_SAW_BLADE_VERTICAL_REVERSED = block("bronze_saw/blade_vertical_reversed"),
            RADIANT_DRILL_HEAD = block("radiant_drill/head"),
            RADIANT_DRILL_HEAD_GLOW = block("radiant_drill/head_glow"),
            SHADOW_DRILL_HEAD = block("shadow_drill/head"),
            BRONZE_DRILL_HEAD = block("bronze_drill/head"),
            HYDRAULIC_PRESS_HEAD = block("hydraulic_press/head"),
            INDUSTRIAL_FAN_COG = block("industrial_fan/cog"),
            BRONZE_ENCASED_FAN_INNER = block("industrial_fan/propeller")
            ;

    public static final Map<ResourceLocation, Couple<PartialModel>> FOLDING_DOORS = new HashMap<>();
    static {
        putFoldingDoor("rose_door");
        putFoldingDoor("smoked_door");
        putFoldingDoor("spirit_door");
    }
    private static void putFoldingDoor(String path) {
        FOLDING_DOORS.put(DDcreate.asResource(path),
                Couple.create(block(path + "/fold_left"), block(path + "/fold_right")));
    }

    private static PartialModel block(String path) {
        return new PartialModel(DDcreate.asResource("block/" + path));
    }

    public static void init() {
    }
}
