package com.packagesmaster.ui.views

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.packagesmaster.thememanager.ThemeManager
import com.packagesmaster.ui.R

class ConstraintLayoutThemed @JvmOverloads constructor(context: Context, var attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    init {
        if (!isInEditMode) {
            initConstraintLayoutThemeSettings()
        }
    }

    private fun initConstraintLayoutThemeSettings() {
        if (attrs?.getAttributeValue("http://schemas.android.com/apk/res/android", "background") == null) {
            initBackgroundColor()
        }
    }

    private fun initBackgroundColor() {
        ThemeManager.getThemeManager().onLightThemeSelected {
            setBackgroundColor(ResourcesCompat.getColor(resources, R.color.background_light, null))
        }
        .onDarkThemeSelected {
            setBackgroundColor(ResourcesCompat.getColor(resources, R.color.background_dark, null))
        }
        .onDynamicThemeSelected {

        }
        .onAnyThemeSelected {

        }
    }

}