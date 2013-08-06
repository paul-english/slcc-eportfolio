---
layout: page
title:  Filesystem Hierarchy Standard Facts
---

The Filesystem Hierarchy Standard (FHS) governs the unified file system for
Linux systems by defining a standard set of directories, subdirectories, and
files. FHS is a subset of the Linux Standards Base (LSB) which is an
organization and a set of guidelines for promoting a set of standards to
increase Linux distribution compatibility.

<table>

<tr> <td><b>Directory</b></td> <td><b>Description</b></td>

</tr>

<tr> <td><b>/</b></td> <td>The <b>/</b> character represents the root
directory of the Linux system. All directories are below the / (root
directory) of the system.</td>

</tr>

<tr> <td><b>/bin</b></td> <td>The <b>/bin</b> directory contains binary
commands that are available to all users.</td>

</tr>

<tr> <td><b>/boot</b></td> <td>The <b>/boot</b> directory contains the kernel
and bootloader files.</td>

</tr>

<tr> <td><b>/dev</b></td> <td>The <b>/dev</b> directory contains device files
that represent the devices used by the system, such as a hard drive, mouse,
and printer.</td>

</tr>

<tr> <td><b>/etc</b></td> <td>The <b>/etc</b> directory contains configuration
files specific to the system.</td>

</tr>

<tr> <td><b>/home</b></td> <td>The <b>/home</b> directory contains by default
the user home directories.</td>

</tr>

<tr> <td><b>/lib</b></td> <td>The <b>/lib</b> directory contains shared
program libraries and kernel modules.</td>

</tr>

<tr> <td><b>/media</b></td> <td>The <b>/media</b> directory contains the
/cdrom and /floppy directories. </td>

</tr>

<tr> <td><b>/mnt</b></td> <td>The <b>/mnt</b> directory is an empty directory,
and is often used for temporarily mounted filesystems.</td>

</tr>

<tr> <td><b>/opt</b></td> <td>The<b> /opt</b> directory contains the
additional programs on the system.</td>

</tr>

<tr> <td><b>/proc</b></td> <td>The <b>/proc</b> directory contains information
about the system state and processes.</td>

</tr>

<tr> <td><b>/root</b></td> <td>The <b>/root</b> directory is the root user's
home directory. Do not confuse <b>/root</b> with the root of the system
(/).</td>

</tr>

<tr> <td><b>/sbin</b></td> <td>The <b>/sbin</b> directory contains system
binary commands.</td>

</tr>

<tr> <td><b>/srv</b></td> <td>The <b>/srv</b> directory contains files for
services such as HTTP and FTP servers.</td>

</tr>

<tr> <td><b>/sys</b></td> <td>The<b> /sys</b> directory contains the
<i>sysfs</i> virtual filesystem which displays information about devices and
drivers.</td>

</tr>

<tr> <td><b>/tmp</b></td> <td>The <b>/tmp</b> directory contains temporary
files created by programs during system use.</td>

</tr>

<tr> <td><b>/usr</b></td> <td>The <b>/usr</b> directory contains system
commands and utilities.</td>

</tr>

<tr> <td><b>/var</b></td> <td>The <b>/var</b> directory contains data files
that change constantly. Standard subdirectories include:

<ul>

<li>/var/mail (holds e-mail in boxes)

</li>

<li>/var/spool (holds files waiting for processing, such as print jobs or
scheduled jobs)

</li>

<li>/var/www (holds www or proxy cache files)

</li>

</ul> </td>

</tr> </table>

