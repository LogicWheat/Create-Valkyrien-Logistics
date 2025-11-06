package io.github.techtastic.valkyrien_logistics

import com.mojang.blaze3d.systems.RenderSystem
import com.mojang.blaze3d.vertex.PoseStack
import com.simibubi.create.foundation.gui.AllIcons
import dev.architectury.utils.Env
import net.createmod.catnip.theme.Color
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.liukrast.eg.EGConstants
import net.liukrast.eg.mixin.AllIconsMixin
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.renderer.LightTexture
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.client.renderer.RenderType
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.phys.Vec3


class VLIcons(x: Int, y: Int) : AllIcons(x, y) {
    @Environment(EnvType.CLIENT)
    override fun bind() {
        RenderSystem.setShaderTexture(0, AllIcons.ICON_ATLAS)
    }

    @Environment(EnvType.CLIENT)
    override fun render(graphics: GuiGraphics, x: Int, y: Int) {
        graphics.blit(
            AllIcons.ICON_ATLAS, x, y, 0,
            (this as AllIconsMixin).iconX.toFloat(),
            (this as AllIconsMixin).iconY.toFloat(), 16, 16, AllIcons.ICON_ATLAS_SIZE, AllIcons.ICON_ATLAS_SIZE
        )
    }

    @Environment(EnvType.CLIENT)
    override fun render(ms: PoseStack, buffer: MultiBufferSource, color: Int) {
        val builder = buffer.getBuffer(RenderType.text(AllIcons.ICON_ATLAS))
        val matrix = ms.last().pose()
        val rgb = Color(color)
        val light = LightTexture.FULL_BRIGHT

        val vec1 = Vec3(0.0, 0.0, 0.0)
        val vec2 = Vec3(0.0, 1.0, 0.0)
        val vec3 = Vec3(1.0, 1.0, 0.0)
        val vec4 = Vec3(1.0, 0.0, 0.0)
        val iconX = (this as AllIconsMixin).iconX
        val iconY = (this as AllIconsMixin).iconY

        val u1 = iconX * 1f / AllIcons.ICON_ATLAS_SIZE
        val u2 = (iconX + 16) * 1f / AllIcons.ICON_ATLAS_SIZE
        val v1 = iconY * 1f / AllIcons.ICON_ATLAS_SIZE
        val v2 = (iconY + 16) * 1f / AllIcons.ICON_ATLAS_SIZE

        val cast = this as AllIconsMixin

        cast.invokeVertex(builder, matrix, vec1, rgb, u1, v1, light)
        cast.invokeVertex(builder, matrix, vec2, rgb, u1, v2, light)
        cast.invokeVertex(builder, matrix, vec3, rgb, u2, v2, light)
        cast.invokeVertex(builder, matrix, vec4, rgb, u2, v1, light)
    }

    companion object {
        val ICON_ATLAS: ResourceLocation = EGConstants.id("textures/gui/icons.png")
        const val ICON_ATLAS_SIZE: Int = 64

        private var x = 0
        private var y = -1

        val X = newRow()
        val Y = next()
        val Z = next()
        val W = next()

        private fun next(): VLIcons {
            return VLIcons(++x, y)
        }

        private fun newRow(): VLIcons {
            return VLIcons(0.also { x = it }, ++y)
        }
    }
}