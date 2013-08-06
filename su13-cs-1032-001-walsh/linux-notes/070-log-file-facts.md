---
layout: page
title:  Log File Facts
---

Log files are records of information about kernel and daemon errors. Log
files:

  * Are typically recorded in plain text.
  * Are typically controlled by the _syslogd_, _rsyslogd_, or _syslog-mg_ daemon depending on the distribution. 
  * Can be encrypted or sent to a remote server to keep attackers from altering them.
  * Are an invaluable resource for troubleshooting a Linux system.

By default, many daemons send their log messages to the **/dev/log** file. The
logging daemon (e.g., syslogd) parses the message entries in **/dev/log** file
to the correct log file locations using entries in **/etc/syslog.conf** (or a
similar configuration file that follows the name of the daemon, such as
**/etc/rsyslog.conf**). Entries in the **/etc/syslog.conf** file have the
following syntax:

> _facility.priority destination_

The following table describes the entry options in the **/etc/syslog.conf**
file:

<table>

<tr> <td>Facility</td> <td>Priority</td> <td>Destination (also known as
<i>action</i>)</td>

</tr>

<tr> <td>The facility is the daemon that produces the message. Be aware of the
following facilities:

<ul>

<li><b>authpriv </b>identifies authentication (login) messages

</li>

<li><b>cron </b>identifies messages from the memory-resident scheduler

</li>

<li><b>daemon </b>identifies messages from resident daemons

</li>

<li><b>kern </b>identifies kernel messages

</li>

<li><b>lpr </b>identifies printer messages

</li>

<li><b>news </b>identifies messages from the news system

</li>

<li><b>mail </b>identifies messages from Sendmail

</li>

<li><b>user </b>identifies messages from user-initiated processes and
programs, including failed logons

</li>

<li><b>local0-local7 </b>identifies user-defined errors

</li>

<li><b>uucp </b>identifies Unix to Unix copy (UUCP) system messages

</li>

<li><b>syslog </b>identifies messages from the syslog process

</li>

</ul> </td> <td>The priority is level of importance of the message. Be aware
of the following priorities (listed high to low):

<ul>

<li><b>emerg </b>represents<b> </b>emergency, the computer is unstable

</li>

<li><b>alert </b>represents<b> </b>immediate action

</li>

<li><b>crit </b>represents<b> </b>critical errors

</li>

<li><b>err </b>represents<b> </b>serious errors

</li>

<li><b>warning </b>represents<b> </b>non-critical errors

</li>

<li><b>notice </b>represents<b> </b>normal events that are significant

</li>

<li><b>info </b>represents<b> </b>informational messages

</li>

<li><b>debug </b>represents<b> </b>all messages

</li>

</ul>



</td> <td>The destination log file is where the logging daemon sends the log
file. Options include:

<ul>

<li><b>/var/log/boot.log</b>

</li>

<li><b>/var/log/messages </b>

</li>

<li><b>/var/log/cron</b>

</li>

<li><b>/var/log/maillog</b>

</li>

<li><b>@<i>ipaddress </i></b>(IP address of remote server receiving log file
messages)

</li>

<li><i><b>user1,user2 </b></i>(sends messages to the specified user currently
logged on to the computer)

</li>

<li><i><b>* </b></i>(sends messages to all users currently logged on the
computer)

</li>

<li><b>/dev/tty1</b> (sends messages to virtual console 1)

</li>

</ul>



</td>

</tr> </table>

The following are examples of entries in the **/etc/syslog.conf** file:

<table>

<tr> <td>Example</td> <td>Description</td>

</tr>

<tr> <td><b>cron.*             /var/log/cron</b> </td> <td>Sends all cron
messages to the <b>/var/log/cron </b> log.</td>

</tr>

<tr> <td><b>*.emerg         *</b> </td> <td>Sends all emergency messages to
all users on the computer.</td>

</tr>

<tr> <td><b>kern.debug    /var/log/kerndebug</b></td> <td>Sends all kernel
messages to the <b>/var/log/kerndebug</b> log.</td>

</tr>

<tr> <td><b>*.*                   @192.168.10.1</b></td> <td>Sends all log
messages to a remote server with an IP address of 192.168.10.1.</td>

</tr> </table>

Sending log message to a remote server increases security for log files and
centralizes log file locations. To enable a server to receive log file
messages:

  * Set the value of the **SYSLOGD_PARAMS** parameter to **-r** in **/etc/sysconfig/syslog**.
  * Ensure UDP port 514 is open on the firewall.

