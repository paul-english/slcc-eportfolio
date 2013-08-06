---
layout: page
title:  Window Manager And Desktop Environment Configuration Facts
---

When installing a Linux distribution, the installation utility often installs
several window managers, but only one desktop environment. The following steps
describe how to configure a new window manager or desktop environment on a
System V distribution:

  1. Download the Red Hat Package Manager (RPM) package from the Internet or get the installation files from the distribution medium.   
**Note**: Ensure that you have the correct package version for the CPU architecture and distribution.
  2. Install the files using the RPM utility.
  3. Log out of the computer. When logging back in, find the tool for selecting installed window managers and desktop environments.
  4. Modify the hidden file to make the new window manager or desktop environment the default, by replacing the **$WINDOWMANAGER** value with the name of the window manager or desktop environment you want to use.
    * In runlevel 3, modify the hidden file **.xinitrc**. 
    * In runlevel 5, modify one of the following hidden files: **.Xsession**, **.Xdefaults**, or **.Xclients**. 
  5. Restart the X server.

Use the following commands to start a specific application if the system does
not have a graphical interface enabled.

<table>

<tr> <td>Use...</td> <td>To launch the...</td>

</tr>

<tr> <td><b>exec startkde</b></td> <td>KDE desktop environment </td>

</tr>

<tr> <td><b>exec gnome-session</b></td> <td>Gnome desktop environment </td>

</tr>

<tr> <td><b>exec fvwm</b></td> <td>Flexible Virtual Window Manager</td>

</tr>

<tr> <td><b>exec</b> <b>sawfish</b></td> <td>Sawfish window manager</td>

</tr>

<tr> <td><b>exec</b> <b>wmaker</b></td> <td>Window Manager</td>

</tr>

<tr> <td><b>exec</b> <b>twm</b></td> <td>Tab Window Manager</td>

</tr> </table>

