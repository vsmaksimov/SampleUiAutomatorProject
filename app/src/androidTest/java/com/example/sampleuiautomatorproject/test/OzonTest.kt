package com.example.sampleuiautomatorproject.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sampleuiautomatorproject.application.Ozon
import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.ext.waitFindObject
import com.example.sampleuiautomatorproject.util.ext.waitFindObjects
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OzonTest: AbstractApplicationTest<Ozon>(Ozon()) {
        // 1. Проверка подсказки при поиске товара
        @Test
        fun hintTest() = with(app) {
            val requestText = "Философия Java"
            val price = "1 499 \u20BD"

            open()
            menuMain.clickSearch()
            menuMain.typeToSearch(requestText)
            menuMain.assertHintText(requestText)
            menuMain.assertHintPrice(price)
        }

        // 2. Добавление товара в избранное
        @Test
        fun addToFavoritesTest() = with(app) {
            val requestText = "Философия Java"
            open()
            menuMain.clickSearch()
            menuMain.typeToSearch(requestText)
            val product = menuMain.tapHint(requestText)
            product.isPageProductLoaded()
            product.addToFavorites()
            menuFavorites.open()
            menuFavorites.checkProduct(requestText)
        }

        // 3. Проверка валидации e-mail при авторизации
        @Test
        fun emailValidationTest() = with(app) {
            open()
            menuProfile.open()
            menuProfile.enterByEmail()
            menuProfile.enterEmail("someincorrectmail")
            menuProfile.pressEnter()
            menuProfile.checkForEmailInputError(visible = true)
            menuProfile.enterEmail("somecorrectmail@nomail.com")
            menuProfile.pressEnter()
            menuProfile.checkForEmailInputError(visible = false)
        }

        // 4. Проверка предложения о регистрации при попытке написания комментария
        @Test
        fun authorizationBeforeReviewTest() = with(app) {
            open()
            menuMain.clickSearch()
            menuMain.typeToSearch("Философия Java")
            val product = menuMain.tapHint("Философия Java")
            product.isPageProductLoaded()
            product.writeReview()
            menuProfile.checkAuthorizationHeader()
        }
}