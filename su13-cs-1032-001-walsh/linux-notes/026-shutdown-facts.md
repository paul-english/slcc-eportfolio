---
layout: page
title:  Shutdown Facts
---

Turning off the power without executing the proper shutdown procedure to a
computer can result in data loss and filesystem corruption. Linux provides
several different shutdown options. The table below shows common commands for
shutting down the system.

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Examples</b></td>

</tr>

<tr> <td><b>shutdown -h now  
halt</b>  
<b>init 0</b> </td> <td>Shut the system down immediately.

<ul>

<li><b>-h</b> specifies that the system halt or poweroff after shutdown.

</li>

<li><b>now </b>forces the system to shut down without a delay.

</li>

</ul>

<b>Note</b>: Any of the three commands shut the system down.

</td> <td>   </td>

</tr>

<tr> <td><b>shutdown -r now  
reboot  
init 6</b> </td> <td>Shut the system down immediately and reboot.

<b>Note</b>: Any of the three commands reboot the system.

</td> <td> </td>

</tr>

<tr> <td><b>shutdown -h</b> <i>time message</i><b>  
shutdown -r</b> <i>time message</i></td> <td>Shut the system down in the
designated amount of time and send a message. </td> <td><b>shutdown -h +5</b>
<b>System is going down </b>sends a message and shuts the system down in five
minutes. <b>  
shutdown -h 22:00</b> shuts the system down at 10:00 pm.  
<b>shutdown -r +15</b> reboots the system in 15 minutes.  
<b>shutdown -r 24:00</b> <b>System is going down at Midnight </b>sends a
message and reboots the system at midnight. </td>

</tr>

<tr> <td><b>shutdown -c</b>  
Ctrl+c</td> <td>Terminate the shutdown process.</td> <td> </td>

</tr>

<tr> <td><b>shutdown -rf </b><i>time</i></td> <td>Reboots the system and skips
the <b>fsck</b> utility on reboot. The <b> -f</b> parameter stands for
<i>reboot fast</i>. </td> <td><b>shutdown -rf </b>reboots the system and skips
<b>fsck</b>. <b>  
shutdown -r +15</b> reboots the system in 15 minutes and uses <b>fsck</b>.
</td>

</tr>

<tr> <td><b>shutdown -k </b><i>message</i></td> <td>Sends a warning message,
but does not shut down the system down. If used in combination with<b> -h</b>
or <b>-r</b>, it will terminate the shutdown process after the message is
sent.</td> <td><b>shutdown -k Please log out of the system </b>sends a message
but does not shut the system down.</td>

</tr>

<tr> <td><b>shutdown -a</b></td> <td>Use the <b>/etc/shutdown.allow</b> file
to shut down the system.

The most common use of this switch is to edit the <b>/etc/inittab</b> file and
add the <b>-a</b> switch to the CTRL-ALT-DELETE section. When the switch is
present, shutdown reads the <b>/etc/shutdown.allow</b> file:

<ul>

<li>If a listed user or root is logged into the system, the system shuts down.

</li>

<li>If a listed user or root is <i>not</i> logged into the system, shutdown is
not allowed.

</li>

<li>If the <b>/etc/shutdown.allow</b> file does not exist, there are no
restrictions on who can shut down the system.

</li>

</ul> </td> <td> </td>

</tr> </table>

When using the **shutdown** command to shut down the computer, the system does
the following:

  1. Sends a SIGTERM message to open programs to allow them to close. 
  2. Notifies logged on users that the shutdown process has initiated and the length of time before shut down. 
  3. Blocks users from logging into the system. 
  4. Uses init and **/etc/inittab** to shut down processes and the system. 

