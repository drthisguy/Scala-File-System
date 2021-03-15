package main.scala.commands
import files.DirEntry
import filesystem.State
import main.scala.files.File

class Touch(name: String) extends CreateEntry(name) {

  override def createSpecificEntry(state: State): DirEntry =
    File.empty(state.wd.path, name)
}
