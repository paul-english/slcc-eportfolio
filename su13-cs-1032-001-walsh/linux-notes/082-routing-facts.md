---
layout: page
title:  Routing Facts
---

A _router_ is a device that sends packets from one network to another network.
Routers receive packets, read their headers to find addressing information,
and send them on to their correct destination on the network or Internet.
Routers can forward packets through an internetwork by maintaining routing
information in a database called a _routing table_. Every Linux system
maintains a route table in RAM that it uses to determine where to send data on
a network. The routing table typically contains the following information:

  * The address of a known network 
  * The interface or next hop router used to reach the destination network 
  * A cost value (also called a _metric_) that identifies the desirability of the route to the destination network (using distance, delay, or cost)
  * A timeout value that identifies when the route expires 

The _default router_ (also known as _gateway router _and _default gateway
router_) is a device that performs the act of routing, and enables a host to
communicate with other hosts on other networks through the process of routing.
The default router IP address:

  * Must be configured on each host to allow inter-network communication. Without the default router, hosts will only be able to communicate with devices within the same subnet. 
  * Must be on the same subnet as the host computer. Routers have multiple network interface cards attached to multiple networks. When configuring the default router, choose the address on the local subnet. 
  * Is stored in the** /etc/sysconfig/network/routes **file. Changes to the** /etc/sysconfig/network/routes** file will not take effect until the network interface is restarted. 

The table below shows common commands for configuring routing:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Example</b></td>

</tr>

<tr> <td><b>route add </b> </td> <td>Add a static route in the routing table.

<ul>

<li><b>default gw</b> creates a route for the default router.

</li>

<li><b>-net</b> specifies a network address.

</li>

<li><b>-host</b> specifies a single host on the network.

</li>

<li><b>reject</b> installs a blocking route.

</li>

</ul> </td> <td><b>route add default gw 192.168.1.1 </b>adds the default
router 192.168.1.1.  
<b>route add -net 15.0.0.0 netmask 255.0.0.0</b> <b>dev eth0 </b>adds a route
to the 15.0.0.0/8 network.  
<b>route add -host 15.0.0.1 gw 10.0.20.1 </b>adds a static route to the
15.0.0.1 host.  
<b>route add -net 10.0.0.0 netmask 255.0.0.0 reject</b> installs a rejecting
route for the 10.0.0.0/8 network.</td>

</tr>

<tr> <td><b>route del</b> </td> <td>Delete a static route in the routing
table. </td> <td><b>route del -net 172.18.0.0 netmask 255.255.0.0</b> deletes
a route to the 17.18.0.0/16 network</td>

</tr>

<tr> <td><b>route</b></td> <td>View the routing table and the default gateway
address. </td> <td> </td>

</tr> </table>

