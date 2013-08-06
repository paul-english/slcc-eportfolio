---
layout: page
title:  Lvm Facts
---

The Logical Volume Manager (LVM) provides an alternative methods to manage
partitions on a Linux system. LVM gives a system administrator more
flexibility in allocating storage on a system. Important aspects of LVM
include:

  * You can (within certain limits) resize and move logical volumes while they are still mounted and running.
  * Logical volumes may be identified by using descriptive names (i.e., _ research_ or _marketing_) instead of physical disk names such as _ /dev/sda_ and _/dev/sdb_.

The following table describes common LVM commands:

<table>

<tr> <td>Command</td> <td>Description</td> <td>Examples</td>

</tr>

<tr> <td><b>pvcreate</b></td> <td>Initializes physical volume for later use by
the Logical Volume Manager (LVM).</td> <td><b>pvcreate /dev/sdb </b>creates a
physical volume on the second hard disk in the system.  
<b>pvcreate /dev/sdd </b>creates a physical volume on the fourth hard disk in
the system.</td>

</tr>

<tr> <td><b>pvscan</b></td> <td>Scans all disks for physical volumes and
displays the result.</td> <td><b>pvscan</b> displays all found physical
volumes on the system and their associated volume groups.</td>

</tr>

<tr> <td><b>vgcreate</b></td> <td>Creates a new volume group.</td>
<td><b>vgcreate system /dev/sdb </b>creates a volume group named <i>system</i>
on the second hard disk in the system.  
<b>vgcreate backup /dev/sdd</b> creates a volume group named <i>backup</i> on
the fourth hard disk in the system.</td>

</tr>

<tr> <td><b>vgextend</b></td> <td>Adds one or more initialized physical
volumes to an existing volume group to extend it in size.</td> <td><b>vgextend
system /dev/sdc </b>adds the third hard disk in the system to the
<i>system</i> volume group.</td>

</tr>

<tr> <td><b>lvcreate</b></td> <td>Creates a new logical volume in a volume
group. Options include:

<ul>

<li><b>-L </b>specifies the size. Use the following size suffixes:

<ul>

<li>K for kilobytes

</li>

<li>M for megabytes

</li>

<li>G for gigabytes

</li>

<li>T for terabytes

</li>

<li>P for petabytes

</li>

<li>E for exabytes

</li>

</ul>

</li>

<li><b>-n </b>specifies the name

</li>

</ul> </td> <td><b>lvcreate -L 20G -n data system</b> creates a 20 Gigabyte
logical volume, named <i>data</i>, on the <i>system</i> volume group.  
<b> lvcreate -L 2T -n Storage1 backup</b> creates a 2 Terabyte logical volume,
named <i>Storage1</i>, on the <i>backup</i> volume group.  
<b> lvcreate -L 1T -n Storage2 backup</b> creates a 1 Terabyte logical volume,
named <i>Storage2</i>, on the <i>backup</i> volume group.</td>

</tr>

<tr> <td><b>lvscan</b></td> <td>Scans all known volume groups or all supported
LVM block devices in the system for logical volumes and displays the result.
</td> <td><b>lvscan </b>displays all of the logical volumes on the
system.</td>

</tr>

<tr> <td><b>lvextend</b></td> <td>Extends the size of a logical volume.
Options include:

<ul>

<li><b>-L </b>specifies the new size of volume. Be aware of the following:

<ul>

<li><b>-L +<i>size</i> </b>specifies an increase in the size of volume.

</li>

<li>The omission of the<b> -L</b> option will increase the size of the logical
volume by the amount of free space on physical volume.

</li>

</ul>

</li>

<li><i><b>logicalvolume </b></i>specifies which logical volume to extend.

</li>

<li><b><i>physicalvolume</i></b> specifies the physical volume to use for the
extension.

</li>

</ul></td> <td><b>lvextend -L 30G data</b> extends the <i>data</i> logical
volume to a total of 30 Gigabytes.  
<b>lvextend -L +10G data</b> extends the <i>data</i> logical volume by another
10 Gigabytes.  
<b>lvextend -L +10G data</b> <b>/dev/sde </b>extends the <i>data</i> logical
volume by another 10 Gigabytes on the<i> </i>physical volume for<i>
/dev/sde</i>.  
<b>lvextend data</b> <b>/dev/sde </b>extends the <i>data</i> logical to all of
the free space on the<i> </i>physical volume for<i> /dev/sde</i>.</td>

</tr> </table>

