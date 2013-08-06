---
layout: page
title:  Hotplug And Coldplug Device Facts
---

Be aware of the following device categories when managing hardware:

<table>

<tr> <td><b>Category</b></td> <td><b>Description</b></td>

</tr>

<tr> <td>Coldplug</td> <td><i>Coldplug </i> devices should only be removed or
replaced when the power to the computer is off. Attempting to remove these
devices while the power is on can damage the computer. Coldplug devices
include:

<ul>

<li>RAM (Random-access Memory) chips

</li>

<li>CPU (Central Processing Unit)

</li>

<li>Expansion cards, such as Peripheral Component Interconnect (PCI) or PCI
Express cards

</li>

<li>Hard disk drives

</li>

</ul> </td>

</tr>

<tr> <td>Hotplug</td> <td><i>Hotplug </i> devices can be removed while the
computer is on. Linux uses software designed to detect these changes as the
devices are added and removed. Hotplug devices include:

<ul>

<li>USB flash drives

</li>

<li>FireWire devices

</li>

</ul></td>

</tr> </table>

Linux uses the following components to manage devices:

<table>

<tr> <td><b>Component</b></td> <td><b>Description</b></td>

</tr>

<tr> <td>sysfs </td> <td><i>sysfs</i> is a virtual file system mounted at
<b>/sys</b> which exports information about hotplug devices so that other
utilities can access the information.</td>

</tr>

<tr> <td>Hardware Abstraction Layer (HAL) daemon</td> <td>The Hardware
Abstraction Layer (HAL) daemon (hald) provides all applications with data
about current hardware. hald runs constantly.</td>

</tr>

<tr> <td>Desktop Bus (D-Bus) daemon</td> <td>The Desktop Bus (D-Bus) daemon
allows processes to communicate with each other and notify them of new hotplug
devices.</td>

</tr>

<tr> <td>/udev</td> <td><i>udev</i> is a virtual file system that dynamically
creates device files as devices are added and removed. udev uses:

<ul>

<li><b>/etc/udev/udev.conf</b> as the configuration file. The configuration
file contains the error reporting level for hotplug device errors.

</li>

<li><b>/etc/udev/rules.d/</b> to name devices.

</li>

</ul> </td>

</tr> </table>

