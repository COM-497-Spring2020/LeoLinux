# *Leo Linux* Programs
Included in this directory are programs, features, and tools that were created or edited by our team in the development of *Leo Linux*.
Some of the programs created/edited include:

| # | Name |
| ---| --- |
| 1 | Project_v5_EXE.java |
| 2 | Project_v5_EXE_Compilation_Version.java |
| 3 | Bracket-Checker-5.7.jar |
| 4 | xfce-applications.menu |


## Project_v5_EXE.java
This program is one that was originally created by *Chase S. Franse* as the final project of the COM 301 (*Algorithms & Data Structures*) course at Saint Leo University. I realized the potential of this program while writing it, and decided that if I could make it an executable file that does not allow other to view the source code, it could be extremely useful as a part of *Leo Linux*.   *See __Bracket-Checker-5.7.jar__ and/or __Project_v5_EXE_Compilation_Version.java__ for more information.*

## Project_v5_EXE_Compilation_Version.java
This JAVA program is nearly an identical copy of the previous **Project_v5_EXE.java** file. The only difference is one line that I needed while compiling the program into an executable. I used *Maven* inside a *Manjaro Linux* machine to compile. One vital part of that is to include a ```package``` line of code at the beginning of whatever .JAVA file that is being compiled. The following snippet of code can be found on line ___4___ of the file "*Project_v5_EXE_Compilation_Version.java*".

```
package Bracket_Checker.Project_v5_EXE.src.main.java.com.chaseFranse.app;
```

## Bracket-Checker-5.7.jar
Unlike the previous .JAVA files, this is the compiled version of the "*Project_v5_EXE_Compilation_Version.java*" file. This .JAR file is both executable, and has completely hidden source code; this means that it can safely be used in a Linux distribution meant for students (even Saint Leo University students) without providing said students any answers to the final project of the COM 301 course. This executable file is included in the current version of *Leo Linux* under the name ``Bracket Checker v5.7``.

## xfce-applications.menu
This file is unlike any of the previous ones. This is the modified ``.menu`` file from the *Linux Mint* based Xfce GUI our team has been modifiying to create *Leo Linux* verion 1.2. This file will continue to change and get larger as more programs, features, and tools are created and imported into newer versions of *Leo Linux*.
