---
layout: page
title:  Network Troubleshooting Considerations And Tools
---

When troubleshooting network communications, consider the following:

<table>

<tr> <td>Problem</td> <td>Considerations</td>

</tr>

<tr> <td>Physical issues</td> <td>The best way to verify if a connection is
valid is to check the link light on both the workstation and the hub. If the
link light is unlit, try the following:

<ul>

<li>Swap the cables. This will help determine whether the cable is the
problem.

</li>

<li>Try using a different switch or hub port for the connection.

</li>

<li>Make sure that the card is properly seated.

</li>

<li>Use loopback plugs to test network cards and cable testing devices to test
network cables.

</li>

</ul></td>

</tr>

<tr> <td>Interference</td> <td>Interference is caused by electromagnetic
fields or radio frequency interference.

<ul>

<li>For wired cables, make sure wires are not routed next to motors or
fluorescent lights that can cause interference.

</li>

<li>For wireless devices, make sure there are not other devices in the area
transmitting on the same frequency and channel (such as microwaves or cordless
phones).

</li>

<li>Check to make sure that the cable is not kinked or worn. Cables should be
routed through walls or ceilings, not strung across the floor. If a cable must
run across the floor, encase the cable to prevent wear and secure the cable in
place to prevent tripping accidents. Worn cables might introduce some
interference, or simply prevent signals from being sent properly.

</li>

</ul> </td>

</tr>

<tr> <td>Network issues</td> <td>If the device and connection to the device
appear to be working, check the following:

<ul>

<li>Check firewalls on both end devices to see if communications are being
blocked by a host-based firewall.

</li>

<li>Check the service on the target device to make sure that it is running and
is properly configured.

</li>

</ul> </td>

</tr> </table>

The following table compares some of the tools for troubleshooting network
communication problems:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td>

</tr>

<tr> <td><b>ping</b></td> <td>Verify connectivity between hosts within the
network.

<ul>

<li>Ping the special loopback address of 127.0.0.1. This tests the TCP/IP
configuration of the local host. If successful, TCP/IP is correctly
configured.

</li>

<li>Ping a destination with IP address. If there is no response, try to ping
any other host.

<ul>

<li>If your computer cannot communicate with any other computer, check the
network cable, the network interface card, or the IP address configuration on
your computer.

</li>

<li>If your computer can communicate with computers on the local network, but
can't communicate with remote computers (such as the Internet), verify the
default gateway configuration on your computer.

</li>

<li>If all computers on the local network cannot communicate with any remote
computer, troubleshoot the router's connection to the remote network.

</li>

</ul>

</li>

<li>Ping by a DNS name. If a ping by IP address works, but a ping by DNS name
fails, then there is probably a DNS problem.

</li>

<li>Use the <b>-c</b> option to specify how many ICMP echo requests to send to
the destination.

</li>

</ul> </td>

</tr>

<tr> <td><b>netstat</b></td> <td>Display a list of network connections (i.e.,
<i>sockets</i>), the routing table, and information about the network
interface. A socket is an endpoint of a bidirectional communication flow
across a computer network. Use the following options for additional
information:

<ul>

<li><b>-a </b>lists both listening and non-listening ports.

</li>

<li><b>-i</b> displays a table of all network interfaces.

</li>

<li><b>-l </b>lists listening sockets.

</li>

<li><b>-s</b> displays statistics for each protocol.

</li>

<li><b>-r </b>displays the route table and default gateway.

</li>

</ul> </td>

</tr>

<tr> <td><b>traceroute  
tracepath</b></td> <td>Test connectivity between devices, show the path
between the two devices. <b>traceroute:</b>

<ul>

<li>Can help track down which router (known as a <i>hop</i>) in the route is
not working correctly.

</li>

<li>Displays the Round Trip Time (RTT) for each hop. The RTT is the time
difference between when the probe was sent from <b>traceroute</b> and the time
the response arrived for each packet.

</li>

</ul>

<b>tracepath </b>is similar to <b>traceroute</b>, but does not require super
user privileges.

</td>

</tr>

<tr> <td><b>nslookup</b></td> <td>Send a name resolution request. To use
nslookup:

<ol>

<li>Enter <b>nslookup</b> at the shell prompt.

</li>

<li>Enter the hostname or IP address, such as 192.168.1.1.

</li>

<li>The DNS server should respond with the requested mapping.

</li>

<li>Enter<b> exit</b> when finished

</li>

</ol> </td>

</tr>

<tr> <td><b>dig</b></td> <td>Send a name resolution request and receive
extensive information about the hostname or IP address. Consider the following
options:

<ul>

<li><b>a </b>resolves a record information

</li>

<li><b>ptr</b> resolves a ptr record

</li>

<li><b>cname </b>resolves cname record information

</li>

<li><b>p </b>queries a specific port on the host

</li>

<li><b>in </b>resolves Internet record information

</li>

<li><b>mx</b> resolves mx record information

</li>

<li><b>soa</b> resolves start of authority information

</li>

</ul> </td>

</tr> </table>

