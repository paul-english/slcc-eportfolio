---
layout: page
title:  Process Facts
---

A _process_ refers to a program that is running in memory and in the CPU. Be
aware of the following file types which create processes on a Linux system:

<table>

<tr> <td><b>Type</b></td> <td><b>Description</b></td>

</tr>

<tr> <td>Binary executable</td> <td>A <i>binary executable</i> is a program
written in a programming language that is compiled into a binary file that the
CPU can process. </td>

</tr>

<tr> <td>Internal shell commands</td> <td>An<i> internal shell</i> command is
a command which is built into the shell. These might include the <b>cd</b>
command and the <b>echo</b> command.</td>

</tr>

<tr> <td>Shell scripts</td> <td>A <i>script</i> is a command or commands
stored in a text file. When the shell reads the file, it executes the commands
as if they were entered through the keyboard.</td>

</tr> </table>

Be aware of the following types of processes:

<table>

<tr> <td><b>Type</b></td> <td><b>Description</b></td>

</tr>

<tr> <td>User </td> <td><i>User</i> processes start when a user executes a
program file. For example, a user executes the <b>grep</b> command starts a
user process.</td>

</tr>

<tr> <td>Daemon </td> <td><i>Daemon</i> processes (also known as <i>system
</i>processes) are started by the operating system usually when it boots, but
users can start daemon processes as well. Most daemons provide system
services. </td>

</tr> </table>

Processes are all given unique process ID numbers randomly from the list of
available numbers. Linux uses the following process identifiers:

<table>

<tr> <td><b>Type</b></td> <td><b>Description</b></td>

</tr>

<tr> <td>Process ID (PID)</td> <td>The process ID (PID) uniquely identifies
each process. System-started processes typically have low numbers, while user-
started processes have higher numbers. </td>

</tr>

<tr> <td>Parent Process ID (PPID)</td> <td>The parent process ID (PPID)
identifies the process that spawned (or started) the process. The process that
spawned the new process is known as the <i>parent</i> process; whereas the
spawned process is known as the <i>child</i> process.</td>

</tr> </table>

Be aware of the following when working with processes:

  * Init is the first process started by the kernel. Init:
    * Has a process ID of 1.
    * Spawns all additional processes the operating system needs at boot time.
    * Is responsible for spawning additional processes including the login shell. 
  * _Forking_ occurs when a parent process spawns a child process that is identical to the parent. An example of forking is the subshell that the shell creates when a user runs the VI editor. 
  * When a user stops a process, all child processes stop as well unless the user specifies that the child processes remain running. The child processes becomes children of init. 
  * A _zombie _process is an orphaned process (a process without a parent). Zombie processes:
    * Typically appear when the parent process fails to kill its child processes properly. 
    * Can linger in the system, consuming resources and PIDs.
  * Core processes always have the lowest PID numbers and are below 100.
  * A _job_ is another name for a running process. Processes are often referred to as jobs when dealing with job control commands, such as Ctrl+z which pauses a job.
  * A single-threaded CPU can run only one process at a time.

