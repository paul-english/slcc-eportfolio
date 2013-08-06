---
layout: page
title:  Gdm Configuration Facts
---

The Gnome Display Manager (GDM) is a tool that manages login functions on a
local computer or over a network. GDM:

  * Lets users select a session type and shut down the computer from the login prompt screen.
  * Uses **/etc/X11/gdm/gdm.conf** as its main configuration file. This is often a plain text file, but some distributions might use an XML file.
  * Has a GUI-based configuration tool called _gdmsetup_. This tool configures color styles, accessibility, and most GDM other functions. 

The **/etc/X11/gdm/gdm.conf** file is divided into sections. The following
table lists the sections and describes the most commonly configured options in
each section these sections

<table>

<tr> <td>Section</td> <td>Description</td>

</tr>

<tr> <td>Xserver definitions</td> <td>The X server definitions section tell
GDM about the installed X servers. Be aware of the following options:

<ul>

<li><i>Name</i> specifies the name that is displayed to the user; used with
chooser broadcasts.

</li>

<li><i>Command</i> contains the path to the server executable file.

</li>

<li><i>Flexible</i> specifies whether the Xserver is an on-demand server that
starts when GDM receives multiple login requests.

</li>

<li><i>Chooser</i> specifies whether the server displays a chooser list of all
Xservers running on the computer rather than a login screen.

</li>

</ul>

<b>Note</b>: To define servers, use the <b>/etc/X11/gdm/gdm.conf</b> file, not
the gdmsetup tool.

</td>

</tr>

<tr> <td>Servers</td> <td>The Servers section has commands for initializing
the X servers. The lines can be a path to the X server executable or the name
of an Xserver definition. GDM can append additional arguments to the command
for the path and server definitions.</td>

</tr>

<tr> <td>Security options</td> <td>The security options section has options
that can implement increased or decreased security depending on the function
of the server. Be aware of the following options:

<ul>

<li><i>AllowRoot</i> specifies whether users can log in locally using the root
account.

</li>

<li><i>AllowRemoteRoot</i> specifies whether users can log in from a remote
computer using the root account.

</li>

<li><i>DisallowTCP</i> specifies whether remote connections are disallowed.

</li>

<li><i>RelaxPermissions</i> specifies user permission levels.

<ul>

<li>When set to 0 it only allows users to access files and directories they
own. The default is 0.

</li>

<li>When set to 1, they can access group-owned files and directories.

</li>

<li>When set to 2, they can access world-writable files and directories.

</li>

</ul>

</li>

</ul> </td>

</tr>

<tr> <td>XDMCP support</td> <td>The XDMCP support section has settings that
customize how users access remote computers that use GDM. Be aware of the
following options:

<ul>

<li><i>Enable</i> specifies whether GDM can listen for XDM Control Protocol
(XDMCP) requests on the UDP port specified in the Port option.

</li>

<li><i>HonorIndirect</i> enables chooser broadcasts when set to true.

</li>

<li><i>MaxSessions</i> limits the number of simultaneous sessions.

</li>

<li><i>Port</i> identifies the port that GDM uses to listen for XDMCP
requests. The default is 177.

</li>

</ul> </td>

</tr>

<tr> <td>XDMCP chooser</td> <td>The XDMCP chooser section has settings that
determine whether users can see and select from a list of available servers.
Be aware of the following options:

<ul>

<li><i>Broadcast</i> enables chooser broadcasts when set to true.

</li>

<li><i>Hosts</i> lists the names of hosts outside of the local network that
display on chooser broadcast lists.

</li>

</ul> </td>

</tr>

<tr> <td>Greeter </td> <td>The greeter section has options to configure the
look and content of the login screen. Be aware of the following options:

<ul>

<li><i>ChooserButton</i> places a button on the screen that lets the user see
a list of available Xservers.

</li>

<li><i>RemoteWelcome</i> holds the string that users see when they log in
remotely.

</li>

<li><i>Welcome</i> holds the string that users see when they log in locally.
The following character pairs query the computer and show the values for the
computer in the string:

<ul>

<li><b>%%</b> returns the `%' character

</li>

<li><b>%d</b> returns the display's hostname

</li>

<li><b>%h</b> returns the fully qualified hostname

</li>

<li><b>%m</b> returns the machine (i.e., processor type)

</li>

<li><b>%n</b> returns the Nodename (i.e., hostname without .domain)

</li>

<li><b>%r</b> returns the operating system version.

</li>

<li><b>%s</b> returns the operating system.

</li>

</ul>

</li>

</ul> </td>

</tr> </table>

GDM provides scripts used to customize the login. The scripts are typically
located at **/etc/gdm/**.

  * The _Init_ script runs as root when GDM initializes the login display. It lets you initialize the display further, and specify programs to run on the login screen. 
  * The _PostLogin_ script runs just after the user types correct login credentials, but before session setup. Use it to set up the home directory, which must be done before the user starts a session.
  * The _PreSession_ script runs as the session is starting and some setup has already occurred. Use this script to register the session with utmp/wtmp.
  * The _PostSession_ script runs after the session ends. Use this script to unregister the session with utmp/wtmp.  


