---
layout: page
title:  X Server Configuration Facts
---

Before configuring the X server, administrators must gather certain
information about their hardware, such as:

  * Manufacturer and model number of video board and monitor
  * Video board specifications, including:
    * Amount of memory 
    * Maximum resolution
    * Maximum color depth 
    * Chipset
  * Monitor sync rate (horizontal and vertical)

Configuration settings are contained in a file in the **/etc** directory. For
the two most common X server implementations, the configuration files are:

  * **/etc/X11/xorg.conf **(X.org)
  * **/etc/X11/XF86Config **(XFree86)

The configuration files include the following sections:

<table>

<tr> <td>Section Name</td> <td>Description</td>

</tr>

<tr> <td>Files </td> <td>The Files section Lists paths to files the server
needs. These can include font paths, RGB color database, server modules and so
forth. </td>

</tr>

<tr> <td>ServerFlags </td> <td>The ServerFlags section contains global server
options. Many of these are for advanced configuration and debugging. </td>

</tr>

<tr> <td>Module </td> <td>The Module section specifies which server modules
should load.</td>

</tr>

<tr> <td>InputDevice </td> <td>The InputDevice section has settings that give
the properties for input devices. These include driver paths, device names,
and options such as keyboard languages.</td>

</tr>

<tr> <td>Device </td> <td>The Device section holds the information the server
needs to use the graphics cards.</td>

</tr>

<tr> <td>VideoAdaptor </td> <td>The VideoAdaptor section has description for X
video.</td>

</tr>

<tr> <td>Monitor </td> <td>The Monitor section holds monitor specific
information such as the sync rate and the refresh rates. </td>

</tr>

<tr> <td>Mode</td> <td>The Mode section holds settings for using different
monitor modes, if necessary.</td>

</tr>

<tr> <td>Screen </td> <td>The Screen section has configurations for resolution
, color depth, and so on.</td>

</tr>

<tr> <td>ServerLayout </td> <td>The ServerLayout section holds information
that binds all input and output devices together to form a complete
configuration.</td>

</tr>

<tr> <td>DRI </td> <td>DRI (Direct Rendering Infrastructure) has
specifications for video rendering and 3d acceleration. </td>

</tr>

<tr> <td>Vendor </td> <td>The Vendor section allows vendors to create vendor-
specific configuration settings.</td>

</tr> </table>

While administrators can edit the configuration file sections manually, it is
recommended to use the configuration utilities that come bundled with the
distribution. The following table describes utilities used with the X server:

<table>

<tr> <td>X Server Type</td> <td>Utility</td> <td>Description</td>
<td>Command</td>

</tr>

<tr> <td>X.org</td> <td>YaST</td> <td>Yet another Setup Tool (YaST) is used in
openSUSE.  </td> <td><b>yast2</b></td>

</tr>

<tr> <td>SaX</td> <td>SaX is a SUSE configuration tool similar to YaST.  </td>
<td> <b>sax2</b> </td>

</tr>

<tr> <td>system-config-display</td> <td>Fedora and Red Hat computers running
X.org use this tool for configuring video board, and monitor settings.  </td>
<td> <b>system-config-display</b></td>

</tr>

<tr> <td>system-config-keyboard</td> <td>Fedora and Red Hat computers running
X.org use this tool for configuring keyboard settings. </td> <td> <b>system-
config-keyboard</b></td>

</tr>

<tr> <td>system-config-mouse</td> <td>Fedora and Red Hat computers running
X.org use this tool for configuring mouse settings. </td> <td> <b>system-
config-mouse</b></td>

</tr>

<tr> <td>Xorg</td> <td>Xorg is a command-line tool that creates an initial
xorg.conf file. It detects hardware and creates a basic configuration file for
it. This tool is used when no graphical environment is present. </td>
<td><b>Xorg -configure</b></td>

</tr>

<tr> <td>xorgconfig</td> <td>Xorgconfig is a command-line tool that scans your
hardware and configures it. You can also use it to change settings on hardware
devices. This tool is used when no graphical environment is present.</td> <td>
<b> xorgconfig</b></td>

</tr>

<tr> <td>xorgcfg</td> <td>Xorgcfg is a graphical tool that can make changes on
a computer that has a running graphical environment.</td>

</tr>

<tr><td> <b>xorgcfg</b> </td>

</tr>

<tr> <td>XFree86 </td> <td>Xconfigurator</td> <td>Xconfigurator sets up the
necessary configuration files and file links to use XFree86 on a Red Hat
system. Use <b>\--hsync and --vsync</b> to set the horizontal and vertical
sync settings.</td> <td> <b> Xconfigurator</b> </td>

</tr>

<tr> <td>XFree-86</td> <td>XFree-86 is a command-line tool that creates an
initial XF86Config file. It detects hardware and creates a basic configuration
file for it. This tool is used when no graphical environment is present.</td>
<td> <b>XFree-86 -configure</b> </td>

</tr>

<tr> <td>xf86config</td> <td>Xf86config is a command-line tool that scans your
hardware and configures it. You can also use it to change settings on hardware
devices. This tool is used when no graphical environment is present.</td> <td>
<b> xf86config</b> </td>

</tr>

<tr> <td>xf86cfg</td> <td>Xf86cfg is a graphical tool that can make changes on
a computer that has a running graphical environment. </td> <td> <b>xf86cfg</b>
</td>

</tr>

<tr> <td>xvidtune</td> <td>Xvidtune enables fine tuning of the monitor
settings in XFree86 computers. It is also compatible with and used on X.org
Xservers. </td> <td> <b>xvidtune</b> </td>

</tr> </table>

When configuring the X server, keep the following in mind:

  * Always test the configuration before implementing it using the testing tools associated with the editing tool.
  * Restart the X server to implement the changes. Use one of the following methods:
    * Restart the computer
    * Log out and in
    * Press Ctrl-Alt-Backspace
  * Type **startx** in a command line to start an X server if no graphical interface is running.
  * If manual edits to the X server configuration file is unavoidable, make a backup of the old file before making the changes.

