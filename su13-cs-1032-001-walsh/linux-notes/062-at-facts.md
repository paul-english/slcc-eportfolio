---
layout: page
title:  At Facts
---

The **at** daemon (atd) schedules tasks to occur at a specific time. **at**:

  * Is started using a script in the** /etc/rc.d/init.d/** or **/etc/init.d/ **script directory.
  * Uses configuration files to specify standard user accounts that can and cannot use the **at **command. 
    * **/etc/at.allow** specifies users who can use the **at** command.
    * **/etc/at.deny** specifies users who cannot use the **at** command.
  * Can read commands from a file or standard input.

Be aware of the follow general steps to use the **at** utility:

  1. Type **at _time_**, then press Enter to access the command prompts.
  2. Type one command per line. Press Enter after each command.
  3. Press Ctrl+D to exit the command prompt.

The table below lists the most common commands for managing tasks with the
**at** command.

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Examples</b></td>

</tr>

<tr> <td><b>at </b><i>time date</i></td> <td>Schedule the command to run at a
specific time and date. Options and syntax include:

<ul>

<li><b>today</b>

</li>

<li><b>tomorrow</b>

</li>

<li><i><b>month #</b></i>

</li>

<li><i><b>MMDDYY</b></i>

</li>

<li><i><b>MM/DD/YY</b></i>

</li>

<li><i><b>DD.MM.YY</b></i>

</li>

</ul> </td> <td><b>at 12:12AM </b>starts the command the next time the clock
reads 12:12 AM.<b>  
at 12:12AM September 1 </b>starts the command at 12:12 AM on September 1.<b>  
at 12:00AM 01/01/2010 </b>starts the command at 12:00 AM on January 1,
2010.<b>  
at 12:00AM 01012010 </b>starts the command at 12:00 AM on January 1, 2010.<b>  
at 12:00AM 01.01.2010 </b>starts the command at 12:00 AM on January 1,
2010.</td>

</tr>

<tr> <td><b>at </b><i>time_of_day</i></td> <td>Use time of day keywords to run
the command. Options are:

<ul>

<li><b>Midnight</b> (12:00 AM)

</li>

<li><b>Noon</b> (12:00 PM)

</li>

<li><b>Teatime</b> (4:00 PM)

</li>

</ul> </td> <td><b>at midnight </b>starts the command the next time the clock
reads 12:00 AM.</td>

</tr>

<tr> <td><b>at now</b></td> <td>Run the command immediately.</td> <td> </td>

</tr>

<tr> <td><b>at now + </b><i>number time_period</i></td> <td>Schedule the
command to run at the designated time in the future. Use:

<ul>

<li>minutes

</li>

<li>hours

</li>

<li>days

</li>

<li>months

</li>

</ul> </td> <td><b>at now +</b> <b>6 days </b>starts the command 1 month after
the time the command is issued.  
<b>at now +</b> <b>1 months </b>starts the command 1 month after the time the
command is issued.</td>

</tr>

<tr> <td><b>at -f </b><i>filename</i> <i>time</i></td> <td>Schedule tasks in a
file to run at the designated time (like a shell script, for example).</td>
<td><b>at -f /home/user/myscript now + 3 hours </b>starts the jobs listed in
the <i>myscript</i> file in three hours from the time the command is
issued.</td>

</tr>

<tr> <td><b>at -l  
atq</b></td> <td>List the tasks in the at queue for the current user.

<ul>

<li>When run as root, <b>atq</b> or <b>at -l</b> lists all the jobs in queue.

</li>

<li>When run as a user other than root, <b>at</b> lists only the jobs for the
user.

</li>

</ul> </td> <td><b>atq</b> shows all jobs in the at queue.</td>

</tr>

<tr> <td><b>at -d</b> <i>jobnumber</i>  
<b>atrm</b> <i>jobnumber</i></td> <td>Remove jobs from the <b>at</b> queue.
Use commas to separate multiple jobs.</td> <td><b>at -d 2,3</b> removes jobs 2
ad 3 from the at queue.  
<b>atrm 4</b> removes job 4 from the at queue.</td>

</tr> </table>

