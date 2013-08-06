---
layout: page
title:  Runlevel And Init Facts
---

A _runlevel_ is collection of services that defines a specific system state.
For example, Microsoft Windows has Safe Mode and regular mode which are
somewhat equivalent to Linux runlevels. The table below describes the
runlevels:

<table>

<tr> <td><b>Runlevel</b></td> <td><b>Description</b></td>

</tr>

<tr> <td>0</td> <td>This is the halt state. In runlevel 0, the system has no
daemons in memory and is ready to be turned off.</td>

</tr>

<tr> <td>1</td> <td>This is single user mode. In single user mode, the system
uses only enough daemons to allow a single user to log in, and is often used
for maintenance tasks. The user is automatically logged in as the root
user.</td>

</tr>

<tr> <td>2</td> <td>This is multi-user mode. In multi-user mode, the system
allows multiple users to log in. It also provides networking services with the
exception of the Network File System.</td>

</tr>

<tr> <td>3</td> <td>This is extended multi-user mode. In extended multi-user
mode, the system provides multi-user mode support in addition to all network
services, including Network File System.</td>

</tr>

<tr> <td>4</td> <td>This runlevel is undefined, but can be defined if
necessary.</td>

</tr>

<tr> <td>5</td> <td>This is graphical mode. In graphical mode, the system
provides the same capabilities as in extended user mode. However, the system
also supports graphical log ins.</td>

</tr>

<tr> <td>6</td> <td>This is the reboot runlevel. In this runlevel, the system
re-starts itself. </td>

</tr> </table>

During the boot process, the init (initialize) daemon loads all the other
daemons that control the system. Init uses the **/etc/inittab **file to
determine the default runlevel, and then starts the appropriate daemons for
that runlevel; however, some distributions place code for initiating runlevels
in separate files. The table below describes the format of the lines in the
**/etc/inittab ** file:

<table>

<tr> <td><b>Field</b></td> <td><b>Description</b></td>

</tr>

<tr> <td>label:</td> <td>This field organizes the file to allow the init
daemon to read it alphabetically.</td>

</tr>

<tr> <td>runlevel(s):</td> <td>This field specifies the runlevel(s) to which
the line corresponds.</td>

</tr>

<tr> <td>action:</td> <td>This field tells init what action to take (e.g.,
respawn, wait, boot, bootwait, powerfail, powerwait).</td>

</tr>

<tr> <td>command</td> <td>This field designates a shell command to
execute.</td>

</tr></table>

The following lines below are typical lines in the **/etc/inittab **file:

  * **id:3:initdefault: **indicates that init should set the system runlevel at 3 by default. 
  * **si::sysinit:/etc/rc.d/rc.sysinit** indicates that that init should execute the** /etc/rc.d/rc.sysinit** command prior to entering a runlevel when the system initializes. 
  * **cmd:123:wait:/sbin/custom** runs the special script file (**/sbin/custom**) for runlevels 1, 2, and 3. 
  * **l5:5:wait:/etc/init.d/rc 5 **determines which script runs when invoking an ** init** command.
  * **ca::ctrlaltdel:/sbin/shutdown -r -t 4 now **specifies what happens when a user presses Ctrl+Alt+Del. 

The following table describes the commands that determine and change the
current runlevel. (The commands require root privileges.)

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Examples</b></td>

</tr>

<tr> <td><b>runlevel</b></td> <td>Display the previous runlevel and the
current runlevel, respectively.

<ul>

<li>The previous runlevel is the first number.

</li>

<li>The current runlevel is the second number.

</li>

<li>An <b>N</b> as the first number specifies that the current runlevel is the
runlevel into which the computer booted.

</li>

<li>An <b>S</b> specifies that the runlevel is single user mode (i.e.,
runlevel 1).

</li>

</ul> </td> <td><b> </b>  
<b>[root@COMP ~]# runlevel</b>  
3 5  

Runlevel is 3 was the previous runlevel; Runlevel 5 is the current runlevel.

</td>

</tr>

<tr> <td><b>init  
telinit </b></td> <td>Change the runlevel of the computer.</td> <td><b>init
0</b> changes the system to runlevel 0, shutting the system down.<b>  
init s</b> changes the runlevel to 1, which is single-user mode.  
<b>init 3</b> changes the runlevel to 3, which is extended multi-user mode.  
<b>telinit 3</b> changes the runlevel to 3.<b>  
telinit 5</b> changes the runlevel to 5, which is graphical multi-user
mode.</td>

</tr>

<tr> <td><b>init q  
init Q</b></td><td>Have init re-examine the inittab file.</td> <td> </td>

</tr> </table>

