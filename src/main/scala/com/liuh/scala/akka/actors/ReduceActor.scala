package com.liuh.scala.akka.actors

import java.util.{ArrayList,HashMap}

import akka.actor.{Actor, ActorRef}
import com.liuh.scala.akka.messages.{ReduceData, Word, MapData}

/**
  * Created by liuh on 2016/2/28.
  */
class ReduceActor(aggregateActor: ActorRef) extends  Actor{


  override def receive: Receive = {
    case message : MapData =>
      aggregateActor ! reduce(message.dataList)
    case _ =>
  }

  def reduce(dataList : ArrayList[Word]) : ReduceData = {
    var reducedMap = new HashMap[String,Integer]
    /*for(wc:Word <- dataList){
      var word : String = wc.word
      if(reducedMap.containsKey(word)){
        reducedMap.put(word,reducedMap.get(word)+1)
      }else{
        reducedMap.put(word,1)
      }
    }*/
    return new ReduceData(reducedMap)
  }

}
