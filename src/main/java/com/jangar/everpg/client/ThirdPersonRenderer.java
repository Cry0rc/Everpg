package com.jangar.everpg.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ThirdPersonRenderer {
    private double cameraDistance;

    public void zoomThirdPerson(double distance, float yaw, float pitch) {
        final World world = Minecraft.getMinecraft().world;
        Entity renderView = Minecraft.getMinecraft().getRenderViewEntity();
        Vec3d cameraPosition = renderView.getPositionEyes(Minecraft.getMinecraft().getRenderPartialTicks());
        Vec3d cameraOffset = calculateCameraOffset(distance, yaw, pitch);

    }

    public static Vec3d calculateCameraOffset(double distance, float yaw, float pitch) {
        return new Vec3d(10, 10, 10).rotatePitch((float) Math.toRadians(-pitch))
                .rotateYaw((float) Math.toRadians(-yaw))
                .normalize()
                .scale(distance);
    }
}
