---
layout: page
title:  Xdm Configuration Facts
---

The X Display Manager (XDM) is an X Window system display manager that allows
users to log in to a Linux computer locally or from another computer on the
network. XDM configuration files are often located at one of the following
paths:

  * **/etc/X11/xdm**
  * **/usr/X11R6/lib/X11/xdm**

The following table describes the XDM configuration files:

<table>

<tr> <td>File</td> <td>Description</td>

</tr>

<tr> <td>Xresources</td> <td>The Xresources file modifies the look of the
login display including colors, border size, and similar functions.

<ul>

<li>The<i> xlogin*Foreground:</i> line controls the color used to display the
foreground.

</li>

<li>The<i> xlogin*Background:</i> line controls the color used to display the
background.

</li>

<li>The<i> xlogin*greetColor:</i> line controls the color used to display the
greeting.

</li>

<li>The<i> xlogin*failColor:</i> line controls the color used to display the
failure message.

</li>

<li>The<i> xlogin*login.Font:</i> line controls the font used to display the
input typed by the user.

</li>

<li>The<i> xlogin*login.greetFont:</i> line controls the font used to display
the greeting.

</li>

<li>The<i> xlogin*login.promptFont:</i> line controls the font used to display
prompts.

</li>

<li>The<i> xlogin*login.failFont:</i> line controls the font used to display
the message when the authentication fails.

</li>

<li>The<i> xlogin*greeting:</i> line changes the greeting that displays when
someone logs on to the server.

</li>

<li>The<i> xlogin*namePrompt:</i> line displays the string displayed to prompt
for a user name.

</li>

<li>The<i> xlogin*fail:</i> line controls the message displayed when the
authentication fails.

</li>

</ul> </td>

</tr>

<tr> <td>Xservers</td> <td>The Xservers file lists the location of the server.
When configuring an Xservers file, be aware of the following:

<ul>

<li>The server can be on the local computer or on a remote computer.

</li>

<li>Each specification consists of the following parts:

<ul>

<li>Display name

</li>

<li>Display class

</li>

<li>Display type

</li>

<li>A command line to start the server (if on a local computer)

</li>

</ul>

</li>

<li>A <b>-nolisten tcp</b> flag in the line prevents the X server from
listening on TCP ports, and renders it inoperable.

</li>

<li>If specifying a remote computer, it must be configured with appropriate
permissions.

</li>

<li>Use the<b> -bpp</b> parameter to change the color depth. Options include:

<ul>

<li>8 (256 colors)

</li>

<li>16 (65,536 colors)

</li>

<li>24 bits (16,777,216 colors)

</li>

<li>32 (over 4.2 billion colors) bits.

</li>

</ul> The following command sets the color depth to 24 bits:

</li>

</ul>

> <b>:0 local /usr/bin/X11/X vt7 -bpp 24</b>

</td>

</tr>

<tr> <td>xdm-config </td> <td>The xdm-config file lists the names and
locations of other configuration files. The file contains a command that
defines general permissions and access, such as the following: <b>
DisplayManager.requestPort: 177</b>

<ul>

<li>If the request port is set to 177, XDM listens to incoming XDMCP requests.
This is the port on which the display manager protocol usually operates.

</li>

<li>If the request port is set to 0, XDM does not listen for incoming
requests; this is one way to disable the display manager when using XDM.

</li>

</ul> </td>

</tr>

<tr> <td>Xaccess</td> <td>The Xaccess file lists the computers which can make
requests to the server using XDM and the computers which can see <i>chooser
broadcasts</i>. A chooser broadcast sends out a signal that lets the user see
that its display manager is enabled and that it is accepting requests. In the
Xaccess file:

<ul>

<li>An asterisk acts as a wildcard that indicates that every computer has
access.

</li>

<li>A line that consists of only an asterisk grants all computers access to
the login screen.

</li>

<li>A line followed with the term CHOOSER BROADCAST defines what computers can
see the chooser broadcast.

</li>

<li>An exclamation point at the start of the command prohibits a computer from
accessing the display manager.

</li>

</ul>

The following command set allows access for only those computers listed. Any
computer in the acme-u.edu domain can see the chooser broadcast and has access
to the login screen. The computer mycomputer.mynetwork.com can access the
login screen, but cannot see the chooser access information.

> *.acme--u.edu  
mycomputer.mynetwork.com  
*.acme-u.edu   CHOOSER BROADCAST 

</td>

</tr> </table>

Be aware of the following:

  * SUSE requires the following configuration changes to the **/etc/sysconfig/displaymanager** file to enable remote logins:
    * **displaymanager_remote_access="yes"**
    * **displaymanager_xsrever_TCP_port_6000_ope="yes"**
  * Because XDM runs as root, it is less secure than the other display managers. If any scripts that XDM uses have security flaws, an attacker could potentially gain root access to the file system.

