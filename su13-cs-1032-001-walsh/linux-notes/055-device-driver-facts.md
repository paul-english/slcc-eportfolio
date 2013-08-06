---
layout: page
title:  Device Driver Facts
---

A _device driver_ is a software component that allows a hardware device to
communicate with the operating system of a computer. Drivers allow an
operating system to correct interpret and implements the signals that come
from the hardware device. The following table describes the two methods Linux
uses to implement device drivers:

<table>

<tr> <td>Method</td> <td>Description</td>

</tr>

<tr> <td>Loaded as a kernel module</td> <td>A kernel<i> module</i> is software
that the kernel accesses only when it is needed. When in use, modules run as
if they were part of the kernel and have the same access rights. Modules:

<ul>

<li>Have an .o or .ko extension.

</li>

<li>Are stored in the <b>/lib/modules/</b><i>kernel_version</i><b>/kernel/driv
ers/</b><i>driver_name</i> directory.

</li>

<li>Are linked and unlinked dynamically.

</li>

</ul> </td>

</tr>

<tr> <td>Compiled into the kernel</td> <td>When the drivers are compiled into
the kernel, it is integrated into the kernel build when the kernel is
recompiled. This method requires an administrator to recompile the kernel.
Drivers compiled into the kernel:

<ul>

<li>Should be limited to the hardware needed to boot the computer, such as
drivers for the keyboard, mouse, and disk drive.

</li>

<li>Increase the size and complexity of the kernel.

</li>

<li>Requires considerable configuration expertise.

</li>

<li>Consume additional computer resources.

</li>

</ul> </td>

</tr> </table>

The following directories contain information about the hardware that is
installed on the computer:

<table>

<tr> <td>Directory</td> <td>Contents</td>

</tr>

<tr> <td><b>/proc</b></td> <td>The <b>/proc</b> directory contains information
about the system state and processes. Its contents are created dynamically. Be
aware of the following files and directories in the <b>/proc</b> directory:

<ul>

<li><i>cmdline </i>displays the boot options that were given to the kernel at
boot time.

</li>

<li><i>cpuinfo</i> has information about the computer's CPU.

</li>

<li><i>devices</i> displays a list of hardware installed on the computer.

</li>

<li><i>dma</i> shows all the <i>direct memory access</i> assignments for the
computer. Direct memory access gives hardware devices direct access the
computer's memory independent of the CPU.

</li>

<li><i>interrupt</i> lists the interrupt request (IRQ) channels the computer
uses. Interrupt requests are signals sent to the CPU that inform it that it
needs to process input from a hardware device.

</li>

<li><i>iomem</i> contains a mapping of the memory allocated to each device and
the input/output port assignments for the memory.

</li>

<li><i>modules</i> lists the kernel modules that the computer is currently
using.

</li>

<li><i>version</i> gives information about the current kernel version.

</li>

<li><i>meminfo</i> displays detailed memory information on the system.

</li>

<li><b>/scsi</b> contains a file or directory for each SCSI device attached to
the computer.

</li>

<li><b>/bus</b> contains a file or directory for each USB device attached to
the computer.

</li>

<li><b>/ide</b> contains a file for the IDE devices attached to the computer,
including the internal hard drives and other devices that attach to an IDE
ribbon.

</li>

</ul>

Changing the system through the <b>/proc</b> directory should be attempted
only by experienced administrators. Be aware of the following facts about
changing <b>/proc</b> files:

<ul>

<li>Not every file can be modified. Some are marked read only and can only be
viewed.

</li>

<li>Do not use<b> vi </b>to view or modify files in the <b>/proc</b>
directory. Instead, use the <b>echo </b>command to redirect commands to the
appropriate files, or use other special commands.

</li>

<li>Use the<b> cat </b>command or other special commands to view files in the
<b>/proc </b>directory and sub-directories.

</li>

</ul> </td>

</tr>

<tr> <td><b>/sys</b></td> <td>The <b>/sys</b> directory displays information
about devices and drivers. Be aware of the following directories in the<b>
/sys</b> directory:

<ul>

<li><b>/block</b> has an entry for each block device on the computer. Block
devices such as flash drives and disk drives use data blocks.

</li>

<li><b>/bus</b> holds a sub-directory for SCSI, USB, PCI, and ISA devices.
Each of these sub-directories has an additional directory for devices and
drivers that has information for each device and driver in the category.

</li>

<li><b>/class</b> has files for each class of devices on the computer.

</li>

<li><b>/devices</b> lists every device that been discovered on the computer.
The directory hierarchy places each device beneath the device to which it is
connected.

</li>

<li><b>/module</b> has a sub-directory for each kernel module installed on the
computer.

</li>

</ul> </td>

</tr> </table>

Linux also includes utilities that provide extensive information about
hardware configurations, including:

<table>

<tr> <td>Use...</td> <td>To...</td> <td>Examples</td>

</tr>

<tr> <td><b>lsusb</b></td> <td>Display information on all USB devices
connected to the computer. This utility uses the following options:

<ul>

<li><b>-v</b> shows exhaustive information.

</li>

<li><b>-s </b> <i>bus_name </i>shows information for a specific bus.

</li>

</ul> </td> <td><b>lsusb -v</b> shows all information about each USB device on
the computer.</td>

</tr>

<tr> <td><b>hwinfo</b></td> <td>Display information about hardware on the
computer. Be aware of the following options:

<ul>

<li><b>\--<i>hardware_item_name</i></b> probes for a specific hardware item.
Common hardware names include:

<ul>

<li><b>bluetooth</b>

</li>

<li><b>camera</b>

</li>

<li><b>cdrom</b>

</li>

<li><b>cpu</b>

</li>

<li><b>disk</b>

</li>

<li><b>dsl</b>

</li>

<li><b>monitor</b>

</li>

<li><b>mouse</b>

</li>

<li><b>keyboard</b>

</li>

<li><b>usb</b>

</li>

</ul>

</li>

<li><b>\--short</b> shows an abbreviated list of information.

</li>

<li><b>\--listmd</b> displays RAID devices.

</li>

</ul> </td> <td><b>hwinfo --cpu</b> shows information about the computer's
CPU.</td>

</tr>

<tr> <td><b>lspci</b></td> <td>Display information for all PCI devices. Be
aware of the following options:

<ul>

<li><b>-k </b>shows the kernel drivers that support the device.

</li>

<li><b>-t </b>displays a tree diagram that shows connections between all
busses, bridges, and devices.

</li>

</ul> </td> <td><b>lspci -k</b> shows the devices and the kernel drivers that
support them.</td>

</tr> </table>

