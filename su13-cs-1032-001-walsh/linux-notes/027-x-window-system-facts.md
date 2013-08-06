---
layout: page
title:  X Window System Facts
---

X Window System is the Graphical User Interface (GUI) for Linux systems. It is
a modular system that gives administrators control over the components that
make up X windows. The components are listed and described in the following
table.

<table>

<tr> <td>Component</td> <td>Description</td>

</tr>

<tr> <td>X server</td> <td>The <i>X server</i> is the main component of the X
Window System. The X server:

<ul>

<li>Manages input devices such as the mouse and keyboard, and it controls
output to monitors and printers.

</li>

<li>Is networked, which means that it can be accessed locally or by other
computers.

</li>

<li>Uses the display environment variable to control output; the environment
variable is <b>DISPLAY=0</b> for local systems.

</li>

<li>Has two commonly-used implementations:

<ul>

<li>Xwindows (also known as X.org or X11) is the most common X server.

</li>

<li>XFree86 is an open source version for X server.

</li>

</ul>

</li>

</ul> </td>

</tr>

<tr> <td>Window manager </td> <td>A <i>window manager</i> controls the
placement and appearance of windows on a Linux computer, such as moving,
hiding, resizing, or closing them, as well as controlling what they display.
Most distributions come with multiple window managers. Types of window
managers include:

<ul>

<li>Enlightenment (E)

</li>

<li>Sawfish

</li>

<li>Flexible Virtual Window Manager (FVWM)

</li>

<li>KDE Window Manager (KWin)

</li>

<li>Tab Window Manager (TWM)

</li>

<li>Window Maker (Wmaker)

</li>

</ul> </td>

</tr>

<tr> <td>Desktop environment </td> <td>A <i>desktop environment</i> controls
the desktop features including desktop menus, screensavers, wallpapers,
desktop icons, and taskbars. The two most common are:

<ul>

<li>GNU Network Object Model Environment (GNOME)

</li>

<li>Kool Desktop Environment (KDE)

</li>

</ul> </td>

</tr>

<tr> <td>X font server</td> <td>An <i>X font server</i> is an optional server
on the network that manages fonts for client computers, but is seldom used. X
font servers were developed when client systems were not powerful enough to
handle font rendering without using significant CPU cycles, so a single
networked server provided font rendering for the client computers.

The<i> fontpath</i> section of the <b>xorg.conf</b> file controls where a
computer looks for fonts.

<ul>

<li>An entry similar to <b>FontPath "unix:/7100"</b><i> </i>specifies that the
local computer is the font server.

</li>

<li>An entry similar to <b>FontPath "tcp/fonts.acme-u.edu"</b><i> </i>gives
the name of a<i> </i>networked font server.

</li>

</ul>

<b>Note</b>: Many Linux distributions have font tools and systems that are
unique to that distribution and may handle fonts differently. Using these
tools is the recommended way to handle fonts.

</td>

</tr> </table>

