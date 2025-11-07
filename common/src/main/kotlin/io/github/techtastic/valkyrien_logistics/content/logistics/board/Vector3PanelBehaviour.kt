package io.github.techtastic.valkyrien_logistics.content.logistics.board

import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlock
import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlockEntity
import io.github.techtastic.valkyrien_logistics.util.ReflectionStuffs
import net.liukrast.eg.api.registry.PanelType
import net.liukrast.eg.content.logistics.board.ScrollOptionPanelBehaviour
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import org.joml.Vector3dc

abstract class Vector3PanelBehaviour(type: PanelType<*>, be: FactoryPanelBlockEntity, slot: FactoryPanelBlock.PanelSlot): ScrollOptionPanelBehaviour<Vector3SelectionMode>(
    Component.translatable("create.logistics.vector_panel"), type, be, slot, Vector3SelectionMode::class.java
) {
    abstract fun getVector(): Vector3dc

    fun getOutput(): Double {
        return when(get()) {
            Vector3SelectionMode.X -> getVector().x()
            Vector3SelectionMode.Y -> getVector().y()
            Vector3SelectionMode.Z -> getVector().z()
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
        val vec = getVector()
        if (shortenNumbers)
            return Component.translatable("create.logistics.vector_panel.string", vec.x().toInt(), vec.y().toInt(), vec.z().toInt())
        return Component.translatable("create.logistics.vector_panel.string", vec.x(), vec.y(), vec.z())
    }
}

