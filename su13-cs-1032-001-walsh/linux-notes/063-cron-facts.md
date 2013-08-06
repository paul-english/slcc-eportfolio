---
layout: page
title:  Cron Facts
---

The **cron** daemon (crond) schedules tasks to run on a regular basis. **
cron** uses the following configuration files:

<table>

<tr> <td>File</td> <td>Description</td>

</tr>

<tr> <td> <b>/etc/crontab</b></td> <td>The <b>/etc/crontab</b> (cron table)
file holds entries that direct commands to execute at a specific time. The<b>
/etc/crontab</b> file:

<ul>

<li>Is for custom task schedules that run system wide.

</li>

<li>Can only be edited by the root user.

</li>

</ul> <b>Note</b>: The crond runs tasks scheduled in the <b>/etc/crontab </b>
file as the root user.</td>

</tr>

<tr> <td><b>/etc/cron.<i>timeparameter</i></b></td> <td>The cron daemon
executes the scripts found in each of the following directories at the
specified interval for the whole system:

<ul>

<li><b>/etc/cron.hourly</b>

</li>

<li><b>/etc/cron.daily</b>

</li>

<li><b>/etc/cron.weekly</b>

</li>

<li><b>/etc/cron.monthly</b>

</li>

</ul> </td>

</tr>

<tr> <td><b>/var/spool/cron/<i>username</i></b></td> <td>Each user has a
personal crontab file located at <b>/var/spool/cron/</b><i>username</i>. The
cron daemon only checks the file of the current user. </td>

</tr>

<tr> <td> <b>/etc/cron.allow</b></td> <td>The <b>/etc/cron.allow</b> file
<i>includes</i> users who can edit their personal crontab file. If
<b>/etc/cron.allow </b>file exists, only users listed in therein are allowed
to edit <b>/var/spool/cron/<i>username.</i></b></td>

</tr>

<tr> <td> <b>/etc/cron.deny</b></td> <td>The <b>/etc/cron.deny</b> file
<i>excludes</i> users from editing their personal crontab file. If
<b>/etc/cron.deny </b>file exists, users listed in therein are not allowed to
edit <b>/var/spool/cron/<i>username.</i></b></td>

</tr> </table>

Each entry **/etc/crontab** or **/var/spool/cron/_username_** has a specific
format. The table below illustrates the schedule format for a typical entry
and provides additional examples. Note that an asterisk (*) is equal to _any_:

<table>

<tr> <td><b>Example</b></td> <td><b>Minute</b></td> <td><b>Hour</b></td>
<td><b>Day of Month</b></td> <td><b>Month</b></td> <td><b>Day of Week</b></td>
<td>Command</td> <td>Description</td>

</tr>

<tr> <td>00 5 * * 6 /bin/tar</td> <td>00</td> <td>5</td> <td>*</td> <td>*</td>
<td>6</td> <td>/bin/tar</td> <td>This schedule runs the <b>tar</b> utility on
the 6th day (Saturday) of the week, at the 5th hour (5am--5pm would be 17) and
zero minutes. (Note that the days of the week are numbered 0 through 7, 0 and
7 being equal to Sunday.)</td>

</tr>

<tr> <td>15 23 25 * * /usr/bin/find</td> <td>15</td> <td>23</td> <td>25</td>
<td>*</td> <td>*</td> <td>/usr/bin/find</td> <td>This schedule runs the
<b>find</b> command at 11:15 pm on the 25th of every month.</td>

</tr>

<tr> <td>00 24 1 1,6 * /bin/rm</td> <td>00</td> <td>24</td> <td>1</td> <td>1
and 6</td> <td>*</td> <td>/bin/rm</td> <td>This schedule runs the <b>rm</b>
command at midnight on the first days of January and July.</td>

</tr> </table>

Use the following commands to manage **cron** task scheduling:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td>Examples</td>

</tr>

<tr> <td><b>crontab</b></td> <td>Manage the
<b>/var/spool/cron/<i>username</i></b> crontab file: Be aware of the following
options:

<ul>

<li><b>-e </b>edits the crontab file in vim for the current user.

</li>

<li><b>-l </b>displays<b> </b>the contents of the crontab file.

</li>

<li><b>-r </b>removes the crontab file.

</li>

<li><b>-u <i>username</i></b> specifies a user for the <b>-e</b>, <b>-l</b>,
and<b> -r</b> options.

</li>

</ul> </td> <td> <b>crontab -e </b>edits the crontab of the current user.  
<b>crontab -eu</b> <b> <i>username</i></b> edits the crontab file of the
specified user.<b>  
crontab -l </b> <i><b> </b></i>lists the cron jobs for the current user.  
<b>crontab -lu</b> <i><b>username </b></i> lists the cron jobs for the
specified user.  
<b>crontab -r -u</b> <b> <i>username </i> </b>removes the crontab file of the
specified user.  
<b>crontab -r </b>removes the crontab file of the current user.  
<b>crontab /home/user/cronjobs</b> creates a crontab file using the cronjobs
file for the current user.</td>

</tr>

<tr> <td><b>vi /etc/crontab</b></td> <td>Open and edit the <b>/etc/crontab
</b>file in Vim.</td> <td> <b>vi /etc/crontab </b>opens the crontab file in
Vim.</td>

</tr>

<tr> <td><b>crontab <i>file</i></b></td> <td>Load a crontab job from a file.
Write the file using crontab syntax.

<b>Note:</b> This overwrites the current crontab.

</td> <td> <b>crontab /home/user/cronjobs</b> creates a crontab file using the
cronjobs file for the current user.</td>

</tr>

<tr> <td><b>which</b></td> <td>Display the full path for a command. For many
distributions,<b> </b>crontab entries require the complete path to commands.
For example, to use<b> /bin/rm</b> instead of only <b>rm</b>. </td> <td>
<b>which bash</b> displays the full path for the borne again shell. </td>

</tr> </table>

Be aware of the following details:

  * Some distributions use separate files in the **/etc/cron.d** directory in addition to lines in the **/etc/crontab** file.
  * The cron daemon (crond) is started using a script in the** /etc/rc.d/init.d/** or **/etc/init.d/ **script directory.

