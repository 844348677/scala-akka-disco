package com.liuh.scala.akka.actors

import java.util
import java.util.StringTokenizer

import akka.actor.{Actor, ActorRef}
import com.liuh.scala.akka.messages.{Word, MapData}

/**
  * Created by liuh on 2016/2/28.
  */
class MapActor(reduceActor: ActorRef) extends Actor {
  val STOP_WORD_LIST = List("a","is")

  override def receive: Receive = {
    case message : String =>
      reduceActor ! evaluateExpression(message)
    case _ =>
  }
  def evaluateExpression(line : String) : MapData = {
    var dataList = new util.ArrayList[Word]
    var parser : StringTokenizer = new StringTokenizer(line)
    var defaultCount : Integer = 1
    while(parser.hasMoreTokens()){
      var word : String = parser.nextToken().toLowerCase()
        if(!STOP_WORD_LIST.contains(word)){
          dataList.add(new Word(word,defaultCount))
        }
      print(word)
    }
    return new MapData(dataList)
  }
}
