---
layout: page
title:  Common Ip Protocols
---

A _protocol_ is a set of standards for communication between network hosts.
Protocols often provide services, such as e-mail or file transfer. Most
protocols are not intended to be used alone, but instead rely on and interact
with other dependent or complimentary protocols. A group of protocols that is
intended to be used together is called a protocol _suite_.

The Internet Protocol (IP) protocol suite (commonly referred to as TCP/IP) is
the most widely used protocol suite today. The following table lists several
protocols in the IP protocol suite.

<table>

<tr> <td>Protocol</td> <td><b>Description</b></td>

</tr>

<tr> <td>Internet Protocol (IP)</td> <td>Internet Protocol (IP) is the main
protocol used on the Internet. It is a connectionless protocol that makes
routing path decisions. It also handles logical addressing issues through the
use of IP addresses.</td>

</tr>

<tr> <td>Transmission Control Protocol (TCP)</td> <td>TCP provides services
that ensure accurate and timely delivery of network communications between two
hosts. TCP is a connection-oriented protocol. TCP provides the following
services to ensure message delivery:

<ul>

<li>Sequencing of data packets

</li>

<li>Flow control

</li>

<li>Error checking

</li>

</ul> </td>

</tr>

<tr> <td>User Datagram Protocol (UDP)</td> <td>UDP is a connectionless
protocol. UDP is a host-to-host protocol like TCP. However, it does not
include mechanisms for ensuring timely and accurate delivery. Because it has
less overhead, it offers fast communications, but at the expense of possible
errors or data loss. </td>

</tr>

<tr> <td>Internet Control Message Protocol (ICMP)</td> <td>ICMP works closely
with IP in providing error and control information, by allowing hosts to
exchange packet status information, which helps move the packets through the
internetwork. Two common management utilities,<b> ping </b>and
<b>traceroute</b>, use ICMP messages to check network connectivity. ICMP also
works with IP to send notices when destinations are unreachable, when devices'
buffers overflow, the route and hops packets take through the network, and
whether devices can communicate across the network.</td>

</tr>

<tr> <td>Internet Group Membership Protocol (IGMP)</td> <td>IGMP is a protocol
for defining host groups. All group members can receive broadcast messages
intended for the group (called multicasts). Multicast groups can be composed
of devices within the same network or across networks (connected with a
router).</td>

</tr>

<tr> <td>HyperText Transfer Protocol (HTTP)</td> <td>HTTP is used by Web
browsers and Web servers to exchange files (such as Web pages) through the
World Wide Web and intranets. HTTP can be described as an information
requesting and responding protocol. It is typically used to request and send
Web documents, but is also used as the protocol for communication between
agents using different IP protocols.</td>

</tr>

<tr> <td>HTTP over SSL (HTTPS)</td> <td>HTTPS is a secure form of HTTP that
uses SSL to encrypt data before it is transmitted.</td>

</tr>

<tr> <td>Secure Sockets Layer (SSL)</td> <td>SSL secures messages being
transmitted on the Internet. It uses RSA for authentication and encryption.
Web browsers use SSL (Secure Sockets Layer) to ensure safe Web transactions.
URLs that begin with<i> https:// </i>trigger your Web browser to use SSL.
</td>

</tr>

<tr> <td>Transport Layer Security (TLS)</td> <td>TLS ensures that messages
being transmitted on the Internet are private and tamper proof. TLS is
implemented through two protocols:

<ul>

<li>TLS Record--Can provide connection security with encryption (with DES for
example).

</li>

<li>TLS Handshake--Provides mutual authentication and choice of encryption
method.

</li>

</ul> TLS and SSL are similar but not interoperable.</td>

</tr>

<tr> <td>File Transfer Protocol (FTP)</td> <td>FTP provides a generic method
of transferring files. It can include file security through usernames and
passwords, and it allows file transfer between dissimilar computer systems.
FTP can transfer both binary and text files, including HTML, to another host.
FTP URLs are preceded by<i> ftp:// </i>followed by the DNS name of the FTP
server. To log in to an FTP server, use:<i>
ftp://username@servername</i>.</td>

</tr>

<tr> <td>Trivial File Transfer Protocol (TFTP)</td> <td>TFTP is similar to
FTP. It lets you transfer files between a host and an FTP server. However, it
provides no user authentication and no error detection. TFTP is often used
when transferring files such as video, audio, or images. Because it does not
perform error detection, TFTP is faster than FTP, but might be subject to file
errors.</td>

</tr>

<tr> <td>Secure File Transfer Protocol (SFTP)</td> <td>

SFTP is a file transfer protocol that uses Secure Shell (SSH) to secure data
transfers. SSH ensures that SFTP transmissions use encrypted commands and data
which prevent data from being transmitted over the network in clear text.

</td>

</tr>

<tr> <td>Secure Copy (SCP)</td> <td>SCP is associated with Unix/Linux networks
and used to transfer files between systems. Like SFTP, SCP relies on SSH to
ensure that data and passwords are not transmitted over the network in clear
text.</td>

</tr>

<tr> <td>Simple Mail Transfer Protocol (SMTP) </td> <td>SMTP is used to route
electronic mail through the internetwork. SMTP is used:

<ul>

<li>Between mail servers for sending and relaying mail.

</li>

<li>By all e-mail clients to send mail.

</li>

<li>By some e-mail client programs, such as Microsoft Outlook, for receiving
mail from an Exchange server.

</li>

</ul> </td>

</tr>

<tr> <td>Internet Message Access Protocol (IMAP)</td> <td>IMAP is an e-mail
retrieval protocol designed to enable users to access their e-mail from
various locations without the need to transfer messages or files back and
forth between computers. Messages remain on the remote mail server and are not
automatically downloaded to a client system. <b>Note</b>: An e-mail client
that uses IMAP for receiving mail uses SMTP for sending mail.</td>

</tr>

<tr> <td>Post Office Protocol 3 (POP3)</td> <td>POP3 is part of the TCP/IP
protocol suite and used to retrieve e-mail from a remote server to a local
client over a TCP/IP connection. With POP3, e-mail messages are downloaded to
the client. <b>Note</b>: An e-mail client that uses POP3 for receiving mail
uses SMTP for sending mail.</td>

</tr>

<tr> <td>Dynamic Host Configuration Protocol (DHCP)</td> <td>DHCP is a method
for automatically assigning addresses and other configuration parameters to
network hosts. Using a DHCP server, hosts receive configuration information at
startup, reducing the amount of manual configuration required on each host.
</td>

</tr>

<tr> <td>Domain Name System (DNS)</td> <td>DNS is a system that is distributed
throughout the internetwork to provide address/name resolution. For example,
the name <b>www.mydomain.com</b> would be identified with a specific IP
address.</td>

</tr>

<tr> <td>Network Time Protocol (NTP)</td> <td>NTP is used to communicate time
synchronization information between systems on a network.</td>

</tr>

<tr> <td>Network News Transport Protocol (NNTP)</td> <td>NNTP is the most
widely-used protocol that manages notes posted on Usenet Newsgroups.</td>

</tr>

<tr> <td>Lightweight Directory Access Protocol (LDAP)</td> <td>LDAP is used to
allow searching and updating of a directory service. The LDAP directory
service follows a client/server model. One or more LDAP servers contain the
directory data, the LDAP client connects to an LDAP Server to make a directory
service request.</td>

</tr>

<tr> <td>Simple Network Management Protocol (SNMP)</td> <td>SNMP is a protocol
designed for managing complex networks. SNMP lets network hosts exchange
configuration and status information. This information can be gathered by
management software and used to monitor and manage the network.</td>

</tr>

<tr> <td>Remote Terminal Emulation (Telnet)</td> <td>Telnet allows an attached
computer to act as a dumb terminal, with data processing taking place on the
TCP/IP host computer. It is still widely used to provide connectivity between
dissimilar systems. Telnet can also be used to test a service by the use of
HTTP commands.</td>

</tr>

<tr> <td>Secure Shell (SSH)</td> <td>SSH allows for secure interactive control
of remote systems. SSH is a secure and acceptable alternative to Telnet. SSH
uses public key cryptography for both connection and authentication. </td>

</tr> </table>

