package me.ava_l4nch.storage

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

fun readFileAsBytes(filePath: String): ByteArray? {
    val path: Path = Paths.get(filePath)
    return try {
        Files.readAllBytes(path)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

fun writeBytesToFile(filePath: String, data: ByteArray): Boolean {
    val path: Path = Paths.get(filePath)
    return try {
        Files.write(path, data.map { it.toByte() }.toByteArray())
        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}
