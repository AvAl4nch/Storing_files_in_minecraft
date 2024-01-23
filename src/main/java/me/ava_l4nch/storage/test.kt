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
        Files.write(path, data)
        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}

fun main() {
    val filePath = "C:\\Users\\laith\\Desktop\\notes.md" // Replace with the actual path to your file
    val fileBytes = readFileAsBytes(filePath)
    println("size= $fileBytes.size")

    if (fileBytes != null) {
        // Use the fileBytes array as needed
        var c = 0
        while (true) {

            if (c < (fileBytes?.size ?: 0)) {
                val blockIndex = fileBytes!![c].toString()
                println("$blockIndex")
            }
            else{
                return
            }
            c++
        }
//        println("File Content as Bytes: ${fileBytes.joinToString(", ")}")
//        val outputFilePath = "C:\\Users\\laith\\Desktop\\test1.txt"
//        writeBytesToFile(outputFilePath, fileBytes)
    } else {
        println("Failed to read file as bytes.")
    }
}
