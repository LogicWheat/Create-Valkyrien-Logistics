package io.github.techtastic.valkyrien_logistics.content.logistics.board

import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlock
import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlockEntity
import io.github.techtastic.valkyrien_logistics.util.ReflectionStuffs
import net.liukrast.eg.api.registry.PanelType
import net.liukrast.eg.content.logistics.board.ScrollOptionPanelBehaviour
import net.minecraft.network.chat.Component


abstract class VectorPanelBehaviour(label: Component, type: PanelType<*>, be: FactoryPanelBlockEntity, slot: FactoryPanelBlock.PanelSlot): ScrollOptionPanelBehaviour<VectorSelectionMode>(
    label, type, be, slot, VectorSelectionMode::class.java
) {
    abstract fun getOutput(): Int

    override fun addConnections(builder: PanelConnectionBuilder) {
        ReflectionStuffs.getConnection<Int>("INTEGER")?.let {
            builder.put(it, ::getOutput)
        }
    }
}

