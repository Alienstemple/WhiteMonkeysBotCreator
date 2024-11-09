package com.whitemonkeys.botcreator.bot_catalog

sealed interface BotCatalogEvent {

    data object OnBackClick : BotCatalogEvent

    data class OnCategoryClick(val id: Int) : BotCatalogEvent
    data class OnSampleAddClick(val id: Int) : BotCatalogEvent
    data class OnSampleRemoveClick(val id: Int) : BotCatalogEvent

}