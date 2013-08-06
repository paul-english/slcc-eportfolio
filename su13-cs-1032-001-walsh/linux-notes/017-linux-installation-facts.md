---
layout: page
title:  Linux Installation Facts
---

The following table describes the general steps necessary to install a Linux
operating system:

<table>

<tr> <td>Step</td> <td>Description</td>

</tr>

<tr> <td>Start the install</td> <td> In many cases, this step involves booting
the computer from installation media. The BIOS may need configuration to boot
from the media. Linux installers often offer different installation options,
such as:

<ul>

<li>New install

</li>

<li>Reinstall

</li>

<li>Upgrade

</li>

<li>Installation recovery

</li>

<li>Reduced feature installation

</li>

</ul> </td>

</tr>

<tr> <td>Select a language</td> <td> The selected language becomes the default
language for all users; however, it can be changed later, if necessary.</td>

</tr>

<tr> <td>Set the system time</td> <td>The system time can be set to local time
or Coordinated Universal Time (UTC) time.

<ul>

<li>For networks dispersed over multiple time zones, choosing UTC simplifies
administration tasks.

</li>

<li>Some distributions have options to synchronize the time over the network.

</li>

</ul> </td>

</tr>

<tr> <td>Format partitions</td> <td>A <i>partition</i> is a logical division
of a storage device associated with a hard disk drive. Create the partition
structure according to the specifications in your installation plan. Determine
the directory structure and file system type for each partition. This may
require initializing a hard drive. Partitioning options can include:

<ul>

<li><b>Use all space </b>makes a single partition from the entire disk drive.

</li>

<li><b>Replace existing Linux system(s) </b>re-partition<b>s</b> all the
previously installed Linux Operating systems.

</li>

<li><b>Shrink partitions</b> reduces the size of an existing partition making
room for additional partitions.

</li>

<li><b>Use free space</b> creates a partition from unpartitioned space on the
disk drive.

</li>

<li><b>Create custom layout</b> manually creates partitions according to the
specific needs of the system or administrator.

</li>

</ul>

Keep the following in mind when creating partitions:

<ul>

<li>Initializing a hard drive removes all existing data.

</li>

<li>A <i>swap</i> partition is required for virtual memory. Swap partitions
should be between one to two times as large and the amount of RAM on the
computer.

</li>

<li>Linux computers can only have four partitions, but a single extended
partition can be sub-divided into additional partitions.

</li>

<li>Create separate partitions for the following directories to keep logs or
abnormally large user files from taking all disk space, and make recovery of
data easier if the operating system crashes.

<ul>

<li><b>/home</b> (user directories)

</li>

<li><b>/opt </b>(installed software)

</li>

<li><b>/var</b> (log files)

</li>

</ul> The operating system can be reinstalled on the root partition (/) and
the others can then be remounted, with no loss to data.

</li>

</ul> </td>

</tr>

<tr> <td>Select applications and services</td> <td>Installing applications and
services depends on the role of the system. Applications and services include
the following:

<ul>

<li>The <i>boot loader</i> determines which operating system boots by default
if more than one operating system exists on a computer.

</li>

<li><i>Package patterns</i> include packages necessary for a specific computer
role, such as Graphical Desktop or Web Server.

</li>

<li><i>Package repositories</i> are locations on the Internet where software
packages are maintained. Specific Linux utilities search and install software
automatically from these package repositories.

</li>

</ul> </td>

</tr>

<tr> <td>Set the root password</td> <td>The secure password for the root user
(and any other user) should typically:

<ul>

<li>Include 8 characters or longer (longer passwords are harder to crack).

</li>

<li>Include the use of numbers and symbols in addition to letters.

</li>

<li>Do not include a username or a dictionary word (or common variations).

</li>

</ul> </td>

</tr>

<tr> <td>Specify a host name</td> <td>The name of the computer identifies the
computer on a network. A domain may be required. </td>

</tr>

<tr> <td>Configure network connections</td> <td>Configure the network
connections. </td>

</tr>

<tr> <td>Configure services</td> <td>Occasionally services must be configured
based on the role of the system, such as a Web Server.</td>

</tr>

<tr> <td>Add new users and groups</td> <td>Create user accounts and groups for
the users who will use the computer.

<ul>

<li>Installations usually require at least one standard user account.

</li>

<li>Network login options enable the system to access a server for login
information rather than maintaining local authentication information.

</li>

</ul> </td>

</tr>

<tr> <td>Configure the hardware settings</td> <td>Hardware configuration
settings might require appropriate drivers or language settings.</td>

</tr> </table>

