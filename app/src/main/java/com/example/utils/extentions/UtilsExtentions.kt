package com.example.utils.extentions

import com.example.rawgio.R

fun getDrawable(platform: String): Int {
    return when (platform) {
        "PC" -> R.drawable.ic_ps
        "iOS" -> R.drawable.ic_ios
        "Android" -> R.drawable.ic_android
        "macOS" -> R.drawable.ic_macos
        "Linux" -> R.drawable.ic_linux
        "GameCube" -> R.drawable.ic_nintendo_gamecube
        "Classic Macintosh" -> R.drawable.ic_masintosh
        "Apple II" -> R.drawable.ic_apple_ii
        "Commodore / Amiga" -> R.drawable.ic_amiga
        "Genesis" -> R.drawable.ic_genesis
        "Dreamcast" -> R.drawable.ic_dreamcast
        "3DO" -> R.drawable.ic_3do
        "Jaguar" -> R.drawable.ic_jaguar
        "Game Gear" -> R.drawable.ic_game_gear
        "Neo Geo" -> R.drawable.ic_neo_geo
        "SEGA Saturn" -> R.drawable.ic_sega_saturn
        "SEGA CD" -> R.drawable.ic_sega_cd
        "SEGA 32X" -> R.drawable.ic_sega_32x
        "SEGA Master System" -> R.drawable.ic_sega_master_system
        "Atari 7800" -> R.drawable.ic_atari_7800
        "Atari 5200" -> R.drawable.ic_atari_5200
        "Atari 2600" -> R.drawable.ic_atari_2600
        "Atari 8-bit" -> R.drawable.ic_atari_8bit
        "Atari ST" -> R.drawable.ic_atari_st
        "Atari Lynx" -> R.drawable.ic_atari_linx
        "Atari XEGS" -> R.drawable.ic_atari_xe
        "Atari Flashback" -> R.drawable.ic_atari_flashbsck
        "Game Boy Advance" -> R.drawable.ic_game_boy_advance
        "Game Boy Color" -> R.drawable.ic_game_boy_color
        "Game Boy" -> R.drawable.ic_game_boy
        "Wii U" -> R.drawable.ic_wii_u
        "Wii" -> R.drawable.ic_wii
        "Xbox One" -> R.drawable.ic_xbox_one
        "Xbox" -> R.drawable.ic_xbox
        "Xbox 360" -> R.drawable.ic_xbox_360
        "Xbox Series S/X" -> R.drawable.ic_xbox_series
        "PlayStation 5" -> R.drawable.ic_ps5
        "PlayStation 4" -> R.drawable.ic_ps4
        "PlayStation 3" -> R.drawable.ic_ps3
        "PlayStation 2" -> R.drawable.ic_ps2
        "PlayStation" -> R.drawable.ic_ps
        "PS Vita" -> R.drawable.ic_ps_vita
        "PSP" -> R.drawable.ic_psp
        "Nintendo Switch" -> R.drawable.ic_nintendo
        "Nintendo 3DS" -> R.drawable.ic_nintendo_3ds
        "Nintendo DS" -> R.drawable.ic_nintendo_ds
        "Nintendo DSi" -> R.drawable.ic_nintendo_ds
        "Nintendo 64" -> R.drawable.ic_nintendo_64
        "SNES" -> R.drawable.ic_snes
        "NES" -> R.drawable.ic_nes
        else -> R.drawable.ic_loading
    }
}