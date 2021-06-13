package woowa

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import java.lang.StringBuilder

fun main() {
    MatcherAssert.assertThat(
        solution(
            """my.song.mp3 11b
greatSong.flac 1000b
not3.txt 5b
video.mp4 200b
game.exe 100b
mov!e.mkv 10000b"""
        ), Matchers.`is`(
            """music 1011b
images 0b
movies 10200b
other 105b"""
        )
    )

    MatcherAssert.assertThat(
        solution(
            """my.song.mp3 11b
greatSong.flac 1000b"""
        ), Matchers.`is`(
            """music 1011b
images 0b
movies 0b
other 0b"""
        )
    )

    MatcherAssert.assertThat(
        solution(
            """my.song.jpg 11b"""
        ), Matchers.`is`(
            """music 0b
images 11b
movies 0b
other 0b"""
        )
    )
}

private const val music = "music"
private const val images = "images"
private const val movies = "movies"
private const val other = "other"

private fun solution(S: String): String {
    val map = HashMap<String, Long>()

    S.lines().forEach { line ->
        val (fileName, byteStr) = line.split(" ")
        val fileExt = fileName.split(".").last()
        val byte = byteStr.substring(0, byteStr.length - 1).toLong()

        val type = getType(fileExt)
        map[type] = map.getOrDefault(type, 0) + byte
    }

    val printOrder = arrayOf(music, images, movies, other)
    val sb = StringBuilder()
    for ((i, type) in printOrder.withIndex()) {
        if (i != 0) {
            sb.append("\n")
        }
        sb.append(type).append(" ").append(map[type] ?: 0).append("b")
    }

    return sb.toString()
}

private fun getType(fileExt: String): String {
    return when (fileExt) {
        in "mp3", "aac", "flac" -> music
        in "jpg", "bmp", "gif" -> images
        in "mp4", "avi", "mkv" -> movies
        else -> other
    }
}
