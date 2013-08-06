---
layout: page
title:  Partition Management Facts
---

A _partition_ is a logical division of a storage device associated with a hard
disk drive. A hard disk drive can have a single partition or multiple
partitions. One common partitioning scheme divides a disk into primary and
extended partitions.

<table>

<tr> <td>Partition Type</td> <td>Description</td>

</tr>

<tr> <td>Primary</td> <td>A <i>primary</i> partition is one that is used to
store the operating system. Primary partitions:

<ul>

<li>Can hold operating system boot files.

</li>

<li>Cannot be further subdivided into logical drives.

</li>

<li>Can be formatted.

</li>

</ul>

<b>Note</b>: There can be a maximum of four primary partitions on a single
hard disk drive.

</td>

</tr>

<tr> <td>Extended</td> <td>An <i>extended</i> partition is an optional
partition that does not have an operating system installed on it and thus is
not bootable. Extended partitions:

<ul>

<li>Can be further subdivided into an unlimited number of logical drives.

</li>

<li>Cannot be formatted.

</li>

</ul>

<b>Note</b>: There can be a maximum of one extended partition on a single hard
disk drive.

</td>

</tr> </table>

Use the following tools to create and manage partitions:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td>

</tr>

<tr> <td><b>fdisk</b></td> <td>Launch the <b>fdisk</b> utility and create
partitions on a hard disk. <b>fdisk</b> is an interactive utility which
requires values and decisions to create partitions. Be aware of the following
details:

<ul>

<li><b>fdisk</b> requests a beginning/ending cylinder or size when creating a
partition. The size is indicated using K (Kilobytes), M (Megabytes), or G
(Gigabytes).

</li>

<li><b>fdisk</b> uses hexadecimal codes to determine the partition type.
Common hexadecimal codes include:

<ul>

<li>0x82 Linux swap

</li>

<li>0x83 Linux partition

</li>

<li>0x85 Linux extended partition

</li>

<li>0x8e Linux logical partition

</li>

</ul>

</li>

<li><b>fdisk -l</b> lists the current partition configuration on the system.

</li>

</ul>

Type<b> fdisk <i>device_name</i> </b>at the command prompt to enter the<b>
fdisk</b> utility. Be aware of the following options within <b>fdisk</b>:

<ul>

<li><b>l</b> lists the partition types supported.

</li>

<li><b>m</b> opens the help file.

</li>

<li><b>n</b> creates a new partition.

</li>

<li><b>p</b> displays the partition table for that device.

</li>

<li><b>q</b> exits <b>fdisk</b> without saving changes.

</li>

<li><b>w</b> writes the partition table to disk (i.e., saves the file) and
exits the <b>fdisk</b> utility.

</li>

<li><b>d</b> deletes a partition.

</li>

</ul> </td>

</tr>

<tr> <td><b>partprobe</b></td> <td>Request that the operating system re-read
the partition table. The operating system kernel reads the partition table and
recognizes the table changes. </td>

</tr> </table>

