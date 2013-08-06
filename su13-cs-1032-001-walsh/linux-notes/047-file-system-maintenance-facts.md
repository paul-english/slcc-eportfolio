---
layout: page
title:  File System Maintenance Facts
---

Use the following commands to maintain file system integrity:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Examples</b></td>

</tr>

<tr> <td><b>df</b></td> <td>Display the free space in the partition holding
the specified directory. If directory is given, the space available on all
currently mounted file systems is shown. Disk space is shown in 1K blocks by
default. Common options include:

<ul>

<li><b>-h</b> displays the output in get human readable format (bytes, KB, MB,
GB).

</li>

<li><b>-i</b> Displays inode information.

</li>

<li><b>-l</b> limits the list to local file systems.

</li>

</ul> </td> <td><b>df /home</b> lists the free space on the partition that
holds the <b>/home</b> directory.</td>

</tr>

<tr> <td><b>du</b>  
 </td> <td>Display files and file sizes in and below a specified directory.
Common options include:

<ul>

<li><b>-c</b> lists a total amount of space for the directory.

</li>

<li><b>-h</b> display the output in human readable format (bytes, KB, MB, GB).

</li>

<li><b>-s</b> lists only the total, not each file.

</li>

</ul> </td> <td><b>du -c /home/badams</b> lists all files and directories in
badams' home directory along with a file size and a total amount of space
taken up by the directory.<b>  
du -c -s /home/badams</b> shows the total amount of space taken up in badams'
home directory.</td>

</tr>

<tr> <td><b>lsof</b></td> <td>Display open files in the file system.
<b>lsof</b> gives the following information by default:

<ul>

<li>The command used to access the file

</li>

<li>The process ID

</li>

<li>The name of the user who is accessing the file

</li>

<li>A file descriptor (these are described in the <b>lsof</b> man pages)

</li>

<li>The file node type

</li>

<li>Device numbers

</li>

<li>The file size

</li>

<li>The inode address

</li>

<li>The file path

</li>

</ul>

Common options include:

<ul>

<li><b>+D </b><i>directory_name </i>recursively<i> </i>lists files in a
directory.

</li>

<li><b>-c</b> <i>command_name</i> lists all files for processes that are
executing the specified command.

</li>

<li><b>-u </b><i>user</i><b> </b>lists open files owned by the specified user.

</li>

<li><b>-g</b> <i>process_ID </i>lists files opened by a specific process.

</li>

</ul> </td> <td><b>lsof -u <i>user </i></b>lists files opened by processes
that the specified user owns.</td>

</tr>

<tr> <td><b>fuser</b></td> <td>Display the Process IDs of processes that are
accessing a specified file or file system. Common options include:

<ul>

<li><b>-a </b>displays all process IDs.

</li>

<li><b>-v </b>displays extended information (verbose mode).

</li>

<li><b>-u </b>appends the username to each process ID.

</li>

<li><b>-m</b> displays process IDs in a specified directory.

</li>

</ul> </td> <td><b>fuser -v /bin/bash</b> shows the user name and process ID
for all users who have an open bash shell.</td>

</tr>

<tr> <td><b>fsck</b></td> <td>Check and optionally repair one or more Linux
file systems. Common options include:

<ul>

<li><b>-s</b> serializes <b>fsck</b> when multiple file systems are checked.

</li>

<li><b>-t</b> specifies the type(s) of file system to be checked.

</li>

<li><b>-a</b> automatically repairs the file system without any questions.

</li>

<li><b>-r</b> prompts for confirmation when errors are found and ask
permission to fix the errors (only when <b>-a</b> is not specified).

</li>

</ul>

Be aware of the following:

<ul>

<li>The file system must be unmounted before using <b>fsck</b>.

</li>

<li>When manually running <b>fsck</b>, use runlevel 1 to ensure that other
users do not mount the file system.

</li>

</ul> </td> <td><b>fsck -t ext3 /dev/sdb1 </b>checks the first partition on
the first partition of the second hard drive.</td>

</tr>

<tr> <td><b>e2fsck</b></td> <td>Check and optionally repair a second extended
file system (ext2) or ext2 files systems containing a journal (ext3). Command
options include:

<ul>

<li><b>-f</b> forces a file system check even when the file system appears
clean.

</li>

<li><b>-n</b> opens the file system as read-only and automatically answers all
questions as "no".

</li>

<li><b>-p </b>automatically repairs the file system without any questions.

</li>

<li><b>-y</b> automatically answers all questions as "yes".

</li>

<li> <b>-b </b>uses an alternative superblock if the primary superblock is
corrupt.

</li>

</ul></td> <td><b>e2fsck -p /dev/sda1 </b>checks and repairs the first
partition of the first hard drive so long as it is partitioned using
ext2.</td>

</tr>

<tr> <td><b>debugfs</b></td> <td>Debug the file system. The command examines
and changes the state of an ext2, ext3, or ext4 file system. It allows
administrators to unlink directories, change inode blocks find all inodes that
point to a block, and several other similar functions. Command options
include:

<ul>

<li><b>-w </b>specifies the file system should open in read-write mode.

</li>

<li> <b>-c</b> specifies the file system should open in catastrophic mode
(this is useful for file system with significant corruption.)

</li>

<li><b>-f </b>executes commands in a text file.

</li>

</ul></td> <td><b>debugfs /dev/sda1 </b>opens the first partition of the first
hard drive and displays a prompt that administrators can use to execute
commands for the file system.</td>

</tr>

<tr> <td><b>dumpe2fs</b></td> <td>Print super block and block information for
an ext2, ext3, or ext4 file system. This includes information for each sector
on the partition about sector type, block ranges, inode information, free
blocks, and similar information. Command options include:

<ul>

<li><b>-b</b> prints blocks reserved as bad in the file system.

</li>

<li><b>-h</b> prints only super block information.

</li>

<li><b>-x</b> prints group information block numbers in hexadecimal format.

</li>

</ul> </td> <td><b>dumpe2fs /dev/sda1</b> lists information for the first
partition of the first hard drive.</td>

</tr>

<tr> <td><b>tune2fs</b></td> <td>Adjust tunable file system parameters on
ext2, ext3, and ext4 file systems. Some of the adjustable parameters include
volume label, reserved blocks, inode sizes, and journaling. Tune2fs can also
implement access control lists for individual users. Command options include:

<ul>

<li><b>-c</b> adjust the number of mounts after which the file system will be
checked.

</li>

<li><b>-e remount-ro</b> remounts the file system as read-only.

</li>

<li>-<b>l </b>lists the contents of the file system super block.

</li>

<li><b>-o acl </b>enables Posix access control lists.

</li>

<li><b>-j</b> converts ext2 file systems to ext3 file systems.

</li>

</ul> </td> <td><b>tune2fs -o acl /dev/sdb1</b> enables access control lists
on the first partition of the second hard drive. The drive needs to be
remounted.</td>

</tr>

<tr> <td><b>xfs_info</b></td> <td>Display the XFS file system parameters, such
as the block size and inode data structures. This is the same functionality as
the <b> xfs_growfs -n</b> command.</td> <td><b>xfs_info /dev/sdb1 </b>displays
file system parameters for the first partition of the second hard drive.</td>

</tr>

<tr> <td><b>xfs_metadump</b></td> <td>Copy (dump) the metadata from an XFS
file system to a file. It does not alter the file system. By default, the file
names and extended attribute names are obfuscated before they are dumped.
Command options include:

<ul>

<li><b>-e</b> stops dumping the file system if there is a read error.

</li>

<li><b>-g</b> displays the dump process.

</li>

<li><b>-o</b> disables obfuscation of file names and extended attributes.

</li>

</ul>

<b>Note</b>: Only use <b>xfs_metadump</b> to dump unmounted, read-only
mounted, or frozen file systems.

</td> <td><b>xfs_metadump -o</b> <b>/dev/sdb1 /dump </b>copies the file system
metadata for the first partition on the second hard drive to the <b> /dump
</b>file.</td>

</tr> </table>

