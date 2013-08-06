---
layout: page
title:  Shell Commands Introduction
---

The Linux shell is the command line interface (CLI) or text user interface
(TUI) that administrators use to control a Linux computer. While many Linux
distributions offer a Graphical User Interface (GUI) that can perform the same
tasks, the Linux+ exam tests only for command line tasks.

Keep in mind the following tips for working in the shell:

  * The tilde symbol (**~**) in the prompt indicates the present working directory is the home directory of the current user.
  * The_ command path_ is the set of directories in which Linux searches to find executable files for the commands typed into the shell prompt: 

    * The path does not include the present working directory.
    * To see the path, type **echo $PATH**.
    * To add a directory to a path, type **PATH=$PATH**:_directory_path_.
  * To execute programs: 

    * Type the executable name in the present working directory if the program is in the command path. 
    * Type ./_filename_ to run an executable in the present working directory. (./ indicates the present working directory.)
    * Type the full pathname to the file to run an executable from anywhere. 
  * File names and paths are case-sensitive.
  * Type the beginning of the name, then press Tab to complete a file, command, or directory name. (Press Tab twice if there is more than one possible file, command, or directory name.) 
  * Press the up arrow at the command prompt to print the last command. Press it again to scroll through all previous commands.

The following table describes several common commands used from the shell.

<table>

<tr> <td>Use...</td> <td>To...</td>

</tr>

<tr> <td><b>pwd</b></td> <td>Show the present working directory.</td>

</tr>

<tr> <td><b>whoami</b></td> <td>Display the current username.</td>

</tr>

<tr> <td><b>uname</b></td> <td>Print system information. Be aware of the
following <b>uname </b> options:

<ul>

<li><b>-a </b>prints all system information.

</li>

<li><b>-o</b> prints the operating system.

</li>

<li><b>-p</b> prints the processor's architecture type.

</li>

</ul> </td>

</tr>

<tr> <td><b>su</b></td> <td>Switch users in the shell prompt. Be aware of the
following <b>su </b> options:

<ul>

<li><b>su -l </b><i>user_name </i>switches to the specified user in a login
shell.

</li>

<li><b>su </b><i>user_name </i>(without the dash, but with the username)
switches to the user.

</li>

<li><b>su -</b> <i>user_name </i>(with the dash and username) switches to the
user and loads the user's environmental variables.

</li>

<li><b>su - </b>(with the dash, but no username) switches to the <i>root</i>
user and loads the <i>root</i> user's environmental variables.

<ul>

<li>The root user account is the Linux system <i>superuser</i>.

</li>

<li>The root user can perform any task; some utilities do not work if the
administrator is not logged in as the root user.

</li>

</ul>

</li>

<li><b>su </b>(no dash or username) switches to the <i>root</i> user and but
<i>does not</i> load the root user's environmental variables.

</li>

</ul>

Linux uses different prompt symbols to indicate the current user:

<ul>

<li><b>#</b> indicates the current user is the root user.

</li>

<li><b>$</b> indicates the current user is a normal user.

</li>

</ul>

<b>Note</b>: <b>su</b> requires the password of the user except when switching
from root to a normal user.

</td>

</tr>

<tr> <td><b>exit</b></td> <td>To exit the login shell or back to the original
user after using the <b>su </b>command.</td>

</tr>

<tr> <td><b>exec</b></td> <td>Execute an executable and to replace the shell
with the new process created by the executable file.</td>

</tr>

<tr> <td><b>cd</b></td> <td>Change directories. For example when the
<b>/usr</b> directory is the current directory:

<ul>

<li><b>cd bin</b> changes to the <b>bin</b> directory in the current
directory.

</li>

<li><b>cd /usr/bin</b> changes to the <b>bin</b> directory from anywhere in
the file system.

</li>

</ul> </td>

</tr>

<tr> <td><b>ls</b></td> <td>Show names of files and directories in the current
directory. The <b>ls</b> command commonly uses the following options:

<ul>

<li><b>-a</b> shows all files and directories, including hidden files.

</li>

<li><b>-l</b> shows information about files including size, permissions,
owner, and modified date.

</li>

<li><b>-d</b> displays only directories.

</li>

<li><b>-s</b> sorts files by size.

</li>

<li><b>-X</b> sorts by extension.

</li>

</ul>

Many distributions have a color scheme for different file types:

<ul>

<li>Directories are blue.

</li>

<li>Text files are white.

</li>

<li>Links are cyan.

</li>

<li>Image files are magenta.

</li>

<li>Compressed files are red.

</li>

</ul> </td>

</tr>

<tr> <td><b>history</b></td> <td>See all commands in the history queue. The<b>
-c</b> option clears the history list.  
<b>Note:</b> History command queues are separate for each user. A command
typed as one user cannot be used after using the <b>su</b> command to switch
to another user.</td>

</tr>

<tr> <td><b>clear</b></td> <td>Clear the shell screen. </td>

</tr>

<tr> <td><b>chsh</b></td> <td>Change the default shell. Be aware of the
<b>chsh</b> options:

<ul>

<li><b>-s</b> changes to a different installed shell. The command prompts for
a password.

</li>

<li><b>-l </b>lists all installed shells.

</li>

</ul> For example, <b>chsh -s /bin/ksh</b> changes the default shell for the
user to the Korn shell if it is installed on the computer.</td>

</tr> </table>

