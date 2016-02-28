package com.liuh.scala.akka.actors

import java.util

import akka.actor.Actor
import com.liuh.scala.akka.messages.{Result, ReduceData}

/**
  * Created by liuh on 2016/2/28.
  */
class AggregateActor extends Actor {

  var finalReducedMap = new util.HashMap[String,Integer]

  override  def receive: Receive = {
    case message : ReduceData =>
      aggregateInMemoryReduce(message.reduceDataMap)
    case message : Result =>
      print(finalReducedMap.toString)
  }

  def aggregateInMemoryReduce(reduceList : util.HashMap[String,Integer]): Unit ={
    var count : Integer = 0
    /*for(key <- reduceList.keySet){
      if(finalReducedMap.containsKey(key)){
        count = reduceList.get(key)
        count += finalReducedMap.get(key)
        finalReducedMap.put(key,count)
      }else{
        finalReducedMap.put(key,reduceList.get(key))
      }
    }*/
  }
}
