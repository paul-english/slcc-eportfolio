---
layout: page
title:  Environment Variable Facts
---

An _environment variable_ is a setting that the operating system or programs
working in the operating system access. Environment variables make up the user
environment.  Be aware of the following details:

  * The standard for writing variables names (called _variable identifiers_) is to use upper case (e.g., SHELL and EUID)
  * Changing environmental variables from the defaults result in _ user-defined_ variables.
  * A_ _user-defined variable applies only to the current session; export the user-defined variables so they apply to child sessions.
  * Add user-defined variables to the shell configuration files to make them persistent.

The table below lists common environment variables:

<table>

<tr> <td>Variable</td> <td>Description</td>

</tr>

<tr> <td>BASH</td> <td>The location of the bash executable file</td>

</tr>

<tr> <td>SHELL</td> <td>The user's login shell.</td>

</tr>

<tr> <td>CPU</td> <td>The type of CPU.</td>

</tr>

<tr> <td>DISPLAY</td> <td>Location where X Windows output goes.</td>

</tr>

<tr> <td>ENV</td> <td>The location of the configuration file for the current
shell.</td>

</tr>

<tr> <td>EUID</td> <td>The ID number of the current user.</td>

</tr>

<tr> <td>HISTFILE</td> <td>The filename where past commands are stored.</td>

</tr>

<tr> <td>HISTSIZE</td> <td>The number of past commands that HISTFILE stores
for the current session.</td>

</tr>

<tr> <td>HISTFILESIZE</td> <td>The number of past commands that HISTFILE
stores for the multiple sessions.</td>

</tr>

<tr> <td>HOME</td> <td>The absolute path of the user's home directory.</td>

</tr>

<tr> <td>HOST</td> <td>The name of the computer.</td>

</tr>

<tr> <td>HOSTNAME</td> <td>HOSTNAME is identical to HOST, but used on certain
distributions.</td>

</tr>

<tr> <td>INFODIR</td> <td>The path to the computer's information pages.</td>

</tr>

<tr> <td>LOGNAME</td> <td>The user name of the current user.</td>

</tr>

<tr> <td>MAIL</td> <td>The path to the current user's mailbox file.</td>

</tr>

<tr> <td>MANPATH</td> <td>The path to the computer's man pages.</td>

</tr>

<tr> <td>OLDPWD</td> <td>The path of the directory the user was in prior to
the current path. </td>

</tr>

<tr> <td>OSTYPE</td> <td>The type of operating system. Usually this is
Linux.</td>

</tr>

<tr> <td>PATH</td> <td>The directory prefixes used to search for programs and
files.

<ul>

<li>Use a colon to separate entries in the PATH variable.

</li>

<li>Do not include a period (.) in the PATH variable. A period indicates that
the working directory is in the path, and this poses a security risk.

</li>

</ul> </td>

</tr>

<tr> <td>PS1</td> <td>The characters the shell uses to indicate normal user
($), root user (#) and similar items.</td>

</tr>

<tr> <td>PWD</td> <td>The path of the current working directory.</td>

</tr>

<tr> <td>LANG</td> <td>The language the operating system uses.</td>

</tr>

<tr> <td>PAGER</td> <td>Used by the <b>man</b> command to specify the program
in which to display man pages.</td>

</tr> </table>

The table below lists the most common environment variable commands:

<table>

<tr> <td>Use...</td> <td>To...</td> <td>Examples</td>

</tr>

<tr> <td><b>echo $</b><i>variable</i></td> <td>View the variable's value.</td>
<td><b>echo $SHELL</b> displays the current shell's path.</td>

</tr>

<tr> <td><b>env</b></td> <td>Display the values for environment variables
applied to child sessions.</td> <td> </td>

</tr>

<tr> <td><b>set</b></td> <td>Set shell environment variables. Without options,
set displays the set environment variables for the system.</td> <td> </td>

</tr>

<tr> <td><b>unset</b> <i>variable</i></td> <td>Remove an environment
variable.</td> <td><b>unset HOMEDIR</b> removes the HOMEDIR variable.</td>

</tr>

<tr> <td><b><i>VARIABLE</i>=</b><i>value</i></td> <td>Create a user-defined
environment variable.  
<b>Note:</b> To append information to an environment variable, put the current
variable in the command. For example,
<b>PATH=$PATH:/bin/additionalpath</b>.</td> <td><b>HOMEDIR=/projects</b> gives
the HOMEDIR variable a value of <b>/projects</b>.</td>

</tr>

<tr> <td><b>export</b> <i>variable</i></td> <td>Export a user-defined variable
to make it available to child sessions. </td> <td><b>export HOMEDIR</b> makes
the HOMEDIR user-defined variable available to child sessions.<b>  
PATH=$PATH:/bin/special ; export PATH</b> appends a directory to PATH and
immediately exports the variable.</td>

</tr> </table>

