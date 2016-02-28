package com.liuh.scala.akka.actors

import akka.actor.{Props, ActorRef, Actor}
import com.liuh.scala.akka.messages.Result

/**
  * Created by liuh on 2016/2/28.
  */
class MasterActor extends Actor{

  val aggregateActor : ActorRef = context.actorOf(Props[AggregateActor],name="aggregate")
  val reduceActor : ActorRef = context.actorOf(Props(new ReduceActor(aggregateActor)),name="reduce")
  val mapActor : ActorRef = context.actorOf(Props(new MapActor(reduceActor)),name="map")

  override  def receive: Receive = {
    case message : String =>
      mapActor ! message
    case message : Result =>
      aggregateActor ! message
    case  _ =>
  }
}
