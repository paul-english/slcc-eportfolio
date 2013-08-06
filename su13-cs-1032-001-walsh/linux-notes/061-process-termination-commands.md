---
layout: page
title:  Process Termination Commands
---

Use the following commands to terminate running processes:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Example</b></td>

</tr>

<tr> <td><b>kill</b></td> <td>Terminate a process using a process ID (PID)
number and a specific kill signal. Kill signals can be sent using a term or a
numeric value. Options include the following:

<ul>

<li><b>-SIGHUP, -1</b> stops and restarts the process with the same process ID
number. This also causes the process to reload its configuration file.

</li>

<li><b>-SIGINT, -2</b> sends an interrupt signal to the process. This is
identical to using the Ctrl+c key combination.

</li>

<li><b>-SIGKILL, -9</b> invokes a hard kill of the process that may not allow
the process to unhook its resources. This means that RAM and other resources
allocated to the process usually remain allocated to the process.

</li>

<li><b>-SIGTERM, -15</b> stops the process after allowing it to unhook its
resources.  
<b>Note</b>: This is the default signal used if no signal is specified.

</li>

<li><b>-n</b> combines the <b>nice</b> command with the <b>kill</b> command to
elevate the <b>kill</b> command's CPU priority above the process it is
stopping. Use minus (-) symbol to elevate the priority of the <b>kill</b>
command.

</li>

<li><b>-l </b>lists all of the signals that are available for the <b> kill</b>
command.

</li>

</ul></td> <td><b>kill -1 6754 </b>stops and restarts the process.<b>  
kill -9 6754 </b>uses a hard kill to stop the process.  
<b>kill -SIGKILL 6754 </b>invokes a hard kill using the signal term.  
<b>kill 6754 </b>stops the process with process ID 6754 using the <i>
SIGTERM</i> signal<b>.  
kill -n20</b> <b>6754 </b>elevates the <b>kill</b> command's priority and then
invokes a hard kill to stop the process.</td>

</tr>

<tr> <td><b>killall </b></td> <td>Terminate a process using the process name.
This command can also use the signal commands that <b>kill</b> uses.</td>
<td><b>killall atd </b>kills all processes named <i>atd.  
</i><b>killall -9 atd </b>uses a hard kill to stop the <i>atd</i>
process.</td>

</tr>

<tr> <td><b>xkill</b></td> <td>Kill a GUI object. <b>xkill</b> is part of the
xorg-x11-apps package. When run, <b>xkill</b> changes the cursor to an X,
which is then used to click on the application you want to kill.</td> <td>
</td>

</tr> </table>

