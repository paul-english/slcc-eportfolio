---
layout: page
title:  File System Facts
---

The file system determines how a computer's files are organized on a hard
drive. Linux supports many different file system types. The table below
describes several common file systems.

<table>

<tr> <td><b>File System Type</b></td> <td><b>Characteristics</b></td>

</tr>

<tr> <td>ext2</td> <td>The second extended file system supports Access Control
Lists to control individual permissions, but it does not support journaling.
</td>

</tr>

<tr> <td>ext3</td> <td>By layering it atop the ext2 file system, the third
extended file system (ext3) supports journaling, so it has faster startup and
recovery times. However, because it is tied to ext2, it doesn't offer the full
performance capabilities available through a pure journaling file system. This
is the most common Linux file system.</td>

</tr>

<tr> <td>ext4</td> <td>Ext4 is the latest version in the ext file system
family. Ext4 can handle files up to 16 terabytes and disk sizes up to 1
exabyte. </td>

</tr>

<tr> <td>swap</td> <td>A swap file system is used as virtual memory (the
portion of the hard disk used to temporarily store portions of main memory) by
the operating system. (A recommended practice is to make the swap file equal
in size to the amount of memory on the computer.)</td>

</tr>

<tr> <td>reiserfs</td> <td>The Reiser file system (ReiserFS) is a newer Linux
file system that calculates and proposes the best options for the file system.
Because ReiserFS was independently built from the ground up, its journaling
capability is native and more robust, offering a great deal of reliability. It
is also more efficient at storing small files than other file systems.
However, data corruption can occur if power goes out during disk
synchronizations. Also, defragmentation tools are not available for this file
system.</td>

</tr>

<tr> <td>ntfs</td> <td>Microsoft operating systems use NTFS (New Technology
File System). Linux can only read ntfs partitions created using Windows 2000
and later, and can write to NTFS file systems created with MS operating system
prior to Windows 2000\. However, utilities such as ntfsprogs may enable
read/write access on all ntfs partitions.</td>

</tr>

<tr> <td>vfat</td> <td>VFAT is a FAT32 filesystem for Linux and does not
support journaling. VFAT includes long name support. Support for vfat must be
compiled into the kernel for the system to recognize the vfat format.</td>

</tr>

<tr> <td>xfs</td> <td>

The XFS file system was developed for Silicon Graphics IRIX operating system.
An XFS file system is proficient at handling large files, offers smooth data
transfers, and provides journaling. It also can reside on a regular disk
partition or on a logical volume.

</td>

</tr> </table>

A disk partition must be formatted using a file system. The following table
describes the commands needed to format a partition.

<table>

<tr> <td>Use...</td> <td>To...</td> <td>Example</td>

</tr>

<tr> <td><b>mkfs</b></td> <td>Create an ext2, ext3, or fat file system.
<b>Mkfs</b> uses the following options:

<ul>

<li><b>-t <i>file_system_type</i></b> determines the file system. File system
types include:

<ul>

<li> <b>ext2 </b>(identical to the <b>mkfs.ext2 </b>command)

</li>

<li> <b>ext3 </b>(identical to<b> mkfs.ext3</b>)

</li>

<li><b> ext4 </b>(identical to<b> mkfs.ext4</b>)

</li>

<li><b>msdos </b>(identical to<b> mkfs.msdos</b>)

</li>

<li> <b>reiserfs</b> (identical to<b> mkreiserfs</b>)

</li>

</ul>

</li>

<li><b>-b </b>specifies the block size. Supported values are 1024, 2048, or
4096.

</li>

<li><b>-i </b>determines how many inodes are on the partition and uses the
same values as <b>-b</b>.

</li>

<li><b>-j</b> appends a journal to an ext2 file system.

</li>

</ul>

<b>Note:</b> Without the <b>-b</b> and <b>-i</b> options, <b>mkfs</b>
calculates the values automatically.

</td> <td><b>mkfs -t ext2 /dev/sda4</b> creates an ext2 file system on the
fourth partition on the first hard disk drive.<b>  
mkfs -t ext3 /dev/sda1</b> creates an ext3 file system on the first partition
on the first hard disk drive.  
<b>mkfs -t ext3 /dev/sdc2</b> creates an ext3 file system on the second
partition on the third hard disk drive.  
<b>mkfs -t ext4 /dev/sdb1</b> creates an ext4 file system on the first
partition on the second hard disk drive.  
 </td>

</tr>

<tr> <td><b> mkreiserfs</b></td> <td>Create a ReiserFS.</td> <td><b>mkreiserfs
/dev/sda2 </b>formats the second partition on the first hard disk with the
Reiser file system.</td>

</tr>

<tr> <td><b>mkswap</b></td> <td>Create a swap partition. A <i>swap</i>
partition is the location on the hard drive where an operating system writes
memory information when it runs out of RAM. <b>Mkswap</b>:

<ul>

<li>Requires the additional command <b>swapon</b> to activate the swap
partition.

</li>

<li>Uses the <b>swapoff</b> command to deactivate swap partitions.

</li>

</ul>

<b>Note:</b> <b>Swapon</b> and <b>swapoff </b>use the<b> -a</b> option to
specify all swap partitions listed in <b>/etc/fstab</b>.

</td> <td><b>mkswap /dev/sda2</b> formats the second hard drive as the swap
partition.  
<b>swapon /dev/sda2</b> activates second hard drive as the swap partition.  
<b>swapon -a</b> activates all swap partitions.  
<b>swapoff /dev/sda2</b> deactivates second hard drive as the swap partition.  
<b>swapoff -a</b> deactivates all swap partitions.</td>

</tr>

<tr> <td><b>mke2fs</b></td> <td>Create an ext2, ext3, or ext4 file system.
Command options include:

<ul>

<li><b>-b </b>specifies the block size of the file system in Bytes (valid
sizes are 1024, 2048 and 4096 bytes per block)

</li>

<li><b>-j</b> creates the file system with an ext3 journal

</li>

<li><b>-L</b> sets the volume label for the file system

</li>

<li><b>-n</b> displays what <b>mke2fs</b> would do if it created a file
system, but does not actually create the file system

</li>

<li><b>-t </b>specify the file system type (i.e., ext2, ext3, ext4, etc.) that
is to be created

</li>

</ul> </td> <td><b>mke2fs /dev/sda2 </b>creates an ext2 file system on the
second partition on the first hard disk drive.<b>  
mke2fs -j /dev/sda1</b><i> </i>creates an ext3 file system on the first
partition on the first hard disk drive.  
<b>mke2fs -t ext4 /dev/sdc3 </b>creates an ext4 file system on the third
partition on the third hard disk drive.</td>

</tr> </table>

Keep the following in mind when working with file systems:

  * Linux cannot format an extended partition; however, it can create logical partitions inside an extended partition for formatting. 
  * File systems use an _inode _(information node)_ table_ to store information about files. An inode specifies where a file's data physically exists on a disk. Inodes also contain additional information including: 
    * File size 
    * Modification, access, and creation times 
    * Permissions
    * Ownership
  * Each file system has a _superblock_, which contains information about the file system, such as:
    * File system type (e.g., ext2 and ext3)
    * Size (e.g., 10GB and 360GB)
    * Status
  * Linux maintains multiple redundant copies of the superblock in every filesystem. 

