package dev.ibrahims.sdwebuiapi.process

import dev.ibrahims.sdwebuiapi.WebUiApi

interface Process {

    companion object {

        fun WebUiApi.text2Image() = Text2Image.Builder(stableDiffusion)

        fun WebUiApi.image2Image() = Image2Image.Builder(stableDiffusion)
    }
}
