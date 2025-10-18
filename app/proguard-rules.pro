# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.

# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Preserve line numbers for debugging stack traces
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# Keep crash reporting information
-keepattributes *Annotation*

# Keep data classes for kotlinx.serialization
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.AnnotationsKt

-keepclassmembers class kotlinx.serialization.json.** {
    *** Companion;
}
-keepclasseswithmembers class kotlinx.serialization.json.** {
    kotlinx.serialization.KSerializer serializer(...);
}

# Keep ALL data classes - CRITICAL for preventing ClassCastException
-keep class com.kreggscode.aristotlequotes.data.** { *; }
-keep class com.kreggscode.aristotlequotes.model.** { *; }
-keep class com.kreggscode.aristotlequotes.ui.screens.WorkItem { *; }
-keep class com.kreggscode.aristotlequotes.ui.screens.WorkCategory { *; }
-keep class com.kreggscode.aristotlequotes.ui.screens.DetailedWork { *; }
-keep class com.kreggscode.aristotlequotes.ui.screens.WorkSection { *; }
-keep class com.kreggscode.aristotlequotes.ui.screens.Equation { *; }

# Keep ViewModels
-keep class com.kreggscode.aristotlequotes.viewmodel.** { *; }

# Keep Compose classes
-keep class androidx.compose.** { *; }
-keepclassmembers class androidx.compose.** { *; }

# Keep Retrofit and OkHttp - CRITICAL for API calls
-dontwarn okhttp3.**
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions
-keepattributes RuntimeVisibleAnnotations
-keepattributes RuntimeInvisibleAnnotations
-keepattributes RuntimeVisibleParameterAnnotations
-keepattributes RuntimeInvisibleParameterAnnotations

# Keep Retrofit interfaces and methods - CRITICAL
-keep interface com.kreggscode.aristotlequotes.data.PollinationsApiService { *; }
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

# Keep Gson - CRITICAL for JSON serialization
-keepattributes Signature
-keep class com.google.gson.** { *; }
-keep class * implements com.google.gson.TypeAdapter
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

# Keep all fields with SerializedName annotation
-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}

# Keep API request/response models - CRITICAL for Pollinations AI
-keep class com.kreggscode.aristotlequotes.data.PollinationsMessage { *; }
-keep class com.kreggscode.aristotlequotes.data.PollinationsRequest { *; }
-keep class com.kreggscode.aristotlequotes.data.PollinationsChoice { *; }
-keep class com.kreggscode.aristotlequotes.data.PollinationsResponse { *; }

# Keep all data classes used for JSON - prevent field name obfuscation
-keep class com.kreggscode.aristotlequotes.data.MajorWork { *; }
-keep class com.kreggscode.aristotlequotes.data.Section { *; }
-keep class com.kreggscode.aristotlequotes.data.EquationDetail { *; }
-keep class com.kreggscode.aristotlequotes.data.Essay { *; }
-keep class com.kreggscode.aristotlequotes.data.KeyPoint { *; }
-keep class com.kreggscode.aristotlequotes.data.Letter { *; }
-keep class com.kreggscode.aristotlequotes.data.Paper { *; }
-keep class com.kreggscode.aristotlequotes.data.WorkItem { *; }
-keep class com.kreggscode.aristotlequotes.data.Prediction { *; }
-keep class com.kreggscode.aristotlequotes.data.SubPaper { *; }

# Keep Kotlin coroutines
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
-keepclassmembers class kotlinx.coroutines.** {
    volatile <fields>;
}

# Keep OkHttp - CRITICAL for network calls
-dontwarn okhttp3.internal.platform.**
-dontwarn org.conscrypt.**
-dontwarn org.bouncycastle.**
-dontwarn org.openjsse.**
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

# Keep OkHttp logging interceptor
-keep class okhttp3.logging.** { *; }

# Keep Parcelable implementations
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

# Keep enums
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Keep Navigation arguments
-keepnames class androidx.navigation.fragment.NavHostFragment
-keep class * extends androidx.navigation.Navigator

# R8 full mode optimization
-allowaccessmodification
-repackageclasses

# Keep source file names and line numbers for better crash reports
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# Keep Kotlin metadata for reflection
-keep class kotlin.Metadata { *; }

# Keep Kotlin coroutines
-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}

# Prevent stripping of generic signatures
-keepattributes Signature,InnerClasses,EnclosingMethod

# Keep Room database classes
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
-dontwarn androidx.room.paging.**

# Keep WorkManager classes
-keep class * extends androidx.work.Worker
-keep class * extends androidx.work.CoroutineWorker
-keepclassmembers class * extends androidx.work.Worker {
    public <init>(android.content.Context,androidx.work.WorkerParameters);
}

# Additional Retrofit rules for production
-keepattributes *Annotation*,Signature,Exception
-keep,allowobfuscation,allowshrinking interface retrofit2.Call
-keep,allowobfuscation,allowshrinking class retrofit2.Response
-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation
