package io.github.techtastic.valkyrien_logistics.registry

import dev.engine_room.flywheel.lib.model.baked.PartialModel
import io.github.techtastic.valkyrien_logistics.ValkyrienLogistics
import net.minecraft.resources.ResourceLocation

object VLPartialModels {
    val POSITION_PANEL = PartialModel.of(ResourceLocation(ValkyrienLogistics.MOD_ID, "block/position_gauge"))
    val LINEAR_VELOCITY_PANEL = PartialModel.of(ResourceLocation(ValkyrienLogistics.MOD_ID, "block/linear_velocity_gauge"))

    fun init() {}
}