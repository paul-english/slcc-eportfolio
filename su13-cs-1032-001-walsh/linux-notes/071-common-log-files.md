---
layout: page
title:  Common Log Files
---

Be aware of the following common log files:

<table>

<tr> <td><b>File/Directory</b></td> <td><b>Contents</b></td>

</tr>

<tr> <td> <b>/var/log/boot.log  
/var/log/boot.msg</b></td> <td>Depending on the distribution, the system holds
messages generated during the boot process in one of the files. </td>

</tr>

<tr> <td><b>/var/log/faillog  
/var/log/btmp</b></td> <td>The faillog or btmp file lists login failures for
user accounts on a computer depending on the distribution.</td>

</tr>

<tr> <td><b>/var/log/firewall</b></td> <td>The firewall file displays messages
about firewall actions.</td>

</tr>

<tr> <td><b>/var/log/lastlog</b></td> <td>The lastlog file holds information
about the last time each user logged in (and is used by the utility of the
same name). </td>

</tr>

<tr> <td><b>/var/log/maillog</b></td> <td>The maillog file contains reports on
mail server status and messages related to incoming and outgoing mail.</td>

</tr>

<tr> <td><b>/var/log/messages </b> </td> <td>The messages file is the default
file for storing system messages. This file may include copies of messages
that appear on the console, internal kernel messages, and messages sent by
networking programs.</td>

</tr>

<tr> <td><b>/var/log/warn</b></td> <td>The warn file displays warning messages
from many processes by default.</td>

</tr>

<tr> <td><b>/var/log/wtmp</b></td> <td>The wtmp file keeps track of all users
who have logged into and out of the system as well as listing every connection
and run-level change.</td>

</tr>

<tr> <td><b>/var/log/dmesg</b></td> <td>The dmesg file is often called the
<i>kernel ring buffer</i>. It reports messages received in the process of
configuring devices as the system boots. </td>

</tr>

<tr> <td><b>/var/log/secure</b></td> <td>The secure file logs any attempts to
log in as the root user or attempts to use the <b>su</b> command. This file
also contains information on remote logins and failed root user login
attempts. </td>

</tr>

<tr> <td><b>/var/log/cron</b></td> <td>The cron file stores messages related
to tasks scheduled with cron. It keeps track of which tasks are run and when
they were started. </td>

</tr>

<tr> <td><b>/var/log/sa</b></td> <td>The /<b>car/log/sa</b> directory stores
<b>/sa<i>n</i></b> files, which contain all performance information for the
day of the month indicated by <i>n</i>. For example, <b>/var/log/sa/sa15</b>
contains performance information for the fifteenth day of the month, and it
will be overwritten on the fifteenth day of the next month.</td>

</tr>

<tr> <td><b>/var/log/XFree86.log</b></td> <td>The XFree86.log file stores X
Window System startup messages. Examine this file to identify X Window System
configuration status and errors.</td>

</tr>

<tr> <td><b>/var/log/rpmpkgs</b></td> <td>On Red Hat systems, the rpmpkgs file
tracks installed packages. It also records all kernel packages on the
system.</td>

</tr>

<tr> <td><b>/tmp/install.log  
/root/install.log</b></td> <td>The install.log<i> </i>might be present
depending on the distribution. This file records messages related to the
installation and can be useful for installation records for a computer. </td>

</tr> </table>

