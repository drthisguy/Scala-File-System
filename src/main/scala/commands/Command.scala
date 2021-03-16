package commands

import filesystem.State
import main.scala.commands.{Cat, Cd, Echo, Ls, Mkdir, Pwd, Rm, Touch}

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
  val RM = "rm"
  val ECHO = "echo"
  val CAT = "cat"

  def From(input: String): Command = {
    val tokens: Array[String]= input.split(" ")

    if (input.isEmpty || tokens.isEmpty) emptyCommand
    else tokens(0) match {
      case MKDIR =>
        if (tokens.length < 2) incompleteCommand(MKDIR)
        else  new Mkdir(tokens(1))
      case LS => new Ls
      case PWD

    }
    if  (MKDIR.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(MKDIR)
      else  new Mkdir(tokens(1))
    } else if (LS.equals(tokens(0))) {
      new Ls
    } else if (PWD.equals(tokens(0))) {
      new Pwd
    } else if (TOUCH.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(TOUCH)
      new Touch(tokens(1))
    } else if (CD.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(CD)
      else new Cd(tokens(1))
    } else if (RM.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(RM)
      else new Rm(tokens(1))
    } else if (ECHO.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(ECHO)
      else new Echo(tokens.tail)
    } else if (CAT.equals(tokens(0)))
      if (tokens.length < 2) incompleteCommand(CAT)
        else new Cat(tokens(1))
    else new UnknownCommand
  }
}