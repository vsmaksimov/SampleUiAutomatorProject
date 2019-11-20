package com.example.sampleuiautomatorproject.application

import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.ext.*
import junit.framework.Assert.assertTrue

class Product(val name: String) {
    private val favoritesSelector = byStringRes("ru.ozon.app.android:id/favoritesIv")
    private val writeReviewButtonId = "ru.ozon.app.android:id/writeReviewBtn"
    private val writeReviewButtonSelector = byStringRes(writeReviewButtonId)

    fun isPageProductLoaded() {
        assertTrue(
            "Product page is not loaded",
            byText(name).waitHasObject(longTimeout)
        )

    }

    fun addToFavorites() {
        favoritesSelector.waitFindObject().click()
    }

    fun writeReview() {
        assertTrue(
            "",
            UiScrollable(UiSelector().scrollable(true)).
                scrollIntoView(UiSelector().resourceId(writeReviewButtonId))
        )
        writeReviewButtonSelector.waitFindObject().click()
    }
}