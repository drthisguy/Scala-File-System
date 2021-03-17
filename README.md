# Scala-Filesystem
Linux like command line interface with basic Filesystem operations.
Use this CLI to preform many of the common command line commands. 

- - - -

>## Table of contents
>* [Description](#description)
>* [Screen Grab](#screen)
>* [Tech Used](#tech)
>* [Usage](#usage)
>* [Project Info](#project)
>* [Issues](#known-issues)



## Description
The Scala-File-System is built using scala to make use of its combined functional with object orientated programming design patterns.  It's a fairly complete filesystem management application and it supports the following operations:  

* <em><b>mkdir</b></em> -- Creates folder directories. Is capable of recursively creating multiple sub-directories (i.e. dirA/dirB...).    
* <em><b>touch</b></em> -- Creates new files.  Is currently limited to new files in the working directory.     
* <em><b>cd</b></em> -- Changes the working directory.  Works with both absolute and relative path tokens (i.e. ../a/b/./, etc).      
* <em><b>rm</b></em> -- Removes files and directories.  
* <em><b>echo</b></em> -- Supports basic prints to console. Creates or overwrites new file with content (with >). And appends new lines to existing files (with >>).         
* <em><b>cat</b></em> -- Reads out the file content to the console. Supported only in the working directory.       
* <em><b>ls</b></em> -- Displays the content of the working directory.             
* <em><b>pwd</b></em> -- Prints the path of the current working directory to the console.       


## Screen:
![Screen Shot 2021-03-17 at 12 41 08 PM](https://user-images.githubusercontent.com/48693333/111504625-3d2c1580-871e-11eb-8582-3d54dbe1dc30.png)


## Tech Used and Required
+ Scala and SBT: https://www.scala-lang.org/download/2.12.8.html            
+ JDK (v11): https://jdk.java.net/15/               

## Usage
can be executed as a normal scala program with "scala Filesystem" or with "sbt run" where either REPL is installed.                 

## Project:
[Repo](https://github.com/drthisguy/Scala-Filesystem)    
[My Github](https://github.com/drthisguy)    
*Email*: page.c.tyler@gmail.com       

## Known Issues:
None known at the moment.  
If any are discovered, please feel free to contact me.  Cheers. :smile:
