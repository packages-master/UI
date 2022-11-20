package com.packagesmaster.ui.components.edittext

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.res.ResourcesCompat
import com.packagesmaster.ui.R
import com.google.android.material.textfield.TextInputEditText
import com.packagesmaster.thememanager.ThemeManager

class TextInputLayoutEditText @JvmOverloads constructor(context: Context, var attrs: AttributeSet? = null) : TextInputEditText(context, attrs) {

    init {
        if (!isInEditMode) {
            initTextInputSettings()
        }
    }

    private fun initTextInputSettings() {
        if (attrs?.getAttributeValue("http://schemas.android.com/apk/res/android", "textColor") == null) {
            initTextColor()
        }
    }

    private fun initTextColor() {
        ThemeManager.getThemeManager().onLightThemeSelected {
            setTextColor(ResourcesCompat.getColor(resources, R.color.bold_text_color_light, null))
        }
        .onDarkThemeSelected {
            setTextColor(ResourcesCompat.getColor(resources, R.color.bold_text_color_dark, null))
        }
        .onDynamicThemeSelected {

        }
        .onAnyThemeSelected {

        }
    }

}