package dev.ibrahims.sdwebuiapi.payload

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement

@Serializable
data class ScriptPayload(
    @SerialName("args") val args: List<ScriptArgs>,
)

@Serializable(with = SectionSerializer::class)
sealed interface ScriptArgs

object SectionSerializer :
    JsonContentPolymorphicSerializer<ScriptArgs>(
        ScriptArgs::class
    ) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<ScriptArgs> {
        return when (element::class) {
            ControlNetUnitPayload::class -> ControlNetUnitPayload.serializer()
            else -> throw Exception("ERROR: No Serializer found. Serialization failed.")
        }
    }
}