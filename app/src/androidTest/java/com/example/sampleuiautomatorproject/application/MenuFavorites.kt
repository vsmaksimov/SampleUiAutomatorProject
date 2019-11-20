package com.example.sampleuiautomatorproject.application

import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.ext.longTimeout
import com.example.sampleuiautomatorproject.util.ext.waitFindObject
import com.example.sampleuiautomatorproject.util.ext.waitHasObject
import junit.framework.Assert.assertTrue

class MenuFavorites {
    private val pageSelector = byStringRes("ru.ozon.app.android:id/menu_favorites")
    private val toolbarSelector = byStringRes("ru.ozon.app.android:id/toolbarTb")
    private val header = "Избранное"

    fun open() {
        pageSelector.waitFindObject(longTimeout).click()
        assertTrue(
            "Menu Favorites: not open",
            toolbarSelector.waitFindObject().hasObject(byText(header))

        )
    }

    fun checkProduct(productName: String) {
        assertTrue(
            "Product is not added to favorites",
            byText(productName).waitHasObject()
        )
    }
}