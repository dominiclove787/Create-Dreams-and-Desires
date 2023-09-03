package uwu.lopyluna.create_dd.block.BlockProperties.drill;

import com.jozufozu.flywheel.core.virtual.VirtualRenderWorld;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import com.simibubi.create.content.contraptions.render.ContraptionMatrices;
import com.simibubi.create.content.contraptions.render.ContraptionRenderDispatcher;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import com.simibubi.create.foundation.render.CachedBufferer;
import com.simibubi.create.foundation.render.SuperByteBuffer;
import com.simibubi.create.foundation.utility.AngleHelper;
import com.simibubi.create.foundation.utility.AnimationTickHolder;
import com.simibubi.create.foundation.utility.VecHelper;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import uwu.lopyluna.create_dd.block.YIPPEEPartialModel;

public class RadiantDrillRenderer extends KineticBlockEntityRenderer<RadiantDrillBlockEntity> {

    public RadiantDrillRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected SuperByteBuffer getRotatedModel(RadiantDrillBlockEntity be, BlockState state) {
         CachedBufferer.partialFacing(YIPPEEPartialModel.RADIANT_DRILL_HEAD_GLOW, state);
        return CachedBufferer.partialFacing(YIPPEEPartialModel.RADIANT_DRILL_HEAD, state);
    }

    public static void renderInContraption(MovementContext context, VirtualRenderWorld renderWorld,
                                           ContraptionMatrices matrices, MultiBufferSource buffer) {
        BlockState state = context.state;
        SuperByteBuffer superBuffer = CachedBufferer.partial(YIPPEEPartialModel.RADIANT_DRILL_HEAD, state);
        SuperByteBuffer superBuffer2 = CachedBufferer.partial(YIPPEEPartialModel.RADIANT_DRILL_HEAD_GLOW, state);

        Direction facing = state.getValue(RadiantDrillBlock.FACING);

        float speed = (float) (context.contraption.stalled
                || !VecHelper.isVecPointingTowards(context.relativeMotion, facing
                .getOpposite()) ? context.getAnimationSpeed() : 0);
        float time = AnimationTickHolder.getRenderTime() / 20;
        float angle = (float) (((time * speed) % 360));

        superBuffer
                .transform(matrices.getModel())
                .centre()
                .rotateY(AngleHelper.horizontalAngle(facing))
                .rotateX(AngleHelper.verticalAngle(facing))
                .rotateZ(angle)
                .unCentre()
                .light(matrices.getWorld(),
                        ContraptionRenderDispatcher.getContraptionWorldLight(context, renderWorld))
                .renderInto(matrices.getViewProjection(), buffer.getBuffer(RenderType.solid()));
        superBuffer2
                .transform(matrices.getModel())
                .centre()
                .rotateY(AngleHelper.horizontalAngle(facing))
                .rotateX(AngleHelper.verticalAngle(facing))
                .rotateZ(angle)
                .unCentre()
                .light(LightTexture.FULL_BRIGHT)
                .renderInto(matrices.getViewProjection(), buffer.getBuffer(RenderType.solid()));
    }

}
