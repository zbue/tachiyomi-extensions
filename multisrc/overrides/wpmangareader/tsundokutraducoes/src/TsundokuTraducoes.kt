package eu.kanade.tachiyomi.extension.pt.tsundokutraducoes

import eu.kanade.tachiyomi.multisrc.wpmangareader.WPMangaReader
import eu.kanade.tachiyomi.network.interceptor.rateLimit
import okhttp3.OkHttpClient
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.TimeUnit

class TsundokuTraducoes : WPMangaReader(
    "Tsundoku Traduções",
    "https://tsundoku.com.br",
    "pt-BR",
    dateFormat = SimpleDateFormat("MMMMM d, yyyy", Locale("pt", "BR"))
) {

    override val client: OkHttpClient = network.cloudflareClient.newBuilder()
        .rateLimit(1, 2, TimeUnit.SECONDS)
        .build()

    override val altName = "Nome alternativo: "

    override fun searchMangaSelector() = ".utao .uta .imgu, .listupd .bs .bsx:not(:has(span.novelabel)), .listo .bs .bsx:not(:has(span.novelabel))"
}
