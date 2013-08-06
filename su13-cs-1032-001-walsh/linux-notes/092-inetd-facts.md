---
layout: page
title:  Inetd Facts
---

Inetd is a super daemon that manages many Internet and network services
(similar to xinetd). Inetd performs the same functions as xinetd; however,
xinetd has some security features not found in inetd.

Inetd uses **/etc/inetd.conf** as the configuration file for every daemon.
Each entry in the file represents how inetd manages the daemon. Entries in
**/etc/inetd.conf ** use the following syntax:

> _Daemon    Socket    Protocol    Flag    User    Executable    Arguments_

The following table describes the configuration parameters for each entry
within the **/etc/inetd.conf** configuration file.

<table>

<tr> <td>Parameter</td> <td>Description</td>

</tr>

<tr> <td><b>Daemon</b></td> <td>Identifies the daemon being controlled. The
name should be as it appears in the <b>/etc/services</b> file</td>

</tr>

<tr> <td><b>Socket</b></td> <td>Designates the type of connection to expect
for the daemon. Socket options include:

<ul>

<li><i>stream</i> specifies a reliable connection.

</li>

<li><i>dgram </i>specifies a less reliable connection, but uses fewer
resources.

</li>

<li><i>raw </i>specifies a low-level network connection.

</li>

</ul> </td>

</tr>

<tr> <td><b>Protocol</b></td> <td>Designates whether the protocol is
Transmission Control Protocol (TCP) or User Datagram Protocol (UDP).</td>

</tr>

<tr> <td><b>Flag</b></td> <td>Specifies how the server processes the packets.
Use:

<ul>

<li><i>wait</i> for UDP connections.

</li>

<li><i>nowait</i> for TCP connections.

</li>

</ul> </td>

</tr>

<tr> <td><b>User</b></td> <td>Determines the user permissions (read, write,
and execute) the daemon will use when accessing the file system. Be aware of
the following:

<ul>

<li>Specify a user with the lowest necessary privileges.

</li>

<li>Common choices are <i>root</i> and <i>nobody</i>.

</li>

<li>Using group permissions is optional.

</li>

</ul> </td>

</tr>

<tr> <td><b>Executable</b></td> <td>Identifies the path to the daemon
executable. Be aware of the following:

<ul>

<li>Use <i>internal</i> if the daemon does not have an executable file.

</li>

<li>Use the path to the executable for external daemons, such as
<b>/usr/bin/ftpd</b>.

</li>

<li>If using TCP wrappers, use <b>/usr/sbin/tcpd</b>.

</li>

</ul> </td>

</tr>

<tr> <td><b>Arguments</b></td> <td>Assigns daemon-specific arguments.

<b>Note</b>: If using TCP wrappers, the path to the actual daemon executable
must be typed here, such as <b>/usr/bin/ftpd</b>.

</td>

</tr> </table>

The following are example entries in the **/etc/inetd.conf ** file:

<table>

<tr> <td>Entry</td> <td>Description</td>

</tr>

<tr> <td><b>ftp stream tcp nowait ftp /usr/sbin/ftpd</b></td> <td>Inetd daemon
will start the ftp daemon when necessary.</td>

</tr>

<tr> <td><b>ftp stream tcp nowait root /usr/sbin/tcpd /usr/bin/ftpd</b></td>
<td>Inetd daemon will use TCP wrappers to control which hosts can start the
ftp daemon.</td>

</tr> </table>

>  

