---
layout: page
title:  Cpio And Dd Facts
---

Be aware of the following **cpio** and **dd** utility details:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Example</b></td>

</tr>

<tr> <td><b>cpio</b></td> <td>

Create a <b>cpio</b> archive or extract files from a <b>cpio</b> archive. The
<b>cpio</b> command is used as another method to archive files, yet is
different from other archive utilities because it only takes files names from
standard input. Cpio:

<ul>

<li>Copies files to an archive (copy-out mode).

</li>

<li>Extracts files from an archive (copy-in mode).

</li>

<li>Copies files to a different directory tree (copy-pass mode).

</li>

</ul>

Cpio uses the following options:

<ul>

<li><b>-o </b>creates the archive by invoking copy-out mode.

</li>

<li><b>-v</b> invokes verbose output, showing file names as they're added to
the archive.

</li>

<li><b>-i</b> extracts files by invoking copy-in mode.

</li>

<li><b>-u</b> overwrites existing files.

</li>

<li><b>-d</b> extracts directories during an extraction.

</li>

<li><b>-t</b> displays archive contents without extracting files.

</li>

<li><b>-p </b>copies files to a new directory (copy-pass mode).

</li>

</ul>



</td> <td><b>ls ~/4archive | cpio -ov > <i>filename</i>.cpio </b> creates a
cpio archive from the files listed in the <b>~/4archive </b> directory.<b>  
cpio -iv < <i>filename</i>.cpio </b>extracts the files from the cpio archive.  
<b>ls ~/copyme | cpio -pvd ./newdirectory </b>copies files from <b>~/copyme
</b>to<b> ./newdirectory</b>. </td>

</tr>

<tr> <td><b>dd</b></td> <td>Copy information using records. The <b>dd</b>
utility copies information using records instead of files. <b>dd</b> is useful
for:

<ul>

<li>Copying partitions to a single image file.

</li>

<li>Copying a master boot record.

</li>

</ul>

Parameters for <b>dd</b> include:

<ul>

<li><b>if=</b> specifies the input file.

</li>

<li><b>of=</b> specifies the output file.

</li>

<li><b>bs=</b> specifies the block size.

</li>

<li><b>count=</b> specifies the number of blocks to be copied.

</li>

</ul> </td> <td><b>dd if=/dev/sdb1 of=/root/partition.image</b> copies the
entire first partition if the second hard drive to a single file. <b>  
dd if=/dev/sda of=/root/file.mbr bs=512 count=1</b> copies the master boot
record of the first hard drive to a single file. </td>

</tr> </table>

