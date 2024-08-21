object Dependencies {

    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hiltCompiler}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-compiler:${Versions.hiltCompiler}" }

}
object Modules{
    const val untilities = ":untilities"
}