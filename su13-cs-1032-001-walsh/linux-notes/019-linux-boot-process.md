---
layout: page
title:  Linux Boot Process
---

The boot process for a Linux computer includes the following general stages:

<table>

<tr> <td>Stage</td> <td>Process</td>

</tr>

<tr> <td>BIOS</td> <td>In the BIOS stage, BIOS is loaded and the system
hardware is identified. The following steps take place:

<ol>

<li>Power is supplied to the processor. The processor is hard-coded to look at
a special memory address for code to execute.

</li>

<li>This memory address contains a pointer or jump program which instructs the
processor where to find the BIOS program.

</li>

<li>The processor loads the BIOS program. The first BIOS process to run is the
power on self test (POST).

</li>

<li> If the POST is successful, the BIOS identifies other system devices. It
uses CMOS settings and information supplied by the devices themselves to
identify and configure hardware devices. Plug and Play devices are allocated
system resources. The system typically displays information about the
keyboard, mouse, and IDE drives in the system. Following this summary,
information about devices and system resources is displayed.

</li>

<li>The BIOS then searches for a boot sector using the boot order specified in
the CMOS.

</li>

</ol> </td>

</tr>

<tr> <td>Boot loader</td> <td>During the boot loader stage, BIOS gives control
to the boot loader program. The following steps take place:

<ol>

<li>BIOS searches the boot sector which contains a Master Boot Record (MBR).

</li>

<li>BIOS loads the primary boot loader code from the MBR.

</li>

<li>The primary boot loader does one of the following:

<ul>

<li>It examines the partition table marked as bootable, and then loads the
boot sector from that partition. This boot sector contains a secondary boot
loader, which locates an OS kernel.

</li>

<li>It locates an OS kernel directly without using a secondary boot loader.

</li>

</ul>

</li>

<li>When the secondary boot loader is in RAM and executing, a splash screen is
commonly displayed, and an optional initial RAM disk (i.e., initrd image) is
loaded into memory. The initrd image:

<ul>

<li>Has root permissions and can be used to access the actual /root file
system regardless of whether it exists on the local computer or an external
device. Without the permissions, the computer could not access the file
systems without being able to read information that only exists on those file
systems.

</li>

<li>Is used to mount the actual file system and load the kernel into RAM.

</li>

</ul>

</li>

<li>With the images ready, the secondary boot loader invokes the kernel image.

</li>

</ol></td>

</tr>

<tr> <td>OS Kernel</td> <td>During this stage, the Linux kernel takes over.
The kernel:

<ol>

<li>Resides in the <b>/boot</b> directory.

</li>

<li>Initializes the hardware on the system.

</li>

<li>Locates and loads the initrd script to access the linuxrc program which
configures the operating system.

</li>

<li>Dismounts and erases the RAM disk image (initrd image).

</li>

<li>Looks for new hardware and loads the drivers.

</li>

<li>Mounts the root partition.

</li>

<li>Loads and executes the initial (init) process.

</li>

</ol> </td>

</tr>

<tr> <td>Init</td> <td>

By default, <b> /sbin/init</b> is the initial (init) process. If
<b>/sbin/init</b> is the initial process, the kernel reads a file called
<b>/etc/inittab</b> to determine what other programs to run, such as:

<ul>

<li>Scripts to mount partitions or start system services known as <i>
daemons</i>.

</li>

<li>A console for a login

</li>

<li>An X Display Manager (XDM) for a graphical login

</li>

</ul>

<b>Note</b>: The initial program gets the process ID of 1 because it's the
first process to run on the system.

</td>

</tr> </table>

