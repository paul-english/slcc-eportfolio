---
layout: page
title:  Ip Address Facts
---

Be aware of the following IPv4 address details:

  * An IPv4 address is a 32-bit binary number represented as four octets (four 8-bit numbers). Each octet is separated by a period. IPv4 addresses can be represented in one of two ways: 
    * Decimal (for example 131.107.2.200). In decimal notation, each octet must be between 0 and 255\. 
    * Binary (for example 10000011.01101011.00000010.11001000). In binary notation, each octet is an 8-character number. 
  * To convert from binary to decimal and vice versa, memorize the decimal equivalent to the following binary numbers: <table>
<tr> <td>10000000</td> <td>01000000</td> <td>00100000</td> <td>00010000</td>
<td>00001000</td> <td>00000100</td> <td>00000010</td> <td>00000001</td>

</tr>

<tr> <td>128</td> <td>64</td> <td>32</td> <td>16</td> <td>8</td> <td>4</td>
<td>2</td> <td>1</td>

</tr> </table> To convert from binary, take each bit position with a 1 value
and add the decimal values for that bit together. For example, the decimal
equivalent of 10010101 is: 128 + 16 + 4 + 1 = 149

  * The _subnet mask_ is a 32-bit number that is associated with each IPv4 address that identifies the network portion of the address. 
    * In binary form, the subnet mask is always a series of 1's followed by a series of 0's (1's and 0's are never mixed in sequence in the mask). A simple mask might be 255.255.255.0. 
    * In Classless Inter-Domain Routing (CIDR) form, the subnet mask appears as a slash (/) followed by the number of bits in the mask that are set to 1. A simple mask might be /24.
  * IPv4 addresses have a default _class_. The address class identifies the range of IPv4 addresses and a default subnet mask used for the range. The following table shows the default address class for each IPv4 address range. <table>
<tr> <td><b>Class</b></td> <td><b>Address Range</b></td> <td><b>First Octet
Range</b></td> <td>Default Subnet Mask</td> <td>CIDR Notation</td>

</tr>

<tr> <td>A</td> <td>1.0.0.0 to 126.255.255.255</td> <td>1-126  
(00000001--01111110 binary)</td> <td>255.0.0.0</td> <td>/8</td>

</tr>

<tr> <td>B</td> <td>128.0.0.0 to 191.255.255.255</td> <td>128-191  
(10000000--10111111 binary)</td> <td>255.255.0.0</td> <td>/16</td>

</tr>

<tr> <td>C</td> <td>192.0.0.0 to 223.255.255.255</td> <td>192-223  
(11000000--11011111 binary)</td> <td>255.255.255.0</td> <td>/24</td>

</tr>

<tr> <td>D</td> <td>224.0.0.0 to 239.255.255.255</td> <td>224-239  
(11100000--11101111 binary)</td> <td>n/a</td> <td>n/a</td>

</tr>

<tr> <td>E</td> <td>240.0.0.0 to 255.255.255.255</td> <td>240-255  
(11110000--11111111 binary)</td> <td>n/a</td> <td>n/a</td>

</tr> </table>

  * A Network Address Translation (NAT) router translates multiple private addresses into the single registered IP address. 
    * The Internet is classified as a _public_ network. All devices on the public network must have a registered IP address; this address is assigned by the ISP. 
    * The internal network is classified as a _private_ network. All devices on the private network use private IP addresses internally, but share the public IP address when accessing the Internet. 
    * A NAT router associates a port number with each private IP address. Communications with the private hosts from the Internet are sent to the public IP address and the associated port number. Port assignments are made automatically by the NAT router. 
    * The private network can use addresses in the following ranges that have been reserved for private use (i.e. they will not be used by hosts on the Internet): 
      * 10.0.0.0 to 10.255.255.255 
      * 172.16.0.0 to 172.31.255.255 
      * 192.168.0.0 to 192.168.255.255
  * _Subnetting _is the process of dividing a large network into smaller networks. When you subnet a network, each network segment (called a _subnet_) has a different network address (also called a _subnet address_). 
    * Subnetting uses_ custom _rather than the default subnet masks. For example, instead of using 255.255.255.0 with a Class C address, you might use 255.255.255.192 instead. 
    * Using custom subnet masks is often called_ classless _addressing because the subnet mask cannot be inferred simply from the class of a given IP address. The address class is ignored and the mask is always supplied to identify the network and host portions of the address.
    * Using classless addresses is made possible by CIDR. 
  * Each host must have a unique IPv4 address.
  * Each host on the same network must have an IPv4 address with a common network portion of the address. 
  * The _network address_ is the first address in the address range and cannot be assigned to a host.
  * The _broadcast address_ is the last address in the address range and is used to send messages to all hosts on the network.

The current IP addressing standard, version 4, will eventually run out of
unique addresses, so a new system is being developed. It is named IP version 6
or IPv6. The IPv6 address is a 128-bit binary number. A sample IPv6 IP address
looks like: 35BC:FA77:4898:DAFC:200C:FBBC:A007:8973. The following list
describes the features of an IPv6 address:

  * The address is made up of 32 hexadecimal numbers, organized into 8 quartets. 
  * The quartets are separated by colons. 
  * Each quartet is represented as a hexadecimal number between 0 and FFFF. Each quartet represents 16-bits of data (FFFF = 1111 1111 1111 1111). 
  * Leading zeros can be omitted in each section. For example, the quartet 0284 could also be represented by 284. 
  * Addresses with consecutive zeros can be expressed more concisely by substituting a double-colon for the group of zeros. For example: 
    * FEC0:0:0:0:78CD:1283:F398:23AB 
    * FEC0::78CD:1283:F398:23AB (concise form) 
  * If an address has more than one consecutive location where one or more quartets are all zeros, only one location can be abbreviated. For example, FEC2:0:0:0:78CA:0:0:23AB could be abbreviated as: 
    * FEC2::78CA:0:0:23AB or 
    * FEC2:0:0:0:78CA::23AB 
But _not_ FEC2::78CA::23AB

  * The 128-bit address contains two parts: <table>
<tr> <td>Component</td> <td>Description</td>

</tr>

<tr> <td>Prefix</td> <td>The first 64-bits is known as the <i>prefix</i>. <ul>

<li>The 64-bit prefix can be divided into various parts, with each part having
a specific meaning. Parts in the prefix can identify the geographic region,
the ISP, the network, and the subnet.

</li>

<li>The <i>prefix length</i> identifies the number of bits in the relevant
portion of the prefix. To indicate the prefix length, add a slash (/) followed
by the prefix length number. Full quartets with trailing 0's in the prefix
address can be omitted (for example 2001:0DB8:4898:DAFC::<b>/</b>64).

</li>

<li>Because addresses are allocated based on physical location, the prefix
generally identifies the location of the host. The 64-bit prefix is often
referred to as the <i>global routing</i> prefix.

</li></ul> </td>

</tr>

<tr> <td>Interface ID</td> <td>The last 64-bits is the <i>interface ID</i>.
This is the unique address assigned to an interface. <ul>

<li>Addresses are assigned to interfaces (network connections), not to the
host. Technically, the interface ID is <i>not</i> a host address.

</li>

<li>In most cases, individual interface IDs are not assigned by ISPs, but are
rather generated automatically or managed by site administrators.

</li>

<li>Interface IDs must be unique within a subnet, but can be the same if the
interface is on different subnets.

</li>

<li>On Ethernet networks, the interface ID can be automatically derived from
the MAC address. Using the automatic host ID simplifies administration.

</li></ul></td>

</tr> </table>

