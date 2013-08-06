---
layout: page
title:  Common Ports
---

Network ports are logical connections, provided by the TCP or UDP protocols.
The IP protocol stack uses port numbers to determine what protocol incoming
traffic should be directed to. Some characteristics of ports are listed below:

  * Ports allow a single host with a single IP address to run network services. Each port number identifies a distinct service.
  * Each host can have over 65,000 ports per IP address.
  * Port use is regulated by the Internet Corporation for Assigning Names and Numbers (ICANN).

 ICANN specifies three categories for ports.

  * _Well known_ ports range from 0 to 1023 and are assigned to common protocols and services. 
  * _Registered_ ports range from 1024 to 49151 and are assigned by ICANN to a specific service. 
  * _Dynamic_ (also called _private_ or _high_) ports range from 49,152 to 65,535 and can be used by any service on an ad hoc basis. Ports are assigned when a session is established, and released when the session ends. 

The following table lists the well known ports that correspond to common
Internet services.

<table>

<tr> <td>Port(s)</td> <td>Service</td>

</tr>

<tr> <td>20 TCP  
21 TCP</td> <td>File Transfer Protocol (FTP)</td>

</tr>

<tr> <td>22 TCP and UDP</td> <td>Secure Shell (SSH)</td>

</tr>

<tr> <td>23 TCP</td> <td>Telnet</td>

</tr>

<tr> <td>25 TCP</td> <td>Simple Mail Transfer Protocol (SMTP)</td>

</tr>

<tr> <td>53 TCP and UDP</td> <td>Domain Name Server (DNS)</td>

</tr>

<tr> <td>67 UDP  
68 UDP</td> <td>Dynamic Host Configuration Protocol (DHCP)</td>

</tr>

<tr> <td>69 UDP</td> <td>Trivial File Transfer Protocol (TFTP)</td>

</tr>

<tr> <td>80 TCP</td> <td>HyperText Transfer Protocol (HTTP)</td>

</tr>

<tr> <td>110 TCP</td> <td>Post Office Protocol (POP3)</td>

</tr>

<tr> <td>119 TCP</td> <td>Network News Transport Protocol (NNTP)</td>

</tr>

<tr> <td>123 UDP</td> <td>Network Time Protocol (NTP)</td>

</tr>

<tr> <td>137 UDP  
138 UDP  
139 TCP</td> <td>NetBIOS</td>

</tr>

<tr> <td>143 TCP and UDP</td> <td>Internet Message Access Protocol
(IMAP4)</td>

</tr>

<tr> <td>161 TCP and UDP  
162 TCP and UDP</td> <td>Simple Network Management Protocol (SNMP)</td>

</tr>

<tr> <td>389 TCP and UDP</td> <td>Lightweight Directory Access Protocol</td>

</tr>

<tr> <td>443 TCP and UDP</td> <td>HTTP with Secure Sockets Layer (SSL)</td>

</tr> </table>

Be aware of the following:

  * **/etc/services** lists all network services on the Linux system, including the port assigned to the service. Most applications reference** /etc/services** for which service is using a specific TCP/UDP port.
  * To protect a server, ensure that only the necessary ports are opened. For example, if the server is only being used for e-mail, then shut down ports that correspond to FTP, DNS, and HTTP (among others).

