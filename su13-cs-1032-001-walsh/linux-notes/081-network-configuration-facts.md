---
layout: page
title:  Network Configuration Facts
---

Linux uses the following files for network configuration:

<table>

<tr> <td><b>File or Directory</b></td> <td><b>Description</b></td>

</tr>

<tr> <td><b>/etc/init.d/network  
/etc/rc.d/init.d/network</b></td> <td>This script file loads and unloads
networking services.</td>

</tr>

<tr> <td><b>/etc/sysconfig/network-scripts</b></td> <td>This is the network
configuration file directory, which contains individual device configuration
files named ifcfg-<i>device_name</i> (e.g., ifcfg-eth0). Edit the files in
this directory to modify the following settings:

<ul>

<li>Boot protocol (static, DHCP, or BootP)

</li>

<li>Autoconfiguration information

</li>

<li>IP Address, mask, and default router (for static configurations)

</li>

</ul> </td>

</tr>

<tr> <td><b>/var/lib/dhcpcd/dhcpclient<i>n  
</i>/var/lib/dhcpcd/dhclient.leases</b></td> <td>Depending on the
distribution's daemon, one of these files exists to manage DHCP address
information.</td>

</tr> </table>

The table below shows common commands for configuring network settings.

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Example</b></td>

</tr>

<tr> <td><b>service network</b></td> <td>Start, restart, or stop networking
services.</td> <td><b>service network start </b>starts the network service.<b>  
service network restart </b>restarts the network service.</td>

</tr>

<tr> <td><b>ifconfig</b> <i><b>interface parameters</b></i></td> <td>Create a
static IP configuration for the specified interface. Common <b>ifconfig</b>
parameters include:

<ul>

<li> <b>address</b> sets the IP address

</li>

<li><b>netmask addr</b> <i>sets</i> the subnet mask

</li>

<li> <b>up </b>activates the interface

</li>

<li><b>down </b>deactivates the interface

</li>

<li> <b>broadcast</b> sets the broadcast address.

</li>

</ul></td> <td><b>ifconfig eth0 192.168.1.1 netmask addr 255.255.255.0</b>
configures a static IP address and subnet mask for eth0.  
<b>ifconfig eth0 up</b> starts the eth0 device.</td>

</tr>

<tr> <td><b>ifup</b> </td> <td>Start a network interface.</td> <td><b>ifup
eth1 </b>starts the eth1 network device.</td>

</tr>

<tr> <td><b>ifdown</b> </td> <td>Stop a network interface.</td> <td><b>ifdown
eth1 </b>stops the eth1 network device.</td>

</tr>

<tr> <td><b>ifconfig  
ifconfig <i>interface</i></b></td> <td>View network interface information. Use
the <b>-a </b>option to display the status of all interfaces.</td>
<td><b>ifconfig -a </b>displays the status of all interfaces, even those that
are down.</td>

</tr> </table>

