package com.kreggscode.aristotlequotes.data

import com.google.gson.annotations.SerializedName
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.concurrent.TimeUnit
import com.kreggscode.aristotlequotes.BuildConfig

// Request/Response models for Pollinations AI
data class PollinationsMessage(
    val role: String,
    val content: String
)

data class PollinationsRequest(
    val model: String = "openai",
    val messages: List<PollinationsMessage>,
    val temperature: Double = 1.0,
    val stream: Boolean = false,
    @SerializedName("private")
    val isPrivate: Boolean = false
)

data class PollinationsChoice(
    val message: PollinationsMessage,
    val index: Int,
    @SerializedName("finish_reason")
    val finishReason: String?
)

data class PollinationsResponse(
    val id: String?,
    val choices: List<PollinationsChoice>,
    val created: Long?,
    val model: String?
)

// Retrofit API interface
interface PollinationsApiService {
    @Headers("Content-Type: application/json")
    @POST("openai")
    suspend fun chat(@Body request: PollinationsRequest): PollinationsResponse
    
    companion object {
        private const val BASE_URL = "https://text.pollinations.ai/"
        
        fun create(): PollinationsApiService {
            val clientBuilder = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
            
            // Only add logging in debug builds
            if (BuildConfig.DEBUG) {
                val loggingInterceptor = HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
                clientBuilder.addInterceptor(loggingInterceptor)
            }
            
            val client = clientBuilder.build()
            
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            
            return retrofit.create(PollinationsApiService::class.java)
        }
    }
}
