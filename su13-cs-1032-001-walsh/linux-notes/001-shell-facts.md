---
layout: page
title:  Shell Facts
---

The Linux shell is the Command Line Interface (CLI) or Text User Interface
(TUI) that administrators use to control a Linux operating system. Users and
programs use the shell to send commands to the system. A shell might be opened
inside a Graphical User Interface (GUI), or might be the sole method used to
run the computer.

Although most Linux distributions now include a graphical interface, and many
administration tools have been converted to a graphical format, many tasks are
best performed from the command prompt. In addition, while graphical elements
vary between distributions, shell commands are more likely to be consistent
between distributions.

The following table describes many common shell types:

<table>

<tr> <td><b>Shell Type</b></td> <td><b>Description</b></td>

</tr>

<tr> <td>bash</td> <td>The Bourne-again shell (bash) is the standard shell
used in most Linux computers. It uses commands similar to a UNIX shell. Bash
includes features such as:

<ul>

<li>Command completion when pressing the tab key

</li>

<li>Command history

</li>

<li>Improved arithmetic functions

</li>

</ul> </td>

</tr>

<tr> <td>sh</td> <td>The Bourne shell is an earlier version of the Bash shell,
and is similar in many ways. <b>Sh </b>is the original shell created by Steve
Bourne.</td>

</tr>

<tr> <td>ksh</td> <td>The Korn shell was developed by David Korn. Ksh has
scripting features not found in bash.</td>

</tr>

<tr> <td>csh</td> <td>The C-shell uses syntax similar to syntax used in the C
programming language.</td>

</tr>

<tr> <td>tcsh</td> <td>The tcsh shell is an improved version of csh. It offers
command line editing and completion features not available with csh.</td>

</tr> </table>

Despite their differences, all shells share some common characteristics:

  * A Linux system can use multiple shells at the same time. 
  * A list of shells is stored in the **/etc/shells** file. 
  * All shells are interfaces with the kernel, separate and distinct from it. 
  * Shells are run both interactively by end users and automatically by the computer's processes. 
  * Shells can run within one another either interactively when a user starts a second shell from the first shell's command line, or automatically by scripts or programs. 
  * Shells use configuration files to establish their operating environments. 

