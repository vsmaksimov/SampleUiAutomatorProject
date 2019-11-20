package com.example.sampleuiautomatorproject.application
import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.ext.*
import junit.framework.Assert.assertEquals

class MenuMain {
    private val searchSelector = byStringRes("ru.ozon.app.android:id/searchTv")
    private val inputSelector = byStringRes("ru.ozon.app.android:id/search_src_text")
    private val priceSelector = byStringRes("ru.ozon.app.android:id/priceTv")
    private val hintImageSelector = byStringRes("ru.ozon.app.android:id/productIv")
    private val hintTextSelector = byStringRes("ru.ozon.app.android:id/titleTv")

    fun clickSearch() {
        searchSelector.waitFindObject(longTimeout).click()
    }

    fun typeToSearch(text: String) {
        inputSelector.waitFindObject(longTimeout).text = text
    }

    fun tapHint(hintText: String): Product {
        hintImageSelector.waitFindObject().clickAndWaitnewWindow()
        return Product(hintText)
    }

    fun assertHintText(hintText: String) {
        val hint = hintImageSelector.waitFindObject().parent
        val hintTextView = hint.findObject(hintTextSelector)
        assertEquals(
            "False hint text",
            hintText,
            hintTextView.text
        )
    }

    fun assertHintPrice(hintPrice: String) {
        assertEquals(
            "False price",
            hintPrice,
            priceSelector.waitFindObject().text)
    }
}