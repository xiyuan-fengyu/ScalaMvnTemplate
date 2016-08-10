package com.xiyuan.template.util

/**
  * Created by xiyuan_fengyu on 2016/7/20.
  */
object RootPathUtil {

  private val fileTag = "file:"

  val isExcuteInJar: Boolean = {
    val path = this.getClass.getResource(this.getClass.getSimpleName + ".class").getPath
    if (path.startsWith(fileTag)) true
    else false
  }


  private val classPath = "/" + this.getClass.getPackage.getName.replaceAll("\\.", "/") + "/" + this.getClass.getSimpleName + ".class"

  val rootPath: String = {
    val path = this.getClass.getResource(this.getClass.getSimpleName + ".class").getPath
    if (path.startsWith(fileTag)) {
      val jarPath = path.substring(fileTag.length, path.indexOf(classPath))
      jarPath.substring(0, jarPath.lastIndexOf("/"))
    }
    else path.substring(0, path.indexOf(classPath))
  }

}
