package main.scala.commands

import commands.Command
import files.{DirEntry, Directory}
import filesystem.State

class Mkdir(name: String) extends Command {

  override def apply(state: State): State = {
    val wd = state.wd
    if (wd.hasEntry(name)){
      state.setMessage("Entry " + name + " already exists!")
    } else if (name.contains(Directory.SEPARATOR)) {
      state.setMessage(name + " must not contain separators!")
    } else if (checkIllegal(name))
      state.setMessage(name + ": illegal entry name!")
    else {
      doMkdir(state, name)
  }
  }

  def checkIllegal(name: String): Boolean = {
    name.contains(".")
  }

  def doMkdir(state: State, name: String): State = {
    def updateStructure(currentDirectory: Directory, path: List[String], newEntry: DirEntry): Directory = {
      if (path.isEmpty) currentDirectory.addEntry(newEntry)
      else {
        val oldEntry = currentDirectory.findEntry(path.head).asDirectory
        currentDirectory.replaceEntry(oldEntry.name, updateStructure(oldEntry, path.tail, newEntry))
      }
    }

    val wd = state.wd

    // all dir in the full path.
    val allDirsInPath = wd.getAllFoldersInPath

    // create a new directory entry in wd.
    val newDir = Directory.empty(wd.path, name)

    // update the whole dir structure starting from the root.
    val newRoot = updateStructure(state.root, allDirsInPath, newDir)

    // get new working dir instance given wd's full path in the new dir structure (immutable).
    val newWd = newRoot.findDescendant(allDirsInPath)

    State(newRoot, newWd)
  }
}
