---
layout: page
title:  Process Management Commands
---

The following table lists commands you can use to manage and prioritize
processes. When a process:

  * Runs in the _foreground_, the terminal from which they were invoked is unusable (i.e., no other commands can run from the terminal) until the process terminates.
  * Runs in the _background, _the terminal is available for additional commands and utilities.

The following table describes ways to move processes between the foreground
and the background, and adjust process priorities.

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td>Examples</td>

</tr>

<tr> <td><b><i>command</i></b> <b>&</b></td> <td>Start a process in the
background, leaving the shell available for other commands. When running a
process in the background, the shell displays the following information:

<ul>

<li>The job ID in brackets

</li>

<li>The process ID (PID)

</li>

<li>The process name, which is often the name of the command used to start the
process

</li>

</ul> </td> <td><b>gedit &</b> starts the <i>gedit</i> process in the
background.</td>

</tr>

<tr> <td><b>jobs</b></td> <td>View the active jobs and see the job ID number.

<ul>

<li>The job ID number is specific to the terminal session.

</li>

<li>Each open terminal has its own set of jobs and job ID numbers.

</li>

<li>Jobs from one terminal cannot be managed from a second terminal using job
ID numbers.

</li>

</ul> </td> <td>  </td>

</tr>

<tr> <td><b>bg</b></td> <td>Send a job to the background.</td> <td><b>bg 3</b>
sends the job with job ID 3 to the background.</td>

</tr>

<tr> <td><b>fg</b></td> <td>Bring a job to the foreground.</td> <td><b>fg 1
</b>brings the job with job ID 1 to the foreground.</td>

</tr>

<tr> <td>Ctrl+z</td> <td>Pause a current job (i.e., send to the background)
and give it a job ID number.</td> <td> </td>

</tr>

<tr> <td><b>nice</b></td> <td>Start a command with a higher or lower priority.

<ul>

<li>Nice values range from 19 (lowest priority), to -20 (highest priority.)
The higher the number, the lower priority the job receives in the system.

</li>

<li>Use <b>-n</b> to specify the priority value. If no value is specified, the
process starts with -10 as the default.

</li>

<li>Zero (0) is the default nice value for processes <i>not</i> executed with
the <b>nice</b> command.

</li>

</ul> </td> <td><b>nice -n 7 gedit</b> starts <i>gedit</i> with a priority
that is 7 lower than the default.  
<b>nice -n -9 gedit</b> starts <i>gedit</i> with a priority that is 9 higher
than the default.  
<b>nice gedit</b> starts <i>gedit</i> with a priority that is 10 lower than
the default.</td>

</tr>

<tr> <td><b>renice</b></td> <td>Assign a new priority to a process that has
already started using the PID of the process. The command can contain multiple
PIDs separated by a space to give them all the same priority number. The
values are identical to the <b>nice</b> command. Be aware of the following
options:

<ul>

<li><b>-n</b> specifies a priority but is assumed by default.

</li>

<li><b>-u</b> specifies a user.

</li>

<li><b>-g</b> specifies a group.

</li>

</ul>

<b>Note:</b> Only root can change the priority of other users and groups or
raise a process priority above the default.

</td> <td><b>renice -5 3346</b> raises the priority of the process with PID
<i> 3346</i> to 5 above the default.  
<b>renice 7 2266 3902</b> lowers the priority of both processes to 7 below the
default.  
<b>renice 5 -u userbob</b> lowers the priority of all processes owned by
<i>userbob</i> to 5 below the default.</td>

</tr>

<tr> <td><b>nohup &</b></td> <td>Allow a command or shell script to continue
running in the background after logging out from a shell.

<b>Note</b>: <b>nohup</b> does not automatically put the command it runs in
the background; Use the ampersand (&) symbol to start a process in the
background.

</td> <td><b>nohup gedit &</b> starts the <i>gedit</i> process in the
background and leaves it running after logging out of the shell.</td>

</tr> </table>

