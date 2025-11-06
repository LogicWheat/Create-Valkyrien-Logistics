package io.github.techtastic.valkyrien_logistics.registry

import dev.engine_room.flywheel.lib.model.baked.PartialModel
import io.github.techtastic.valkyrien_logistics.ValkyrienLogistics
import net.minecraft.resources.ResourceLocation

object VLPartialModels {
    val VECTOR_X_PANEL = PartialModel.of(ResourceLocation(ValkyrienLogistics.MOD_ID, "block/vector_x_gauge"))
    val VECTOR_Y_PANEL = PartialModel.of(ResourceLocation(ValkyrienLogistics.MOD_ID, "block/vector_y_gauge"))
    val VECTOR_Z_PANEL = PartialModel.of(ResourceLocation(ValkyrienLogistics.MOD_ID, "block/vector_z_gauge"))
    val VECTOR_W_PANEL = PartialModel.of(ResourceLocation(ValkyrienLogistics.MOD_ID, "block/vector_w_gauge"))
}