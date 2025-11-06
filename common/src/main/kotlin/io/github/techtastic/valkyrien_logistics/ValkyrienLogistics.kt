package io.github.techtastic.valkyrien_logistics

import io.github.techtastic.valkyrien_logistics.registry.VLItems

object ValkyrienLogistics {
    const val MOD_ID = "valkyrien_logistics"

    @JvmStatic
    fun init() {
        VLItems.register()
    }

    @JvmStatic
    fun initClient() {
    }
}
