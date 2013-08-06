---
layout: page
title:  Device File Names
---

Storage devices in Linux are represented by device files.

  * Device files are located in the **/dev** directory. 
  * The **/dev** directory contains files for all types of devices, even those that don't exist on the system. 
  * Not only do device files represent devices, they indicate how data is transferred to that device. 
  * Devices, like storage devices, that receive data in block transfers by using memory to buffer the transfers are called _block_ devices. Devices that send data transfers character-by-character (like the keyboard) are called _character_ devices. 

The table below lists and describes the most common device files.

<table>

<tr> <td><b>Device File</b></td> <td><b>Description</b></td>

</tr>

<tr> <td><b>/dev/sd<i>xn</i></b></td> <td><i>sd</i> files identify hard
drives. A letter (beginning with <i>a</i>) follows the <i>sd</i> designation
and identifies the ID of the hard drive. At the end is appended a number
(beginning with 1) that identifies the partition on the drive. Examples
include:

<ul>

<li>sda2 is the second partition (2) on the hard drive with the lowest ID
number (a)

</li>

<li>sdc1 is the first partition (1) on the drive with the third lowest ID
number (c)

</li>

<li>sda1 is the first partition (1) on the hard drive with the lowest ID
number (a)

</li>

<li>sdb3 is the third partition (3) on the drive with the second lowest ID
number (b)

</li>

<li>sdc2 is the second partition (2) on the drive with the third lowest ID
number (c)

</li>

<li>sdd1 is the first partition (1) on the drive with the forth lowest ID
number (d)

</li>

</ul> <b>Note: </b>Some systems will use <b>/dev/sr<i>x</i></b> instead.</td>

</tr>

<tr> <td><b>/dev/cdrom</b></td> <td>This is a special designation used to
identify the CD-ROM in the system. In reality, the <b>/dev/cdrom</b> ID is
just a symbolic link to the actual device (sr0).</td>

</tr>

<tr> <td><b>/dev/fd<i>n</i></b></td> <td><i>fd</i> files identify floppy
drives. Device numbering begins at 0. For example, <b>/dev/fd0</b> is the
first floppy drive. </td>

</tr>

<tr> <td><b>/dev/tty<i>n</i></b></td> <td><i>tty</i> files identify local
terminals on the system. Device numbering begins at 0. Subsequent terminals
are represented with files that increment by one (e.g., the file for terminal
two is /dev/tty2, and so on).</td>

</tr>

<tr> <td><b>/dev/ttyS<i>n</i></b></td> <td><i>ttyS</i> files identify serial
ports. Device numbering begins at 0. Files for subsequent serial ports are
represented by files that increment by one (e.g., the file for serial port two
is <b>/dev/ttyS1</b>, and so on).</td>

</tr>

<tr> <td><b>/dev/lp<i>n</i></b></td> <td><i>lp</i> files identify parallel
ports. Device numbering begins at 0. Files for subsequent parallel ports are
represented by files that increment by one (e.g., the file for parallel port
two is <b>/dev/lp1</b>, and so on).</td>

</tr>

<tr> <td><b>/dev/usb/<i>file_name</i></b></td> <td>USB devices have their own
subdirectory of files to support up to 127 USB devices.</td>

</tr>

<tr> <td><b>/dev/psaux</b></td> <td>This file is for the PS/2 mouse port.</td>

</tr>

<tr> <td><b>/dev/st<i>n</i></b></td> <td>st files identify SCSI tape devices.
Device numbering begins at 0. </td>

</tr> </table>

