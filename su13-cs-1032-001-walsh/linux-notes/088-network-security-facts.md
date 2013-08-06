---
layout: page
title:  Network Security Facts
---

The following table describes the general procedures for increasing network
security of a Linux system:

<table>

<tr> <td>Security Task</td> <td>Procedure</td>

</tr>

<tr> <td>Remove unneeded software</td> <td>Unneeded software takes disk space
and could introduce security flaws. To remove unneeded software:

<ol>

<li>Run one of the following commands:

<ul>

<li>Use <b>yum list installed</b> to see installed RPM packages on the
computer.

</li>

<li>Use <b>dpkg âget-selections</b> to see installed Debian packages on the
computer.

</li>

</ul>

</li>

<li>Research the function of any unrecognized package to determine whether it
is necessary.

</li>

<li>Use <b>yum</b>, <b>rpm</b>, or <b>dpkg</b> to uninstall unneeded packages.

</li>

</ol> </td>

</tr>

<tr> <td>Check for unneeded network services</td> <td>Unneeded network
services waste the computer's resources and might provide attackers with an
entry point for an attack. To remove unneeded network services:

<ol>

<li>Search within the <b>/etc/init.d</b> or <b>/etc/rc.d/init.d
</b>directories for unusual or unrecognized scripts.

</li>

<li>Use the <b>man</b> command and the Internet to research the scripts'
functions and determine whether they can be safely removed or disabled.

</li>

<li>Use <b>chkconfig</b>, <b>insserv</b>, or <b>init</b> to disable the
script, or use <b>yum</b>, <b>rpm</b>, or <b>dpkg</b> remove the script
package entirely.

</li>

</ol> </td>

</tr>

<tr> <td>Locate open ports</td> <td>Open ports can provide information about
what operating system a computer uses, and might provide entry points, or
information about ways to formulate an attack. To locate open ports:

<ol>

<li>Install the <b>nmap</b> utility (if not already installed).

</li>

<li>Use one of the following commands to scan for open ports:

<ul>

<li><b>nmap -sT</b> scans for TCP ports

</li>

<li><b>nmap -sU</b> scan for UDP ports

</li>

</ul>

</li>

<li>From the results of the scan, determine which ports to close and which
services use the ports.

</li>

<li>Disable the services using ports.

</li>

</ol> </td>

</tr>

<tr> <td>Check network connections</td> <td>Open network connections (i.e.,
open sockets) on a computer also create a security risk. A <i>socket</i> is an
endpoint of a bidirectional communication flow across a computer network. Use
the following <b>netstat</b> options to identify the open network connections
on the Linux system:

<ul>

<li><b>-a </b>lists both listening and non-listening sockets.

</li>

<li><b>-l </b>lists listening sockets.

</li>

<li><b>-s</b> displays statistics for each protocol.

</li>

<li><b>-i</b> displays a table of all network interfaces.

</li>

</ul> </td>

</tr> </table>

