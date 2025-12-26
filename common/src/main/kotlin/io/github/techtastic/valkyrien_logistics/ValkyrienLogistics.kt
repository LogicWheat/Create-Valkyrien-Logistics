package io.github.techtastic.valkyrien_logistics

import io.github.techtastic.valkyrien_logistics.registry.VLItems
import io.github.techtastic.valkyrien_logistics.registry.VLPartialModels

object ValkyrienLogistics {
    const val MOD_ID = "valkyrien_logistics"

    @JvmStatic
    fun init() {
        VLItems.register()
        VLPartialModels.init()


    }

    @JvmStatic
    fun initClient() {
    }
}
