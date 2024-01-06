package dev.ibrahims.sdwebuiapi.payload.script

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive

@Serializable(with = ScriptSerializer::class)
sealed class ScriptPayload {

    @Serializable
    data class Single(
        @SerialName("args") val args: ScriptArgs,
    ) : ScriptPayload()

    @Serializable
    data class Multiple(
        @SerialName("args") val args: List<ScriptArgs>,
    ) : ScriptPayload()

    @Serializable
    data class Array(
        @SerialName("args") val args: List<JsonPrimitive>,
    ) : ScriptPayload()
}

@Serializable(with = ScriptArgsSerializer::class)
sealed interface ScriptArgs

object ScriptSerializer : JsonContentPolymorphicSerializer<ScriptPayload>(ScriptPayload::class) {

    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<ScriptPayload> {
        return when (element::class) {
            ScriptPayload.Single::class -> ScriptPayload.Single.serializer()
            ScriptPayload.Multiple::class -> ScriptPayload.Multiple.serializer()
            ScriptPayload.Array::class -> ScriptPayload.Array.serializer()
            else -> throw Exception("ERROR: No Serializer found. Serialization failed.")
        }
    }
}

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
