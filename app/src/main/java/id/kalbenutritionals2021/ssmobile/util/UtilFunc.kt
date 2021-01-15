package id.kalbenutritionals2021.ssmobile.util

import android.annotation.SuppressLint
import com.google.gson.*
import retrofit2.Retrofit
import java.lang.reflect.Type
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun gsonWithDate(): Gson? {

    val builder = GsonBuilder()
    builder.registerTypeAdapter(Date::class.java, object : JsonDeserializer<Date?> {
        val df: DateFormat = SimpleDateFormat(Constants.ConfigTag.dateFormat3)

        @Throws(JsonParseException::class)
        override fun deserialize(
                json: JsonElement,
                typeOfT: Type?,
                context: JsonDeserializationContext?
        ): Date? {
            return try {
                df.parse(json.asString)
            } catch (e: ParseException) {
                e.printStackTrace()
                null
            }
        }
    })

    builder.registerTypeAdapter(Date::class.java, object : JsonSerializer<Date?> {
        val df: DateFormat = SimpleDateFormat(Constants.ConfigTag.dateFormat3)

        @Throws(JsonParseException::class)
        override fun serialize(
                src: Date?,
                typeOfSrc: Type?,
                context: JsonSerializationContext?
        ): JsonElement {
            return try {
                if (src == null)
                    return JsonPrimitive(df.format(Date()))
                val formatted = df.format(src)
                JsonPrimitive(formatted)
            } catch (e: ParseException) {
                e.printStackTrace()
                JsonPrimitive(getDateNow())
            }
        }
    })
    return builder.create()
}

@SuppressLint("SimpleDateFormat")
fun getDateNow(): String {
    val sdf = SimpleDateFormat(Constants.ConfigTag.dateFormat3)
    return sdf.format(Date())
}

inline fun <reified T> createApiService(retrofit: Retrofit): T = retrofit.create(T::class.java)
