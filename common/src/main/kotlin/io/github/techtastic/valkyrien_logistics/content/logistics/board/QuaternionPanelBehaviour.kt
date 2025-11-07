package io.github.techtastic.valkyrien_logistics.content.logistics.board

import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlock
import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlockEntity
import dev.engine_room.flywheel.lib.model.baked.PartialModel
import io.github.techtastic.valkyrien_logistics.registry.VLItems
import io.github.techtastic.valkyrien_logistics.registry.VLPartialModels
import io.github.techtastic.valkyrien_logistics.util.ReflectionStuffs
import net.liukrast.eg.api.registry.PanelType
import net.liukrast.eg.content.logistics.board.ScrollOptionPanelBehaviour
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import net.minecraft.world.item.Item
import org.joml.Quaterniond
import org.valkyrienskies.mod.common.getShipManagingPos

class QuaternionPanelBehaviour(type: PanelType<*>, be: FactoryPanelBlockEntity, slot: FactoryPanelBlock.PanelSlot): ScrollOptionPanelBehaviour<QuaternionSelectionMode>(
    Component.translatable("create.logistics.vector_panel"), type, be, slot, QuaternionSelectionMode::class.java
) {
    fun getOutput(): Double {
        val ship = world.getShipManagingPos(pos)
        return when(get()) {
            QuaternionSelectionMode.X -> ship?.transform?.shipToWorldRotation?.x() ?: 0.0
            QuaternionSelectionMode.Y -> ship?.transform?.shipToWorldRotation?.y() ?: 0.0
            QuaternionSelectionMode.Z -> ship?.transform?.shipToWorldRotation?.z() ?: 0.0
            QuaternionSelectionMode.W -> ship?.transform?.shipToWorldRotation?.w() ?: 0.0
            else -> 0.0
        }
    }

    override fun addConnections(builder: PanelConnectionBuilder) {
        ReflectionStuffs.getConnection<Int>("INTEGER")?.let {
            builder.put(it) { getOutput().toInt() }
        }
        ReflectionStuffs.getConnection<String>("STRING")?.let {
            builder.put(it) { getOutput().toString() }
        }
    }

    override fun getDisplayLinkComponent(shortenNumbers: Boolean): MutableComponent {
        val quat = world.getShipManagingPos(pos)?.transform?.shipToWorldRotation ?: Quaterniond()
        if (shortenNumbers)
            return Component.translatable("create.logistics.quaternion_panel.string", quat.x().toInt(), quat.y().toInt(), quat.z().toInt(), quat.w().toInt())
        return Component.translatable("create.logistics.quaternion_panel.string", quat.x(), quat.y(), quat.z(), quat.w())
    }

    override fun getItem(): Item = VLItems.ROTATION_GAUGE.get()

    override fun getModel(panelState: FactoryPanelBlock.PanelState, panelType: FactoryPanelBlock.PanelType): PartialModel =
        VLPartialModels.ROTATION_PANEL
}

