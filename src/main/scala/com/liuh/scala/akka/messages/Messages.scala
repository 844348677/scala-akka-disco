package com.liuh.scala.akka.messages

import java.util.{ArrayList,HashMap}

/**
  * Created by liuh on 2016/2/28.
  */

class Word(val word:String , val count:Integer)

case class Result

class MapData(val dataList: ArrayList[Word])

class ReduceData(val reduceDataMap: HashMap[String,Integer])
