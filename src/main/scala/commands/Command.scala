package commands

import filesystem.State
import main.scala.commands.Mkdir

trait Command {

  def apply(state: State): State
}

object Command {

  def emptyCommand: Command = new Command {
    override def apply(state: State): State = state
  }
  def incompleteCommand(name: String): Command = new Command {
    override def apply(state: State): State = {
      state.setMessage(name + ": incomplete command!")
    }
  }

  val MKDIR = "mkdir"

  def From(input: String): Command = {
    val tokens: Array[String]= input.split(" ")

    if (input.isEmpty || tokens.isEmpty) emptyCommand
    else if  (MKDIR.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(MKDIR)
      else  new Mkdir(tokens(1))
    }
    else new UnknownCommand
  }
}