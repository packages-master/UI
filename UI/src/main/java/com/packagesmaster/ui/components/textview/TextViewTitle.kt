package com.packagesmaster.ui.components.textview

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.res.ResourcesCompat
import com.packagesmaster.ui.R
import com.google.android.material.textview.MaterialTextView
import com.packagesmaster.thememanager.ThemeManager

class TextViewTitle @JvmOverloads constructor(context: Context, var attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0) : MaterialTextView(context, attrs, defStyleAttr, defStyleRes) {

    init {
        if (!isInEditMode) {
            initTextViewTitleSettings()
        }
    }

    private fun initTextViewTitleSettings() {
        if (attrs?.getAttributeValue("http://schemas.android.com/apk/res/android", "textColor") == null) {
            initTextColor()
        }
    }

    private fun initTextColor() {
        ThemeManager.getThemeManager().onLightThemeSelected {
            setTextColor(ResourcesCompat.getColor(resources, R.color.title_color_light, null))
        }
        .onDarkThemeSelected {
            setTextColor(ResourcesCompat.getColor(resources, R.color.title_color_dark, null))
        }
        .onDynamicThemeSelected {

        }
        .onAnyThemeSelected {

        }
    }

}