package com.example.sampleuiautomatorproject.application

import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.ext.longTimeout
import com.example.sampleuiautomatorproject.util.ext.waitFindObject
import com.example.sampleuiautomatorproject.util.ext.waitHasObject
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue

class MenuProfile {
    private val pageSelector = byStringRes("ru.ozon.app.android:id/menu_profile")
    private val enterByEmailSelector = byText("Войти по почте")
    private val inputEmailSelector = byStringRes("ru.ozon.app.android:id/emailEt")
    private val buttonEnterSelector = byStringRes("ru.ozon.app.android:id/submitBtn")
    private val inputErrorSelector = byText("Некорректный формат почты")
    private val header = "Вход или регистрация"
    private val headerEneterByEmailSelector = byText("Вход по почте")

    fun open() {
        pageSelector.waitFindObject(longTimeout).click()
    }

    fun enterByEmail() {
        enterByEmailSelector.waitFindObject(longTimeout).click()
        assertTrue("", headerEneterByEmailSelector.waitHasObject(longTimeout))
    }

    fun enterEmail(email: String) {
        inputEmailSelector.waitFindObject().text = email
    }

    fun pressEnter() {
        assertTrue(
            "Enter button is not clickable",
            buttonEnterSelector.waitFindObject().isClickable
        )
        buttonEnterSelector.waitFindObject().click()
    }

    fun checkForEmailInputError(visible: Boolean) {
        if (visible)
            assertTrue(
                "InputErrorLabel is not visible",
                inputErrorSelector.waitHasObject(longTimeout)
            )
        else
            assertFalse(
                "InputErrorLabel is visible",
                inputErrorSelector.waitHasObject(longTimeout)
            )
    }

    fun checkAuthorizationHeader() {
        assertTrue(
            "False header",
            byText(header).waitHasObject()
        )
    }
}