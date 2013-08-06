---
layout: page
title:  Kdm Configuration Facts
---

The KDE Display Manager (KDM) is the display manager supported by the KDE
software organization. KDM:

  * Offers features such as letting users select a session type and shut down the computer from the login prompt screen. 
  * Uses XDM configuration files, but might use a configuration file named **kdmrc**. The kdmrc file is typically located in one of the following locations:
    * **/etc/kde/kdm/**
    * **/etc/x11/kdm/**
  * Looks to XDM during installation and copies the settings for KDM to use. This is optional.
  * Has a GUI tool called _Kcontrol_ that can configure most KDM settings.

The following table lists the general sections of the kdmrc file and describes
the most commonly used options.

<table>

<tr> <td>Sections</td> <td>Options</td>

</tr>

<tr> <td>General</td> <td>The general section holds options that affect the
overall use of KDM. Be aware of the following:

<ul>

<li><i>Xservers</i> specifies a path to the X server definitions file or
contain X server definitions.

</li>

<li>The format is similar to that used by XDM.

</li>

</ul> </td>

</tr>

<tr> <td>XDMCP</td> <td>The XDMCP support section has settings that customize
how users access remote computers that use KDM. Be aware of the following:

<ul>

<li><i>Enable</i> specifies whether kdm listens to incoming XDM Control
Protocol (XDMCP) requests.

<ul>

<li>The default value is true.

</li>

<li>If set to false, KDM does not accept incoming requests.

</li>

</ul>

</li>

<li><i>Port</i> specifies the UDP port number KDM uses to listen for incoming
XDMCP requests.

<ul>

<li>The default is 177.

</li>

<li>If set to 0, KDM does not accept incoming requests.

</li>

</ul>

</li>

<li><i>Xaccess</i> contains the path to the Xaccess file.

<ul>

<li>The Xaccess file lists the computers that can access the server using
XDMCP, and the computers that can see the chooser broadcasts. It might also
list servers to which the requests are forwarded.

</li>

<li>The default path is<b> {kde_confdir}/kdm/Xaccess</b>.

</li>

</ul>

</li>

</ul> </td>

</tr>

<tr> <td>Xgreeter</td> <td>The Xgreeter section has options to configure the
look and content of the login screen. Be aware of the following:

<ul>

<li><i>GreetString</i> holds the string users see when logging in. An empty
greeting means none at all. The following character pairs query the computer
and show the values for the computer in the string:

<ul>

<li><b>%d</b> returns the name of the current display

</li>

<li><b>%h</b> returns the local host name, possibly with the domain name

</li>

<li><b>%n</b> returns the local node name, most probably the host name without
the domain name

</li>

<li><b>%s</b> returns the operating system

</li>

<li><b>%r</b> returns the operating system version

</li>

<li><b>%m</b> returns the machine (hardware) type

</li>

<li><b>%%</b> returns the a single %

</li>

</ul>

</li>

<li>The default is "Welcome to %s at %n".

</li>

</ul> </td>

</tr> </table>

