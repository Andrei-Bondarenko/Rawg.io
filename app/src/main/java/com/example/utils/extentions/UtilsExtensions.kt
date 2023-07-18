package com.example.utils.extentions

import android.widget.ImageView
import com.example.main_page.ui.enum_class.PlatformsEnum
import com.example.rawgio.R



    fun Any.getDrawable(platform: String) =
        when (platform) {
            PlatformsEnum.PS3.platform -> R.drawable.ic_ps3
            PlatformsEnum.PS4.platform -> R.drawable.ic_ps4
            PlatformsEnum.PS5.platform -> R.drawable.ic_ps5
            PlatformsEnum.MAC_OS.platform -> R.drawable.ic_macos
            PlatformsEnum.IOS.platform -> R.drawable.ic_ios
            PlatformsEnum.ANDROID.platform -> R.drawable.ic_android
            PlatformsEnum.XBOX.platform -> R.drawable.ic_xbox
            PlatformsEnum.XBOX360.platform -> R.drawable.ic_xbox
            PlatformsEnum.XBOX_ONE.platform -> R.drawable.ic_xbox
            PlatformsEnum.XBOX_SERIES.platform -> R.drawable.ic_xbox
            PlatformsEnum.LINUX.platform -> R.drawable.ic_linux
            PlatformsEnum.NINTENDO_SWITCH.platform -> R.drawable.ic_nintendo
            PlatformsEnum.PC.platform -> R.drawable.ic_pc
            else -> R.drawable.ic_loading
        }
