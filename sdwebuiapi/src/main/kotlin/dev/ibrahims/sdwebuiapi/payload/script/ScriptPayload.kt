package dev.ibrahims.sdwebuiapi.payload.script

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement

@Serializable
data class ScriptPayload(
    @SerialName("args") val args: List<ScriptArgs>,
)

@Serializable(with = ScriptArgsSerializer::class)
sealed interface ScriptArgs

object ScriptArgsSerializer : JsonContentPolymorphicSerializer<ScriptArgs>(ScriptArgs::class) {

    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<ScriptArgs> {
        return when (element::class) {
            ControlNetScriptArgs::class -> ControlNetScriptArgs.serializer()
            ADetailerScriptArgs::class -> ADetailerScriptArgs.serializer()
            ReActorScriptArgs::class -> ReActorScriptArgs.serializer()
            else -> throw Exception("ERROR: No Serializer found. Serialization failed.")
        }
    }
}
