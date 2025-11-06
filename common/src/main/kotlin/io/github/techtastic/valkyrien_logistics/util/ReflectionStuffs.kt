package io.github.techtastic.valkyrien_logistics.util

import net.liukrast.eg.api.logistics.board.PanelConnection
import net.liukrast.eg.registry.EGPanelConnections

object ReflectionStuffs {
    fun <T> getConnection(field: String): PanelConnection<T>? {
        try {
            val instance = EGPanelConnections::class.java.getField(field)
            val get = Class.forName("net.minecraftforge.registries.RegistryObject").getMethod("get")
            return get.invoke(instance.get(null)) as PanelConnection<T>
        } catch (_: Exception) {}
        return null
    }
}