package commands

import filesystem.State
import main.scala.commands.{Cd, Ls, Mkdir, Pwd, Touch}

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
  val LS = "ls"
  val PWD = "pwd"
  val TOUCH = "touch"
  val CD = "cd"

  def From(input: String): Command = {
    val tokens: Array[String]= input.split(" ")

    if (input.isEmpty || tokens.isEmpty) emptyCommand
    else if  (MKDIR.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(MKDIR)
      else  new Mkdir(tokens(1))
    } else if (LS.equals(tokens(0))) {
      new Ls
    } else if (PWD.equals(tokens(0))) {
      new Pwd
    } else if (TOUCH.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(MKDIR)
      new Touch(tokens(1))
    } else if (CD.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(MKDIR)
      else new Cd(tokens(1))
    }
    else new UnknownCommand
  }
}