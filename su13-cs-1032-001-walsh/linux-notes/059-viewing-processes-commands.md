---
layout: page
title:  Viewing Processes Commands
---

Use the following commands to view processes:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Example</b></td>

</tr>

<tr> <td><b>top</b></td> <td>View an interactive listing of processes
organized by processor time. <b>top</b>:

<ul>

<li>Displays a list of processes is in real-time.

</li>

<li>Returns Process ID (PID), uptime, load, CPU status, memory, and priority
information for processes.

</li>

<li>Lists the most CPU-intensive processes at the top of the output by
default.

</li>

<li>Is useful when monitoring processes.

</li>

</ul>

When using top, be aware of the following options:

<ul>

<li>Press <b>h</b> to display the help screen.

</li>

<li>Press <b>f</b> to add or remove columns from the chart.

</li>

<li>Press <b>F</b> to show a list of sortable columns, then press the key of
the letter next to the column to be sorted.

</li>

<li>Press <b>u</b> to specify processes for a specific user.

</li>

</ul> </td> <td><b>top -u gshant </b>starts top by monitoring only the
<i>gshant</i> user.</td>

</tr>

<tr> <td><b>ps</b></td> <td>Show the processes associated with the current
user and terminal (in ascending order based on the process ID). By default,
the <b>ps</b> command displays the following information:

<ul>

<li>Process ID (PID)

</li>

<li>Name of the shell session on which the process is running (TTY)

</li>

<li>CPU time the process has used (TIME)

</li>

<li>The command used to invoke the process (CMD)

</li>

</ul>

Be aware of the following <b>ps</b> options:

<ul>

<li><b>-A, e </b>shows all processes.

</li>

<li><b>-a </b>shows processes owned by other users and attached to a terminal
(i.e., foreground processes).

</li>

<li><b>-f </b>shows all possible detail for processes.

</li>

<li><b>-u </b>shows processes by user ID.

</li>

<li><b>-l </b>shows the processes in long format, and the <i>process state</i>
(under the STAT column). The process states include:

<ul>

<li>sleeping (S)

</li>

<li>running (r)

</li>

<li>traced (t) by another process

</li>

<li>zombie (Z)

</li>

</ul>

</li>

<li><b>-x </b>shows processes that are not attached to a controlling terminal.
Use this option to view daemon processes that begin during system boot.

</li>

</ul> </td> <td><b>ps -Au jsmith</b> shows all processes owned by the user
jsmith.  
<b>ps elf</b> shows all processes in long format.  
<b>ps aux</b> shows all processes including zombie processes.</td>

</tr> </table>

