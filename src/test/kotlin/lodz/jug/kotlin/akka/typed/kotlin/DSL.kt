package lodz.jug.kotlin.akka.typed.kotlin

import akka.typed.ActorRef
import akka.typed.javadsl.Adapter

infix fun <T> ActorRef<T>.send(cmd:T) = this.tell(cmd)


//Untyped Extension
fun <T> ActorRef<T>.toUntyped(): akka.actor.ActorRef = Adapter.toUntyped(this)

fun <T> akka.typed.javadsl.ActorContext<T>.actorOf(props:akka.actor.Props,name:String) =
        Adapter.actorOf(this,props,name)

fun <T> akka.typed.javadsl.ActorContext<T>.watchUntyped(ref:akka.actor.ActorRef) =
        Adapter.watch<Nothing>(this,ref)

fun <T> akka.typed.javadsl.ActorContext<T>.stopUntyped(ref:akka.actor.ActorRef) =
        Adapter.stop(this,ref)