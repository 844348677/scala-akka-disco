package com.liuh.scala.akka

import akka.actor.{Props, ActorSystem}
import com.liuh.scala.akka.actors.MasterActor
import com.liuh.scala.akka.messages.Result

/**
  * Created by liuh on 2016/2/28.
  */
object MapReduceApplication {

  def main(args: Array[String]) {
    val _system = ActorSystem("HelloAkka")
    val master = _system.actorOf(Props[MasterActor],name="master")

    master ! "hi hi hi"
    master ! "hello hello hello hello"
    master ! "test"

    Thread.sleep(5000)

    master ! new Result

    Thread.sleep(5000)
    _system.shutdown()
  }


}
