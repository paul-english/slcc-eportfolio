---
layout: page
title:  Log File Display Commands
---

The following table describes commands to view and manage text-based log
files:

<table>

<tr> <td>Use...</td> <td>To... </td> <td>Examples</td>

</tr>

<tr> <td><b>cat</b></td> <td>View the contents of a log file. </td> <td><b>cat
/var/log/messages</b> shows the entire text of the messages log.</td>

</tr>

<tr> <td><b>grep</b></td> <td>Filter text from a text file. </td> <td><b>cat
/var/log/messages | grep ftp</b> filters the output of the cat command to show
only lines that contain the term <i>ftp</i>.</td>

</tr>

<tr> <td><b>tail</b></td> <td>Show the last 10 lines of a file. Be aware of
the following options:

<ul>

<li><b>-f</b> displays additions to the log in real time.

</li>

<li> <b>-n</b><i>#</i> option with specifies the number of lines to display.

</li>

</ul> </td> <td><b>tail /var/log/messages </b>shows the last 10 lines of the
messages log.  
<b>tail -f /var/log/messages </b>continually displays the real-time entries of
the messages log.</td>

</tr>

<tr> <td><b>head</b></td> <td>Show the first 10 lines of a file.</td>
<td><b>head /var/log/messages </b>shows the first 10 lines of the messages
log.</td>

</tr>

<tr> <td><b>less  
more</b></td> <td>Scroll through individual pages of a file.</td> <td><b>less
/var/log/messages </b>allows scrolling through each page of the file.</td>

</tr>

<tr> <td><b>vi  
gedit</b></td> <td>Open text files for editing.</td> <td><b>vi less
/var/log/messages </b>opens the messages log for editing.</td>

</tr> </table>

The following table lists several commands used to view and manage binary log
files.

<table>

<tr> <td>Use...</td> <td>To... </td>

</tr>

<tr> <td><b>dmesg</b></td> <td>View the boot logs and to troubleshoot hardware
errors. The <b>dmesg</b> command shows information about all the hardware
controlled by the kernel and displays error messages as they occur. </td>

</tr>

<tr> <td><b>dmesg -n</b> <i>#</i></td> <td>Control which error messages are
sent to the console. For example, <b>dmesg -n 1</b> sends only the most
critical errors (0 and 1) to the console. Other messages are still logged in
the log files.</td>

</tr>

<tr> <td><b>last</b></td> <td>Show all users who have logged into and out of
the system as well as listing every connection and run-level change (i.e., the
contents of the <b>/var/log/wtmp</b> file).</td>

</tr>

<tr> <td><b>faillog  
lastb </b></td> <td>Show all failed login attempts on the system (i.e., the
contents of the <b>/var/log/btmp</b> file or <b>/var/log/faillog</b> file
depending on the distribution).</td>

</tr>

<tr> <td><b>lastlog</b></td> <td>Show a list of the dates and times for the
last login for each user.</td>

</tr>

<tr> <td><b>logger</b></td> <td>Change the message severity and where logged
messages are sent.</td>

</tr>

<tr> <td><b>logrotate</b></td> <td>Manage, compress, rename, and delete log
files based on specific criteria (such as size or date). </td>

</tr>

<tr> <td><b>sar</b></td> <td>View system statistics. <b> sar</b> is short for
System Activity Report. It comes as part of the <b>sysstat</b> (System
Statistics) package. When used alone, it returns CPU statistics. Common
options include the following:

<ul>

<li><b>-A</b> Displays all information

</li>

<li><b>-b</b> Displays I/O statistics

</li>

<li><b>-B</b> Displays swap statistics

</li>

<li><b>-f /var/log/sa</b> <i>filename</i> Displays information from the
specified file.

</li>

</ul></td>

</tr> </table>

