package com.main.platform.workspace.websites.json

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.IOException
import kotlin.reflect.KClass

fun <T : Any>toObject(objectModel:KClass<T>, bufferedReader: BufferedReader): Any{
    val jb = StringBuffer()
    var line: String? = null
    while (bufferedReader.readLine().also { line = it } != null) jb.append(line)
    return Gson().fromJson(jb.toString(), objectModel.java)
}

fun <T : Any>toString(objectModel: Any): String {
    return Gson().toJson(objectModel)
}