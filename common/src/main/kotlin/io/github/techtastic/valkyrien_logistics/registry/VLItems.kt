package io.github.techtastic.valkyrien_logistics.registry

import dev.architectury.registry.registries.DeferredRegister
import io.github.techtastic.valkyrien_logistics.ValkyrienLogistics
import io.github.techtastic.valkyrien_logistics.platform.PanelRegistry
import net.liukrast.eg.api.logistics.board.PanelBlockItem
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.Item

object VLItems {
    private val ITEMS = DeferredRegister.create(ValkyrienLogistics.MOD_ID, Registries.ITEM)

    val POSITION_GAUGE = ITEMS.register("position_gauge") { PanelBlockItem(PanelRegistry::getPositionPanel, Item.Properties()) }

    fun register() {
        ITEMS.register()
    }
}