---
layout: page
title:  Mounting Facts
---

_Mounting_ is the process of making a device accessible to users through the
directory tree. The directory to which the device or partition is attached is
called the _mount point_.

  * Volumes are represented by files located in the **/dev** directory; however, volumes must be mounted before use.
  * A volume is mounted to a directory. When accessing the directory in the file system, you are actually accessing the volume mounted to that directory. 
  * Always mount volumes and other storage devices to empty directories. Mounting a volume to a directory that contains data makes the data inaccessible. 
  * The **/mnt** and **/media** directories (depending on the system configuration) are directories that contain mount points specifically for external storage devices (e.g., CD-ROM drives, floppy drives, magnetic tape drives).

The following files manage and monitor the mounting of file systems:

<table>

<tr> <td><b>File</b></td> <td><b>Description</b></td>

</tr>

<tr> <td> <b>/etc/fstab</b></td> <td>The <b>/etc/fstab</b> file identifies
volumes to mount each time the system boots. When the system boots, it
automatically mounts the volumes identified in the file. The<b> </b>file
contains entries with six fields that control how a device is mounted. A
common entry is shown below:

> /dev/hda3 /mnt/disk1 ext3 auto,ro,nosuid,users 0 1

The fields in entry are as follows:

<ul>

<li><i>Device to mount</i> is the path to the device file or the label that
describes the volume.

</li>

<li><i>Mount point</i> specifies where to mount the device. This is the
directory to which the device is attached.

</li>

<li><i>file system type</i> specifies the device's file system type.

</li>

<li><i>Options</i> specifies the additional options accepted when mounting the
device. Options can be strung together in a comma-separated list. Be aware of
the following options:

<ul>

<li><b>sync </b>reads all I/O files synchronously.<b> </b>(<b>async</b>
disables this function.)

</li>

<li><b>atime </b>updates the timestamp on file's inode. (<b>noatime
</b>disables this function.)

</li>

<li><b>auto</b> allows the volume to be mounted automatically. Use the auto
parameter typically with floppy devices.

</li>

<li><b>noauto </b>prevents the volume from being mounted automatically. Use
this option for removable media.

</li>

<li><b>dev</b> allows block files to be read from the volume. (<b>nodev</b>
disables this function.)

</li>

<li><b>exec</b> allows programs and script files to run from the volume.
(<b>noexec</b> disables this function.)

</li>

<li><b>owner</b> identifies that only the device owner can mount the volume.

</li>

<li><b>ro</b> mounts the volume read only.

</li>

<li><b>rw</b> mounts the volume read/write.

</li>

<li><b>suid</b> allows the SUID bit to be set on files in the volume.
(<b>nosuid</b> disables this function.)

</li>

<li><b>user</b> identifies a specific user who can mount the volume.

</li>

<li><b>nouser</b> allows only the root user to mount the volume.

</li>

<li><b>users </b>allows any user to mount the volume.

</li>

<li><b>defaults</b> uses the following default settings: rw, suid, dev, exec,
auto, nouser, and async.

</li>

</ul>

</li>

<li><i>Dump##</i> is used by the dump command when backing up the file system.

</li>

<li><i>Fsck# </i>indicates when to run <b>fsck</b> (file system check) during
boot up.

<ul>

<li>0 = never

</li>

<li>1 = only if not unmounted cleanly (Always set for the root partition.)

</li>

<li>2 = always

</li>

</ul>

</li>

</ul> </td>

</tr>

<tr> <td> <b>/etc/mtab</b></td> <td>The <b>/etc/mtab</b> file tracks the
currently-mounted volumes on the system. </td>

</tr>

<tr> <td><b>/procs/mounts</b></td> <td>The <b>/procs/mounts</b> file contains
entries for all currently-mounted volumes on the system. The <b>/proc</b> file
system is a virtual file system that contains current system information,
including the mounted file systems.</td>

</tr> </table>

Use the following commands to manage the mounting of file systems:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Example</b></td>

</tr>

<tr> <td><b>mount /dev/</b><i>device</i> <i>/mountpoint</i> </td> <td>Mount a
volume or device. Common mount options:

<ul>

<li><b>-a</b> mounts all file systems listed in the <b>/etc/fstab </b>file

</li>

<li><b>-r, ro</b> mounts the volume as read only

</li>

<li><b>-w, rw</b> mounts the volume as read/write

</li>

<li><b>-t</b> specifies the volume type (If you mount an ext3 file system
without the <b>-t</b>, the system recognizes it as an ext2 file system)

</li>

<li><b>-o loop</b> mounts an ISO file.

</li>

</ul></td> <td><b>mount -a </b>reads the <b>/etc/fstab </b>file and mounts all
volumes listed (except those with the <b>noauto </b>parameter)<b>  
mount -rt reiserfs /dev/hdc1 /mnt/reis</b> mounts the hdc1 device with the
reiser file system as read only to the <b>/mnt/reis</b> mount point.  
<b>mount -t iso9660 /dev/cdrom /media/cdrom </b>mounts the CD-ROM device to
the <b>/media/cdrom</b> mount point.  
<b>mount -wt vfat /dev/fd0 /mnt/floppy</b> mounts the fd0 device with the vfat
file system as read/write to the floppy mount point.</td>

</tr>

<tr> <td><b>mount</b></td> <td>View the currently-mounted volumes on the
system. This will display the contents of the <b>/etc/mtab</b> file.</td> <td>
</td>

</tr>

<tr> <td><b>df</b></td> <td>View which file systems are mounted to specific
mount points.</td> <td> </td>

</tr>

<tr> <td><b>umount</b> <i>/device</i>  
<b>umount</b> <i>/mountpoint</i></td> <td>Unmount a volume or device from the
system. If <i>disk is busy</i> is displayed when unmounting a device:

<ul>

<li>Make sure the current working directory is not in that file system.

</li>

<li>Close any open files located on that file system.

</li>

</ul> </td> <td><b>umount /dev/hdc1</b> unmounts the hdc1 device.  
<b>umount /mnt/reis</b> unmounts the device on the /mnt/reis mount point.  
<b>umount /dev/cdrom</b> unmounts the CD-ROM device.  
<b>umount /mnt/cdrom</b> unmounts the device on the /mnt/cdrom mount point
(most likely a CD-ROM device).  
</td>

</tr> </table>

