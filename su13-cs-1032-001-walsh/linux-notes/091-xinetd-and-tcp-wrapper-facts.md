---
layout: page
title:  Xinetd And Tcp Wrapper Facts
---

Xinetd is a super daemon that manages many Internet and network services.
Xinetd:

  * Starts and stops daemons as necessary to provide port security and conserve resources.
  * Acts based on requests from client computers.
  * Acts as an intermediary between the user requesting a network service and the actual daemon that performs the service.
  * Can be configured to grant  and deny access to specific services, based on the IP address of the computer making the request. This is known as a _TCP wrapper_.
  * Increases server latency, and might not be optimal for servers with very high request volumes.
  * Must be restarted after configuration changes.

Use the following files to configure the xinetd super daemon:

<table>

<tr> <td>File</td> <td>Description</td>

</tr>

<tr> <td><b>/etc/xinetd.conf</b></td> <td>The <b>/etc/xinetd.conf</b> file
configures the xinetd daemon. The default configuration for this file rarely
needs adjustment; however, be aware of the following parameters:

<ul>

<li><b>instances</b> sets the maximum number of concurrent requests xinetd can
support.

</li>

<li><b>log_type </b>configures the location to where xinetd writes logs. The
default is the <b>/var/log/secure</b> file.

</li>

<li><b>log_on_success</b><i> </i>determines whether successful connections are
logged.

</li>

<li><b>log_on_failure </b>determines whether failed or disallowed connections
are logged.

</li>

<li><b>cps</b> limits the number of connections per second.

</li>

<li><b>includedir/etc/xinetd.d/ </b>sets options for the configuration files
in the <b>/etc/xinetd.d/</b> directory.

</li>

</ul> </td>

</tr>

<tr> <td> <b>/etc/xinetd.d</b></td> <td>The <b>/etc/xinetd.d </b>directory
contains a file for each network daemon managed by xinetd. The configuration
file determines how xinetd will enable the network daemon. Be aware of the
following parameters:

<ul>

<li><b>disable</b> enables and disables the daemon.

</li>

<li><b>service</b> names the daemon. The name often comes from the<b>
/etc/services</b> file.

</li>

<li><b>socket_type</b> determines whether the socket type is a stream.

</li>

<li><b>wait</b> specifies whether the daemon is single-threaded or multi-
threaded Yes specifies single-threaded.

</li>

<li><b>user</b> determines the user under which the daemon runs.

</li>

<li><b>server</b> lists the path to the executable.

</li>

<li><b>log_on_failure</b><i> </i>defines logging specifications for failed
logins.

</li>

</ul>

<b>Note</b>: Each enabled daemon requires an exception in the host-based
firewall to open the port for that daemon.

</td>

</tr> </table>

TCP wrappers (tcpd) use the IP addresses of incoming network packets to allow
or deny access to computers or daemons. Xinetd can use TCP wrappers to
restrict access to enabled daemons. To use TCP wrappers with xinetd, consider
the following steps:

<table>

<tr> <td>Step</td> <td>Description</td> <td>Examples</td>

</tr>

<tr> <td>Install/Verify the TCP wrappers package is installed.</td> <td>Ensure
that the TCP wrappers package (<b>tcpd</b>) is installed with the <b>rpm
-q</b> or <b>dpkg -d</b> commands.</td> <td><b>rpm -q tcpd</b> uses the rpm
utility to determine whether tcpd is installed.  
<b>dpkg -s tcpd</b> performs the identical function on Debian
distributions.</td>

</tr>

<tr> <td>Edit<b> </b> the<b> </b>daemon files in <b> /etc/xinetd.d</b>.</td>
<td>

Edit and save the<b> /etc/xinetd.d</b> daemon file(s) for the daemon(s) as
follows:

<ul>

<li>Comment out the existing <b>server=</b> line with the number/pound
(<b>#</b>) symbol.

</li>

<li>Add the line <b>server = /usr/sbin/tcpd</b> to send requests through tcpd
so it can grant or deny access.

</li>

<li>Add the line <b>server_args = <i>daemonpath</i> </b>to provide the tcpd
daemon with the location of the path to the executable file of the service.

</li>

<li>Set the <i>disable</i> line to <b>no</b>.

</li>

</ul> </td> <td><b># server = /usr/bin/rsync</b> tells the computer to treat
this line as a comment and ignore it.  
<b>server = /usr/sbin/tcpd </b> replaces the direct path to the executable
with the path to tcpd so the request can be filtered.  
<b>server_args = /usr/bin/rsync </b>specifies the executable to be started if
access is granted.  
<b>disable = no</b> enables the service through xinetd.d.</td>

</tr>

<tr> <td>Restart xinetd.</td> <td>Restart the xinetd to enforce the changes
made to the <b>/etc/xinetd.d</b> daemon file(s).</td> <td><b>service inetd
restart </b>restarts the daemon on computers that use the path specified. Some
distributions place the daemon in another location.</td>

</tr>

<tr> <td>Modify <b>tcpd</b> control files.</td> <td>Modify the following
<b>tcpd</b> control files to determine which computers can access the
services:

<ul>

<li><b>/etc/hosts.deny</b> denies services to the specified host(s) or
subnets.

</li>

<li><b>/etc/hosts.allow</b> permits services to the specified host(s) or
subnets.

</li>

</ul>

Be aware of the following details:

<ul>

<li>The <b>/etc/hosts.deny</b> is read and applied before<b>
/etc/hosts.allow</b>. In each of these files, if <b>tcpd</b> matches a rule,
all remaining rules are ignored.

</li>

<li>Rules in the <b>hosts.allow</b> file override rules in the <b>
hosts.deny</b> file.

</li>

</ul>

Both files have the following syntax:

<ul>

<li>Use <b><i>service: ipaddresses</i> </b>to specify the host(s).

</li>

<li>Use <b><i>service</i>: <i>subnet</i> </b>to specify a subnet.

</li>

</ul> </td> <td><b>ALL:192.168.0.0/255.255.255.0</b> specifies all computers
on the <i>192.168.*.*</i> network. <i>ALL</i> specifies all services. The
subnet mask follows the network.  
<b>ftp:192.168.10.10</b> specifies <i>ftp</i> access for only the computer
with the IP address of 192.168.10.10  
<b>sshd:192.168.</b> specifies <i>sshd</i> access for all computers on the
<i>192.168.*.*</i> network.  
<b>sshd:ALL</b> specifies <i>sshd</i> access for all computers.  
<b>sshd:ALL EXCEPT fs1</b> specifies <i>sshd</i> access for all computers but
<i>fs1</i>. </td>

</tr>

<tr> <td>Confirm TCP wrapper configuration</td> <td>Use <b>tcpdchk</b> to test
and display any potential or real problems with the TCP wrapper configuration.
<b>tcpdchk</b> compares the <b>/etc/hosts.deny </b> and<b>
/etc/hosts.allow</b> files against the configuration files.</td> <td> </td>

</tr> </table>

