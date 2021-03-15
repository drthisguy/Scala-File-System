package main.scala.commands

import commands.Command
import files.{DirEntry, Directory}
import filesystem.State

import scala.annotation.tailrec

class Cd(dir: String) extends Command {

  override def apply(state: State): State = {

    // find root.
    val root = state.root
    val wd = state.wd

    // find absolute path of dir to cd to.
    val absolutePath =
      if (dir.startsWith(Directory.SEPARATOR)) dir
      else if (wd.isRoot) wd.path +  dir
    else  wd.path + Directory.SEPARATOR + dir

    // find the dir given the path.
    val destinationDirectory = doFindEntry(root, absolutePath)

    // change the state given new dir.
    if (destinationDirectory == null || !destinationDirectory.isDirectory)
      state.setMessage(dir + ": no such directory")
    else
      State(root, destinationDirectory.asDirectory)
  }

  def doFindEntry(root: Directory, path: String): DirEntry = {
    @tailrec
    def findEntryHelper(currentDirectory: Directory, path: List[String]): DirEntry = {
      if (path.isEmpty || path.head.isEmpty) currentDirectory
      else if (path.tail.isEmpty) currentDirectory.findEntry(path.head)
      else {
        val nextDir = currentDirectory.findEntry(path.head)
        if (nextDir == null || !nextDir.isDirectory) null
        else findEntryHelper(nextDir.asDirectory, path.tail)
      }
    }
    // tokens
    val tokens: List[String] = path.substring(1).split(Directory.SEPARATOR).toList

    //navigate to correct entry
    findEntryHelper(root, tokens)
  }
}
