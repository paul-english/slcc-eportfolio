---
layout: page
title:  Time Maintenance Facts
---

Applications and services, especially those that are used for security
purposes, require accurate time. Be aware of the following details:

  * Services that communicate with other computers require that the clocks on all computers are synchronized within a small degree of variance.
  * A _timestamp_ is a record attached to an event or an action that identifies the time when the event took place. Timestamps are used to: 
    * Record when security events, such as logon or system changes, occur. 
    * Identify the correct sequence of events. For example, if a database record is changed from two different computers, the timestamp associated with the changes are used to identify which change took place first (or last). 

Use the following files and utilities to manage the hardware clock and system
time:

<table>

<tr> <td>Use...</td> <td>To...</td> <td>Examples</td>

</tr>

<tr> <td> <b> cat /proc/driver/rtc</b></td> <td>Display the hardware clock
time.</td> <td> <b>cat</b> <b> /proc/driver/rtc </b>displays the hardware
clock time.</td>

</tr>

<tr> <td><b>hwclock</b></td> <td>View and set the hardware clock time and
synchronize the hardware clock and the system time. Options include:

<ul>

<li><b>-a, --adjust</b> adds or subtracts time from the hardware clock to
account for systematic drift since the last time the clock was set or
adjusted.

</li>

<li><b>-r, \--show</b> displays the current hardware clock time.
<b>hwclock</b> assumes <b>-r</b> if no options are used.

</li>

<li> <b>\--set--date </b>sets the hardware clock time and date.

</li>

<li><b>-s, --hctosys</b> sets the system time to the current hardware clock
time.

</li>

<li><b>-w, --systohc</b> sets the hardware clock based on the system time.

</li>

<li><b>\--localtime</b> sets the hardware clock to local time.

</li>

<li><b>-u, --utc</b> sets the hardware clock to UTC time.

</li>

</ul></td> <td> <b>hwclock -w </b> sets the hardware clock time to match the
system time.  
<b>hwclock --set --date="2/24/2020 16:45:05" -utc </b>sets the hwclock time to
4:45:05 PM on February 24, 2020 un UTC time.  
<b>hwclock -s </b> sets the system time to match the hardware clock.  
<b>hwclock -u </b> sets the hardware clock time to UTC time.</td>

</tr>

<tr> <td> <b> /etc/sysconfig/clock</b></td> <td>

Configure the hardware clock to use UTC or local time automatically. the file
acts as a configuration file that sets the <b>HWCLOCK</b> setting to control
whether the clock uses local or Coordinated Universal Time (UTC):

<ul>

<li><b>HWCLOCK -u</b> specifies that the system use UTC.

</li>

<li><b>HWCLOCK --localtime</b> specifies  that the system use local time.

</li>

</ul>

<b>Note:</b> Managing a large group of computers in different time zones is
less complex if <b>HWCLOCK</b> is set to use UCT.

</td> <td> </td>

</tr>

<tr> <td><b>netdate</b></td> <td>Set the system time to match the time on a
time server on the network. The time provider must be running the time service
on UPD port 37.</td> <td><b>netdate<i> </i>192.168.1.10</b> sets the time on
the local computer to match the time on the time server at 192.168.1.10.</td>

</tr>

<tr> <td><b>date</b></td> <td>View and manually set the system time.

<ul>

<li><b>-d</b> shows the current date and time. <b>date</b> assumes <b>-d</b>
if no options are used.

</li>

<li><b>-s</b> sets the date and time.

</li>

<li><b>-u, --utc</b> specifies UTC time.<i> </i>

</li>

</ul> </td> <td><b>date -s "11/20/2020 15:48:00" </b>sets the time and date to
3:48:00 PM on November 20, 2020.  
<b>date -su "11/20/2020 15:48:00" </b>sets the UTC time and date to 3:48:00 PM
on November 20, 2020  
<b>date -d</b> shows the local time and date.  
<b>date -u</b> shows the current UTC time.</td>

</tr> </table>

