---
layout: page
title:  Display Manager Facts
---

The display manager is a modular tool that manages the graphical display on a
computer and has functions that provide users with a graphical login prompt to
log in to a Linux computer from a remote computer. The main display manager
types for Linux are:

  * X Display Manager (XDM)
  * Gnome Display Manager (GDM)
  * KDE Display Manager (KDM)

The following table describes different tasks when configuring the display
manager:

<table>

<tr> <td>Task</td> <td>Description</td>

</tr>

<tr> <td>Select the default display manager</td> <td>Selecting the default
display manager depends on the distribution.

<ul>

<li>Some distributions use a configuration file that is often located at
<b>/etc/sysconfig</b>.

<ul>

<li>The name and often the location of the file vary by distribution; use the
<b>grep</b> utility to find a file that has DISPLAYMANAGER text in it.

</li>

<li>The entry should look similar to <b>DISPLAYMANAGER="KDM</b>".

</li>

</ul>

</li>

<li>Some distributions use a script in the <b>/etc/init.d</b> directory.

<ul>

<li>The script is named xdm, kdm, or gdm depending on the distribution.

</li>

<li>Replace the script to change the display manager.

</li>

</ul>

</li>

</ul> </td>

</tr>

<tr> <td>Start or stop the display manager</td> <td>If at runlevel 3, you
might need to manually start or stop the display manager. Using a shell
prompt, navigate to the <b>/etc/init.d/</b> directory and use one of the
following commands:

<ul>

<li><b>[xdm] [kdm] [gdm] start</b>

</li>

<li><b>[xdm] [kdm] [gdm] stop</b>

</li>

</ul> </td>

</tr>

<tr> <td>Enable or disable the display manager at startup</td> <td>To
permanently enable or disable the display manager at startup, use one of the
following commands:

<ul>

<li><b>chkconfig [xdm] [kdm] [gdm] on</b>

</li>

<li><b>chkconfig [xdm] [kdm] [gdm] off</b>

</li>

</ul> </td>

</tr>

<tr> <td>Change the color depth</td> <td>To change the color depth of the
display manager, use a setting in the servers file for the type of display
manager in use.

<ul>

<li>The <b>startx</b> command can change color depth by using the<b>
-depth</b> option, followed by the color depth in bits.

</li>

<li>Lower color depth conserves video memory for a better resolution
(increased color depth can sometimes affect the maximum resolution of older
video cards).

</li>

<li>For example, to start a session in 16 bit mode, use the following command:

</li>

</ul>

> <b>startx -depth 16 </b>

</td>

</tr>

<tr> <td>Support X Terminals</td> <td>An X Terminal is a system which
typically connects only to an X server and does not have its own local system
resources. To support X Terminals, complete the following general steps:

<ol>

<li>Select and configure a display host to listen connection requests on the
XDMCP protocol.

</li>

<li>Restart the display manager.

</li>

<li>Make sure port 177 is allowed through the firewall.

</li>

<li>Specify the computers or domain which can make connection requests to the
display host.

</li>

</ol> </td>

</tr> </table>

