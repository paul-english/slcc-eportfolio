---
layout: page
title:  Logrotate Facts
---

By default, most Linux distributions include the **logrotate** utility to
automatically manage, compress, rename, and delete log files based on specific
criteria (such as size or date). On most distributions, **logrotate:**

  * Automatically runs each week as a **cron** job to periodically maintain system logs. Old logs are renamed with a numbered extension, and logs are deleted after 4 weeks. 
  * Uses **/etc/logrotate.conf** as the main configuration file. It contains entries that apply to the whole system.
  * Uses scripts in **/etc/logrotate.d** to overwrite the settings in **/etc/logrotate.conf**. 

The following table describes the commands found in **/etc/logrotate.conf** or
scripts in **/etc/logrotate.d**:

<table>

<tr> <td>Use...</td> <td>To...</td> <td>Examples</td>

</tr>

<tr> <td><b>compress</b></td> <td>Compress old log files using
<b>gzip</b>.</td> <td> </td>

</tr>

<tr> <td><b>maxage</b></td> <td>Remove rotated logs that are older than the
specified number of days.</td> <td><b>maxage 180</b> deletes every rotated log
older than 180 days.</td>

</tr>

<tr> <td><b>dateext</b></td> <td>Use a daily extension on archived files using
<b> <i>file.YYYYMMDD</i></b> format. </td> <td> </td>

</tr>

<tr> <td><b>rotate</b></td> <td>Specify the number of times to rotate the log
before deleting it.</td> <td><b>rotate 5</b> rotates the log file five times
and then removes it.</td>

</tr>

<tr> <td><b>size</b></td> <td>Rotate or remove log files based on file size.
Use the following:

<ul>

<li>s<i>ize</i><b>k</b> to specify the size in kilobytes.

</li>

<li>s<i>ize</i><b>M</b> to specify the size in megabytes.

</li>

<li>s<i>ize</i><b>G</b> to specify the size in gigabytes.

</li>

</ul> </td> <td><b>size 100M</b> deletes or rotates files larger than 100
megabytes.</td>

</tr>

<tr> <td><b>notifempty</b></td> <td>Prohibit empty logs from being
rotated.</td> <td>  </td>

</tr>

<tr> <td><b>missingok</b></td> <td>Prevent errors from being displayed for
missing log files.</td> <td>  </td>

</tr>

<tr> <td><b>create</b></td> <td>Create a log file with a name identical to the
one just rotated. The command specifies the mode (permissions) of the file and
well as the owner and group for the file.</td> <td><b>create 744 root root</b>
creates a file with read, write, and execute permissions for the owner and
read permission for the group and everyone; specifies root as the file owner;
and specifies root as the group.</td>

</tr>

<tr> <td><b>postrotate</b></td> <td>Indicate the start of script commands to
be executed after log files are rotated. The term endscript must be used to
indicate the end of the script.</td> <td>  </td>

</tr> </table>

