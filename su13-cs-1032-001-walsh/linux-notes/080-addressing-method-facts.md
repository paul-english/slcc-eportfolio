---
layout: page
title:  Addressing Method Facts
---

The following table lists several options for assigning IP addresses.

<table>

<tr> <td><b>Method</b></td> <td><b>Uses</b></td>

</tr>

<tr> <td>Static (manual) assignment</td> <td>Using static addressing, IP
configuration information must be manually configured on each host. Use static
addressing:

<ul>

<li>On networks with a very small number of hosts.

</li>

<li>On networks that do not change often or that will not grow.

</li>

<li>To permanently assign IP addresses to hosts that must have always have the
same address (such as printers, servers, or routers).

</li>

<li>For hosts that cannot accept an IP address from DHCP.

</li>

<li>To reduce DHCP-related traffic.

</li>

</ul> <b>Note:</b> Static addressing is very susceptible to configuration
errors and duplicate IP address configuration errors (two hosts that have been
assigned the same IP address). Static addressing also disables both APIPA and
DHCP capabilities on the host.</td>

</tr>

<tr> <td>Dynamic Host Configuration Protocol (DHCP) assignment</td> <td>A DHCP
server is a special server configured to pass out IP address and other IP
configuration information to network clients.

<ul>

<li>When a client boots, it contacts the DHCP server for IP configuration
information.

</li>

<li>The DHCP server is configured with a range of IP addresses it can assign
to hosts (Microsoft calls these ranges<i> scopes</i>).

</li>

<li>The DHCP server can also be configured to pass out other IP configuration
such as the default gateway and DNS server addresses.

</li>

<li>The DHCP server ensures that each client has a unique IP address.

</li>

<li>The DHCP server can be configured to not assign specific addresses in the
range, or to assign a specific address to a specific host.

</li>

<li>The DHCP server assigns the IP address and other information to the
client. The assignment is called a<i> lease</i>, and includes a lease time
that identifies how long the client can use the IP address.

</li>

<li>Periodically and when the client reboots, it contacts the DHCP server to
renew the lease on the IP address.

</li>

<li>The DHCP lease process uses frame-level broadcasts. For this reason, DHCP
requests typically do not pass through routers to other subnets. To enable
DHCP across subnets:

<ul>

<li>Enable BootP (DHCP broadcast) requests through the router.

</li>

<li>Configure a computer for BootP forwarding to request IP information on
behalf of other clients.

</li>

</ul>

</li>

<li>You can configure a DHCP server to deliver the same address to a specific
host each time it requests an address. Microsoft calls this configuration a<i>
reservation</i>.

</li>

<li>DHCP is a TCP/IP protocol. Any client configured to use DHCP can get an IP
address from any server configured for DHCP, regardless of operating system.

</li>

</ul> Use DHCP for small, medium, or large networks. DHCP requires a DHCP
server and minimal configuration. </td>

</tr> </table>

