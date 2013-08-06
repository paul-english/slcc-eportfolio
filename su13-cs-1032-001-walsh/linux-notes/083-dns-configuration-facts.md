---
layout: page
title:  Dns Configuration Facts
---

Domain Name Service (DNS) resolves IP addresses to domain names that people
can remember. The following table lists the files that administrators use to
configure DNS settings on Linux.

<table>

<tr> <td>Use...</td> <td>To...</td> <td>Examples</td>

</tr>

<tr> <td><b>/etc/hosts</b></td> <td>Provide the system with domain names for
IP addresses. The line contains the IP address, fully qualified domain name
and aliases for the domain name. This file:  

<ul>

<li>Provides name resolution when DNS is not running (for example during
system startup before DNS has started)

</li>

<li>Operates with the Network Information Service (NIS) to identify hosts.

</li>

<li>Provides information for small networks without a DNS server.

</li>

</ul> <b>Note:</b> Domain names include alphanumeric characters, periods (.),
and dashes (-), and must begin and end with alphanumeric characters.</td>
<td><b>127.0.0.1 fs4.mydomain.com localhost </b>specifies that the IP address
127.0.01 is assigned to fs4.mycomain.com and that the term localhost can be
used as an alias to specify the computer.</td>

</tr>

<tr> <td><b>/etc/resolv.conf</b></td> <td>Provide the system with the name of
the network DNS server. Up to three servers can be listed, and the servers are
accessed in the order specified. The file also has settings that append fully
qualified domain names to computer names</td> <td><b>nameserver 192.168.1.3
</b>specifies 192.168.1.3 as the IP address of the DNS server.<b>  
search mydomain.com </b>appends the domain name to computer names that do not
have a domain name. For example, <b>linux1</b> becomes <b>
linux1.mydomain.com</b>.</td>

</tr>

<tr> <td><b>/etc/nsswitch.conf</b></td> <td>Specify whether the computer's
host file or the DNS server takes precedence if there is a DNS resolution
conflict between the two.</td> <td><b>hosts: files dns </b>specifies that the
hosts file takes precedence over information obtained from a DNS server.</td>

</tr>

<tr> <td><b>/etc/HOSTNAME  
/etc/sysconfig/network</b></td> <td>Define the host and domain names. </td>
<td><b>HOSTNAME=fs1 </b>identifies the hostname as <i>fs1.</i></td>

</tr>

<tr> <td><b>host</b></td> <td>Find the IP address for a domain name.</td>
<td><b>host www.testout.com </b>displays the IP address for
www.testout.com.</td>

</tr>

<tr> <td><b>hostname</b></td> <td>Display or set the name of the local host
for the current session.</td> <td><b>hostname ls4</b> sets the hostname for
the current session to <i> ls4</i>.</td>

</tr> </table>

