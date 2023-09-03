package uwu.lopyluna.create_dd.rando;

import javax.annotation.Nonnull;

import com.simibubi.create.foundation.utility.Color;
import com.simibubi.create.foundation.utility.VecHelper;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SimpleAnimatedParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;
import uwu.lopyluna.create_dd.block.BlockProperties.bronze_encased_fan.BronzeIAirCurrentSource;
import uwu.lopyluna.create_dd.recipes.BakingFanProcessing;

public class BronzeAirFlowParticle extends SimpleAnimatedParticle {

    private final BronzeIAirCurrentSource source;

    protected BronzeAirFlowParticle(ClientLevel world, BronzeIAirCurrentSource source, double x, double y, double z,
                              SpriteSet sprite) {
        super(world, x, y, z, sprite, world.random.nextFloat() * .5f);
        this.source = source;
        this.quadSize *= 0.75F;
        this.lifetime = 40;
        hasPhysics = false;
        selectSprite(7);
        Vec3 offset = VecHelper.offsetRandomly(Vec3.ZERO, world.random, .25f);
        this.setPos(x + offset.x, y + offset.y, z + offset.z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
        setAlpha(.25f);
    }

    @Nonnull
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        if (source == null || source.isSourceRemoved()) {
            dissipate();
            return;
        }
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            if (source.getBAirCurrent() == null || !source.getBAirCurrent().bounds.inflate(.25f).contains(x, y, z)) {
                dissipate();
                return;
            }

            Vec3 directionVec = Vec3.atLowerCornerOf(source.getBAirCurrent().direction.getNormal());
            Vec3 motion = directionVec.scale(1 / 8f);
            if (!source.getBAirCurrent().pushing)
                motion = motion.scale(-1);

            double distance = new Vec3(x, y, z).subtract(VecHelper.getCenterOf(source.getAirCurrentPos()))
                    .multiply(directionVec).length() - .5f;
            if (distance > source.getBAirCurrent().maxDistance + 1 || distance < -.25f) {
                dissipate();
                return;
            }
            motion = motion.scale(source.getBAirCurrent().maxDistance - (distance - 1f)).scale(.5f);
            selectSprite((int) Mth.clamp((distance / source.getBAirCurrent().maxDistance) * 8 + level.random.nextInt(4),
                    0, 7));

            morphType(distance);

            xd = motion.x;
            yd = motion.y;
            zd = motion.z;

            if (this.onGround) {
                this.xd *= 0.7;
                this.zd *= 0.7;
            }
            this.move(this.xd, this.yd, this.zd);

        }

    }

    public void morphType(double distance) {
        if (source.getBAirCurrent() == null)
            return;
        BakingFanProcessing.FanType type = source.getBAirCurrent().getSegmentAt((float) distance);



        if (type == BakingFanProcessing.FanType.SPLASHING) {
            setColor(Color.mixColors(0x4499FF, 0x2277FF, level.random.nextFloat()));
            setAlpha(1f);
            selectSprite(level.random.nextInt(3));
            if (level.random.nextFloat() < 1 / 32f)
                level.addParticle(ParticleTypes.BUBBLE, x, y, z, xd * .125f, yd * .125f,
                        zd * .125f);
            if (level.random.nextFloat() < 1 / 32f)
                level.addParticle(ParticleTypes.BUBBLE_POP, x, y, z, xd * .125f, yd * .125f,
                        zd * .125f);
        }

        if (type == BakingFanProcessing.FanType.SMOKING) {
            setColor(Color.mixColors(0x0, 0x555555, level.random.nextFloat()));
            setAlpha(1f);
            selectSprite(level.random.nextInt(3));
            if (level.random.nextFloat() < 1 / 32f)
                level.addParticle(ParticleTypes.SMOKE, x, y, z, xd * .125f, yd * .125f,
                        zd * .125f);
            if (level.random.nextFloat() < 1 / 32f)
                level.addParticle(ParticleTypes.LARGE_SMOKE, x, y, z, xd * .125f, yd * .125f,
                        zd * .125f);
        }

        if (type == BakingFanProcessing.FanType.HAUNTING) {
            setColor(Color.mixColors(0x0, 0x126568, level.random.nextFloat()));
            setAlpha(1f);
            selectSprite(level.random.nextInt(3));
            if (level.random.nextFloat() < 1 / 128f)
                level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, xd * .125f, yd * .125f,
                        zd * .125f);
            if (level.random.nextFloat() < 1 / 32f)
                level.addParticle(ParticleTypes.SMOKE, x, y, z, xd * .125f, yd * .125f,
                        zd * .125f);
        }

        if (type == BakingFanProcessing.FanType.BLASTING) {
            setColor(Color.mixColors(0xFF4400, 0xFF8855, level.random.nextFloat()));
            setAlpha(.5f);
            selectSprite(level.random.nextInt(3));
            if (level.random.nextFloat() < 1 / 32f)
                level.addParticle(ParticleTypes.FLAME, x, y, z, xd * .25f, yd * .25f,
                        zd * .25f);
            if (level.random.nextFloat() < 1 / 16f)
                level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.LAVA.defaultBlockState()), x, y,
                        z, xd * .25f, yd * .25f, zd * .25f);
        }

        if (type == BakingFanProcessing.FanType.FREEZING) {
            setColor(Color.mixColors(0xEEEEFF, 0xDDE8FF, level.random.nextFloat()));
            setAlpha(1f);
            selectSprite(level.random.nextInt(3));
            if (level.random.nextFloat() < 1 / 32f)
                level.addParticle(ParticleTypes.SNOWFLAKE, x, y, z, xd * .125f, yd * .125f,
                        zd * .125f);
            if (level.random.nextFloat() < 1 / 32f)
                level.addParticle(ParticleTypes.POOF, x, y, z, xd * .125f, yd * .125f,
                        zd * .125f);
        }

        if (type == null) {
            setColor(0xEEEEEE);
            setAlpha(.25f);
            setSize(.2f, .2f);
        }
    }

    private void dissipate() {
        remove();
    }

    public int getLightColor(float partialTick) {
        BlockPos blockpos = new BlockPos(this.x, this.y, this.z);
        return this.level.isLoaded(blockpos) ? LevelRenderer.getLightColor(level, blockpos) : 0;
    }

    private void selectSprite(int index) {
        setSprite(sprites.get(index, 8));
    }

    public static class Factory implements ParticleProvider<DDAirFlowParticleData> {
        private final SpriteSet spriteSet;

        public Factory(SpriteSet animatedSprite) {
            this.spriteSet = animatedSprite;
        }

        public Particle createParticle(DDAirFlowParticleData data, ClientLevel worldIn, double x, double y, double z,
                                       double xSpeed, double ySpeed, double zSpeed) {
            BlockEntity be = worldIn.getBlockEntity(new BlockPos(data.posX, data.posY, data.posZ));
            if (!(be instanceof BronzeIAirCurrentSource))
                be = null;
            return new BronzeAirFlowParticle(worldIn, (BronzeIAirCurrentSource) be, x, y, z, this.spriteSet);
        }
    }

}
